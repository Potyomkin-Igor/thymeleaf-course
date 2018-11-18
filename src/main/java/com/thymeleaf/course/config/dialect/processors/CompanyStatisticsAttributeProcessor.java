package com.thymeleaf.course.config.dialect.processors;

import com.thymeleaf.course.domain.model.entity.Company;
import com.thymeleaf.course.domain.repository.CompanyRepository;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.context.SpringContextUtils;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

public class CompanyStatisticsAttributeProcessor  extends AbstractAttributeTagProcessor {
    private static final String ATTR_NAME = "statistics";
    private static final int PRECEDENCE = 0;

    public CompanyStatisticsAttributeProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML,
                dialectPrefix,
                null, /* Название тега */
                false,
                ATTR_NAME,
                true,
                PRECEDENCE,
                true /* Удаляет аттрибут после процессинга */
        );
    }

    @Override
    protected void doProcess(
            ITemplateContext context, IProcessableElementTag tag,
            AttributeName attributeName, String attributeValue,
            IElementTagStructureHandler structureHandler) {

        /*  Interface defining the main configuration object that specifies how an {@link ITemplateEngine} instance
            should behave. */
        final IEngineConfiguration configuration = context.getConfiguration();

        /*
         * Obtain the Thymeleaf Standard Expression parser
         */
        final IStandardExpressionParser parser =
                StandardExpressions.getExpressionParser(configuration);

        /*
         * Parse the attribute value as a Thymeleaf Standard Expression
         */
        final IStandardExpression expression =
                parser.parseExpression(context, attributeValue);

        /*
         * Execute the expression just parsed
         */
        final String companyName = (String) expression.execute(context);

        final ApplicationContext appCtx = SpringContextUtils.getApplicationContext(context);
        final CompanyRepository repository = appCtx.getBean(CompanyRepository.class);
        Company company = repository.findByName(companyName);
        String message = "The number of employees: " + "<b>" + company.getEmployees().size() + "</b>";

        /*
         * Set the computed message as the body of the tag, HTML-escaped and
         * non-processable (hence the 'false' argument)
         */
        structureHandler.setBody(HtmlEscape.unescapeHtml(message),  true);
    }


}
