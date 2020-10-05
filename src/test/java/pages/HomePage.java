package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        driver.findElement(By.cssSelector("#CybotCookiebotDialogBodyButtonAccept")).click();
        WebElement menuItem = driver.findElement(By.cssSelector("div.site-nav__icons > button.icon-menu"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(menuItem));
        menuItem.click();
    }

    public void selectPartnersItem() {
        WebElement partnersItem = driver.findElement(By.cssSelector(".site-nav__menu__primary > li:nth-child(3) > button"));
        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(partnersItem));
        partnersItem.click();
    }

    public void selectOfficesItem() {
        WebElement officesItem = driver.findElement(By.cssSelector(".site-nav__menu__secondary > li:nth-child(3) > a"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(officesItem));
        officesItem.click();
    }
}