package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class PartnersPage {
    private WebDriver driver;

    public PartnersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnOurPartnersButton() {
        WebElement outPartnersButton = driver.findElement(By.cssSelector("a.button--primary-hollow[data-om-navcta='Partners']"));
        outPartnersButton.click();
    }

    public void printPartners() {
        List<WebElement> partners = driver.findElements(By.cssSelector(".partners-block__logo"));
        ArrayList<String> names = new ArrayList<String>();
        for (WebElement partner : partners) {
            names.add(partner.getAttribute("href").substring(39, partner.getAttribute("href").length() - 1));
        }

        Set<String> filtered = new LinkedHashSet<String>(names);
        for (String s : filtered) {
            System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
        }
    }

    public String checkPage() {
        return driver.findElement(By.xpath("//h3[contains(text(), 'Partners')]")).getAttribute("textContent");
    }
}