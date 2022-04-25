package com.library.step_definitions;

import com.library.pages.DashboardPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US5_Step_Definitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I login as a librarian")
    public void iLoginAsALibrarian() {
        loginPage.login();
    }

    @And("I navigate to {string} page")
    public void iNavigateToPage(String booklinkClick) {

        dashboardPage.bookslink.click();
    }

    @When("I open book {string}")
    public void iOpenBook(String arg0) {
    }

    @Then("book information must match the Database")
    public void bookInformationMustMatchTheDatabase() {
    }
}
