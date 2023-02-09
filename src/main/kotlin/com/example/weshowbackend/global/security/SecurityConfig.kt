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

                .antMatchers(HttpMethod.POST,"/user/signup").permitAll()
                .antMatchers(HttpMethod.POST,"/user/sign").permitAll()
                .antMatchers(HttpMethod.PUT,"/user/refresh").authenticated()

                .antMatchers(HttpMethod.GET, "/profile").authenticated()
                .antMatchers(HttpMethod.PUT, "/profile").authenticated()

                .antMatchers(HttpMethod.POST, "/review/{id}").authenticated()
                .antMatchers(HttpMethod.PUT, "/review/{id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/review{id}").authenticated()

                .antMatchers(HttpMethod.POST, "/point/{id}").authenticated()
                .antMatchers(HttpMethod.PUT, "/point/{id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/point/{id}").authenticated()

                .antMatchers(HttpMethod.GET, "/order").authenticated()

                .antMatchers(HttpMethod.GET, "/product/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/product").permitAll()
                .antMatchers(HttpMethod.GET, "/product/category/{category}").permitAll()
                .antMatchers(HttpMethod.GET, "/product/search/{title}").permitAll()
                .antMatchers(HttpMethod.POST, "/product/{product-id}/{count}").authenticated()
                .antMatchers(HttpMethod.GET, "/product/basket").authenticated()
                .antMatchers(HttpMethod.POST, "/product/order").authenticated()

                .antMatchers(HttpMethod.GET, "/product/v1").authenticated()
                .antMatchers(HttpMethod.POST, "/product/v1").authenticated()
                .antMatchers(HttpMethod.PUT, "/product/v1/{id}").authenticated()
                .antMatchers(HttpMethod.GET, "/product/v1/{id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/product/v1/{id}").authenticated()

                .anyRequest().authenticated()

                .and()
                .apply(FilterConfig(objectMapper, jwtTokenProvider))

        return http.build()
    }

    @Bean
    protected fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}