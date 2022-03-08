package co.com.devco.driver;

public enum DriverProperty {
    APP_PACKAGE("appium.appPackage"),
    APP_ACTIVITY("appium.appActivity"),
    BUNDLE_ID("appium.bundleId"),
    PLATFORM_NAME("appium.platformName");

    private DriverProperty(String property) {
        this.propertyName = property;
    }

    final String propertyName;

    public String propertyName() {
        return propertyName;
    }
}
