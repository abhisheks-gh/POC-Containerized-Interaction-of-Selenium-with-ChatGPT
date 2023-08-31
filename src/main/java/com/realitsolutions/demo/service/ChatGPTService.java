/** Service layer that contains the business logic for interacting with ChatGPT and Selenium. */

package com.realitsolutions.demo.service;

import com.realitsolutions.demo.model.PromptRequest;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTService {

    private final WebDriver webDriver;

    @Autowired
    public ChatGPTService(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /** CREDENTIALS:
     * fokidav917@trazeco.com
     * Password@123 */
    public void loginToChatGPT() {
        try {
            // Navigate to login page
            webDriver.get("https://auth0.openai.com/u/login/identifier?state=hKFo2SAyZlFIWDZVVmdUVTlhbENVVU9KY2QyRDVEUVZGdVdnOKFur3VuaXZlcnNhbC1sb2dpbqN0aWTZIEZZcTZoX19yekZIQVJ0WFRHcmFvUzQzMWh5ZDlWanpEo2NpZNkgVGRKSWNiZTE2V29USHROOTVueXl3aDVFNHlPbzZJdEc");

            // Find and interact with the login elements (e.g., username, password, submit)
            WebElement usernameInput = webDriver.findElement(By.id("Email Address"));
            usernameInput.sendKeys("fokidav917@trazeco.com");
            WebElement continueButton = webDriver.findElement(By.id("Continue"));
            continueButton.click();
            WebElement passwordInput = webDriver.findElement(By.id("Password"));
            passwordInput.sendKeys("Password@123");
            WebElement submitButton = webDriver.findElement(By.id("Continue"));

            // Fill in the login form
            // usernameInput.sendKeys("fokidav917@trazeco.com");
            // passwordInput.sendKeys("Password@123");

            // Submit the form
            submitButton.click();

            // Add logic to wait for successful login or handle errors
            // You may also want to check if you are logged in successfully
        } catch (Exception e) {
            // Handle any exception
            e.printStackTrace();
        }
    }

    public String sendPromptToChatGPT(String prompt) {
        // Navigate to the ChatGPT website
        webDriver.get("https://chat.openai.com/");

        // Locate the input field and enter the prompt
        WebElement inputField = webDriver.findElement(By.id("chat-input"));
        inputField.sendKeys(prompt);

        // Submit the prompt (assuming there's a send button)
        WebElement sendButton = webDriver.findElement(By.id("send-button"));
        sendButton.click();

        // Wait for response
        // TODO: implement proper waiting strategies
        // Just using sleep here for simplicity (not recommended in production)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds (adjust as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieve and return the response
        WebElement responseElement = webDriver.findElement(By.id("response")); // Replace with the actual element ID
        return responseElement.getText();
    }

    public String getResponseFromChatGPT() {
        try {
            // Locate the response element (adjust the selector as needed)
            WebElement responseElement = webDriver.findElement(By.id("response")); // Replace with actual element ID or other selector

            // Extract the text from the response element
            String responseText = responseElement.getText();

            return responseText;
        } catch (Exception e) {
            // Handle any exceptions, log errors, or return an appropriate message
            e.printStackTrace();
            return "Failed to retrieve the response from ChatGPT";
        }
    }
}
