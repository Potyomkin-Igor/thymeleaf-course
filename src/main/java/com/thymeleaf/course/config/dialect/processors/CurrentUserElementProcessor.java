package com.thymeleaf.course.config.dialect.processors;

import com.thymeleaf.course.domain.model.entity.User;
import com.thymeleaf.course.domain.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

public class CurrentUserElementProcessor extends AbstractElementTagProcessor {
    private static final String TAG_NAME = "current";
    private static final int PRECEDENCE = 1;

    public CurrentUserElementProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, /* Будет применён только к определенному моду */
                dialectPrefix, /* Префикс будет добавлен к тегу */
                TAG_NAME, /* Название тега*/
                true, /* Нужно давлять префикс к тегу или нет(false) */
                null, /* Аттрибут который так же будет обработан */
                false, /* Префикс не применяется к имени атрибута */
                PRECEDENCE /* Очередность вызовов процессоров внутри диалекта */
        );
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler structureHandler) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final ApplicationContext appCtx = SpringContextUtils.getApplicationContext(context);
        String greeting;

        if (authentication == null || authentication.getName() == null) {
            greeting = "You are not authenticated";
        } else {
            final UserRepository repository = appCtx.getBean(UserRepository.class);
            User user = repository.findByEmail(authentication.getName());
            greeting = String.format(
                    "Welcome, %s", user.getFirstName().concat(" ").concat(user.getLastName())
            );
        }

        /*
         * Create the DOM structure that will be substituting our custom tag.
         * The headline will be shown inside a '<div>' tag, and so this must
         * be created first and then a Text node must be added to it.
         */
        final IModelFactory modelFactory = context.getModelFactory();
        final IModel model = modelFactory.createModel();
        model.add(modelFactory.createOpenElementTag("div", "class", "text-left font-weight-bold"));
        model.add(modelFactory.createText(HtmlEscape.escapeHtml5(greeting)));
        model.add(modelFactory.createCloseElementTag("div"));

        /*
         * Instruct the engine to replace this entire element with the specified model.
         */
        structureHandler.replaceWith(model, false);
    }
}
