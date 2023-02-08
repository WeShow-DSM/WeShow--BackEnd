package com.example.weshowbackend.global.security

import com.example.weshowbackend.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig (
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .formLogin().disable()
                .csrf().disable()
                .cors()

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
                .authorizeHttpRequests()

                .requestMatchers(HttpMethod.POST,"/user/signup").permitAll()
                .requestMatchers(HttpMethod.POST,"/user/sign").permitAll()

                .requestMatchers(HttpMethod.GET, "/profile").authenticated()
                .requestMatchers(HttpMethod.PUT, "/profile").authenticated()

                .requestMatchers(HttpMethod.POST, "/review/{id}").authenticated()
                .requestMatchers(HttpMethod.PUT, "/review/{id}").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/review{id}").authenticated()

                .requestMatchers(HttpMethod.POST, "/point/{id}").authenticated()
                .requestMatchers(HttpMethod.PUT, "/point/{id}").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/point/{id}").authenticated()

                .requestMatchers(HttpMethod.GET, "/order").authenticated()

                .anyRequest().authenticated()

                .and()
                .apply(FilterConfig(objectMapper, jwtTokenProvider))

        return http.build()
    }

    @Bean
    protected fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}