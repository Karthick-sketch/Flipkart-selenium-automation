import static org.assertj.core.api.Assertions.assertThat;

import common.LoadProperties;
import flipkart.FlipkartSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.Map;

class ChromeTest {
    FlipkartSteps flipkartSteps;
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        LoadProperties.loadChromeSetup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        flipkartSteps = new FlipkartSteps(driver);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        driver.get("https://www.flipkart.com/");

        assertThat(flipkartSteps.clickCloseButtonInLoginWindow()).isTrue();

        assertThat(flipkartSteps.searchTextInTheSearchField("Samsung Galaxy S10")).isTrue();

        assertThat(flipkartSteps.clickMobilesInCategory()).isTrue();

        assertThat(flipkartSteps.clickSamsungCheckbox()).isTrue();

        assertThat(flipkartSteps.clickFlipkartAssuredCheckboxUsingJS()).isTrue();

        assertThat(flipkartSteps.clickPriceHighToLowOption()).isTrue();

        Thread.sleep(3000);
        List<Map<String, String>> products = flipkartSteps.getAllProductInfo();
        for (Map<String, String> product : products) {
            System.out.println(product.toString());
        }
    }

}