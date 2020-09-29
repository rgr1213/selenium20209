package com.ceshi.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest2 {
    WebDriver driver;
    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.chrome","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }
    /*
    1.打开百度页面
    2.在百度按钮上右键
     */
    @Test
    public void actionsTest() throws InterruptedException {
        //定位百度一下按钮
        WebElement  element = driver.findElement(By.id("su"));
        //new Actions 对象
        Actions actions = new Actions(driver);
        //显示等待
      //  WebDriverWait webDriverWait = new WebDriverWait(driver,10);
     //   webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("su")));
        Thread.sleep(3000);
        //在百度按钮上右键
        actions.contextClick(element).perform();
        //双击百度按钮,
     //   actions.doubleClick(webElement).perform();

    }
    @AfterMethod
    public void end()  {
    //    Thread.sleep(3000);
        driver.quit();
    }
}
