package com.venkyold.org.adv.utils;

import com.venkyold.org.adv.utils.Condition;
import com.venkyold.org.adv.utils.CoreDriver;
import com.venkyold.org.adv.utils.ElementIsDisplayed;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ClickAndWaitForElement implements Condition {

    private static final Logger LOGGER = Logger.getLogger(com.venkyold.org.adv.utils.ClickAndWaitForElement.class);
    private WebElement button;
    private ElementIsDisplayed elementIsDisplayed;

    public ClickAndWaitForElement(WebElement button, WebElement view) {
        this.button = button;
        elementIsDisplayed = new ElementIsDisplayed(view);
    }

    public boolean isSatisfied() {
        try {
            if (elementIsDisplayed.isSatisfied()) return true;
            button.click();
            return false;
        } catch (Exception e) {
            LOGGER.info(e.getClass().getSimpleName());// + " thrown while waiting for condition [" + describe() + "]", true);
            return false;
        }
    }

    public String describe() {
        return "Waiting for click event to display view. Element xpath [" + CoreDriver.getXPath(button) + "]";
    }

}
