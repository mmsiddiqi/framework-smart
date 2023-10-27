package portal.screenplay.navigation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.DefaultUrl;

import static net.serenitybdd.screenplay.actions.Open.browserOn;

@DefaultUrl("https://fdx-pilot-t.apps.femadex-az.fematdl.net/Feature/Home")
public class NavigateNewHomePage extends PageObject {
    public static Performable login(){
        return Task.where("{0} on the login page",
                browserOn().thePageNamed("portal.temp.loginpage")
                //browserOn().thePageNamed
        );

    }
}
