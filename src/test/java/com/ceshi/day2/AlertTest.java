package com.ceshi.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
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
    JS的弹窗，无法定位，用这种方法处理************
    1.打开UI自动化页面
    2.点击alert弹窗按钮
    3.在alert警告窗口里点击确定按钮
     */
    @Test
    public void alert(){
      webDriver.get("file:selenium.html");
      //点击alert按钮
      webDriver.findElement(By.className("alert")).click();
      //将控制权转交给alert
      Alert alert =  webDriver.switchTo().alert();
      //获取弹框中的文本进行校验
        String test = alert.getText();
        //校验获取弹窗内容
        Assert.assertEquals(test,"请输入密码");
      //点击alert中的确定
      alert.accept();
    }
    /*
    JS的弹窗，无法定位，用这种方法处理****************
    1.获取页面
    2.点击comfirm按钮
    3.点击取消按钮
    4.点击确定按钮
     */
    @Test
    public void comfired() throws InterruptedException {
        webDriver.get("file:selenium.html");
        //1.点击confirm按钮
        webDriver.findElement(By.className("comfire")).click();
        Thread.sleep(3000);
        //driver控制权转交给alert
        Alert alert = webDriver.switchTo().alert();
        //弹窗里点击取消
        alert.dismiss();
        Thread.sleep(3000);
        //弹窗里点击确定
        alert.accept();
    }
    /*
    JS的弹窗，无法定位，用这种方法处理*******************
    1.获取页面
    2.点击prompt按钮
    3.在prompt弹窗中输入这个prompt
    4.点击确定按钮
    5.再次点击确定按钮
     */
    @Test
    public void prompt() throws InterruptedException {
        webDriver.get("file://index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        //转交控制权给alert
        Alert alert = webDriver.switchTo().alert();
        //
        alert.sendKeys("这个是prompt");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }
    @AfterMethod
    public void close(){
        webDriver.quit();
    }
}
