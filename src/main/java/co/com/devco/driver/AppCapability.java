package co.com.devco.driver;

public enum AppCapability {
    ANDROID_APP_PACKAGE("com.uberall.uberall"),
    ANDROID_APP_ACTIVITY("com.uberall.uberall.MainActivity"),
    IOS_BUNDLE_ID("com.uberall.uberall");

    AppCapability(String property) {
        this.property = property;
    }

    final String property;

    public String getProperty() {
        return property;
    }
}
