package co.com.devco.stepdefinitions;

import co.com.devco.driver.AndroidMobileDriver;
import co.com.devco.driver.IOSMobileDriver;
import co.com.devco.driver.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.devco.driver.DriverProperty.PLATFORM_NAME;
import static co.com.devco.utilities.ReadSerenityProperty.getTheProperty;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Hooks {

    @Managed(driver = "Appium")
    public static WebDriver driver;
    private static boolean beforeAll = true;

    @Before
    public void setUp() {
        if (beforeAll) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    driver.quit();
                    driver = null;
                }
            });
            beforeAll = false;
        }
        driver = getProxiedDriver();
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(BrowseTheWeb.with(driver)));
    }

    @After
    static void teardown() {
        String platformName = getTheProperty(PLATFORM_NAME.propertyName());
        MobileDriver mobileDriver = new MobileDriver(new AndroidMobileDriver());
        if ("iOS".equalsIgnoreCase(platformName)) {
            mobileDriver = new MobileDriver(new IOSMobileDriver());
        }
        mobileDriver.resetApp();
    }
}