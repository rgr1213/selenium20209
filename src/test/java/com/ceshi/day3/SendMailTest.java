package com.ceshi.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendMailTest {
    WebDriver webDriver;
    @BeforeMethod
    public void begin(){
        System.setProperty("Webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
        //全局等待
        webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

    }
    @Test
    public void caseTest(){
        //调用登录
        LoginTest.loginTest(webDriver,"meyoungtester ","meyoung123");
        //点击写信按钮
        webDriver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //定位收件人，并且发送文本
        webDriver.findElement(By.className
                ("js-component-emailcontainer nui-multiLineIpt C-multiLineIpt nui-ipt"))
                .sendKeys("aaaaaa");
        //定位主题，发送文本
        webDriver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input"))
                .sendKeys("这个是主体");
        //点击附件，上传文件
        webDriver.findElement(By.xpath(".//*[@title=['一次可发送2000张照片，600首MP3，一部高清电影']/input"));
        //定位iframe
        WebElement frame = webDriver.findElement(By.className("APP-editor-iframe"));
        //转交iframe
        webDriver.switchTo().frame(frame);
        //在iframe里面定位
        webDriver.findElement(By.xpath("/html/body")).sendKeys("22222");
        //控制权转交回原页面
        webDriver.switchTo().defaultContent();
        //发送按钮
        webDriver.findElement(By.xpath(".//*[text()='发送']")).click();
        //校验是否发送成功
        Boolean sc = webDriver.findElement(
                By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertEquals(sc,"发送成功");


    }
    //封装登录
    public static void loginTest(WebDriver webDriver,String zhanghao,String pwd){
        //driver控制权的转交
        WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        String id = iframe.getAttribute("id");
        if(id!=null){
            webDriver.switchTo().frame(id);
        }
        webDriver.findElement(By.name("email")).sendKeys(zhanghao);
        webDriver.findElement(By.name("password")).sendKeys(pwd);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//隐式等待，不推荐使用
        webDriver.findElement(By.id("dologin")).click();
        String  s = webDriver.findElement(By.id("_mail_tabitem_3_119text")).getText();
        Assert.assertEquals(s,"收件箱");

    }

    @AfterMethod
    public void close(){
        webDriver.quit();
    }

}
