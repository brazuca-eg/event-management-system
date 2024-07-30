package com.kravchenko.events.config;

import com.kravchenko.events.converter.CreateEventRequestToEventConverter;
import com.kravchenko.events.converter.EventToEventResponseConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CreateEventRequestToEventConverter());
        registry.addConverter(new EventToEventResponseConverter());
    }
}
