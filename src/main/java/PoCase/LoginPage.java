package PoCase;

import org.openqa.selenium.By;

/*
1.把一个页面可能用到的自动化元素都定义到这个页面上来
 */
public class LoginPage {
    //定义email文本框的定位方式
    public  static  By emailInput = By.name("email");
    //定义密码文本框的定义方式
    public  static  By password = By.name("password");
    //定义登录按钮的定义方式
    public static  By loginButton = By.id("dologin");
    //定义注册按钮的定义方式
    public static By register = By.id("register");
}
