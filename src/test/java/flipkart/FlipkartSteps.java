package flipkart;

import common.UIOperation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipkartSteps {
    private final WebDriver driver;
    private final UIOperation uiOperation;

    public FlipkartSteps(WebDriver driver) {
        this.driver = driver;
        uiOperation = new UIOperation(this.driver);
    }

    public boolean clickCloseButtonInLoginWindow() {
        if (uiOperation.verifyTheElementIsEnabled(FlipkartComponentObjects.loginWindowCloseButton)) {
            uiOperation.click(FlipkartComponentObjects.loginWindowCloseButton);
            return true;
        }
        return false;
    }

    public boolean searchTextInTheSearchField(String text) {
        if (uiOperation.verifyTheElementIsEnabled(FlipkartComponentObjects.searchBar)) {
            uiOperation.sendKeys(FlipkartComponentObjects.searchBar, text);
            uiOperation.click(FlipkartComponentObjects.searchButton);
            return true;
        }
        return false;
    }

    public boolean clickMobilesInCategory() {
        if (uiOperation.verifyTheElementIsEnabled(FlipkartComponentObjects.mobileCategory)) {
            uiOperation.click(FlipkartComponentObjects.mobileCategory);
            return true;
        }
        return false;
    }

    public boolean clickSamsungCheckbox() {
        if (uiOperation.verifyTheElementIsEnabled(FlipkartComponentObjects.samsungCheckbox)) {
            uiOperation.click(FlipkartComponentObjects.samsungCheckbox);
            return true;
        }
        return false;
    }

    public boolean clickFlipkartAssuredCheckboxUsingJS() {
        return uiOperation.executeJavaScript("document.getElementsByClassName('_24_Dny _3tCU7L')[0].click();");
    }

    public boolean clickPriceHighToLowOption() {
        if (uiOperation.verifyTheElementIsEnabled(FlipkartComponentObjects.priceHighToLow)) {
            uiOperation.click(FlipkartComponentObjects.priceHighToLow);
            return true;
        }
        return false;
    }

    public List<Map<String, String>> getAllProductInfo() {
        List<WebElement> productLinks = driver.findElements(FlipkartComponentObjects.productLink);
        List<WebElement> productNames = driver.findElements(FlipkartComponentObjects.productName);
        List<WebElement> productPrices = driver.findElements(FlipkartComponentObjects.productPrice);

        assert productLinks.size() == productNames.size() && productLinks.size() == productPrices.size() : "Name=" + productNames.size() + "\nPrice=" + productPrices.size() + "\nLink=" + productLinks.size();

        List<Map<String, String>> productsInfo = new ArrayList<>();
        for (int i = 0; i < productLinks.size(); i++) {
            Map<String, String> productInfo = new HashMap<>();
            productInfo.put("Name", productNames.get(i).getText());
            productInfo.put("Price", productPrices.get(i).getText());
            productInfo.put("Link", productLinks.get(i).getAttribute("href"));
            productsInfo.add(productInfo);
        }
        return productsInfo;
    }
}
