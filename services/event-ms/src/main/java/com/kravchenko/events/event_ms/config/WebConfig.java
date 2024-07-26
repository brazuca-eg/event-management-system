package com.kravchenko.events.event_ms.config;

import com.kravchenko.events.event_ms.converter.CreateEventRequestToEventConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CreateEventRequestToEventConverter());
    }
}
