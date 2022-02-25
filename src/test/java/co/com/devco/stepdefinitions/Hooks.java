package co.com.devco.stepdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Hooks {

    @Managed(driver = "Appium")
    public static WebDriver driver;
    private static boolean beforeAll = true;
    private static boolean afterFirst = true;

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
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(BrowseTheWeb.with(getProxiedDriver())));
    }

    @After
    public void logOut() {
        try {
            AppiumDriver facade=null;
            if (afterFirst) {
                afterFirst=false;
            }else{
                facade= getProxiedDriver();
            }

            if(facade!=null){
                facade.quit();
            }
        } catch (Exception ex) {
            Logger.getAnonymousLogger().log(Level.WARNING, "Could not close driver. AppiumDriver not found", ex);
        }
    }
}