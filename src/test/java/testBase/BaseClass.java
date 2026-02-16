package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;
    public Properties p;

    @BeforeClass
    @Parameters("browser")
    public void setup(String br) throws IOException {

        p = new Properties();
        FileInputStream file =
                new FileInputStream("src/test/resources/config.properties");
        p.load(file);

        if (br.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // ✅ HEADLESS MODE (CI/JENKINS)
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(p.getProperty("appURL"));
    }

    // ---------- SCREENSHOT ----------
    public String captureScreenshot(String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String folderPath =
                System.getProperty("user.dir") + File.separator + "screenshots";
        new File(folderPath).mkdirs();

        String targetPath =
                folderPath + File.separator + testName + "_" +
                System.currentTimeMillis() + ".png";

        try {
            FileHandler.copy(source, new File(targetPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return targetPath;
    }

    @AfterClass
    public void closeup() {
        if (driver != null) {
            driver.quit();
        }
    }
}
