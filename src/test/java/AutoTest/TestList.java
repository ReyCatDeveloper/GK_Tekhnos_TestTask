package AutoTest;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;

import static Environment.ProjectDriver.currentWebDriver;
import static Environment.ProjectDriver.runBrowser;
import static Environment.Resources.*;
import static WebAction.Checks.checkElement;
import static WebAction.Clicks.clickElement;
import static WebAction.Entering.*;

public class TestList {

    @Test
    public void test0(){
        String locator = "//textarea[@name=\"q\"]";
        runBrowser(resource_google.getUrl());

        new Actions(currentWebDriver)
                .keyDown(Keys.SHIFT)
                .sendKeys("aaaaa")
                .keyUp(Keys.SHIFT)
                .sendKeys("b")
                .sendKeys(Keys.BACK_SPACE)
                .perform();
    }

    @Test
    public void test() throws InterruptedException {
        //LOCATORS
        String locator_button_ipoteka = "//a[@aria-label=\"Ипотека\"]";
        String locator_button_secondHome = "//a[text()=\"Ипотека на вторичное жильё\"]";
        String locator_calcGreetings = "//p[text()=\"Кредитный калькулятор поможет подобрать выгодные условия\"]";
        String locator_field_costOfHome = "//label[text()=\"Стоимость недвижимости\"]/preceding-sibling::input";
        String locator_field_costOfHome2 = "//label[text()=\"Стоимость недвижимости\"]/preceding-sibling::input/ancestor::div[1]";
        String locator_field_firstCost = "//label[text()=\"Первоначальный взнос\"]/preceding-sibling::input";
        String locator_field_firstCost2 = "//label[text()=\"Первоначальный взнос\"]/preceding-sibling::input/ancestor::div[1]";
        String locator_field_timeOfCredit ="//label[text()=\"Срок кредита\"]/preceding-sibling::input/ancestor::div[1]";

        String locator_modal_paymentScheduleForm = "//div[@data-dc-modal=\"opened\"]//h4[text()=\"График платежей\"]";
        String locator_slider_motherMany = "//span[text()=\"Использовать материнский капитал\"]";
        //ТЕСТОВЫЕ ДАННЫЕ:
        //стоимость недвижимости
        String costOfHome = "5300000";
        //первоначальный взнос
        String firstCost = "550000";

        //ЗАПУСК яндекс-браузера
        runBrowser(resource_sber.getUrl());

        //Нажать "Ипотека"
            Thread.sleep(5000);
            clickElement(locator_button_ipoteka);
        //Нажать "Вторичное жилье"
            clickElement(locator_button_secondHome);
        //Принять cookies
            Thread.sleep(2000);
            String locator_button_cookiesAgree = "//button[text()=\"Принять\"]";
            clickElement(locator_button_cookiesAgree);

        //(активация фрейма)
            checkElement(locator_calcGreetings, "\"Кредитный калькулятор, приветствие\"");
            try{
                clickElement(locator_field_timeOfCredit);
            }catch(WebDriverException wde){

            };

        //Переключение на фрейм калькулятора   iFrameResizer0   id="iFrameResizer0"
            Thread.sleep(2000);
            currentWebDriver.switchTo().frame("iFrameResizer0");
        //"Прокрутка" до поля срок кредита (сугубо для удобства наблюдения)
        clickElement(locator_field_timeOfCredit);

        //ЗАПОЛНЕНИЕ ФОРМЫ

            //стоимость недвижимости
            Thread.sleep(3000);
            clickElement(locator_field_costOfHome2);
            clearActiveField(locator_field_costOfHome);
            enteringIntoElement(locator_field_costOfHome,costOfHome);

            //первоначальный взнос
            Thread.sleep(1000);
            clickElement(locator_field_firstCost2);
            clearActiveField(locator_field_firstCost);
            enteringIntoElement(locator_field_firstCost,firstCost);

        //НАЖАТЬ: ГРАФИК ПЛАТЕЖЕЙ
            Thread.sleep(1000);
            String locator_button_paymentSchedule = "//span[text()=\"График платежей\"]/ancestor::button";
            clickElement(locator_button_paymentSchedule);

        //Ожидание формы с расчетом
           Thread.sleep(2000);
            checkElement(locator_modal_paymentScheduleForm, "\"График платежей\"");


    }

}
