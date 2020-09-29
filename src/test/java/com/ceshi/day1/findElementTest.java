package com.ceshi.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class findElementTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome(){

        System.setProperty("webdriver.chrome.driver","D:\\Program Files\\selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    /*
    1.打开百度搜索框
    2.定位百度搜索框
     */
    @Test
    public void openBaiDu() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
      // 1. WebElement webElement =  webDriver.findElement(By.id("kw"));  通过id属性
      // 2. webDriver.findElement(By.name("wd"));  通过name属性查找
     //  3. webDriver.findElement(By.className("s_ipt"));  通过className属性查找
        // 通过By.linkTest(),只能是<a></a>可以用  **********
        //4.webDriver.findElement(By.linkText("贴吧")); 通过链接文本
       //5. webDriver.findElement(By.partialLinkText("贴")); 通过部分链接文本
        /*
        6.通过tagName寻找
        List<WebElement> list = webDriver.findElements(By.tagName("input"));
        System.out.println(list.size());
         */

        /*
        7.通过xpath查找
        （1）WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[5]"));
        （2）一次性定位所有元素，然后遍历得到所要得到的元素
           List<WebElement> list = webDriver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).getText());
            }
         */

     //8. webDriver.findElements(By.cssSelector("#lg > map > area")); 通过css路径定位
        //优先考虑id、name（查找是否有相同的）、xpath
        Thread.sleep(3000);

    }
    //关闭浏览器
    @AfterMethod
    public void close(){
        webDriver.quit();
    }



}
