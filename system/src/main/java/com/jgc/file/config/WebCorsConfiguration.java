package com.jgc.file.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>跨域配置</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 10:07
 **/
@Configuration
@ConfigurationProperties("jgc.web.cors")
public class WebCorsConfiguration {
    private CorsConfiguration config = new CorsConfiguration();

    public WebCorsConfiguration() {
    }

    public CorsConfiguration getConfig() {
        return this.config;
    }

    public void setConfig(CorsConfiguration config) {
        this.config = config;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", this.config);
        return new CorsFilter(source);
    }
}
