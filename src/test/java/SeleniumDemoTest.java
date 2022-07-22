import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemoTest {
    WebDriver driver;

    @Before
    public void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/");
    }

    @Test
    public void verifyTitle() {
        System.out.println("In verify title test case");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Online Tutorials Library"));
    }

    @Test
    public void verifyingHeading() {
        System.out.println("In verify Heading Text Above Search Test Case");
        String expectedSearchHeading = "Simply Easy Learning at your fingertips";
        String actualHeading = driver.findElement(By.xpath("//h1"))
                .getText();
        Assert.assertEquals(expectedSearchHeading, actualHeading);
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}