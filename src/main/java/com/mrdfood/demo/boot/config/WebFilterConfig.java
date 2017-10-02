package com.mrdfood.demo.boot.config;

import com.mrdfood.demo.boot.filter.CustomRandomHeaderFilter;
import com.mrdfood.demo.boot.repository.RandomStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.io.IOException;

@Configuration
class WebFilterConfig {

    @Autowired
    private RandomStringRepository randomStringRepository;

    @Bean
    Filter customRandomHeaderFilter() throws IOException {
        return new CustomRandomHeaderFilter("Chuck-Norris-Fact", randomStringRepository);
    }
}
