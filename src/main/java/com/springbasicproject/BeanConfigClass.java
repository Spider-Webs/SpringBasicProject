package com.springbasicproject;

import com.springbasicproject.mapper.BookMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan(basePackages = "com.springbasicproject")
@PropertySource("classpath:/config/db.properties")
public class BeanConfigClass implements WebMvcConfigurer{

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUserName;
    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource message(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("db");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("org.mariadb.jdbc.Driver");
        source.setUrl(dbUrl);
        source.setUsername(dbUserName);
        source.setPassword(dbPassword);

        return source;
    }
    // SqlSessionFactory : jdbc를 처리하는 객체
    @Bean
    public SqlSessionFactory factory(BasicDataSource source) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(source);
        SqlSessionFactory factory = factoryBean.getObject();
        return factory;
    }

    // Mapper
    @Bean
    public MapperFactoryBean<BookMapper> test_mapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<BookMapper> factoryBean = new MapperFactoryBean<BookMapper>(BookMapper.class);
        factoryBean.setSqlSessionFactory(factory);
        return factoryBean;
    }


}

