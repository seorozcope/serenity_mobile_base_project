package co.com.devco.userinterface;

import co.com.devco.automation.mobile.locator.Locator;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.devco.automation.mobile.locator.ElementFinder.theElementBy;
import static co.com.devco.automation.mobile.locator.Locator.locator;

public class CheckoutCompletadoPage {
    public static final Locator LBL_CHECKOUT_COMPLETE_LOCATOR = locator().withAndroidXpathStatic("//android.widget.TextView[@text='CHECKOUT: COMPLETE!']" )
                                                                        .withIosXpathDynamic("1" );

    public static final Target LBL_CHECKOUT_COMPLETE = Target.the("Title Checkout Complete").located(theElementBy(LBL_CHECKOUT_COMPLETE_LOCATOR));
}