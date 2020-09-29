package com.ceshi.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    //校验a==a
    @Test
    public void assertEqualsTest(){
        String a = "asdf";
        String b = "asdf1111";
        /*
         if(a.equals(b)){
            System.out.println("正确");
        }else{
            System.out.println("错误");
        }
         */
        Assert.assertEquals(a,b,"a不等于b");
    }
    @Test
    public void assertNotEqual(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }
}
