package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US4_Step_Definitions {
    @When("I execute a query to find the most popular user")
    public void iExecuteAQueryToFindTheMostPopularUser() {

        DB_Util.runQuery("SELECT full_name,count(*)\n" +
                "from users\n" +
                "inner join book_borrow on users.id = book_borrow.user_id\n" +
                "group by full_name;\n");



    }


    @Then("verify {string} is the user who reads the most")
    public void verifyIsTheUserWhoReadsTheMost(String userName) {


        String fullName = DB_Util.getFirstRowFirstColumn();

        Assert.assertEquals(userName,fullName);
    }
}
