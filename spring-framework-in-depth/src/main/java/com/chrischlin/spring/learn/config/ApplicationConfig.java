package com.chrischlin.spring.learn.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;


/**
 * This Application Config is also called BeanFactory.
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.chrischlin.spring.learn")
@EnableAspectJAutoProxy
public class ApplicationConfig {


}
