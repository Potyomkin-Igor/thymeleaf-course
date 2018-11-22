package com.thymeleaf.course.config;

import com.thymeleaf.course.config.dialect.ThymeleafCourseDialect;
import com.thymeleaf.course.config.dialect.functions.FunctionDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.HashSet;
import java.util.List;

@Configuration
public class ThymeleafConfigDialect {

    @Bean
    public ViewResolver viewResolver(List<AbstractProcessorDialect> dialects, SpringTemplateEngine templateEngine) {
        templateEngine.setDialects(new HashSet<>(dialects));

        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public ThymeleafCourseDialect thymeleafCourseDialect() {
        return new ThymeleafCourseDialect();
    }

    @Bean
    public FunctionDialect functionDialect() {
        return new FunctionDialect();
    }
}
