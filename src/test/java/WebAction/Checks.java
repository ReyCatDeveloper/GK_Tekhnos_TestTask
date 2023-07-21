package WebAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Environment.ProjectDriver.currentWebDriver;

public class Checks {

        public static void checkElement(String locator, String elementName_Rus){
                List<WebElement> elementsList = currentWebDriver.findElements(By.xpath(locator));
                assert elementsList.size() > 0 :"Элемент " +locator+ " не отображен";
                System.out.println("Элемент " +elementName_Rus+ " отображен");
        }

}
