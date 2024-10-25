import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {

    @Test
    public void test() {

        /*
        --Проверка - ввести четыре цифры
        Открыть браузер
        Открыть страницу https://sharelane.com/cgi-bin/register.py
        В поле ZipCode ввести 1111
        Нажать кнопку Continue
        Проверить появление ошибки
        Закрыть браузер
         */

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1111");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();

    }

    @Test
    public void test1() {

        /*
        --Проверка - оставить поле пустым
        Открыть браузер
        Открыть страницу https://sharelane.com/cgi-bin/register.py
        В поле ZipCode ничего не вводить
        Нажать кнопку Continue
        Проверить появление ошибки
        Закрыть браузер
         */

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();

    }

    @Test
    public void test2() {

        /*
        --Проверка - ввести буквы
        Открыть браузер
        Открыть страницу https://sharelane.com/cgi-bin/register.py
        В поле ZipCode ввести qqqqq
        Нажать кнопку Continue
        Проверить появление ошибки
        Закрыть браузер
         */

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("qqqqq");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();

    }

    @Test
    public void test3() {

        /*
        --Проверка - ввести буквы
        Открыть браузер
        Открыть страницу https://sharelane.com/cgi-bin/register.py
        В поле ZipCode ввести !!!!!
        Нажать кнопку Continue
        Проверить появление ошибки
        Закрыть браузер
         */

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("!!!!!");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();

    }

    @Test
    public void test4() {

        /*
        --Позитивная проверка - ввести 5 цифр
        Открыть браузер
        Открыть страницу https://sharelane.com/cgi-bin/register.py
        В поле ZipCode ввести 12345
        Нажать кнопку Continue
        Проверить что открылась страница ввода имени и электронной почты
        Закрыть браузер
         */

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String currentUrl = browser.getCurrentUrl();
        String expectedUrl = "https://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345";
        browser.quit();

    }
}
