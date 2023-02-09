import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeHeadlessBrowser {
    public static void main(String[] args) {
        //declare the chrome driver from the local machine location
        System.setProperty("webdriver.chrome.driver","src/test/resources/Driver/chromedriver.exe");

        //create object of chrome options
        ChromeOptions options = new ChromeOptions();

        //add the headless argument
        options.addArguments("headless");

        //pass the options parameter in the Chrome driver declaration
        WebDriver driver = new ChromeDriver(options);

        //2. navigate to the URL
        driver.get("https://www.youtube.com/watch?v=smjfGmCn7x0");
        driver.manage().window().maximize();
        //3. Find element //4. check the state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"button-shape\"][1]")));
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
