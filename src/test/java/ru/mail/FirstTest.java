package ru.mail;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FirstTest {
    @Test
    public void firstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vanek\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://mail.ru/");

        WebElement registr = driver.findElement(By.xpath("//a[@data-testid='mailbox-create-link']"));
        registr.click();

        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));

        WebElement element1 = driver.findElement(By.xpath("//form/button/span[text()='Создать']"));
        element1.click();
        Thread.sleep(5000);

        List <WebElement> fields = driver.findElements(By.xpath("//div[@data-test-id='error-footer-text']"));

        for (WebElement label : fields) {
            String text = label.getText();
            String kek = driver.findElement(By.xpath("//div[@data-test-id='error-footer-text']//small[text()='"+text+"']/ancestor::*/div/label[contains(@class,'base')]")).getText();
            System.out.println("В поле " + kek + " " + text);
        }

        driver.quit();
    }
}
