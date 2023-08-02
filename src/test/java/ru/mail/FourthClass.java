package ru.mail;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FourthClass {

    @Test
    public void fourthTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vanek\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//Открыть окно в полный размер экрана
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Добавление неявного ожидания длительностью 5 секунд


        driver.get("https://mail.ru/");//Открыть сайт mail.ru

        WebElement registr = driver.findElement(By.xpath("//a[@data-testid='mailbox-create-link']"));//Найти кнопку регистрации
        registr.click();//Нажать на кнопку регистрации

        ArrayList tabs = new ArrayList(driver.getWindowHandles());//Получение списка открытых вкладок браузера
        driver.switchTo().window((String) tabs.get(1));//Переключиться на вторую открытую вкладку браузера

        WebElement fieldName = driver.findElement(By.xpath("//input[@name='fname']"));//Найти поле ввода "Имя"
        fieldName.click();
        fieldName.sendKeys("Иван");//Ввести в поле "Имя" значение "Иван"

        WebElement fieldSecondname = driver.findElement(By.xpath("//input[@name='lname']"));//Найти поле ввода "Фамилия"
        fieldSecondname.click();
        fieldSecondname.sendKeys("Иванов");//Ввести в поле "Фамилия" значение "Иванов"

        WebElement day = driver.findElement(By.xpath("//span[text()='День']/parent::div"));//Найти выпадающий список "Месяц"
        day.click();
        WebElement dayValue = driver.findElement(By.xpath("//span[@class='base-0-2-6 control-0-2-14'][text()='7']"));//Выбрать значение 7 из выпадающего списка "Месяц"
        dayValue.click();

        WebElement month = driver.findElement(By.xpath("//span[text()='Месяц']/parent::div"));//Найти выпадающий список "Месяц"
        month.click();
        WebElement monthValue = driver.findElement(By.xpath("//span[@class='base-0-2-6 control-0-2-14'][text()='Апрель']"));//Выбрать значение Апрель из выпадающего списка "Месяц"
        monthValue.click();

        WebElement year = driver.findElement(By.xpath("//span[text()='Год']/parent::div"));//Найти выпадающий список "Год"
        year.click();
        WebElement yearValue = driver.findElement(By.xpath("//span[@class='base-0-2-6 control-0-2-14'][text()='1999']"));//Выбрать значение 1999 из выпадающего списка "Год"
        yearValue.click();

        try {
            WebElement gender = driver.findElement(By.xpath("//label[@data-test-id='gender-male']"));
            gender.click();
        } catch (Exception gender) {
            System.out.println("Без возможности выбора пола");
        }

        WebElement mail = driver.findElement(By.xpath("//input[@name='username']"));//Найти поле ввода "Имя ящика"
        mail.click();
        mail.sendKeys("az123xz");//Ввести в поле "Имя ящика" значение "az123xz"

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));//Найти поле ввода "Имя ящика"
        password.click();
        password.sendKeys("Zascx098765");//Ввести в поле "Имя ящика" значение "Zascx098765"

        WebElement repeatPassword = driver.findElement(By.xpath("//input[@name='repeatPassword']"));//Найти поле ввода "Имя ящика"
        repeatPassword.click();
        repeatPassword.sendKeys("Zascx098765");//Ввести в поле "Имя ящика" значение "Zascx098765"
        Thread.sleep(2000);

        WebElement element1 = driver.findElement(By.xpath("//form/button/span[text()='Создать']"));//Найти кнопку "Создать"
        element1.click();//Нажатие по кнопке "Создать"
        Thread.sleep(2000);

        List <WebElement> fields = driver.findElements(By.xpath("//div[@data-test-id='error-footer-text']"));//Получение списка fields с текстами ошибок на страниице

        for (WebElement label : fields) {
            String text = label.getText();//Привсоение переменной text для текста с ошибкой
            String kek = driver.findElement(By.xpath("//div[@data-test-id='error-footer-text']//small[text()='"+text+"']/ancestor::*/div/label[contains(@class,'base')]")).getText();
            //Присвоение переменной kek для получения текста поля с соответствующей ему текста с ошибкой
            System.out.println("В поле " + kek + " " + text);
            //Вывод в консоль переменных
        }

        try {
            WebElement code = driver.findElement(By.xpath("//input[@placeholder='Код']"));
            System.out.println("Ошибки не выведены");
        } catch (Exception code) {
            System.out.println("");
        }

        driver.quit();//Закрытие браузера
    }
}