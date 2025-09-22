package google_test;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;

public class GoogleTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        test = extent.createTest("Google Search Test")
                     .assignAuthor("QA Engineer")
                     .assignCategory("Regression");

        driver.get("https://www.google.com");
        test.log(Status.INFO, "Navigated to Google");

        driver.findElement(By.name("q")).sendKeys("Selenium ExtentReports");
        test.log(Status.INFO, "Entered search text");

        driver.findElement(By.name("q")).submit();
        test.log(Status.INFO, "Submitted search");

        String title = driver.getTitle();
        test.log(Status.INFO, "Page title: " + title);

        Assert.assertTrue(title.contains("Selenium"),
                "Title does not contain 'Selenium'");
        test.pass("Test passed: Title contains 'Selenium'");
    }
}
