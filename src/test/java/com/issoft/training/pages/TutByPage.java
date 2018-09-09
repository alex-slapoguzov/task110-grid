package com.issoft.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TutByPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href=\"http://mail.tut.by/#ua:top_menu_www.tut.by~10\"]")
    private WebElement mailLink;

    public TutByPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickMailLink() {
        mailLink.click();
        return new LoginPage(driver);
    }
}
