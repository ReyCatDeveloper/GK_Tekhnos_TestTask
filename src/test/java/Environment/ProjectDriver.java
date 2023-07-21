package Environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectDriver {

    static {
        System.setProperty("webdriver.chrome.driver", ".\\Drivers\\yandexdriver.exe");          //com.yandex.browser
    }

    public static void getWindowSize(){
        System.out.println(currentWebDriver.manage().window().getSize());
    }

    public static void runBrowser(String url){
        currentWebDriver = (WebDriver) yandexWebDriver;
        currentWebDriver.get(url);
    }

    public static org.openqa.selenium.WebDriver yandexWebDriver = new ChromeDriver();
    public static org.openqa.selenium.WebDriver currentWebDriver;

}
