package co.com.devco.tasks;

import co.com.devco.automation.mobile.actions.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.devco.userinterface.CheckoutPage.BTN_CHECKOUT;
import static co.com.devco.userinterface.CheckoutPage.BTN_CONTINUE;
import static co.com.devco.userinterface.CheckoutPage.BTN_FINISH;
import static co.com.devco.userinterface.CheckoutPage.TXT_LAST_NAME;
import static co.com.devco.userinterface.CheckoutPage.TXT_NAME;
import static co.com.devco.userinterface.CheckoutPage.TXT_POST_CODE;
import static co.com.devco.userinterface.ProductPage.BTN_OPEN_SHOP_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Checkout implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_OPEN_SHOP_CART),
                Scroll.untilVisibleTarget(BTN_CHECKOUT).toBottom().untilMaxAttempts(10),
                Click.on(BTN_CHECKOUT),
                Enter.theValue("Juan").into(TXT_NAME),
                Enter.theValue("Fernandez").into(TXT_LAST_NAME),
                SendKeys.of("050005").into(TXT_POST_CODE),
                Scroll.untilVisibleTarget(BTN_CONTINUE).toBottom().untilMaxAttempts(3),
                Click.on(BTN_CONTINUE),
                Scroll.untilVisibleTarget(BTN_FINISH).toBottom().untilMaxAttempts(10),
                WaitUntil.the(BTN_FINISH,isClickable()).forNoMoreThan(5).seconds(),
                Click.on(BTN_FINISH));
    }

    public static Performable checkout() {
        return instrumented(Checkout.class);
    }
}
