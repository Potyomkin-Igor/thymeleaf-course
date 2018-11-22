package com.thymeleaf.course.config.dialect.functions;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.spring5.expression.SpringStandardExpressionObjectFactory;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Objects.isNull;

/**
 * Extension of {@link SpringStandardDialect} for adding custom utility classes to spring standard dialect
 */

public class FunctionDialect extends SpringStandardDialect {

    private IExpressionObjectFactory expressionObjectFactory;

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        if (isNull(this.expressionObjectFactory)) {
            this.expressionObjectFactory = new ExtendedSpringStandardExpressionObjectFactory();
        }
        return this.expressionObjectFactory;
    }

    public static class ExtendedSpringStandardExpressionObjectFactory extends SpringStandardExpressionObjectFactory {
        private static final String IS_EMAIL_EXPRESSION_OBJECT_NAME = "email";
        private static final Set<String> ALL_EXPRESSION_OBJECT_NAMES;

        static {

            final Set<String> allExpressionObjectNames = new LinkedHashSet<>();
            allExpressionObjectNames.addAll(SpringStandardExpressionObjectFactory.ALL_EXPRESSION_OBJECT_NAMES);
            allExpressionObjectNames.add(IS_EMAIL_EXPRESSION_OBJECT_NAME);

            ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(allExpressionObjectNames);
        }

        @Override
        public Object buildObject(IExpressionContext context, String expressionObjectName) {
            if (IS_EMAIL_EXPRESSION_OBJECT_NAME.equals(expressionObjectName)) {
                return new EmailThymeleafFunction();
            }
            return super.buildObject(context, expressionObjectName);
        }

        @Override
        public Set<String> getAllExpressionObjectNames() {
            return ALL_EXPRESSION_OBJECT_NAMES;
        }
    }

}
