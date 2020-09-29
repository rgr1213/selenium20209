package com.ceshi.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class closeBrowserTest {
    @Test
    public void chromeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭当前窗口
        webDriver.close();

    }
    @Test
    public void chromeTest1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭窗口,完全退出浏览器，一般采用quit
        webDriver.quit();

    }
}
