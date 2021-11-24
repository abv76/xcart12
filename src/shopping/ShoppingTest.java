package shopping;

import browserTesting.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class ShoppingTest extends BaseTest {

    String baseUrl = "https://mobile.x-cart.com";

    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {
        // 1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        // 1.2 Mouse hover on the “Sale”  link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));

        //1.3 Verify the text “Sale”
        String expectedtext = "Sale";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to shipping page", expectedtext, actualtext);

        // 1.4 Mouse hover on “Sort By” and select “Name A-Z”

        mouseHover(By.xpath("//span[contains(text(),'Recommended')]"));
        Thread.sleep(1000);
        clickOnElement(By.partialLinkText("Name A"));

        // 1.5 Click on “Add to cart” button of the product “Avengers Fabrikations Plush”
        Thread.sleep(1000);

        mouseHover(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-16']/span[1]"));
        // 1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedtextmessage = "Product has been added to your cart";
        // Thread.sleep(1000);
        String actualtextmessage = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        assertEquals("User has not added the product in to the cart ", expectedtextmessage, actualtextmessage);

        // 1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1]"));
        //  1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        // 1.9 Verify the text “Your shopping cart - 1 item”

        String expectedcartmessage = "Your shopping cart - 1 item";
        Thread.sleep(1000);
        String actualcartmessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User has not added the product in to the cart ", expectedcartmessage, actualcartmessage);

        // 1.10 Change the Qty = 2
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='amount16' and @name='amount']"));
        sendTextToElement(By.xpath("//input[@id='amount16' and @name='amount']"), "2");
        //1.11 Verify the text “Your shopping cart - 2 items

        String expectedupdatedcartmessage = "Your shopping cart - 2 items";
        Thread.sleep(1000);
        String actualupdatedcartmessage = getTextFromElement(By.xpath("//h1[normalize-space()='Your shopping cart - 2 items']"));
        assertEquals("User has not added the product in to the cart ", expectedupdatedcartmessage, actualupdatedcartmessage);
        //1.12 Verify the Subtotal $29.98
        String expectedupdatedtotal = "$29.98";
        Thread.sleep(1000);
        String actualupdatedtotal = getTextFromElement(By.xpath("//ul[@class='sums']//span[@class='surcharge-cell']"));
        assertEquals("Total is not verified ", expectedupdatedtotal, actualupdatedtotal);

        //1.13 Verify the total $36.00
        String expectedupdatedsubtotal = "$36.00";
        Thread.sleep(1000);
        String actualupdatedsubtotal = getTextFromElement(By.xpath("//li[@class='total']//span[@class='surcharge-cell']"));
        assertEquals("Subtotal is not verified ", expectedupdatedsubtotal, actualupdatedsubtotal);

        //1.14 Click on “Go to checkout” button
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));

        //1.15 Verify the text “Log in to your account”
        String expectedloginmessage = "Log in to your account";
        Thread.sleep(1000);
        String actualloginmessage = getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        assertEquals("Subtotal is not verified ", expectedloginmessage, actualloginmessage);

        //1.16 Enter Email address
        sendTextToElement(By.xpath("//input[@id='email']"), "samira.patel" + randomInt + "@yahoo.com");
        Thread.sleep(1000);

        //1.17 Click on “Continue” Button
        clickOnElement(By.xpath("//tbody/tr[2]/td[1]/button[1]"));

        //1.18 Verify the text “Secure Checkout”
        String expectedcheckoutmessage = "Secure Checkout";
        Thread.sleep(1000);
        String actualcheckoutmessage = getTextFromElement(By.xpath("//h1[@class='title']"));
        assertEquals("Subtotal is not verified ", expectedcheckoutmessage, actualcheckoutmessage);
        //1.19 Fill all the mandatory fields
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Graham");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Sinden");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "Flat 11,Kingsbury road");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='shippingaddress-city']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), "London");
        Thread.sleep(1000);
        selectByIndexFromDropDown(By.xpath("//select[@id='shippingaddress-country-code']"), 6);
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "Middlesex");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='shippingaddress-zipcode']"));
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "NW9 9HN");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-phone']"), "07744123454");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='email']"));
        sendTextToElement(By.xpath("//input[@id='email']"), "graham.sinden" + randomInt + "@yahoo.com");

        // 1.20 Check the check box “Create an account for later use”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='create_profile']"));

        // 1.21 Enter the password
        sendTextToElement(By.xpath("//input[@id='password']"), "abcd1234");
        // 1.22 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.xpath("//input[@id='method128' and @name='methodId']"));

        // 1.23 Select Payment Method “COD”
        clickOnElement(By.xpath("//input[@id='pmethod6' and @name='methodId']"));
        // 1.24 Verify the total $37.03
        String expectedtotalverification = "$37.03";
        Thread.sleep(1000);
        String actualtotalverification = getTextFromElement(By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"));
        assertEquals("Subtotal is not verified ", expectedtotalverification, actualtotalverification);

        //1.25 Click on “Place Order” Button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='button-row']"));
        // 1.26 Verify the text “Thank you for your order”

        String expectedverification = "Thank you for your order";
        Thread.sleep(1000);
        String actualverification = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("Subtotal is not verified ", expectedtotalverification, actualtotalverification);
    }

    @Test

    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));

        //1.2 Mouse hover on the “Bestseller”  link and click
        Thread.sleep(1000);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//li[2]/a[1]/span"));
        //1.3 Verify the text “Bestsellers”

        String expectedtext = "Bestsellers";
        Thread.sleep(1000);
        String actualtext = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User not redirected to Bestsellers page", expectedtext, actualtext);

        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        Thread.sleep(1000);
        mouseHover(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(1000);
        clickOnElement(By.partialLinkText("Name A -"));


        //1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        mouseHover(By.cssSelector(" .product.productid-13"));
        Thread.sleep(1000);

        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']/span[1]"));

        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedtextmessage1 = "Product has been added to your cart";
        // Thread.sleep(1000);
        String actualtextmessage1 = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        assertEquals("User has not added the product in to the cart ", expectedtextmessage1, actualtextmessage1);

        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1]"));

        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //1.9 Verify the text “Your shopping cart - 1 item”
        String expectedcartmessage2 = "Your shopping cart - 1 item";
        Thread.sleep(1000);
        String actualcartmessage2 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        assertEquals("User has not added the product in to the cart ", expectedcartmessage2, actualcartmessage2);
        //1.10 Click on “Empty your cart” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        String alert;
        alert = driver.switchTo().alert().getText();
        String expectedalertmessage = "Are you sure you want to clear your cart?";
        Thread.sleep(1000);

        //1.12 Click “Ok” on alert
        driver.switchTo().alert().accept();
        //1.13 Verify the message “Item(s) deleted from your cart”

        String expectedcartemptymessage = "Item(s) deleted from your cart";
        Thread.sleep(1000);
        String actualcartemptymessage = getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        assertEquals("Item is  not deleted ", expectedcartemptymessage, actualcartemptymessage);

        //1.14 Verify the text “Your cart is empty”

        String expectedmessageemptycart = "Your cart is empty";
        Thread.sleep(1000);
        String actualmessageemptycart = getTextFromElement(By.xpath("//h1[normalize-space()='Your cart is empty']"));
        assertEquals("your cart is not empty ", expectedmessageemptycart, actualmessageemptycart);

    }


}