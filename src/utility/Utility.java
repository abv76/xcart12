package utility;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class Utility {
    public WebDriver driver;

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    public void selectByValueFromDropDown(By by, String value) {

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void selectByVisibleTextFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }

    public void selectByIndexFromDropDown(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);

    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(by);
        actions.moveToElement(target).build().perform();

    }

    public void clear(By by) {
        driver.findElement(by).clear();

    }

    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);

    public String getUrl() {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl;
    }

    public <BY, attribute> String getAttributefromelement(By by, String value) {
        return driver.findElement(by).getAttribute("value");

    }
    // public void selectByOption(By by){
    // WebElement dropDown = driver.findElement(by);
    // Select select= new Select(dropDown);

    // List<WebElement> products = select.getOptions();
    //   for(WebElement element: products) {
    //    element.getText();
    //  }
    public void sortData(By by) {
        List<WebElement> products = driver.findElements(by);
        String[] beforeSort_products = new String[products.size()];

        for (int i = 0; i < products.size(); i++) {
            beforeSort_products[i] = products.get(i).getText().trim();
        }
        Arrays.sort(beforeSort_products);
        // System.out.println("after the sort");
        WebElement sort = driver.findElement(by);
        sort.click();

        products = driver.findElements(by);
        String[] aftersort_products = new String[products.size()];

        for (int i = 0; i < products.size(); i++) {
            aftersort_products[i] = products.get(i).getText().trim();
            System.out.println("After");

        }
        // Assert.assertTrue(beforeSort_products.equals(aftersort_products));
    }




}



