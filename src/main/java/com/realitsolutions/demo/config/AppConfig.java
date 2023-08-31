/** Configuration class responsible for creating and configuring beans. */

package com.realitsolutions.demo.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${selenium.webdriver.path}")
    private String chromeDriverPath;    // Path to ChromeDriver executable

    @Bean
    public WebDriver webDriver() {
        // Set up and return the WebDriver (ChromeDriver in this case)
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
