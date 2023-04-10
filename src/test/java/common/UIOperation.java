package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIOperation {
    private final WebDriver driver;
    private final WebDriverWait webDriverWait;

    public UIOperation(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public boolean verifyTheElementIsEnabled(By element) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element)).isEnabled();
    }

    public void click(By button) {
        driver.findElement(button).click();
    }

    public void sendKeys(By inputField, String value) {
        driver.findElement(inputField).sendKeys(value);
    }

    public boolean executeJavaScript(String script) {
        try {
            ((JavascriptExecutor) driver).executeScript(script);
            return true;
        } catch (JavascriptException e) {
            e.printStackTrace();
        }
        return false;
    }
}
