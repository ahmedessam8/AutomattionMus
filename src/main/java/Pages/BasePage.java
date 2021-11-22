package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private final Duration TIMEOUT = Duration.ofSeconds(60);
    private final Duration POLLING_TIMEOUT = Duration.ofMillis(200);
    private By loadingIcon = By.xpath("//div[contains(@class, 'loader-container show')]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 200);
        PageFactory.initElements(driver, this);
    }
    protected boolean elementVisible(By locator, int timeOut) {
        boolean flag;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            flag = true;
        } catch (Exception ex) {
            flag = false;
        }
        return flag;
    }

    protected WebElement waitUntilElementVisible(By locator, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return   wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected WebElement findElementWithTimeout(By locator, long timeout){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(NoSuchElementException.class);
        return wait.until(d -> d.findElement(locator));
    }

    protected WebElement findElement(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(NoSuchElementException.class);
        return wait.until(d -> d.findElement(locator));
    }

    protected List<WebElement> findElements(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT)
                .pollingEvery(POLLING_TIMEOUT)
                .ignoring(NoSuchElementException.class);
        return wait.until(d -> d.findElements(locator));
    }
    public void waitUntilLoadingIconDisappears(int timeOut){
        waitUntilItemDisappears(loadingIcon, timeOut);
    }
    public void waitUntilItemDisappears(By item, int timeOut){
        elementVisible(item, 5);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(item));
    }
    public void waitUntilLoadingIconAppears(int timeOut){
        elementVisible(loadingIcon,timeOut);
    }
    protected WebElement findElementClickable(By locator, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return   wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public String switchToChildWindow() {
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        return  parentWindowId;
    }
    public String getURLValue() {
        return driver.getCurrentUrl();
    }
}
