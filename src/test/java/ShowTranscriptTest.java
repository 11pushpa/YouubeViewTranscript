import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShowTranscriptTest {
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void showTrascriptTest() {
        //1. Instantiate the driver
        WebDriver driver = new ChromeDriver();
        //2. navigate to the URL
        driver.get("https://www.youtube.com/watch?v=smjfGmCn7x0");
        driver.manage().window().maximize();
        //3. Find element //4. check the state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("button-shape")));
        Actions a = new Actions(driver);
        a.moveToElement(element).click().perform();

        WebElement showTranscriptButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Show transcript']")));
        a.moveToElement(showTranscriptButton).click().perform();

        WebElement transcript = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("segments-container")));
        System.out.println(transcript.getText());

        // quit the driver
        driver.quit();
    }

}
