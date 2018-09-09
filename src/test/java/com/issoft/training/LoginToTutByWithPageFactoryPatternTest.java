package com.issoft.training;

import com.issoft.training.pages.LoginPage;
import com.issoft.training.pages.MailPage;
import com.issoft.training.pages.TutByPage;
import com.issoft.training.pages.YandexPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginToTutByWithPageFactoryPatternTest {

	private final static String TYT_BY_URL = "https://www.tut.by/";
	private final static String LOGIN = "seleniumtests10";
	private final static String PASSWORD = "060788avavav";
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN10);
		capabilities.setBrowserName("chrome");

		driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get(TYT_BY_URL);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	public void loginTutByTest() {
		TutByPage tutByPage = new TutByPage(driver);
		LoginPage loginPage = tutByPage.clickMailLink();
		MailPage mailPage = loginPage.login(LOGIN, PASSWORD);
		Assert.assertTrue(mailPage.isFormPresent(), "Form isn't present");
	}

	@Test(dependsOnMethods = {"loginTutByTest"})
	public void logOutTutByTest() {
		MailPage mailPage = new MailPage(driver);
		mailPage.logout();
		YandexPage yandexPage = new YandexPage(driver);
		Assert.assertTrue(yandexPage.isInputFieldIsPresent(), "Input field isn't on Yandex page");
	}
}
