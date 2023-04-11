package com.callan.hoaxify.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {


    private final AuthUserService authUserService;

    public SecurityConfiguration(AuthUserService authUserService){
        this.authUserService = authUserService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();


        // This shows that we are using basic authentication which means user credentials should be passed in
        // auth section of the request header

        http.httpBasic().authenticationEntryPoint(new BasicAuthenticationEntryPoint());

        http.authorizeHttpRequests( )
            .requestMatchers(HttpMethod.POST, "/api/v1/login").authenticated()
            .and()
            .authorizeHttpRequests().anyRequest().permitAll();





        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(authUserService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
