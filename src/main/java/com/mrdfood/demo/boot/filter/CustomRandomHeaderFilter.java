package com.mrdfood.demo.boot.filter;

import com.mrdfood.demo.boot.repository.RandomStringRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.common.base.Preconditions.checkNotNull;

public class CustomRandomHeaderFilter extends OncePerRequestFilter {

    private final String headerName;
    private final RandomStringRepository randomStringRepository;

    public CustomRandomHeaderFilter(String headerName, RandomStringRepository randomStringRepository) {
        this.headerName = checkNotNull(headerName);
        this.randomStringRepository = checkNotNull(randomStringRepository);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        httpServletResponse.addHeader(headerName, randomStringRepository.load());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
