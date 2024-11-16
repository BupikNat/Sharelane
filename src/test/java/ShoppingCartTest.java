import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartTest {

    public WebDriver loginToSharelane() {
        //Регистрация
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name=" +
                "test&email=user%40pflb.ru&password1=12345678&password2=12345678");

        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();

        //Перейти на страницу логина и залогиниться
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        return driver;
    }

    @Test
    public void checkDiscount0() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        //Вводим количество книг = 19 (тогда дисконт 0)
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "0", "Процент дисконта не равен 0");
        softAssert.assertEquals(discountDollar, "0.0", "Сумма дисконта не равна 0.0");
        softAssert.assertEquals(total, "190.00", "Общая сумма стоимости книг не равна 190.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount2PercentsAnd20Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "2", "Процент дисконта не равен 2");
        softAssert.assertEquals(discountDollar, "4.0", "Сумма дисконта не равна 4.0");
        softAssert.assertEquals(total, "196.00", "Общая сумма стоимости книг не равна 196.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount2PercentsAnd49Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("49");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "2", "Процент дисконта не равен 2");
        softAssert.assertEquals(discountDollar, "9.8", "Сумма дисконта не равна 9.8");
        softAssert.assertEquals(total, "480.20", "Общая сумма стоимости книг не равна 480.20");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3PercentsAnd50Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "3", "Процент дисконта не равен 3");
        softAssert.assertEquals(discountDollar, "15.0", "Сумма дисконта не равна 15.0");
        softAssert.assertEquals(total, "485.00", "Общая сумма стоимости книг не равна 485.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3PercentsAnd99Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("99");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "3", "Процент дисконта не равен 3");
        softAssert.assertEquals(discountDollar, "29.7", "Сумма дисконта не равна 29.7");
        softAssert.assertEquals(total, "960.30", "Общая сумма стоимости книг не равна 960.30");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount4PercentsAnd100Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "4", "Процент дисконта не равен 4");
        softAssert.assertEquals(discountDollar, "40.0", "Сумма дисконта не равна 40.0");
        softAssert.assertEquals(total, "960.00", "Общая сумма стоимости книг не равна 960.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount4PercentsAnd499Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("499");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "4", "Процент дисконта не равен 4");
        softAssert.assertEquals(discountDollar, "199.6", "Сумма дисконта не равна 199.6");
        softAssert.assertEquals(total, "4790.40", "Общая сумма стоимости книг не равна 4790.40");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount5PercentsAnd500Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("500");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "5", "Процент дисконта не равен 5");
        softAssert.assertEquals(discountDollar, "250.0", "Сумма дисконта не равна 250.0");
        softAssert.assertEquals(total, "4750.00", "Общая сумма стоимости книг не равна 4750.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount5PercentsAnd999Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("999");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "5", "Процент дисконта не равен 5");
        softAssert.assertEquals(discountDollar, "499.5", "Сумма дисконта не равна 499.5");
        softAssert.assertEquals(total, "9490.50", "Общая сумма стоимости книг не равна 9490.50");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount6PercentsAnd1000Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("1000");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "6", "Процент дисконта не равен 6");
        softAssert.assertEquals(discountDollar, "600.0", "Сумма дисконта не равна 600.0");
        softAssert.assertEquals(total, "9400.00", "Общая сумма стоимости книг не равна 9400.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount6PercentsAnd4999Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("4999");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "6", "Процент дисконта не равен 6");
        softAssert.assertEquals(discountDollar, "299.4", "Сумма дисконта не равна 2999.4");
        softAssert.assertEquals(total, "46999.6", "Общая сумма стоимости книг не равна 46999.6");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount7PercentsAnd5000Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("5000");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "7", "Процент дисконта не равен 7");
        softAssert.assertEquals(discountDollar, "3500.0", "Сумма дисконта не равна 3500.0");
        softAssert.assertEquals(total, "46500.00", "Общая сумма стоимости книг не равна 46500.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount7PercentsAnd9999Bokks() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("9999");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "7", "Процент дисконта не равен 7");
        softAssert.assertEquals(discountDollar, "6999.3", "Сумма дисконта не равна 6999.3");
        softAssert.assertEquals(total, "92990.70", "Общая сумма стоимости книг не равна 92990.70");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount8PercentsAnd10000Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("10000");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "8", "Процент дисконта не равен 8");
        softAssert.assertEquals(discountDollar, "8000.0", "Сумма дисконта не равна 8000.0");
        softAssert.assertEquals(total, "9200.00", "Общая сумма стоимости книг не равна 9200.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount8PercentsAnd10001Books() {
        //Выполнить тест регистрация + логин
        WebDriver driver = loginToSharelane();

        //Выбираем книгу и отправляем ее в корзину
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=1");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("10001");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total = driver.
                findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(discountPercent, "8", "Процент дисконта не равен 8");
        softAssert.assertEquals(discountDollar, "8000.8", "Сумма дисконта не равна 8000.8");
        softAssert.assertEquals(total, "92009.20", "Общая сумма стоимости книг не равна 92009.20");
        driver.quit();
        softAssert.assertAll();
    }
}
