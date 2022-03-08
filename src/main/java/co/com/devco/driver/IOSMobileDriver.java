package co.com.devco.driver;

import io.appium.java_client.ios.IOSDriver;

import static co.com.devco.driver.DriverProperty.BUNDLE_ID;
import static co.com.devco.utilities.ReadSerenityProperty.getTheProperty;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class IOSMobileDriver implements IMobileDriver{
    @Override
    public void resetApp() {
        String appBundleId = getTheProperty(BUNDLE_ID.propertyName());
        IOSDriver driver = getProxiedDriver();
        driver.terminateApp(appBundleId);
        driver.activateApp(appBundleId);
    }
}
