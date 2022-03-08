package co.com.devco.driver;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;


import static co.com.devco.driver.DriverProperty.APP_ACTIVITY;
import static co.com.devco.driver.DriverProperty.APP_PACKAGE;
import static co.com.devco.utilities.ReadSerenityProperty.getTheProperty;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class AndroidMobileDriver implements IMobileDriver{
    @Override
    public void resetApp() {
        String appPackage = getTheProperty(APP_PACKAGE.propertyName());
        String appActivity = getTheProperty(APP_ACTIVITY.propertyName());
        Activity activity = new Activity(appPackage, appActivity);
        AndroidDriver driver = getProxiedDriver();
        driver.terminateApp(appPackage);
        driver.startActivity(activity);
    }
}
