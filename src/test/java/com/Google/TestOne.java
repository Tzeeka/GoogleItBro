package com.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestOne {
    ChromeDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void Test1() {

        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Bebe's Boobs Destroy Society");
        driver.findElement(By.cssSelector("input.lsb")).click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Bebe's Boobs Destroy Society - Поиск в Google"));

        WebElement results = driver.findElement(By.id("resultStats"));
        String resultsText = results.getText();
        Assert.assertTrue(!resultsText.equals(null));

    }

    @AfterClass
    public void finish() {
        driver.quit();
        driver = null;
    }



}

