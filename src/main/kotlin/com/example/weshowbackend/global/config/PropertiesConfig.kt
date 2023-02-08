package com.example.weshowbackend.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackages = ["com.example.demo"])
@Configuration
class PropertiesConfig {
}