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

        driver.get(url);

        element = driver.findElement(By.id("id"));
        element.sendKeys("ljs0429777");

        //패스워드 입력
        element = driver.findElement(By.id("pw"));
        element.sendKeys("kjccs123!@#");

        element = driver.findElement(By.className("btn_global"));
        element.submit();
    }
}
