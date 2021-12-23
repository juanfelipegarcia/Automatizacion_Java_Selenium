package co.com.sofka.page.common;

import org.openqa.selenium.*;

public class CommonActionOnpages extends BaseSikulix{
    private WebDriver driver;

    public CommonActionOnpages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void findElement(By locator){
        driver.findElement(locator);
    }

    protected void enter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void addFile(By locator, String add){
        driver.findElement(locator).sendKeys(add);
    }

    protected void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    protected void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }




    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    public void clearText(WebElement webElement){
        webElement.clear();
    }


    protected void click(WebElement webElement){
        webElement.click();
    }



    protected void enter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void addFile(WebElement webElement, String add){
        webElement.sendKeys(add);
    }


    protected  String getText (WebElement webElement){
        return webElement.getText();
    }


    protected void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }






}
