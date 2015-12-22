package ua.org.gostroy.mimicFlickr;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Sergey on 12/22/2015.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(bufferedImageHttpMessageConverter());
    }

    @Bean
    BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter() {
        BufferedImageHttpMessageConverter converter = new BufferedImageHttpMessageConverter();
        return converter;
    }

}
