package com.ceshi.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class gridTest {
    @Test
    public void testCase() throws MalformedURLException, InterruptedException {
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.1.7:5555/wd/hub"),chrome);
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.quit();
    }
}
