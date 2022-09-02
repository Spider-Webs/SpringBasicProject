package com.springbasicproject;

import com.springbasicproject.mapper.BookMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.springbasicproject")
@PropertySource("classpath:/config/db.properties")
public class SpringContext implements WebMvcConfigurer{

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUserName;
    @Value("${spring.datasource.password}")
    private String dbPassword;

//    // Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        // TODO Auto-generated method stub
//        WebMvcConfigurer.super.configureViewResolvers(registry);
//        registry.jsp("/WEB-INF/views/", ".jsp");
//    }
//
//    // 정적 파일의 경로를 매핑한다.
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // TODO Auto-generated method stub
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//        registry.addResourceHandler("/**").addResourceLocations("/resources/");
//    }

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

