package com.realitsolutions.demo.controller;

import com.realitsolutions.demo.model.PromptRequest;
import com.realitsolutions.demo.model.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SeleniumController {

    private final WebDriver driver;
    private final JavascriptExecutor js;
    private final Map<String, Object> vars;
    Response response;

    public SeleniumController() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @PostMapping("/execute-prompt")
    public Response executePrompt(@RequestBody PromptRequest promptRequest) {
        driver.get("https://chat.openai.com/auth/login?iss=https%3A%2F%2Fauth0.openai.com%2F");
        driver.manage().window().setSize(new Dimension(699, 728));
        driver.findElement(By.cssSelector(".relative:nth-child(1) > .relative")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("fokidav917@trazeco.com");
        driver.findElement(By.cssSelector(".\\_widget")).click();
        driver.findElement(By.name("action")).click();
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.cssSelector(".cd6a2dc65")).click();
        driver.findElement(By.id("prompt-textarea")).click();
        driver.findElement(By.id("prompt-textarea")).sendKeys(promptRequest.getPrompt());
        driver.findElement(By.cssSelector(".p-1 > span")).click();
        js.executeScript("window.scrollTo(0,0)");

        // Set the response or handle the request from Selenium as needed
        // For example, we can capture the response text and return it
        response.setMessage("Selenium test completed successfully");

        return response;
    }
}
