package com.thymeleaf.course.config;

import com.thymeleaf.course.config.dialect.ThymeleafCourseDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class ThymeleafConfigDialect {

    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        templateEngine.addDialect(new ThymeleafCourseDialect());

        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
