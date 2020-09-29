package com.ceshi.day3;

import PoCase.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;
    @BeforeMethod
    public void begin(){
        System.setProperty("Webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
    }
    @Test
    public void caseTest(){
        //调用登录
        LoginTest.loginTest(webDriver,"meyoungtester ","meyoung123");
        String  s = webDriver.findElement(By.id("_mail_tabitem_3_119text")).getText();
        Assert.assertEquals(s,"收件箱");
    }
    //封装登录
    public static void loginTest(WebDriver webDriver,String zhanghao,String pwd){
        //driver控制权的转交
        WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        String id = iframe.getAttribute("id");
        if(id!=null){
            webDriver.switchTo().frame(id);
        }
        webDriver.findElement(LoginPage.emailInput).sendKeys(zhanghao);
        webDriver.findElement(LoginPage.password).sendKeys(pwd);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//隐式等待，不推荐使用
        webDriver.findElement(LoginPage.loginButton).click();

    }

    @AfterMethod
    public void close(){
        webDriver.quit();
    }

}
