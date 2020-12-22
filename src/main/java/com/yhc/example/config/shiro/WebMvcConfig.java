package com.yhc.example.config.shiro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IDEA2018.3
 * author:杨海传
 * Date:2020-08-22 16:56
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${upload.profile}")
    private String profile;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //视图映射：浏览器发送"/"请求，会来到index页面（thymeleaf解析的页面），
//        registry.addViewController("/").setViewName("/index");
        registry.addViewController("index.html").setViewName("index");
        registry.addViewController("pages/console.html").setViewName("pages/console");
        //配置springboot直接访问静态html页面，不经过controller
        //配置之后，发送/loginAndRegister.html，就相当于在controller中return "loginAndRegister"
        registry.addViewController("loginAndRegister.html").setViewName("loginAndRegister");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        /** 本地文件上传路径 */
        registry.addResourceHandler("/profile"+ "/**").addResourceLocations("file:" + profile + "/");

        /** swagger配置 */
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //配置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")     //允许的路径
                .allowedMethods("*")     //允许的方法
                .allowedOrigins("*")       //允许的网站
                .allowedHeaders("*")     //允许的请求头
                .allowCredentials(true)
                .maxAge(3600);
    }
}
