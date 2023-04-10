package flipkart;

import org.openqa.selenium.By;

public final class FlipkartComponentObjects {
    public static By loginWindowCloseButton = By.xpath("//body/div/div/div/button");
    public static By searchBar = By.cssSelector("input[placeholder='Search for products, brands and more']");
    public static By searchButton = By.xpath("//button[@type='submit']");
    public static By mobileCategory = By.xpath("//a[@title='Mobiles']");
    public static By samsungCheckbox = By.xpath("//div[text()='SAMSUNG']/preceding-sibling::div");
//    public static By flipkartAssuredCheckbox = By.xpath("//img[contains(@src, 'fa_62673a.png')]/parent::div/parent::div/preceding-sibling::input/following-sibling::div[1]");
    public static By priceHighToLow = By.xpath("//div[text()='Price -- High to Low']");
    public static By productLink = By.xpath("//a[contains(@href, '/samsung-galaxy-s')]");
    public static By productName = By.xpath("//a[contains(@href, '/samsung-galaxy-s')]/div[2]/div[1]/div[1]");
    public static By productPrice = By.xpath("//a[contains(@href, '/samsung-galaxy-s')]/div[2]/div[2]/div[1]/div[1]/div[1]");
}
