package com.ceshi.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver webDriver;
    /*
   1.点击百度页面的新闻按钮
    */
    @BeforeMethod
    public void openBroeser(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //全局等待方法,一般放在最外层，也叫隐式等待
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
    }
    /*
    1.打开测试页面
    2.点击wait按钮
    3.获取文本，并判断是否是"wait for display"
     */
    @Test
    public void isDisplay(){
        webDriver.get("http://www.baidu.com/");
        //点击wait按钮
        webDriver.findElement(By.xpath(".//*[@id=su]/a")).click();
        //最推荐的一个方案
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                (By.xpath(".//*[@id=oo]/div"))));
        String text = webDriver.findElement(By.xpath(".//*[@id=oo]/div")).getText();

    }

    @AfterMethod
    public void close(){
        webDriver.quit();
    }
}
