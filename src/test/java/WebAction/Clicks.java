package WebAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Environment.ProjectDriver.currentWebDriver;

public class Clicks {

    public static void clickElement(String locator){
        WebElement element = currentWebDriver.findElement(By.xpath(locator));
        element.click();
    }
}
