package com.example.emall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

/*    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    @Value("${file.uploadFolder}")
    private String uploadFolder;*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
/*        //设置虚拟路径，访问绝对路径下资源
        registry.addResourceHandler(staticAccessPath).addResourceLocations(
                "file:" + uploadFolder);*/
        //访问静态资源
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        //访问swagger
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
    }
}
