import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TempClass {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/patittawut/Documents/Selenium-workspace/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DataProvider(name = "testMgt")
    public Object[] testData(){
        Object[][] data = new Object[3][5];
        data[0][0] = "John";
        data[0][1] = "Doe";
        data[0][2] = "5719181974";
        data[0][3] = "abc@gmail.com";
        data[0][4] = "Student";

        data[1][0] = "Pepper";
        data[1][1] = "Kitten";
        data[1][2] = "5719181964";
        data[1][3] = "abcefg@gmail.com";
        data[1][4] = "Instructor";

        data[2][0] = "Pip";
        data[2][1] = "Tidy";
        data[2][2] = "5719181994";
        data[2][3] = "abcdef@gmail.com";
        data[2][4] = "Mentor";

        return data;
    }

    @Test(dataProvider = "testMgt")
    public void testUserStudent(String firstName, String lastName, String phoneNo, String email,String role){
        driver.get("http://automation.techleadacademy.io/#/usermgt");

        driver.findElement(By.id("Firstname")).sendKeys(firstName);
        driver.findElement(By.id("Lastname")).sendKeys(lastName);
        driver.findElement(By.id("Phonenumber")).sendKeys(phoneNo);
        driver.findElement(By.id("Email")).sendKeys(email);

        // verify use xpath last in table
        Select select = new Select(driver.findElement(By.id("Select-role")));
        select.selectByVisibleText("Student");

        driver.findElement(By.id("submit-btn")).click();
        String expecterRole = "Student";
        String actualRole = driver.findElement(By.xpath("//tr[last()]/td[5]")).getText();//xpath is the last one in Table
        Assert.assertEquals(actualRole, expecterRole);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
/*
Test 1: Verify all links on the homepage of the application are taken to the expected page by
        using the title of the target website. Requirement: Use data providers.
Test 2: Verify title of the page is "User DB" when you open a window with
        the Access DB button in the User-Mgt page
Test 3: Add a new user to the User-Mgt page, Submit a table to add to the Database, and verify
        the user was added to DB. Requirement: Use DataProviders to have 3 different users (mentor, student, instructor)

 */