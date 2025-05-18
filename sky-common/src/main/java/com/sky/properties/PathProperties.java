package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 接口路径前缀配置
 */
@Component
@ConfigurationProperties(prefix = "server.path")
@Data
public class PathProperties {
    String globalPrefix = "";
}
