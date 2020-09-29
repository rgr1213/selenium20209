package com.ceshi.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsSlectTest {
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
    2.点击open new window
    3.点击百度
     */
    @Test
    public void openWindows() throws InterruptedException {
        webDriver.get("http:www.baidu.com");
        webDriver.findElement(By.linkText("open new window")).click();
        Thread.sleep(3000);
        String handle = webDriver.getWindowHandle(); //获取当前页面的handle值
        webDriver.getWindowHandles();//获取当前页面的所有handle值
        for (String handles : webDriver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }
            //转交handle
            webDriver.switchTo().window(handles);
        }
        webDriver.findElement(By.linkText("baidu"));
        //回到原来的页面
        webDriver.switchTo().window(handle);
    }
    @AfterMethod
    public void close(){
        webDriver.quit();
    }
}
