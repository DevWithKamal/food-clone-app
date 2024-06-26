package com.nexdew.authenticationservice.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private  final  JWTAuthenticationFilter jwtAuthenticationFilter;
private final  ApplicationConfig applicationConfig;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests(request->request
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("/api/v1/admin/**").hasAuthority("ADMIN ACCESS")
                        .requestMatchers("/api/v1/user/**").hasAuthority("USER")
                        .requestMatchers("/api/v1/otp/**").hasAuthority("ADMIN ACCESS")
                        .requestMatchers("/api/v1/MANAGER/**").hasAuthority("MANAGER")
                        .requestMatchers("/api/v1/CUSTOMER/**").hasAuthority("CUSTOMER")
                        .anyRequest().authenticated()
                ).sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(applicationConfig.authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return  httpSecurity.build();
    }

}
