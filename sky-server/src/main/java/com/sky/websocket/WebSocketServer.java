package com.sky.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/ws/{sid}")
@Slf4j
public class WebSocketServer {
    private static final ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        log.info("客户端连接成功: {}", sid);
        sessionMap.put(sid, session);
        log.info("{}",sessionMap);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("sid") String sid) {
        log.info("收到来自 {} 的消息: {}", sid, message);
        // 示例：将消息回发给当前客户端
        sendToClient(sid, "ECHO: " + message);
    }

    @OnClose
    public void onClose(@PathParam("sid") String sid, Session session) {
        if (session.isOpen()) {
            try {
                session.close();
            } catch (IOException e) {
                log.error("关闭会话失败: {}", sid);
            }
        }
        sessionMap.remove(sid);
        log.info("连接关闭: {}", sid);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("WebSocket 错误: {}", error.getMessage());
        error.printStackTrace();
    }

    // 单播消息
    public void sendToClient(String sid, String message) {
        log.info("sendToClient sessionMap {}",sessionMap);
        Session session = sessionMap.get(sid);
        log.info("{}",session);
        if (session != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.error("单播消息失败，sid: {}", sid);
                sessionMap.remove(sid);
            }
        }
    }

    // 广播消息
    public void sendToAllClient(String message) {
        sessionMap.forEach((sid, session) -> {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    log.error("广播消息失败，sid: {}", sid);
                }
            }
        });
    }
}