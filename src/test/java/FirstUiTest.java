import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstUiTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }

    @Test
    void openSiteAndCheckTitle() {
        driver.get("https://www.wikipedia.org");
        String title = driver.getTitle();
        assertTrue(title.contains("Wikipedia"));
    }

    @Test
    void searchForApple() {
        driver.get("https://www.wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("Apple", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.titleContains("Apple")));
    }
    @Test
    void searchForAppleWithPageObject() {
        WikipediaHomePage homePage = new WikipediaHomePage(driver);
        homePage.open();
        homePage.searchFor("Apple");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(wait.until(ExpectedConditions.titleContains("Apple")));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}