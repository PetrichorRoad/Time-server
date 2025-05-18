package com.sky.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.sky.properties.PathProperties;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Autowired
    private PathProperties pathProperties;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 匹配所有路径
//                .allowedOrigins("http://localhost:8081/") // 允许的前端地址
                .allowedOrigins("*") // 允许的前端地址
                .allowCredentials(true)
                .allowedMethods("*")                     // 允许所有 HTTP 方法（GET/POST等）
                .allowedHeaders("*")                     // 允许所有请求头
                .allowCredentials(true)                  // 允许携带 Cookie
                .maxAge(3600);                           // 预检请求缓存时间（秒）
    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer
                .addPathPrefix(pathProperties.getGlobalPrefix(), c -> c.isAnnotationPresent(RestController.class));
    }
}
