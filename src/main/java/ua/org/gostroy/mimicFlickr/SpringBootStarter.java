package ua.org.gostroy.mimicFlickr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Sergey on 12/21/2015.
 */

@Import({ SpringConfiguration.class })
public class SpringBootStarter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootStarter.class, args);
    }

}
