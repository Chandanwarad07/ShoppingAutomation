package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	

    public WebDriver driver;
    public Properties p;

    @BeforeClass
    public void setup() throws IOException {

        p = new Properties();
        FileInputStream file = new FileInputStream("src/test/resources/config.properties");
        p.load(file);

        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("appURL"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

