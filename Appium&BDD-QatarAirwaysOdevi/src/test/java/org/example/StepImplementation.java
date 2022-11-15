package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {
    Logger logger = LogManager.getLogger(StepImplementation.class);

    @Step("<second> saniye kadar bekle")
    public void waitForsecond(int second) throws InterruptedException {
        Thread.sleep(1000 * second);
    }

    @Step("<xpath> xpath'li elemente tıkla")
    public void clickElementByXpath(String xpath) {
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.click();
        System.out.println(element + "elemente tıklandı");
    }

    @Step("<id> li elemente tıkla")
    public void clickElementByid(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        element.click();
        System.out.println(element + "elemente tıklandı");
    }

    @Step("<id> li elementi bul ve <key> degerini yaz")
    public void sendkeyElementById(String id, String key) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        element.sendKeys(key);
        System.out.println(element + "elemente tıklandı");
    }

    @Step("<xpath> li element <text> degerini iceriyor mu kontrol et")
    public void assertElement(String xpath, String text) {
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        System.out.println("Alinan text degeri ===== " + element.getText() + "   -> Ana ekran acilisi kontrolu saglandi..");
        logger.info("Ana ekrandaki bir unique text degeri kontrolu ile uygulamanın acildigi kontrol edildi!!");
        Assert.assertTrue("Element bulunamadı", element.getText().equals(text));

    }

    @Step("ucus secim ekrani icin <id> li element <text> degerini iceriyor mu kontrol et")
    public void assertElementUcusSecim(String id, String text) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        System.out.println("Alinan text degeri ===== " + element.getText() + "     -> Ucus secim kontolu saglandi..");
        Assert.assertTrue("Element bulunamadı", element.getText().equals(text));
        logger.info("Ucus secim ekranindaki bir unique text degeri kontrolu ile ucus secim ekraninin acilgigi kontrol edildi!!");
    }
}
