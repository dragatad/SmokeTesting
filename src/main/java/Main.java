import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/*Napisati dva smoke testa za https://www.telerik.com/support/demos:
    Proveriti da klikom na Desktop odlazimo na tu sekciju
    Proveriti da klikom na Mobile odlazimo na tu sekciju
    Koristiti TestNG, asserte.*/

public class Main {

    private WebDriver driver;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Acer\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void visitWebsite(){
        driver.navigate().to("https://www.telerik.com/support/demos");
    }


    @Test
    public void testDesktop() {
        WebElement desktopBtn = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopBtn.click();
        String expectedTitle = "Desktop";
        String actualTitle = desktopBtn.getText();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void testMobile() {
        WebElement mobileBtn = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobileBtn.click();
        String expectedTitle = "Mobile";
        String actualTitle = mobileBtn.getText();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterClass
    public void shutdown(){
        driver.close();
    }
}
