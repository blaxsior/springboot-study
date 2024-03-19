package com.example.demo.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        // dataSource는 spring-boot-starter-data에 의해 자동으로 설정됨.
        // 모든 정보는 DB에 저장되어 있으므로 하드코딩 필요 X
        var manager = new JdbcUserDetailsManager(dataSource);

        // username 기반으로 연관 데이터 가져오는 쿼리 작성
        // 여기에 작성하는 쿼리는 일반적인 SQL
        manager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
        manager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return manager;
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
