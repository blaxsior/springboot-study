package com.example.demo.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        var john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        var mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();


        var susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // set end point authorization by user role
        http.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/employees/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
        );

        // disable csrf because this api is stateless
        http.csrf(it -> it.disable());

        // HTTP Basic Authentication
        // withDefaults는 아무 옵션도 없는 Customizer 객체를 반환
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
