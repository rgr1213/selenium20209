package com.ceshi.day1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo1 {

    @Test
    public void testCase1(){
        //第一个测试用例
        System.out.println("sss");
    }

    @Test
    public void testCase2(){
        //第二个测试用例
        System.out.println("2SSSS");
    }
    @BeforeTest
    public void beforeCase1(){
        //这个测试用例会在所有的@Test运行之前运行一次，
        // 比如：打开一次浏览器
        System.out.println("Beforesss");
    }
    @AfterTest
    public void afterCase2(){
        //这个测试用例在所有的@Test运行之后去运行一次
        //比如：关闭
        System.out.println("aftersss");
    }
}
