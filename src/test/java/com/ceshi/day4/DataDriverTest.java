package com.ceshi.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {
    //数据源
    @DataProvider(name="login")
    public Object[][] data1(){
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"}
        };
    }

    @Test(dataProvider = "login")
    public void loginTest(String username,String pwd){
        System.out.println("username: "+username);
        System.out.println("PWD: "+pwd);
    }


}
