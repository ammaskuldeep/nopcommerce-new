package com.venkyold.org.utils;

import com.venkyold.org.abstractTest;
import org.openqa.selenium.support.PageFactory;
import com.venkyold.org.utils.CoreObjectRepository;

/**
 * Created with IntelliJ IDEA.
 * User: GBY9AMA9
 * Date: 16/03/13
 * Time: 00:23
 * To change this template use File | Settings | File Templates.
 */
public class CoreObjectFactory {


    public static CoreObjectRepository getWebElements() {
        return PageFactory.initElements(abstractTest.getDriver(), CoreObjectRepository.class);
    }


}
