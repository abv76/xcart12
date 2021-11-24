package homepage;

import browserTesting.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://mobile.x-cart.com";

    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {

        // 1.1 Click on the “Shipping” link

        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[3]"));


        // 1.2 Verify the text “Shipping”
        String expectedtext = "Shipping";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to shipping page", expectedtext, actualtext);
    }

    @Test

    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {

        // 2.1 Click on the “New!” link

        Thread.sleep(1000);
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[4]"));

        //2.2 Verify the text “New arrivals
        String expectedtext1 = "New arrivals";
        Thread.sleep(1000);
        String actualtext1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to New arrivals page", expectedtext1, actualtext1);
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException {
        // 3.1 Click on the “Coming soon” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[5]"));

        //3.2 Verify the text “Coming soon”

        String expectedMessage = "Coming soon";
        Thread.sleep(1000);
        String actualMessge = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to New arrivals page", expectedMessage, actualMessge);
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException {
        // 4.1 Click on the “Contact us” link

        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[6]"));

        //4.2 Verify the text “Contact us”

        String expectedMessage = "Contact us";
        Thread.sleep(1000);
        String actualMessge = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to New arrivals page", expectedMessage, actualMessge);
    }

}

















