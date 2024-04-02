package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

//    @Bean
//    public UserDetailsManager detailsManager() {
//        var user1 = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        var user2 = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        var user3 = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }

//    @Bean
//    public UserDetailsManager detailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public UserDetailsManager detailsManager(DataSource dataSource) {
        var manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        manager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return manager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/system/**").hasAnyRole("ADMIN")
                        .anyRequest()
                        .authenticated()
        ).exceptionHandling(config ->
                config
                        .accessDeniedPage("/error/403")
        ).formLogin(form ->
                form
                        .loginPage("/auth/login") // show login page
                        .loginProcessingUrl("/auth/login") // run POST /auth/loginUser
                        .permitAll() // everyone can access without permission
        ).logout(logout -> logout
                .logoutUrl("/auth/logout")
                .permitAll()
        );
        return http.build();
    }
}
