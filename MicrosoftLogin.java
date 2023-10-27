package portal.screenplay.action;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.net.URI;
import java.util.function.Predicate;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class MicrosoftLogin implements net.serenitybdd.screenplay.Task {
    @Managed
    WebDriver driver;
    public static MicrosoftLogin withCredentials() {
        return instrumented(MicrosoftLogin.class);
    }

    @SneakyThrows
    @Beta
    @Override
    @Step("Log in as: {0}")
    public <T extends Actor> void performAs(T actor) {
        Thread.sleep(30000);
        actor.attemptsTo(
                WaitUntil.the(portal.screenplay.pages.MicrosoftLogin.USERNAME_FIELD, isPresent()).then(
                        Enter.theValue(authenticated(actor).userName())
                                .into(portal.screenplay.pages.MicrosoftLogin.USERNAME_FIELD)
                ),
                WaitUntil.the(portal.screenplay.pages.MicrosoftLogin.USERNAME_SIGN_IN_BUTTON, isClickable()).then(
                        Click.on(portal.screenplay.pages.MicrosoftLogin.USERNAME_SIGN_IN_BUTTON)
                )
//                ),
//
//                WaitUntil.the(portal.screenplay.pages.MicrosoftLogin.PASSWORD_FIELD, isPresent()).then(
//                        Enter.theValue(authenticated(actor).password())
//                                .into(portal.screenplay.pages.MicrosoftLogin.PASSWORD_FIELD)
//                ),
//                WaitUntil.the(portal.screenplay.pages.MicrosoftLogin.PASSWORD_SIGN_IN_BUTTON, isClickable()).then(
//                        Click.on(portal.screenplay.pages.MicrosoftLogin.PASSWORD_SIGN_IN_BUTTON)
//                ),
//
//                WaitUntil.the(portal.screenplay.pages.MicrosoftLogin.STAY_SIGNED_IN_NO_BUTTON, isClickable()).then(
//                        Click.on(portal.screenplay.pages.MicrosoftLogin.STAY_SIGNED_IN_NO_BUTTON)
//                )
        );


        Thread.sleep(5000);

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("https://fdx-pilot-r.apps.femadex.fema.net");
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("femadex-analyst@fema.net", "JL1JlVd0%X(9NhPM"));
        driver.get("adfs.fema.dhs.gov");


        Thread.sleep(10000);
        //"femadex-analyst@fema.net", "JL1JlVd0%X(9NhPM"
    }

    private Authenticate authenticated(Actor actor) {
        return Authenticate.as(actor);
    }
}
