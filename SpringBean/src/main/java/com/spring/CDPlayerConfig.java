package com.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/11/18.
 */

/**
 * 启用注解扫描：如果没有其他配置，@ComponentScan默认会扫描与配置类相同的包，查找带有@Componenet注解的类
 */
@Configuration
@ComponentScan
public class CDPlayerConfig {
}
