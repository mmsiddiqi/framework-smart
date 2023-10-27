package portal.screenplay.pages;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchDataProductPage {

    WebDriver driver = null;
    Actor actor=null;
    public SearchDataProductPage(WebDriver driver, Actor actor ){
        this.driver=driver;
        this.actor=actor;
        PageFactory.initElements(driver, this);
    }

    //SCENARIO: 1 ============================================================================= SCENARIO: 1 ====================================================================================================================

    public static final Target global_search = Target.the("Search").locatedBy("//span[text()='Search']");

    public static final Target global_search_Box = Target.the("Search Box").locatedBy("   //input[@placeholder='Search Data Products']");

    public static Target SEARCH_RESULTS_MESSAGE = Target.the("We couldn't find anything for your search 'QWERTY'")
            .locatedBy("//b[contains (text(), 'We couldn')]").waitingForNoMoreThan(Duration.ofSeconds(10));


    //SCENARIO: 2 ============================================================================= SCENARIO: 2 ====================================================================================================================

    public final Target Data_Products = Target.the("Data Products").located(By.id("data_products"));


    public static final Target Search_Data_Products = Target.the("search Data Products").located(By.id("search_data_products"));

    public static final Target Clear_All_Filters = Target.the("Clear All Filters").locatedBy(".pill.pill--link");





    // Workspace =====================================Workspace==========================================================================
    public static final Target workspace_Filter = Target.the("Workspace").located(By.id("accordian-header-Workspace"));
    public static final Target enterprise_Workspace_DataProduct_count= Target.the("Enterprise").located(By.id("item-count-span-Enterprise"));
    public static final Target refine_result_DataProduct_count= Target.the("Enterprise Refine Result Count").locatedBy(".dp-search-count");
    public static final Target fEMADex_Team_Developers_DataProduct_count= Target.the("FEMADex-Team-Developers").located(By.id("item-count-span-FEMADex-Team-Developers"));


    // Data Product Type =================================Data Product Type===========================================================
    public static final Target Data_Product_Type_Filter = Target.the("Data Product Type").located(By.id("accordian-header-Data Product Type"));

   public final Target decisionSupport_DataProduct_count= Target.the("Decision Support").located(By.id("item-count-span-Decision Support"));

 public final  Target derivedData_DataProduct_count=Target.the("Derived Data").located(By.id("item-count-span-Derived Data"));
    public final  Target rawData_DataProduct_count=Target.the("Raw Data").located(By.id("item-count-span-Raw Data"));


    // Tools=======================================Tools=================================================================================

    public final Target tools= Target.the("Tools").located(By.id("accordian-header-Tools"));
    public final Target arcGIS= Target.the("ArcGIS").located(By.id("item-count-span-ArcGIS"));
    public final Target azure_Data_Lake= Target.the("Azure Data Lake").located(By.id("item-count-span-Azure Data Lake"));

    public final Target databricks= Target.the("Databricks").located(By.id("item-count-span-Databricks"));
    public final Target powerBI= Target.the("Power BI").located(By.id("item-count-span-Power BI"));

    public final Target tableau= Target.the("Tableau").located(By.id("item-count-span-Tableau"));


    // Program and Events =========================Program and Events=======================================================================
    public final Target program_Events= Target.the("Program & Events").located(By.id("accordian-header-Programs & Events"));
    public final Target publicAssistance= Target.the("Public Assistance").located(By.id("item-count-span-Public Assistance"));


    // Data Domains =============================== Data Domains ============================================================================
    public final Target dataDomains= Target.the("Data Domains").located(By.id("accordian-header-Data Domains"));
    public final Target field_Operations= Target.the("Field Operations").located(By.id("item-count-span-Field Operations"));
    public final Target grants= Target.the("Grants").located(By.id("item-count-span-Grants"));
    public final Target humanCapital= Target.the("Human Capital").located(By.id("item-count-span-Human Capital"));
    public final Target response_and_Recovery= Target.the("Response and Recovery").located(By.id("item-count-span-Response and Recovery"));
    public final Target uSFA= Target.the("USFA").located(By.id("item-count-span-USFA"));


    // SENSITIVITY ================================SENSITIVITY=================================================================================

    public final Target sensitivity= Target.the("Sensitivity").located(By.id("accordian-header-Sensitivity"));
    public final Target controlled= Target.the("Controlled (Level 1)").located(By.id("item-count-span-Controlled (Level 1)"));
    public final Target public_= Target.the("Public (Level 0)").located(By.id("item-count-span-Public (Level 0)"));
    public final Target restricted= Target.the("Restricted (Level 2)").located(By.id("item-count-span-Restricted (Level 2)"));


    // Tags================================Tags=================================================================================

    public final Target tags= Target.the("Tags").located(By.id("accordian-header-Tags"));
    public final Target algorithm= Target.the("Algorithm").located(By.id("item-count-span-Algorithm"));
    public final Target analysis= Target.the("Analysis").located(By.id("item-count-span-Analysis"));
    public final Target appeal= Target.the("Appeal").located(By.id("item-count-span-Appeal"));

    public final Target applicant= Target.the("Applicant").located(By.id("item-count-span-Applicant"));

    public final Target diversity= Target.the("Diversity").located(By.id("item-count-span-Diversity"));

    public final Target equity= Target.the("Equity").located(By.id("item-count-span-Equity"));

















    //SCENARIO: 3 ============================================================================= SCENARIO: 3 ====================================================================================================================
    public static final Target enterprise_Workspace_filterName_at_the_top_0f_Search_Results = Target.the("Enterprise Workspace filterName located at the top of Search Results").locatedBy("//div[text()='Enterprise']");

    public static final Target dataProduct_search_Results_Filtered_By_enterprise_Workspace = Target.the("Data product Search Results filtered by Enterprise workspace").locatedBy(".sr-card-container");



    //SCENARIO: 4 ============================================================================= SCENARIO: 4 ====================================================================================================================

    public final Target myFilters=  Target.the("My Filters").locatedBy("//div[@id='accordian-header-My Filters']");



}
