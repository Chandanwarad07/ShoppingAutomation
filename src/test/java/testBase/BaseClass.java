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
        FileInputStream file = new FileInputStream("src/test/resources/config.properties");
        p.load(file);

        if (br.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("appURL"));
    }
    
    public String captureScreenshot(String testName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String folderPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator;
        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdir();
        }

        String targetPath = folderPath + testName + "_" + System.currentTimeMillis() + ".png";
        File target = new File(targetPath);

        try {
            FileHandler.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Screenshot saved at: " + targetPath);

        return targetPath;
    }

    @AfterClass
    public void closeup() {
    	driver.quit();
    }
}

