package co.com.devco.userinterface;

import co.com.devco.automation.mobile.locator.Locator;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.devco.automation.mobile.locator.ElementFinder.dynamicElement;
import static co.com.devco.automation.mobile.locator.Locator.locator;

public class HomePage {
    public static final Locator LBL_NAME_PRODUCT_LOCATOR = locator().withAndroidXpathDynamic("//android.widget.TextView[@text='{0}']")
                                                                    .withIosXpathDynamic("1" );

    public static final Target LBL_NAME_PRODUCT = Target.the("Title with the name of the prodcut").locatedBy(dynamicElement(LBL_NAME_PRODUCT_LOCATOR));
}
