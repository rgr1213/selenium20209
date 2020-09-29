package com.ceshi.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
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
    1.打开测试页面
    2.点击百度链接
     */
    @Test
    public void  openIfame(){
        webDriver.get("https://www.baidu.com/");
        //转交控制权，通过id或者name转交
        webDriver.switchTo().frame("aa");
        webDriver.findElement(By.linkText("baidu")).click();
        //将控制权转交到原来的页面
        webDriver.switchTo().defaultContent();
        //定位原页面的东西
        webDriver.findElement(By.linkText("新闻"));
        //对于多层iframe嵌套，应多次转交就可以了
    }
    @AfterMethod
    public void close(){
        webDriver.quit();
    }
}
