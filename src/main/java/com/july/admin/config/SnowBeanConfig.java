package com.july.admin.config;

import com.july.admin.beans.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: july
 * @date: 2020/1/14 23:16
 * @description:
 */
@Configuration
public class SnowBeanConfig {

    /**
     *  demo1 : @Bean(name = "testDemo")
     *  demo2 : @Bean
     * @return
     */
    @Bean
    public SnowflakeIdWorker getIdWorker() {
        return new SnowflakeIdWorker(0, 0);
    }
}
