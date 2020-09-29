package com.ceshi.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
    WebDriver webDriver;
    /*
   1.点击百度页面的新闻按钮
    */
    @BeforeMethod
    public void openBroeser(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    /*
    1.打开测试界面
    2.下拉框选择 小米、华为、魅族
     */
    @Test
    public void select() throws InterruptedException {
        webDriver.get("https://aaa.clll");
        WebElement element = webDriver.findElement(By.id("SSS"));
        Select select = new Select(element);
        select.selectByIndex(0);
        Thread.sleep(300);
        select.deselectByValue("huawei");
        Thread.sleep(300);
        select.selectByVisibleText("魅族");

    }
    @AfterMethod
    public void close(){
        webDriver.quit();
    }
}
