package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.SeleniumUtils;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void localSetUp(){

        homePage = new HomePage(getDriver());
    }
    @DataProvider(name = "Testalllink")
    public Object[][] testData01(){
        Object[][] data = new Object[7][2];
        data[0][0] = "php-travels";
        data[1][1] = "Demo Script Test drive - PHPTRAVELS";

        data[1][0] = "mercury-tours";
        data[1][1] = "Demoaut.com";

        data[2][0] = "internet";
        data[2][1] = "The Internet";

        data[3][0] = "e-commerce";
        data[3][1] = "My Store";

        data[4][0] = "passion-tea-company";
        data[4][1] = "www.practiceselenium.com";

        data[5][0] = "sauce-demo";
        data[5][1] = "Swag Labs";

        data[6][0] = "shopping-cart";
        data[6][1] = "Typescript React Shopping Cart";

        return data;
    }

    @Test(dataProvider = "Testalllink")
    public void test01(String allLink, String expectedTitle) {
        getDriver().findElement(By.id(allLink)).click();
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver());
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
