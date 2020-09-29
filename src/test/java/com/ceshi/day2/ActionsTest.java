package com.ceshi.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    WebDriver webDriver;
    /*
    1.点击百度页面的新闻按钮
     */
    @BeforeMethod
    public void openBroeser(){
        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
    }
   @Test
    public void caseLink() throws InterruptedException {
        //定位新闻
      WebElement webElement = webDriver.findElement(By.linkText("新闻"));
      Thread.sleep(3000);
      //点击新闻链接
       webElement.click();
       //先获取当前url
       String url = webDriver.getCurrentUrl();
       //校验当前页面是否新闻页面
       Assert.assertEquals(url,"https://www.baidu.com/");
   }

    /*
    1.打开百度首页
    2.输入关键字selenium
    3.点击百度一下
    4.校验搜索的是否是第一行
     */
    @Test
    public void sendKeysTest() throws InterruptedException {
        //sendkeys在input标签，不能用于button按钮 ********
        webDriver.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(3000);
        //等待的原因，是有的页面还没加载完成，就去点击，会报错，Thread不是很推荐，暂时用
        webDriver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        String title = webDriver.getTitle();
        Thread.sleep(3000);
        Assert.assertEquals(title,"selenium_百度搜索");
    }
    /*
    1.clear()方法  清空文本框
     */
    @Test
    public void clearText() throws InterruptedException {
        //定位文本框
       WebElement webElement =  webDriver.findElement(By.id("kw"));
       //文本框输入值
       webElement.sendKeys("selenium");
       Thread.sleep(3000);
       //清空文本框
       webElement.clear();
    }
    /*
    1.打开百度首页
    2.获取新闻链接文本
    3.校验文本是否新闻
     */
    @Test
    public void texText() throws InterruptedException {
         String test = webDriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]")).getText();
         Thread.sleep(2000);
         //keys.getText获取的是<a></a>中间的值，而不是文本框中的值，是获取标签中间的值
        //Assert.assertEquals放在最后
         Assert.assertEquals(test,"新闻");
    }
    /*
    1.打开百度首页
    2.获取文本框的tagname
    3.校验是否为input
     */
    @Test
    public void tagNameText(){
       WebElement webElement = webDriver.findElement(By.id("kw"));
       String tagName = webElement.getTagName();
       Assert.assertEquals(tagName,"input");
    }
    /*
    1.打开百度页面
    2.判断按钮显示的文本是 百度一下
     */
    @Test
    public void getAtrribute(){
        WebElement webElement = webDriver.findElement(By.id("su"));
        String a = webElement.getAttribute("value");
        Assert.assertEquals(a,"百度一下");
    }
    /*
    1.打开百度按钮
    2.校验百度按钮是否显示
     */
    @Test
    public void isdisplayTest(){
       Boolean a = webDriver.findElement(By.id("su")).isDisplayed();
       Assert.assertTrue(a);
    }

    /**
     * 1.打开测试页面
     * 2.判断按钮是否被选中
     */
    /*
    1.打开百度首页
    2.截图百度首页
     */
    @Test
    public void shotTest() throws IOException {
        //只能截取到当前的页面，截图目的是为了跑脚本之后，就立即截图
        File file =((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        //图片的格式可以随便命名jpg、png
        FileUtils.copyFile(file,new File("D:\\test1.png"));
    }
   @AfterMethod
    public void close(){
        webDriver.quit();
   }

}
