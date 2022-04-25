package com.library.pages;

import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryPageUrl"));

        emailBox.sendKeys(ConfigurationReader.getProperty("librarianemail"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        signInButton.click();
    }
}
