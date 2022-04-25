package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US3_Step_Definitions {

    @When("I execute a query to find the most popular book genre")
    public void iExecuteAQueryToFindTheMostPopularBookGenre() {

        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "    inner  join books b on bb.book_id = b.id\n" +
                "    inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc;");

        String theFamousCategory = DB_Util.getFirstRowFirstColumn();
        System.out.println(theFamousCategory);


    }


    @Then("verify that {string} is the most popular book genre.")
    public void verifyThatIsTheMostPopularBookGenre(String popularGenre) {

        Assert.assertEquals("Classic",popularGenre);

    }
}
