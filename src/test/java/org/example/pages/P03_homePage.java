package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P03_homePage {

public Select choose_currency ()
{
    Select E=new Select(Hooks.driver.findElement(By.id("customerCurrency")));
    return E;
}

    public List<WebElement> euroSign()
    {
        return Hooks.driver.findElements(By.xpath("//span[@class=\"price actual-price\"]"));
    }

    public WebElement searchProduct(){
    return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchBtn(){
        return Hooks.driver.findElement(By.className("search-box-button"));
    }


    public List<WebElement> hoverCategory()
    {
        List<WebElement> computer= new ArrayList<>(3);
        computer.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/computers\"] ")));
        computer.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/electronics\"] ")));
        computer.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/apparel\"] ")));
         return computer;
    }

    public List<WebElement> computerCategories()
    {
        List<WebElement> computer= new ArrayList<>(3);
        computer.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/desktops\"]")));
        computer.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/notebooks\"]")));
        computer.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/software\"]")));
        return computer;
    }
    public List<WebElement> electronicsCategories()
    {
        List<WebElement> elec= new ArrayList<>(3);
        elec.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/camera-photo\"]")));
        elec.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/cell-phones\"]")));
        elec.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/others\"]")));
        return elec;
    }
    public List<WebElement> apparelCategories()
    {
        List<WebElement> apparel= new ArrayList<>(3);
        apparel.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/shoes\"]")));
        apparel.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/clothing\"]")));
        apparel.add(Hooks.driver.findElement(By.cssSelector("a[href=\"/accessories\"]")));
        return apparel;
    }

}
