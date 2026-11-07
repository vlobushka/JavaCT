import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WikipediaHomePage {

    private final WebDriver driver;
    private final By searchInput = By.id("searchInput");

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WikipediaHomePage open() {
        driver.get("https://www.wikipedia.org");
        return this;
    }

    public void searchFor(String text) {
        driver.findElement(searchInput).sendKeys(text, Keys.ENTER);
    }
}