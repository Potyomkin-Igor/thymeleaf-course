package com.thymeleaf.course.config.dialect;

import com.thymeleaf.course.config.dialect.processors.CompanyStatisticsAttributeProcessor;
import com.thymeleaf.course.config.dialect.processors.CurrentUserElementProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class ThymeleafCourseDialect extends AbstractProcessorDialect {
    private static final String HTML_PREFIX = "tcourse";
    private static final String DIALECT_NAME = "Thymeleaf Course Dialect";

    public ThymeleafCourseDialect() {
        super(DIALECT_NAME, HTML_PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors = new HashSet<>();
        processors.add(new CurrentUserElementProcessor(dialectPrefix));
        processors.add(new CompanyStatisticsAttributeProcessor(dialectPrefix));
        return processors;
    }
}
