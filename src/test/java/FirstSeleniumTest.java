import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest {

    private static final String HOME_PAGE_URL = "https://www.facebook.com/";

    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        SharedDriver.closeDriver();

    }

    @AfterEach
    public void testTeardown() {
        driver.get(HOME_PAGE_URL);

    }

    @Test
    public void homePageURLTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "URLs do not match");
    }

    @Test
    public void findElementByAttributeTest() {

        WebElement elementEmailById = driver.findElement(By.id("email"));
        assertNotNull(elementEmailById);
        WebElement elementEmailByName = driver.findElement(By.name("email"));
        assertNotNull(elementEmailByName);
        WebElement elementPasswordByName = driver.findElement(By.name("pass"));
        assertNotNull(elementPasswordByName);
        WebElement elementPasswordById = driver.findElement(By.id("pass"));
        assertNotNull(elementPasswordById);
        WebElement elementEnterByName = driver.findElement(By.name("login"));
        assertNotNull(elementEnterByName);
        WebElement elementCreatePageByLinkText = driver.findElement(By.linkText("Создать новый аккаунт"));
        assertNotNull(elementCreatePageByLinkText);
        WebElement elementEmailByCss = driver.findElement(By.cssSelector("#email"));
        assertNotNull(elementEmailByCss);
    }

    @Test

    public void findElementsByXpathTest() {
        //check email and password
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        assertNotNull(emailElement);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='pass']"));
        assertNotNull(passwordElement);
        WebElement passwordElementData = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElementData);
        WebElement emailElementData = driver.findElement(By.xpath("//input[@data-testid='royal_email']"));
        assertNotNull(emailElementData);
        WebElement emailElementPlaceHolder = driver.findElement(By.xpath("//input[@placeholder='Электронный адрес или номер телефона']"));
        assertNotNull(emailElementPlaceHolder);
        WebElement passwordElementPlaceHolder = driver.findElement(By.xpath("//input[@placeholder='Пароль']"));
        assertNotNull(passwordElementPlaceHolder);
        WebElement emailElementClass = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        assertNotNull(emailElementClass);
        WebElement passwordElementClass = driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy _9npi']"));
        assertNotNull(passwordElementClass);
        WebElement emailElementAutofocus = driver.findElement(By.xpath("//input[@autofocus='1']"));
        assertNotNull(emailElementAutofocus);
        WebElement emailElementAria = driver.findElement(By.xpath("//input[@aria-label='Электронный адрес или номер телефона']"));
        assertNotNull(emailElementAria);
        WebElement passwordElementAria = driver.findElement(By.xpath("//input[@aria-label='Пароль']"));
        assertNotNull(passwordElementAria);
        WebElement passwordElementType = driver.findElement(By.xpath("//input[@type='password']"));
        assertNotNull(passwordElementType);
        WebElement emailElementType = driver.findElement(By.xpath("//input[@type='text']"));
        assertNotNull(emailElementType);
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
        WebElement loginButtonElementName = driver.findElement(By.xpath("//button[@name='login']"));
        assertNotNull(loginButtonElementName);
        WebElement loginButtonElementValue = driver.findElement(By.xpath("//button[@value='1']"));
        assertNotNull(loginButtonElementValue);
        //check forgot password
        WebElement forgotPassElement = driver.findElement(By.xpath("//a[text()='Забыли пароль?']"));
        assertNotNull(forgotPassElement);
        //check create a new account
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text() = 'Создать новый аккаунт']"));
        assertNotNull(createNewAccButton);

    }

    @Test
    public void loginScreenTest() {
        //find email element
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='email']"));
        //verify element found
        assertNotNull(emailElement);
        // send text
        emailElement.sendKeys("zemlianoi.aa@gmail.com");
        //get text from browser
        String emailValue = emailElement.getAttribute("value");
        //verify text is correct
        assertEquals("zemlianoi.aa@gmail.com", emailValue);
        //same with password
        WebElement passwordElement = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        assertNotNull(passwordElement);
        passwordElement.sendKeys("Gm3");
        String passValue = passwordElement.getAttribute("value");
        assertEquals("Gm3", passValue);
        //find login button
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(loginButtonElement);
        //click
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Test

    public void createNewAccTest() throws InterruptedException {
        //create a new account
        WebElement createNewAccountElement = driver.findElement(By.xpath("//*[text()='Создать новый аккаунт']"));
        assertNotNull(createNewAccountElement);
        driver.findElement(By.xpath("//*[text()='Создать новый аккаунт']")).click();
        Thread.sleep(1000);
        //check name and last name
        WebElement nameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(nameElement);
        WebElement lastnameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastnameElement);
        //check email and password
        WebElement numberOrEmailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(numberOrEmailElement);
        WebElement newPasswordElement = driver.findElement(By.xpath("//input[@data-type='password']"));
        assertNotNull(newPasswordElement);
        //check registration text
        WebElement createElement = driver.findElement(By.xpath("//*[text() = 'Регистрация']"));
        assertNotNull(createElement);
        WebElement fastAndEasyElement = driver.findElement(By.xpath("//*[text() = 'Быстро и легко.']"));
        assertNotNull(fastAndEasyElement);
        //check birthday and gender text
        WebElement dataBirthdayElement = driver.findElement(By.xpath("//*[text() = 'Дата рождения']"));
        assertNotNull(dataBirthdayElement);
        WebElement genderElement = driver.findElement(By.xpath("//*[text() = 'Пол']"));
        assertNotNull(genderElement);
        //check terms text
        WebElement clickButtonCreateTermsElement = driver.findElement(By.xpath("//*[text() = 'Нажимая кнопку Регистрация, вы принимаете ']"));
        assertNotNull(clickButtonCreateTermsElement);
        WebElement termsElement = driver.findElement(By.xpath("//*[text() = 'Условия']"));
        assertNotNull(termsElement);
        WebElement privacyElement = driver.findElement(By.xpath("//*[text() = 'Политику использования данных']"));
        assertNotNull(privacyElement);
        WebElement commaElement = driver.findElement(By.xpath("//*[text() = ', ']"));
        assertNotNull(commaElement);
        WebElement andElement = driver.findElement(By.xpath("//*[text() = ' и ']"));
        assertNotNull(andElement);
        WebElement cookieElement = driver.findElement(By.xpath("//*[text() = 'Политику в отношении файлов cookie']"));
        assertNotNull(cookieElement);
        WebElement smsTextElement = driver.findElement(By.xpath("//*[text() = '. Вы можете получать от нас SMS-уведомления, отказаться от которых можно в любой момент.']"));
        assertNotNull(smsTextElement);
        //check websubmit button
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(loginButtonElement);
        //check gender-wrapper text
        WebElement womanElement = driver.findElement(By.xpath("//*[text() = 'Женщина']"));
        assertNotNull(womanElement);
        WebElement manElement = driver.findElement(By.xpath("//*[text() = 'Мужчина']"));
        assertNotNull(manElement);
        WebElement otherElement = driver.findElement(By.xpath("//*[text() = 'Другое']"));
        assertNotNull(otherElement);
        //check gender-wrapper 'radio-button'
        WebElement radioWomanElement = driver.findElement(By.xpath("//input[@value='1']"));
        assertNotNull(radioWomanElement);
        WebElement radioManElement = driver.findElement(By.xpath("//input[@value='2']"));
        assertNotNull(radioManElement);
        WebElement radioOtherElement = driver.findElement(By.xpath("//input[@value='-1']"));
        assertNotNull(radioOtherElement);
        //check red exclamation Mark Element
        WebElement exclamationMarkElement = driver.findElement(By.xpath("//i[@class='_5dbc img sp_98fCI7IVTTz sx_54513f']"));
        assertNotNull(exclamationMarkElement);
        //check close button
        WebElement closeButtonElement = driver.findElement(By.xpath("//img[@class='_8idr img']"));
        assertNotNull(closeButtonElement);
        //check 'other' radio button
        driver.findElement(By.xpath("//*[text() = 'Другое']")).click();
        Thread.sleep(1000);
        //check 'other' text
        WebElement pronounElement = driver.findElement(By.xpath("//*[text() = 'Укажите, как к вам обращаться']"));
        assertNotNull(pronounElement);
        WebElement pronounGenderElement = driver.findElement(By.xpath("//*[text() = 'Местоимение, указывающее ваш пол, видят все.']"));
        assertNotNull(pronounGenderElement);
        //check custom gender field
        WebElement customGenderElement = driver.findElement(By.xpath("//input[@name='custom_gender']"));
        assertNotNull(customGenderElement);
        //check preferred pronoun
        WebElement customGenderButtonElement = driver.findElement(By.xpath("//*[text() = 'Укажите, как к вам обращаться']"));
        assertNotNull(customGenderButtonElement);
        driver.findElement(By.xpath("//*[text() = 'Укажите, как к вам обращаться']")).click();
        Thread.sleep(1000);
        WebElement genderHerElement = driver.findElement(By.xpath("//option[@value='1']"));
        assertNotNull(genderHerElement);
        WebElement genderHisElement = driver.findElement(By.xpath("//option[@value='2']"));
        assertNotNull(genderHisElement);
        WebElement genderHerHisElement = driver.findElement(By.xpath("//option[@value='6']"));
        assertNotNull(genderHerHisElement);
        //check submit button
        WebElement submitButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(submitButtonElement);
    }

    @Test

    public void createNewAccInputTest() throws InterruptedException {
        WebElement createNewAccountElement = driver.findElement(By.xpath("//*[text()='Создать новый аккаунт']"));
        assertNotNull(createNewAccountElement);
        driver.findElement(By.xpath("//*[text()='Создать новый аккаунт']")).click();
        Thread.sleep(1000);
        //firstName
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("Andrei");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Andrei", firstNameValue);
        //lastName
        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Zemlianoi");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Zemlianoi", lastNameValue);
        //phoneNumber&email
        WebElement phoneNumberElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(phoneNumberElement);
        phoneNumberElement.sendKeys("15064266778123");
        String phoneNumberValue = phoneNumberElement.getAttribute("value");
        assertEquals("15064266778123", phoneNumberValue);
        //newPassword
        WebElement passwodElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(passwodElement);
        passwodElement.sendKeys("hgRYTDK+1KDh");
        String passwordValue = passwodElement.getAttribute("value");
        assertEquals("hgRYTDK+1KDh", passwordValue);
        //numberOfDate
        WebElement numberOfDateElement = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        assertNotNull(numberOfDateElement);
        driver.findElement(By.xpath("//select[@name='birthday_day']")).click();
        Thread.sleep(1000);
        WebElement dayElement = driver.findElement(By.xpath("//option[@value='14']"));
        assertNotNull(dayElement);
        driver.findElement(By.xpath("//option[@value='14']")).click();
        Thread.sleep(1000);
        //monthOfDate
        WebElement monthOfDateElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        assertNotNull(monthOfDateElement);
        driver.findElement(By.xpath("//select[@name='birthday_month']")).click();
        Thread.sleep(1000);
        WebElement monthElement = driver.findElement(By.xpath("//*[text() = 'июн']"));
        assertNotNull(monthElement);
        driver.findElement(By.xpath("//*[text() = 'июн']")).click();
        Thread.sleep(1000);
        //yearOfDate
        WebElement yearOfDateElement = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        assertNotNull(yearOfDateElement);
        driver.findElement(By.xpath("//select[@name='birthday_year']")).click();
        Thread.sleep(1000);
        WebElement yearElement = driver.findElement(By.xpath("//*[text() = '1989']"));
        assertNotNull(yearElement);
        driver.findElement(By.xpath("//*[text() = '1989']")).click();
        Thread.sleep(1000);
        //genderMan
        WebElement genderManElement = driver.findElement(By.xpath("//*[text() = 'Мужчина']"));
        assertNotNull(genderManElement);
        driver.findElement(By.xpath("//*[text() = 'Мужчина']")).click();
        Thread.sleep(1000);
        //submit
        WebElement webSubmitElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(webSubmitElement);
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        Thread.sleep(1000);
    }
}



