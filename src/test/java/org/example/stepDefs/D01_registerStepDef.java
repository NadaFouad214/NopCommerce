package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class D01_registerStepDef {
    P01_register reg = new P01_register();
    SoftAssert soft = new SoftAssert();
    @Given("user go to register page")
    public void pressRegisterIcon()
    {
        reg.registerLink().click();
    }
    @And("user select gender type")
    public void selectGender(){reg.selectGenderType().click();}
    @And("user enter first name and last name")
    public void fNameAndLName(){
        reg.enterFName().sendKeys("automation");
        reg.enterLName().sendKeys("tester");}

    @And("user enter date of birth")
    public void dateOfBirth(){
        int rand = (int) Math.floor(Math.random()*(32-1+1)+1);
        reg.selectDayOfBirth().selectByIndex(rand);
        int rand2 = (int) Math.floor(Math.random()*(13-1+1)+1);
        reg.selectMonthOfBirth().selectByIndex(rand2);
        int rand3 = (int) Math.floor(Math.random()*(111-1+1)+1);
        reg.selectYearOfBirth().selectByIndex(rand3);
    }
    @And("user enter email field")
    public void emailField(){
        reg.enterEmail().sendKeys("tes6t@example.com");
    }

    @And("user fills Password fields")
    public void enterPasswordAndConfirmation()
    {
        reg.enterPassword().sendKeys("P@ssw0rd");
        reg.enterConfirmPassword().sendKeys("P@ssw0rd");
    }
    @When("user clicks on register button")
    public void pressRegButton()
    {
        reg.regButton().click();
    }
    @Then("success message is displayed")
    public void successMsg()
    {
        //Success message is displayed "Your registration completed"
          soft.assertTrue(reg.sucess_Msg().getText().contains("Your registration"));
        //the color of this message is green rgba(76, 177, 124, 1)
        soft.assertEquals(reg.sucess_Msg().getCssValue("color"),"rgba(76, 177, 124, 1)");
         soft.assertAll();
    }



}



