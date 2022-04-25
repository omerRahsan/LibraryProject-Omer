package com.library.step_definitions;

import com.library.pages.BookManagementPage;
import com.library.pages.DashboardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US6_Step_Definitions {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    BookManagementPage bookManagementPage = new BookManagementPage();


    @Given("I log in as a librarian")
    public void iLogInAsALibrarian() {
        loginPage.login();
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String arg0) {

        dashboardPage.bookslink.click();
    }

    @And("I take all book categories in UI")
    public void iTakeAllBookCategoriesInUI() {
        Select select = new Select(bookManagementPage.dropdowns);
        List<WebElement> categoryOptions = select.getAllSelectedOptions();


    }

    @And("I execute a query to get book categories")
    public void iExecuteAQueryToGetBookCategories() {
        DB_Util.createConnection("jdbc:mysql://34.230.35.214:3306/library2",
                "library2_client","6s2LQQTjBcGFfDhY");
        DB_Util.runQuery("SELECT name\n" +
                "from book_categories;");

    }

    @Then("verify book categories must match the book_categories table from DB.")
    public void verifyBookCategoriesMustMatchTheBook_categoriesTableFromDB() {

        List<String> databaseCategoryNames =  DB_Util.getColumnDataAsList(1);;
        System.out.println(databaseCategoryNames);

    }
}
