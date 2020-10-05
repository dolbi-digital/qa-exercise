package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OfficesPage {
    private WebDriver driver;

    public OfficesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnUnitedKingdom() {
        WebElement unitedKingdomLink = driver.findElement(By.xpath("//li[@class='list-item' and contains(text(), 'United Kingdom')]"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(unitedKingdomLink));
        unitedKingdomLink.click();
    }

    public void printUKOffices() {
        List<WebElement> offices = driver.findElements(By.xpath("//h3[contains(text(), 'United Kingdom')]/../..//address"));
        for(WebElement element : offices) {
            System.out.println(element.getAttribute("textContent") + "\n");
        }
    }

    public String checkPage() {
        return driver.findElement(By.cssSelector("div.site-chapter__box > h3")).getAttribute("textContent");
    }
}