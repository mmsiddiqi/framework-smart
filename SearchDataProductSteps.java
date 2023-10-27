package femadex.portal.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.EventualConsequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import portal.screenplay.navigation.NavigateNewHomePage;
import portal.screenplay.pages.HomePage;
import portal.screenplay.questions.DataProductSearchQuestions;
import portal.screenplay.questions.SearchDataProductQuestion;
import portal.screenplay.tasks.HomeTasks;

import portal.screenplay.tasks.SearchDataProductTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class SearchDataProductSteps extends UIInteractionSteps {

    static WebDriver driver = null;
    Actor actor;

    static SearchDataProductTask task = null;

    @Given("{actor} am a FEMADex user in pilot interested in search bar")
    public void iAmAFEMADexUserInPilotSearch(Actor actor) throws InterruptedException {

        System.out.println(" BACKGROUND STARTS ======================== BACKGROUND STARTS  ============================================ BACKGROUND STARTS  =========================" + "\n");

        driver = BrowseTheWeb.as(actor).getDriver();
        this.actor = actor;

        task = new SearchDataProductTask(driver, actor);

        actor.attemptsTo(NavigateNewHomePage.login());
        actor.attemptsTo(WaitUntil.the(HomePage.SIGN_IN_SSO_BTN, isVisible()));

        actor.attemptsTo(HomeTasks.clickLoginBtn());

        actor.attemptsTo(WaitUntil.the(HomePage.RULES_OF_BEHAVIOR_ACCEPT_BTN, isVisible()));
        actor.attemptsTo(HomeTasks.clickRulesOfBehaviorAcceptBtn());
        Thread.sleep(5000);
        if (task.Data_Products.isVisibleFor(actor)) {
            System.out.println("I am on Dash Board.");
        } else {
            actor.attemptsTo(WaitUntil.the(HomePage.SIGN_IN_SSO_BTN, isVisible()));

            actor.attemptsTo(HomeTasks.clickLoginBtn());

            actor.attemptsTo(WaitUntil.the(HomePage.RULES_OF_BEHAVIOR_ACCEPT_BTN, isVisible()));
            actor.attemptsTo(HomeTasks.clickRulesOfBehaviorAcceptBtn());
        }

        System.out.println("\n" + " BACKGROUND ENDS ======================== BACKGROUND ENDS   ============================================ BACKGROUND ENDS   ================================================" + "\n");

    }

    //SCENARIO: 1 ============================================================================= SCENARIO: 1 ====================================================================================================================
    @When("I enter QWERTY in the search box and press enter")
    public void iEnterQWERTYInTheSearchBoxAndClickTheSearchIcon() {

        System.out.println(" SCENARIO:1 STARTS ======================== Scenario:1 STARTS ============================================ SCENARIO:1 STARTS =================================" + "\n");

        theActorInTheSpotlight().attemptsTo(task.click_global_search());
        actor.wasAbleTo(task.enterQWERTYSearchQuery());

    }


    @Then("{actor} should see No Results returned to the user")
    public void iShouldSeeNoResultsReturnedToTheUser(Actor actor) {

        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(SearchDataProductQuestion.noSearchResultsDisplayed(), equalTo("We couldn't find anything for your search 'QWERTY'")))
                .waitingForNoLongerThan(10).seconds());

        System.out.println("\n" + "SCENARIO:1 ENDS ======================== Scenario:1 ENDS ============================================ SCENARIO:1 ENDS ===================================" + "\n");

    }

    //SCENARIO: 2 ============================================================================= SCENARIO: 2 ====================================================================================================================

    @When("{actor} navigate to the data product search results")
    public void iNavigateToTheDataProductSearchResults(Actor actor) throws InterruptedException {

        System.out.println(" SCENARIO:2 STARTS ======================== Scenario:2  STARTS ============================================ Scenario:2  STARTS =============================" + "\n");

        actor.attemptsTo(task.click_Data_Products_Menu());
        actor.attemptsTo(task.click_Search_Data_Products_Link());

    }

    @Then("I see a section Refine Results with following filter groups to further refine my search results")
    public void i_see_a_section_with_following_filter_groups_to_further_refine_my_search_results() {

        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.refineResultsTextDisplayed(), equalTo("Refine Results")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle1Displayed(), equalTo("Workspaces")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle2Displayed(), equalTo("Data Product Type")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle3Displayed(), equalTo("Tools")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle4Displayed(), equalTo("Programs & Events")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle5Displayed(), equalTo("Data Domains")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle6Displayed(), equalTo("Sensitivity")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle7Displayed(), equalTo("Tags")))
                .waitingForNoLongerThan(10).seconds());
        theActorInTheSpotlight().should(EventualConsequence.eventually(
                        seeThat(DataProductSearchQuestions.filterTitle8Displayed(), equalTo("My Filters")))
                .waitingForNoLongerThan(10).seconds());

    }


    @And("{actor} see each value within the filters has the count that represents the number of search results returned for the search criteria")
    public void i_see_each_value_within_the_filters_has_the_count_that_represents_the_number_of_search_results_returned_for_the_search_criteria(Actor actor) {


        // Workspace Category
        theActorInTheSpotlight().attemptsTo(task.click_Workspace_Filter()); // Expand

        // Workspace: Enterprise
        theActorInTheSpotlight().attemptsTo(task.click_Enterprise_Workspace());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.enterprise_Workspace_DataProduct_count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Workspace:FEMADex-Team-Developers
        actor.attemptsTo(task.click_FEMADex_Team_Developers_Workspace()); // The attemptsTo() method accepts "Performable" object.
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_fEMADex_Team_Developers_DataProduct_count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        theActorInTheSpotlight().attemptsTo(task.click_Workspace_Filter()); // Collapse





        // Data Product Type Category
        actor.attemptsTo(task.click_Data_Product_Type_Filter());

        // Data Product Type: Decision Support
        actor.attemptsTo(task.click_Decision_Support());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Decision_Support_DataProduct_count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Data Product Type: Derived Data
        actor.attemptsTo(task.click_Derived_Data());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_DerivedData_DataProduct_count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Data Product Type: Raw Data
        actor.attemptsTo(task.click_Raw_Data());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_RawData_DataProduct_count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        theActorInTheSpotlight().attemptsTo(task.click_Data_Product_Type_Filter()); // Collapse





        // Tools Category
        actor.attemptsTo(task.click_Tools());

        // Tools: ArcGIS
        actor.attemptsTo(task.click_ArcGIS());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_ArcGIS_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tools: Azure Data Lake
        actor.attemptsTo(task.click_Azure_Data_Lake());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Azure_Data_Lake_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tools: Databricks
        actor.attemptsTo(task.click_Databricks());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Databricks_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tools: Power BI
        actor.attemptsTo(task.click_PowerBI());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_PowerBI_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        //Tools: Tableau
        actor.attemptsTo(task.click_Tableau());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_TableauCount()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        theActorInTheSpotlight().attemptsTo(task.click_Tools()); // Collapse





        // Program & Events Category
        actor.attemptsTo(task.click_Program_Events());

        // Program & Events: Public Assistance
        actor.attemptsTo(task.click_PublicAssistance());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_PublicAssistanceCount()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        theActorInTheSpotlight().attemptsTo(task.click_Program_Events()); // Collapse





        // Data Domain
        actor.attemptsTo(task.click_DataDomain());

        // Data Domain: Field Operations
        actor.attemptsTo(task.click_FieldOperations());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_FieldOperations_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Data Domain: Grants
        actor.attemptsTo(task.click_Grants());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Grants_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Data Domain: Human Capital
        actor.attemptsTo(task.click_HumanCapital());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_HumanCapital_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Data Domain: Response and Recovery
        actor.attemptsTo(task.click_ResponseRecovery());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_ResponseRecovery_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Data Domain: USFA
        actor.attemptsTo(task.click_USFA());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_USFA_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        theActorInTheSpotlight().attemptsTo(task.click_DataDomain()); // Collapse





        // Sensitivity
        actor.attemptsTo(task.click_Sensitivity());

        // Sensitivity: Controlled
        actor.attemptsTo(task.click_Controlled());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Controlled_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Sensitivity: Public
        actor.attemptsTo(task.click_Public());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Public_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        //Sensitivity: Restricted
        actor.attemptsTo(task.click_Restricted());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Restricted_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        theActorInTheSpotlight().attemptsTo(task.click_Sensitivity()); // Collapse





        // Tags
        actor.attemptsTo(task.click_Tags());

        // Tags: Algorithm
        actor.attemptsTo(task.click_Algorithm());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Algorithm_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tags: Analysis
        actor.attemptsTo(task.click_Analysis());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Analysis_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tags: Appeal
        actor.attemptsTo(task.click_Appeal());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Appeal_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tags: Applicant
        actor.attemptsTo(task.click_Applicant());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Applicant_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tags: Diversity
        actor.attemptsTo(task.click_Diversity());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Diversity_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        // Tags: Equity
        actor.attemptsTo(task.click_Equity());
        actor.attemptsTo(Ensure.that(task.get_RefineResult_count()).contains(task.get_Equity_Count()));

        actor.attemptsTo(task.click_Clear_All_Filters());

        theActorInTheSpotlight().attemptsTo(task.click_Tags()); // Collapse


    }


    @And("{actor} have the ability to collapse and or expand the filter groups")
    public void i_have_the_ability_to_collapse_and_or_expand_the_filter_groups(Actor actor) {

        actor.attemptsTo(task.click_Workspace_Filter()); // Expand
        actor.attemptsTo(task.click_Workspace_Filter()); // Collapse

        actor.attemptsTo(task.click_Data_Product_Type_Filter());// Expand
        actor.attemptsTo(task.click_Data_Product_Type_Filter());// Collapse

        actor.attemptsTo(task.click_Tools());// Expand
        actor.attemptsTo(task.click_Tools());// Collapse

        actor.attemptsTo(task.click_Program_Events());// Expand
        actor.attemptsTo(task.click_Program_Events());// Collapse

        actor.attemptsTo(task.click_DataDomain());// Expand
        actor.attemptsTo(task.click_DataDomain());// Collapse

        actor.attemptsTo(task.click_Sensitivity());// Expand
        actor.attemptsTo(task.click_Sensitivity());// Collapse

        actor.attemptsTo(task.click_Tags());// Expand
        actor.attemptsTo(task.click_Tags());// Collapse

        actor.attemptsTo(task.click_MyFilters());// Expand
        actor.attemptsTo(task.click_MyFilters());// Collapse

        System.out.println("\n" + " Scenario:2 ENDS  ======================== Scenario:2 ENDS ============================================ Scenario:2 ENDS ====================================" + "\n");

    }

    @When("{actor} navigate to the data product search results and select a filter")
    public void i_navigate_to_the_data_product_search_results_and_select_a_filter(Actor actor) throws InterruptedException {

        System.out.println(" SCENARIO:3 STARTS ======================== Scenario:3  STARTS ============================================ Scenario:3  STARTS ====================================" + "\n");

        iNavigateToTheDataProductSearchResults(actor);

        theActorInTheSpotlight().attemptsTo(task.click_Workspace_Filter()); // Expand

        theActorInTheSpotlight().attemptsTo(task.click_Enterprise_Workspace());
    }

    @Then("{actor} see the selected filters are displayed at the top of the search results")
    public void i_see_the_selected_filters_are_displayed_at_the_top_of_the_search_results(Actor actor) {

        int distance_of_Filter_Name_from_top_left_corner_of_the_screen = task.getVerticalDistance_of_Filter_Name_from_top_left_corner_of_the_screen();

        int distance_of_Search_Result_from_top_left_corner_of_the_screen = task.getVerticalDistance_of_Search_Result_from_top_left_corner_of_the_screen();

        actor.attemptsTo(Ensure.that(distance_of_Filter_Name_from_top_left_corner_of_the_screen).isLessThan(distance_of_Search_Result_from_top_left_corner_of_the_screen));  // |----  I should see a value that is less than: <519>

        // From Top Left Corner, the less distance means close to top and Left, the greater distance means far from top left.

        // actor.attemptsTo(Ensure.that(PageElement_SearchDataProduct.refineResult_Count).text().contains(BrowseTheWeb.as(actor).find(PageElement_SearchDataProduct.fEMADex_Team_Developers_Workspace).getText() ));

        System.out.println("\n" + " SCENARIO:3 ENDS ======================== Scenario:3  ENDS ============================================ Scenario:3  ENDS ==========================================");

    }

    @Then("I see the My Filters filter group has the following values My Favorites")
    public void i_see_the_filter_group_has_the_following_values() {

        System.out.println(" SCENARIO:4 STARTS ======================== Scenario:4  STARTS ============================================ Scenario:4  STARTS =========================================" + "\n");

        actor.attemptsTo(task.click_MyFilters());

        // My Filter is empty.
        Assert.fail(" When \"MY FIlTERS\" is Expanded, NOTHING is found inside it.");

    }

    @Then("I will see a filter group named \"Workspace\" within the Refine Results section")
    public void i_will_see_a_filter_group_named_within_the_refine_results_section() {

    }


}
