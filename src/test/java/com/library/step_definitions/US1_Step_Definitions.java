package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US1_Step_Definitions {
    /*
       Host IP: 34.230.35.214  (SAME FOR ALL)
       Username: library2_client
       Password: 6s2LQQTjBcGFfDhY
       Database name: library2
       Port: 3306
       JDBC url : jdbc:mysql://34.230.35.214:3306/library2
        */

    @Given("Establish the database connection")
    public void establishTheDatabaseConnection() {

        DB_Util.createConnection("jdbc:mysql://34.230.35.214:3306/library2",
                "library2_client","6s2LQQTjBcGFfDhY");
    }

    @When("Execute query to get all IDs from users")
    public void executeQueryToGetAllIDsFromUsers() {

        DB_Util.runQuery("select id from users");

    }

    @Then("verify all users has unique ID")
    public void verifyAllUsersHasUniqueID() {

        int allIdNumbers = DB_Util.getRowCount();

        DB_Util.runQuery("select distinct id from users;");
        int allDistinctIdNumbers = DB_Util.getRowCount();


        /*
        verifying all id numbers and all distinct id numbers are matching, if it will match it means
        all users have unique ids!
         */

        Assert.assertEquals(allIdNumbers,allDistinctIdNumbers);

    }

//------------------------------------------------------------------------------------------------------------------
    List<String> allColumnName;

    @When("Execute query to get all columns")
    public void executeQueryToGetAllColumns() {

        DB_Util.runQuery("select * from users;");
        allColumnName = DB_Util.getAllColumnNamesAsList();
        System.out.println(allColumnName);

    }

    @Then("verify the below columns are listed in result")
    public void verifyTheBelowColumnsAreListedInResult(List<String> columns) {

        Assert.assertEquals(allColumnName,columns);
    }
}
