package com.Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import java.util.concurrent.TimeUnit;

public class MailTest {
    ChromeDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void start1() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void LoginTest () {
            driver.get("https://gmail.com");
            WebElement login = driver.findElement(By.cssSelector("#identifierId"));
            login.sendKeys("yourmail@gmail.com");
            driver.findElement(By.cssSelector("#identifierNext > content > span")).click();
            WebElement password = driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input"));
            password.sendKeys("password");
            wait.until(presenceOfElementLocated(By.cssSelector("div.PxpPTe.dCgGDe")));
            driver.findElement(By.cssSelector("#passwordNext > content > span")).click();
        }

    @Test
    public void findMail () {
            WebElement searchBox = driver.findElement(By.cssSelector("#gbqfq"));
            searchBox.sendKeys("TestHomework");
            WebElement search = driver.findElement(By.cssSelector("#gbqfb > span"));
            search.click();
            Actions actions = new Actions(driver);
            WebElement findedMail = driver.findElement(By.xpath("//*[@id=\":6y\"]"));
            actions.moveToElement(findedMail).click().build().perform();
        }

    @Test
    public void getSender() {
                WebElement senderMail = driver.findElement(By.cssSelector("span.go"));
                String senderMailTxt = senderMail.getText();
                Assert.assertTrue(senderMailTxt.equals("<tzeeka@gmail.com>"));
        }

    @Test
    public void getText() {
            wait.until(presenceOfElementLocated(By.cssSelector("#\\3a 8a > div:nth-child(1)")));
            WebElement mailBody = driver.findElement(By.cssSelector("#\\3a 8a > div:nth-child(1)"));
            String mailBodyTxt = mailBody.getText();
            Assert.assertTrue(mailBodyTxt.equals("Это нужное письмо"));
        }


    @Test
    public void getTheme() {
            WebElement theme = driver.findElement(By.cssSelector("#\\3a 7g > span"));
            String themeTxt = theme.getText();
            Assert.assertTrue(themeTxt.equals("TestHomework"));
        }

    @AfterClass
    public void finish2() {
        driver.quit();
        driver = null;
    }

}
