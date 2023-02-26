package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {
    public WebElement loginLink(){
        return Hooks.driver.findElement(By.className("ico-login")) ;
    }
    public WebElement enterEmail()
    {
        return   Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement enterPassword()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement loginButton()
    {
        return Hooks.driver.findElement(By.className("login-button"));
    }
    public WebElement error_Msg()
    {
        return Hooks.driver.findElement(By.className("message-error"));
    }

}
