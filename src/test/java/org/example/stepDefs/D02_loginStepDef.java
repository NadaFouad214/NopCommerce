package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D02_loginStepDef {



    P02_login login =new P02_login();
    SoftAssert soft = new SoftAssert();

    @Given("user go to login page")
    public void pressLoginIcon()
    {
        login.loginLink().click();
    }
    @And("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
    public void userEmailAndPassword(){
        login.enterEmail().sendKeys("tes6t@example.com");
        login.enterPassword().sendKeys("P@ssw0rd");
    }
    @When("user press on login button")
    public void pressRegButton()
    {
        login.loginButton().click();
    }
    @Then("user login to the system successfully")
    public void verify()
    {
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        WebElement myaccount = Hooks.driver.findElement(By.className("ico-account"));
        soft.assertTrue(myaccount.isDisplayed());
        soft.assertAll();
    }


    // scenario 2
    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void invalid(){
        login.enterEmail().sendKeys("asmaa@test.com");
        login.enterPassword().sendKeys("12345");
    }

    @Then("user could not login to the system")
    public void notlogedin(){
        SoftAssert soft = new SoftAssert();
        String errormsg =  login.error_Msg().getText();
        soft.assertTrue(errormsg.contains("Login was unsuccessful."));
        String msgColor= login.error_Msg().getCssValue("color");
        String hexColor= Color.fromString(msgColor).asHex();
        soft.assertEquals(hexColor,"#e4434b");
        soft.assertAll();
    }

}
