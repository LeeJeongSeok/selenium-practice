package com.lee.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

    //WebDriver
    private WebDriver driver;
    private WebElement element;
    private String url;

    private String kakaourl = "https://accounts.kakao.com/login?continue=https%3A%2F%2Flogins.daum.net%2Faccounts%2Fksso.do%3Frescue%3Dtrue%26url%3Dhttps%253A%252F%252Fwww.daum.net%252F";

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "/Users/jeongseok/Downloads/chromedriver";

    public static void main(String[] args) {
       Selenium selenium = new Selenium();
    }

    public Selenium() {
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);

        url = "https://nid.naver.com/nidlogin.login?";

        driver.get(kakaourl);

        element = driver.findElement(By.id("id_email_2"));
        element.sendKeys("ljs0429777@kakao.com");

        //패스워드 입력
        element = driver.findElement(By.id("id_password_3"));
        element.sendKeys("kjccs123!@#");

        element = driver.findElement(By.className("btn_g"));
        element.click();
    }
}
