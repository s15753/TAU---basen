package selenium;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@RunWith(JUnit4.class)
public class LoginIncorrectCredentialsTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginIncorrectCredentialsTest() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email")).sendKeys("testmar@test.pl");
        driver.findElement(By.id("passwd")).sendKeys("qwert1");
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement loginCheck = wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/ol/li")));

        assertEquals("Authentication failed.", loginCheck.getText().toString());
    }
}
