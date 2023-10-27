package femadex.portal.screenplay.features.login;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

/**
@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("Screenplay pattern"),
        @WithTag("version:RELEASE-1"),
})*/
public class TempHomeQuestions extends UIInteractions {
   public static WebDriver iguanaIvyBrowser;

    Actor iguanaIvy = Actor.named("Iguana Ivy");
    //.whoCan(Authenticate.with("femadex-analyst@fema.net", "JL1JlVd0%X(9NhPM"));

   // @Steps
   // NavigateNewHomePage newHomePage;

    //@Steps
    //DataProductDetails dataProductDetails;

    @BeforeEach
    public void iguanaIvyCanBrowseTheWeb() {
        BrowseTheWeb.with(iguanaIvyBrowser);
        //newHomePage.login();
    }

    /**
    @AfterEach
    void clearTheList(){
        dataProductDetails.clearList();
    }*/

    /**
    @Test
    public void TempHomeQuestions(){
        iguanaIvy.can(BrowseTheWeb.with(iguanaIvyBrowser));

        iguanaIvy.should(seeThat(TheWebPage.title(), containsString("FEMADex User Portal")));
    }*/

}
