package WebAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static Environment.ProjectDriver.currentWebDriver;
import static WebAction.Clicks.clickElement;

public class Entering {
    public static void enteringIntoElement(String locator, String value) throws InterruptedException {
        WebElement element = currentWebDriver.findElement(By.xpath(locator));
        Thread.sleep(3000);
        element.sendKeys(value);
    }

    public static void clearElement(String locator) throws InterruptedException {
        WebElement element = currentWebDriver.findElement(By.xpath(locator));
        element.clear();

    }

    public static void clearElementWithActions(String locator) throws InterruptedException {
        WebElement element = currentWebDriver.findElement(By.xpath(locator));
        Actions builder = new Actions(currentWebDriver);
        Action clear = builder.moveToElement(element).keyDown(Keys.BACK_SPACE).build();
        clear.perform();
    }

    public static void tapBackSpace(){
        new Actions(currentWebDriver).sendKeys(Keys.BACK_SPACE).perform();
    }
    public static void tapBackSpace(int count){
        for(int i = 0; i < count; i++){
            new Actions(currentWebDriver).sendKeys(Keys.BACK_SPACE).perform();
        }
    }

    public static void clearActiveField(String locator){
        WebElement field = currentWebDriver.findElement(By.xpath(locator));
        String field_value = field.getAttribute("value");
        int iterationCount = field_value.length();

        for(int i = 0; i < iterationCount; i++){
            new Actions(currentWebDriver).sendKeys(Keys.BACK_SPACE).perform();
        }
    }


}
