package world.rfch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("admin/files-from-users/**")
                .addResourceLocations("file:C:/services/src/main/resources/files-from-users/");
        registry
                .addResourceHandler("/static/**","/images/***","/fonts/**","/images/**","/images/*","/images/","/*")
                .addResourceLocations("file:C:/services/src/main/resources/static/**","file:C:/services/src/main/resources/static/","file:C:/services/src/main/resources/static/images/**");
    }
}
