package com.thymeleaf.course.config.dialect.functions;

import java.util.regex.Pattern;

public class EmailThymeleafFunction {
    private static final String EMAIL_PATTERN = "|^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean isValid(String email) {
        return (Pattern.compile(EMAIL_PATTERN).matcher(email)).matches();
    }
}
