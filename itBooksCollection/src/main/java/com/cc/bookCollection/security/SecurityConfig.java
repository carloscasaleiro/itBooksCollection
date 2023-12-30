package com.cc.bookCollection.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails administrator = User.builder()
                .username("user")
                .password("{noop}pass")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(administrator);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AntPathRequestMatcher css = new AntPathRequestMatcher("/css/**");
        AntPathRequestMatcher images = new AntPathRequestMatcher("/images/**");

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(css, images).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                );

        return http.build();
    }
}
