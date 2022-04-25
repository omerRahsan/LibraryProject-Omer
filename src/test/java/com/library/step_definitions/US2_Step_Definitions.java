package com.library.step_definitions;

import com.library.pages.DashboardPage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class US2_Step_Definitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    String borrowedBookNumbers1;

    @Given("I am in the homepage of the library app")
    public void iAmInTheHomepageOfTheLibraryApp() {

        loginPage.login();
    }

    @When("I take borrowed books number")
    public void iTakeBorrowedBooksNumber() {

        borrowedBookNumbers1 = dashboardPage.borrowedBookNumbers.getText();
        System.out.println(borrowedBookNumbers1);


    }

    @Then("borrowed books number information must match with DB")
    public void borrowedBooksNumberInformationMustMatchWithDB() {

        DB_Util.createConnection("jdbc:mysql://34.230.35.214:3306/library2",
                "library2_client","6s2LQQTjBcGFfDhY");


        DB_Util.runQuery("SELECT COUNT(book_id)\n" +
                "FROM book_borrow\n" +
                "where is_returned = 0;");

        String DBBorrowedBookNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println(DBBorrowedBookNumber);

        //borrowed books number information must match with DB

        Assert.assertEquals(DBBorrowedBookNumber,borrowedBookNumbers1);



    }
}
