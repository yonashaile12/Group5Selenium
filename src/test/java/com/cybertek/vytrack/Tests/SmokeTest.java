package com.cybertek.vytrack.Tests;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.vytrack.Pages.DashboardPage;
import com.cybertek.vytrack.Pages.LoginPage;
import com.cybertek.vytrack.Pages.OdometerPage;
import com.cybertek.vytrack.Verifications.VyTrackVerifications;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUrl();
        loginPage.login();
    }

    @Test
    public void loginVerification() {
        VyTrackVerifications verification = new VyTrackVerifications(driver);
        verification.verifyLogoIsPresent();
        System.out.println("Login test PASS");
    }

    @Test
    public void odometerPageIsDisplayedVerification() {
        DashboardPage page = new DashboardPage(driver);
        page.goToOdometerPage();
        VyTrackVerifications verification = new VyTrackVerifications(driver);
        verification.verifyVehicleOdometerPageIsDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
