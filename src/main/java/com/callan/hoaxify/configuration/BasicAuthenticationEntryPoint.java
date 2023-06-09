package com.callan.hoaxify.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.naming.AuthenticationException;
import java.io.IOException;

public class BasicAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(
        HttpServletRequest request,
        HttpServletResponse response,
        org.springframework.security.core.AuthenticationException authException
    ) throws IOException, ServletException {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());

    }
}

