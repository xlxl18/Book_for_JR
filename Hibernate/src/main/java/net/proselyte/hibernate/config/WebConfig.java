package net.proselyte.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@ComponentScan({"net.proselyte.hibernate"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
       // resolver.setSuffix(".jsp");
        resolver.setSuffix(".zul");
        //resolver.setOrder(2);
        return resolver;
    }

    @Override //статик расположение файлов
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/scripts/");
        registry.addResourceHandler("/styles/**").addResourceLocations("/WEB-INF/styles/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/fonts/");
    }

}