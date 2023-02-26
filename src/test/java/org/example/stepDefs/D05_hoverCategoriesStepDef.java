package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCategoriesStepDef {

    P03_homePage hover = new P03_homePage();

    Actions action = new Actions(driver);
    int min = 0;
    int max = hover.hoverCategory().size()-1;
    int selectedItem = (int) Math.floor(Math.random() * (max - min + 1) + min);
    int selectedItem1, selectedItem2, selectedItem3;
 String computer,electo,apparel;
    @When("user hover on category")
    public void categoriesHover() {

        action.moveToElement(hover.hoverCategory().get(selectedItem)).perform();

        //hover.hoverComputer().get(selectedItem).click();
    }

    @Then("user select a subcategory and open page")
    public void selectSubCategory() {

        SoftAssert soft = new SoftAssert();
        int min = 0;
        int max = 2;

        if (hover.hoverCategory().get(selectedItem).getText().contains("Computers")) {
            selectedItem1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            WebElement n = hover.computerCategories().get(selectedItem1);
             computer=n.getText();
            n.click();
            soft.assertTrue(driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText().toLowerCase().trim().contains(computer.toLowerCase().trim()));
            soft.assertAll();
        } else if (hover.hoverCategory().get(selectedItem).getText().contains("Electronics")) {
            selectedItem2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            WebElement f = hover.electronicsCategories().get(selectedItem2);
             electo=f.getText();
            f.click();
            soft.assertTrue(driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText().toLowerCase().trim().contains(electo.toLowerCase().trim()));
            soft.assertAll();
        } else {

            selectedItem3 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            WebElement m = hover.apparelCategories().get(selectedItem3);
             apparel= m.getText();
            m.click();
            soft.assertTrue(driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText().toLowerCase().trim().contains(apparel.toLowerCase().trim()));
            soft.assertAll();
        }


    }


}
