package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Selenium1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = null;
        try {
            chromeDriver = new ChromeDriver();
            /*chromeDriver.get("https://google.com/");
            WebElement search = chromeDriver.findElement(By.name("q"));
            search.sendKeys("test");
            search.sendKeys(Keys.ENTER);
            System.out.println("searching test");*/

            Rozetka2page rozetka2page = new Rozetka2page(chromeDriver);
            rozetka2page.loadPage();
            System.out.println("Page loaded!");
            rozetka2page.search("");
            System.out.println("Search commited at: " + LocalDateTime.now());

            rozetka2page.verifySearchResult();
            System.out.println("Label found at: " + LocalDateTime.now());
            rozetka2page.verifySearchResultBrokenSpecially();
            System.out.println("This line newer works!");

        } catch (Exception e){
            System.out.println("Verification was broken at: " + LocalDateTime.now());
        }
        finally {
            if (chromeDriver != null) {
                chromeDriver.quit();
            }
        }
    }}

