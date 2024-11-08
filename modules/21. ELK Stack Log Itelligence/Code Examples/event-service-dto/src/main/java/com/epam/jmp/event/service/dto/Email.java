package com.epam.jmp.event.service.dto;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@AllArgsConstructor
public final class Email {

    @Field("email")
    private final String value;

    @Component
    static class EmailToStringConverter implements Converter<Email, String> {

        @Override
        public String convert(Email source) {
            return source == null ? null : source.value;
        }
    }

    @Component
    static class StringToEmailConverter implements Converter<String, Email> {

        public Email convert(String source) {
            return StringUtils.hasText(source) ? new Email(source) : null;
        }
    }
}