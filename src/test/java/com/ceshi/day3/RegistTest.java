package com.ceshi.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistTest {
    WebDriver webDriver;
    @BeforeMethod
    public void begin(){
        System.setProperty("Webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void testCase() throws InterruptedException {
        webDriver.get("https://mail.163.com/");
        //定位到注册界面,并点击
        webDriver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]")).click();
        Thread.sleep(1000);
        //获取当前driver所在的handle值
        String handle = webDriver.getWindowHandle();
        for(String handldes : webDriver.getWindowHandles()){
            if(handldes.equals(handle)){
                continue;
            }
            webDriver.switchTo().window(handldes);
           String time =  String.valueOf(System.currentTimeMillis()/100);
            webDriver.findElement(By.id("username"))
                    .sendKeys(time); //时间戳13位
            Thread.sleep(2000);
            webDriver.findElement(By.id("password")).sendKeys("123123XZ");
            Thread.sleep(2000);
            webDriver.findElement(By.id("phone"))
                    .sendKeys(time);
            WebDriverWait webDriverWait = new WebDriverWait(webDriver,30);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("立即注册")));
            webDriver.findElement(By.linkText("立即注册")).click();
        }

    }

    @AfterMethod
    public void close(){
        webDriver.quit();
    }
}
