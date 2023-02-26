package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D04_searchStepDef {
    P03_homePage search =new P03_homePage();
    SoftAssert soft = new SoftAssert();
    @And("^user enter \"(.*)\" in search field")
    public void enterProductName(String product_name)
    {
        search.searchProduct().sendKeys(product_name);
    }

    @And("^user enter product \"(.*)\"$")
    public void enterProductSKU(String sku)
    {
        search.searchProduct().sendKeys(sku);
    }

    @When("user press on search button")
    public void enterSearchBtn()
    {
        search.searchBtn().click();

    }

    @Then("user check search by \"(.*)\" \"(.*)\"$")
    public void searchResult(String name,int result)
    {
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q="+name+"");
        soft.assertAll();

      int count =driver.findElements(By.xpath("//div[@class=\"item-box\"]")).size();
      System.out.println("count:"+count);
      soft.assertEquals(count,result);
      soft.assertAll();

      // note:this assertion will fail in the case of book because not all search result have book word
      List<WebElement> searchResult =driver.findElements(By.xpath("//div[@class=\"item-box\"]"));
        for(WebElement results: searchResult)
        {
            soft.assertTrue(results.getText().toLowerCase().contains(""+name+""));
            soft.assertAll();
        }



    }
    @Then("check search by sku \"(.*)\"$")
    public void searchSkuResult(String sku) {
       driver.findElement(By.className("picture")).click();
      String skuResult= driver.findElement(By.cssSelector("span[class=\"value\" ][id]")).getText();
        Assert.assertEquals(skuResult,sku);
    }
}
