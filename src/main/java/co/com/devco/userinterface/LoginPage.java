package co.com.devco.userinterface;

import co.com.devco.automation.mobile.locator.Locator;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.devco.automation.mobile.locator.ElementFinder.theElementBy;
import static co.com.devco.automation.mobile.locator.Locator.locator;

public class LoginPage {

    public static final Locator TXT_USERNAME_LOCATOR = locator().withAndroidXpathStatic("//android.widget.EditText[@content-desc='test-Username']" )
                                                                .withIosAccesibilityId("test-Username" );
    public static final Locator TXT_PASSWORD_LOCATOR = locator().withAndroidXpathStatic("//android.widget.EditText[@content-desc='test-Password']" )
                                                                .withIosAccesibilityId("test-Password" );
    public static final Locator BTN_LOGIN_LOCATOR = locator().withAndroidXpathStatic("//android.view.ViewGroup[@content-desc='test-LOGIN']" )
                                                            .withIosAccesibilityId("test-LOGIN" );

    public static final Target TXT_USERNAME = Target.the("Username Input").located(theElementBy(TXT_USERNAME_LOCATOR));
    public static final Target TXT_PASSWORD = Target.the("Password Input").located(theElementBy(TXT_PASSWORD_LOCATOR));
    public static final Target BTN_LOGIN = Target.the("Login Button").located(theElementBy(BTN_LOGIN_LOCATOR));
}
