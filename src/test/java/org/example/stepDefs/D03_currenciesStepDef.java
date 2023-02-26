package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;
import org.openqa.selenium.support.ui.Select;

public class D03_currenciesStepDef {
    P03_homePage currencies =new P03_homePage();
    @And("user select currency from the dropdown list")
    public void chooseCurrency(){
        currencies.choose_currency().selectByVisibleText("Euro");
    }

    @Then("user check Euro sign in the four products")
    public void currency()
    {
        for (int i=0;i<currencies.euroSign().size();i++)
        {
             Assert.assertTrue(currencies.euroSign().get(i).getText().contains("€"));
        }
    }

}
