package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HelloSelenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.get("http://automationpractice.com");
            driver.manage().deleteAllCookies();
//            driver.findElement(By.className("login")).click();
//            WebElement firstCheck = wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/span[2]")));
//
//
//
//            driver.findElement(By.id("email_create")).sendKeys("robert@robert.pl" + Keys.ENTER);
//            WebElement secondCheck = wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/span[2]")));
//
//            driver.findElement(By.id("id_gender1")).click();
//            driver.findElement(By.id("customer_firstname")).sendKeys("Robert");
//            driver.findElement(By.id("customer_lastname")).sendKeys("Kowalski");
//            driver.findElement(By.id("passwd")).sendKeys("qwert1");
//            driver.findElement(By.id("address1")).sendKeys("301 E Dave Ward Dr");
//            driver.findElement(By.id("city")).sendKeys("Conway");
//            Select state = new Select(driver.findElement(By.id("id_state")));
//            state.selectByVisibleText("Arkansas");
//            driver.findElement(By.id("postcode")).sendKeys("72032");
//            driver.findElement(By.id("phone_mobile")).sendKeys("333444555");
//            driver.findElement(By.id("submitAccount")).click();
//
//            WebElement thirdCheck = wait.until(presenceOfElementLocated(By.id("navigation_page")));
//
//            System.out.println("to jest pierwszy: " + firstCheck.getAttribute("SubmitCreate"));
//            System.out.println("to jest drugi: " + secondCheck.getAttribute("account-creation_form"));
//            System.out.println("to jest trzeci: " + thirdCheck.getAttribute("navigation_page"));


        } finally {
            driver.quit();
        }
    }
}
