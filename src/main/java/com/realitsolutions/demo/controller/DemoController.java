package com.realitsolutions.demo.controller;

import com.realitsolutions.demo.model.PromptRequest;
import com.realitsolutions.demo.model.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

//    private final WebDriver driver;
//    private final JavascriptExecutor js;
//    private final Map<String, Object> vars;
//    Response response;

//    public SeleniumController() {
//        driver = new ChromeDriver();
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<>();
//    }

    @GetMapping("/execute-prompt")
    public void executePrompt() {
        System.setProperty("webdriver.chrome.driver",
                "E:\\Dev Projects\\demo\\src\\main\\resources\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.get("http://localhost:19004/token/dashboard2/getdashboardbyname/" +
        // dashboardName);
        driver.get("https://chat.openai.com/auth/login?iss=https%3A%2F%2Fauth0.openai.com%2F");
        System.out.println("Hello!");
//        driver.manage().window().setSize(new Dimension(699, 728));
//        driver.findElement(By.cssSelector(".relative:nth-child(1) > .relative")).click();
//        driver.findElement(By.id("username")).click();
//        driver.findElement(By.id("username")).sendKeys("fokidav917@trazeco.com");
//        driver.findElement(By.cssSelector(".\\_widget")).click();
//        driver.findElement(By.name("action")).click();
//        driver.findElement(By.id("password")).sendKeys("Password@123");
//        driver.findElement(By.cssSelector(".cd6a2dc65")).click();
//        driver.findElement(By.id("prompt-textarea")).click();
//        driver.findElement(By.id("prompt-textarea")).sendKeys(promptRequest.getPrompt());
//        driver.findElement(By.cssSelector(".p-1 > span")).click();
//        js.executeScript("window.scrollTo(0,0)");

        // Set the response or handle the request from Selenium as needed
        // For example, we can capture the response text and return it
//        response.setMessage("Selenium test completed successfully");
//
//        return response;
    }
}
