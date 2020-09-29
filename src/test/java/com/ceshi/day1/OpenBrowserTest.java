package com.ceshi.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

public class OpenBrowserTest {
    @Test
    public void fixTest(){
        WebDriver webDriver = new FirefoxDriver() ;
    }
    @Test
    public void fixTest2(){
        //没有打开成功
        System.setProperty("webdriver.firefox.driver","D:\\Program Files\\selenium\\drivers\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void chromeTest(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }
    @Test
    public void ieTest(){
        System.setProperty("webdriver.ie.driver","D:\\Program Files\\selenium\\drivers\\IEDriverServer.exe");
    }
}
