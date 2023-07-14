package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withUsername("upendra")
                .password(passwordEncoder().encode("9876@Tgb"))
                .roles("ADMIN")
                .build();

        UserDetails user2= User.withUsername("upendra1")
                .password(passwordEncoder().encode("9876@Tgb1"))
                .roles("NORMAL")
                .build();

        return new InMemoryUserDetailsManager(user2,user1);

    }

    @Bean
    public SecurityFilterChain filterchain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers("/api/v1/home")
//                .hasRole("NORMAL")
//                .requestMatchers("/api/v1/home1")
//                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();

    }
}
