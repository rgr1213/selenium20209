package com.ceshi.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowsserActionTest {
    WebDriver webDriver ;
    @BeforeMethod
    public void begin(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com");
    }
    /*
    1.打开chrome浏览器
    2.打开百度首页
    3.等待5s
    4.关闭浏览器
     */
    @Test
    public void browserTest() throws InterruptedException {
        Thread.sleep(5000);
    }
    /*
    1.打开chrome浏览器
    2.打开百度首页
    3.等待5s
    4.后退
    4.等待3s
    4.关闭浏览器
     */
    @Test
    public void browserBack() throws InterruptedException {
        //等待5s
        Thread.sleep(5000);
        //后退
        webDriver.navigate().back();
        //等待3s
        Thread.sleep(3000);
    }
     /*
    1.打开chrome浏览器
    2.打开百度首页
    3.等待3s
    4.后退
    5.等待3s
    6.前进
    7.等待3s
    8.关闭浏览器
      */
    @Test
    public void browserForword() throws InterruptedException { webDriver = new ChromeDriver();
        Thread.sleep(3000);
        //后退
        webDriver.navigate().back();
        Thread.sleep(3000);
        //前进
        webDriver.navigate().forward();
        Thread.sleep(3000);
        //刷新
        webDriver.navigate().refresh();
    }
    //设置浏览器最大化
    @Test
    public void windowSize() throws InterruptedException {
        //获取浏览器最大化
        webDriver.manage().window().maximize();
     //   Dimension dimension = new Dimension(800,700);
        Thread.sleep(5000);
    }

    /*
    1.设置浏览器窗口大小
    2.获取当前页面url
    3.获取当前页面title
     */
    @Test
    public void getBrowserInfo() throws InterruptedException {
        //设置窗口大小
        Dimension dimension = new Dimension(900,800);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //获取当前页面
        webDriver.getCurrentUrl();
        Thread.sleep(2000);
        //校验url是否是百度url
        Assert.assertEquals( webDriver.getCurrentUrl(),"https://www.baidu.com/");

        //获取当前标题
        webDriver.getTitle();
        Thread.sleep(3000);
    }
    /*
    1.打开chrome浏览器
    2.打开百度首页
    3.等待5s
    4.校验
    4.关闭浏览器
     */
    @AfterMethod
    public  void close(){
        webDriver.quit();
    }
}
