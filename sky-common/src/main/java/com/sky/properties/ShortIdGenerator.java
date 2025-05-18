package com.sky.properties;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.codec.Base62;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShortIdGenerator {
    private final Snowflake snowflake;

    public ShortIdGenerator(
            @Value("${snowflake.machine-id:0}") long machineId,  // 机器ID（0-31）
            @Value("${snowflake.data-center-id:0}") long dataCenterId // 数据中心ID（0-31）
    ) {
        this.snowflake = IdUtil.getSnowflake(machineId, dataCenterId);
    }

    /**
     * 生成短唯一ID（长度约 11 字符）
     */
    public String generate() {
        String id = Long.toString(snowflake.nextId()) ;      // 生成 64 位 Long 型 ID
        return Base62.encode(id);    // 转换为 Base62 字符串
    }
}