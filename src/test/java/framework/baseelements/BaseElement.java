package framework.baseelements;

import framework.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public abstract class BaseElement {
    protected By byLocator;
    protected String nameElement;

    public BaseElement(By byLocator, String nameElement){
        this.byLocator = byLocator;
        this.nameElement = nameElement;
    }

    public Integer getSizeFindElements() throws MalformedURLException {
        List<WebElement> listWebEl = Driver.getDriver().findElements(byLocator);
        return listWebEl.size();
    }
}
