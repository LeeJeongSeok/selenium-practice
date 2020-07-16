package com.lee.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

    private String kakaourl = "https://accounts.kakao.com/login?continue=https%3A%2F%2Flogins.daum.net%2Faccounts%2Fksso.do%3Frescue%3Dtrue%26url%3Dhttps%253A%252F%252Fwww.daum.net%252F";

    //WebDriver
    private WebDriver driver;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "/Users/jeongseok/Downloads/chromedriver";

    public Selenium() {

        selenium_init();
        execute_selenium();

    }

    private void execute_selenium() {
        try {
            login();
            Thread.sleep(1000);
            go_to_mail();
            Thread.sleep(1000);
            delete_spam_mail();
        } catch (Exception e) {

        }
    }

    private void selenium_init() {
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);
    }

    public void login() {
        driver.get(kakaourl);

        driver.findElement(By.id("id_email_2")).sendKeys("ID");
        driver.findElement(By.id("id_password_3")).sendKeys("PW");
        driver.findElement(By.className("btn_g")).click();

    }

    public void go_to_mail() {
        driver.findElement(By.xpath("//*[@id=\"mArticle\"]/div[1]/div[2]/ul/li[1]/a")).click();
    }


    public void delete_spam_mail() {
        driver.findElement(By.xpath("//*[@id=\"mailToolbar\"]/div/div/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"mailToolbar\"]/div/div/div[2]/button[1]")).click();
    }
}

