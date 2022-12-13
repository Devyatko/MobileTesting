package framework.basepages;

import framework.baseelements.Button;

import java.net.MalformedURLException;

public abstract class BasePage {
    private Button uniqueEl;

    public BasePage(Button uniqueEl){
        this.uniqueEl = uniqueEl;
    }

    public boolean isOpen() throws MalformedURLException {
        return uniqueEl.getSizeFindElements() > 0;
    }
}
