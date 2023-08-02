package ru.mail;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ThirdTest {

    @Test
    public void thirdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vanek\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//Открыть окно в полный размер экрана
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Добавление неявного ожидания длительностью 5 секунд

        driver.get("https://mail.ru/");//Открыть сайт mail.ru

        WebElement registr = driver.findElement(By.xpath("//a[@data-testid='mailbox-create-link']"));//Найти кнопку регистрации
        registr.click();//Нажать на кнопку регистрации

        ArrayList tabs = new ArrayList(driver.getWindowHandles());//Получение списка открытых вкладок браузера
        driver.switchTo().window((String) tabs.get(1));//Переключиться на вторую открытую вкладку браузера

        WebElement fieldSecondname = driver.findElement(By.xpath("//input[@name='lname']"));//Найти поле ввода "Фамилия"
        fieldSecondname.sendKeys("Иванов");//Ввести в поле "Фамилия" значение "Иванов"

        WebElement element1 = driver.findElement(By.xpath("//form/button/span[text()='Создать']"));//Найти кнопку "Создать"
        element1.click();//Нажатие по кнопке "Создать"
        Thread.sleep(2000);

        List <WebElement> fields = driver.findElements(By.xpath("//div[@data-test-id='error-footer-text']"));//Получение списка с текстами ошибок на страниице

        for (WebElement label : fields) {
            String text = label.getText();//Привсоение переменной для текста с ошибкой
            String kek = driver.findElement(By.xpath("//div[@data-test-id='error-footer-text']//small[text()='"+text+"']/ancestor::*/div/label[contains(@class,'base')]")).getText();
            //Присвоение переменной для получения текста поля с соответствующей ему текста с ошибкой
            System.out.println("В поле " + kek + " " + text);
            //Вывод в консоль переменных
        }
        driver.quit();//Закрытие браузера
    }
}
