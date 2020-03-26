package com.orientsec.businesslog.samples.crud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author miemie
 * @since 2018-08-10
 */
@Configuration
@MapperScan("com.orientsec.businesslog.samples.crud.mapper")
public class MybatisPlusConfig {

}
