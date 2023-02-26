package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_register {
    public WebElement registerLink(){
        return Hooks.driver.findElement(By.className("ico-register")) ;
    }
public WebElement selectGenderType()
{
    return Hooks.driver.findElement(By.id("gender-male"));
}
public WebElement enterFName()
{
    return Hooks.driver.findElement(By.id("FirstName"));
}

public WebElement enterLName()
{
    return Hooks.driver.findElement(By.id("LastName"));
}


    public Select selectDayOfBirth()
    {
        Select day=new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        return day;
    }
    public Select selectMonthOfBirth()
    {
        Select month=new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        return month;
    }
    public Select selectYearOfBirth()
    {
        Select year=new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        return year;
    }

    public WebElement enterEmail()
    {

        return   Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement enterPassword()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement enterConfirmPassword()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement regButton()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }
public WebElement sucess_Msg()
{
    return Hooks.driver.findElement(By.className("result"));
}


}
