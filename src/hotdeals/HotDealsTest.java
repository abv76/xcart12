package hotdeals;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HotDealsTest extends BaseTest {

    String baseUrl = "https://mobile.x-cart.com";

    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        // 1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        //1.2 Mouse hover on the “Sale”  link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

        //1.3 Verify the text “Sale”
        String expectedtext = "Sale";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to shipping page", expectedtext, actualtext);

        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        Thread.sleep(1000);
        clickOnElement(By.partialLinkText("Name A"));
        Thread.sleep(1000);


        //1.5 Verify that the product arrange alphabetically

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        //2.2 Mouse hover on the “Sale”  link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        //2.3 Verify the text “Sale”
        String expectedtext = "Sale";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to Sale page", expectedtext, actualtext);

        //2.4 Mouse hover on “Sort By” and select “Price Low-High”
        Thread.sleep(1000);
        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        sortData(By.partialLinkText("Price Low - Hi"));

        //2.5 Verify that the product’s price arrange Low to High


    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        // 3.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        //3.2 Mouse hover on the “Sale”  link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

        //3.3 Verify the text “Sale”
        String expectedtext = "Sale";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to Sale page", expectedtext, actualtext);


        //3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(1000);
        sortData(By.partialLinkText("Rates"));


        //3.5 Verify that the product’s arrange Rates
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        // 1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        // 1.2 Mouse hover on the “Bestsellers”  link and click
        Thread.sleep(1000);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));

        // 1.3 Verify the text “Bestsellers”
        String expectedtext = "Bestsellers";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to Bestsellers page", expectedtext, actualtext);


        //1.4 Mouse hover on “Sort By” and select “Name Z-A”
        Thread.sleep(1000);
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        // clickOnElement(By.partialLinkText("Name Z -"));

        sortData(By.partialLinkText("Name Z -"));

        //1.5 Verify that the product arrange by Z to A

    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        // 2.2 Mouse hover on the “Bestsellers” link and click

        Thread.sleep(1000);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));

        String expectedtext = "Bestsellers";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to Bestsellers page", expectedtext, actualtext);


        //2.4 Mouse hover on “Sort By” and select “Price High-Low”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        //clickOnElement(By.partialLinkText("Price Low - Hi"));
        sortData(By.partialLinkText("Price Low - Hi"));

        //2.5 Verify that the product’s price arrange High to Low

    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        // 3.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        // 3.2 Mouse hover on the “Bestsellers”  link and click

        Thread.sleep(1000);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        // 3.3 Verify the text “Bestsellers”
        String expectedtext = "Bestsellers";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to Bestsellers page", expectedtext, actualtext);


        // 3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        sortData(By.partialLinkText("Rates"));

        //  3.5 Verify that the product’s arrange Rates


    }

}

