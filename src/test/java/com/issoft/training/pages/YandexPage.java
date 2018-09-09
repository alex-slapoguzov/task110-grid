package com.issoft.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".input__control.input__input")
    private WebElement inputField;

    public YandexPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public boolean isInputFieldIsPresent() {
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        return inputField.isDisplayed();
    }
}
