package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookManagementPage {

    public BookManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "book_categories")
    public WebElement dropdowns;
}
