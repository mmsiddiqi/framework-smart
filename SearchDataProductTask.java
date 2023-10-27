package portal.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.*;
import portal.screenplay.pages.SearchDataProductPage;

public class SearchDataProductTask extends SearchDataProductPage {
    WebDriver driver;
    Actor actor;

    public SearchDataProductTask(WebDriver driver, Actor actor) {
        super(driver, actor);
        this.driver = driver;
        this.actor = actor;

    }

    //SCENARIO: 1 ============================================================================= SCENARIO: 1 ====================================================================================================================
    public Performable click_global_search() {

        return Task.where("{0} click Search Menu Link",
                Click.on(global_search));
    }


    public Performable enterQWERTYSearchQuery() {
        Click.on(global_search_Box);
        return Task.where("{0} enters QWERTY as a value in Search bar and press enter",
                Enter.theValue("QWERTY")
                        .into(global_search_Box).thenHit(Keys.ENTER));
    }

    //SCENARIO: 2 ============================================================================= SCENARIO: 2 ====================================================================================================================
    public Performable click_Data_Products_Menu() {

        Performable  click_DataProduct = Task.where("{0} click DataProduct Menu", Click.on(Data_Products));

        return click_DataProduct;
    }

    public Performable click_Search_Data_Products_Link() {
        return Task.where("{0} click Search Data Product Link",
                Click.on(Search_Data_Products));
    }

    public Performable click_Clear_All_Filters() {
        return Task.where("{0} click Clear All Filters",
                Click.on(Clear_All_Filters));
    }

    public Performable click_Workspace_Filter() {
        System.out.println("\n" +"========================Workspace============================================ " );

        return Task.where("{0} click Workspace underneath the Refine Results",
                Click.on(workspace_Filter));
    }

    public Performable click_Enterprise_Workspace() {
        System.out.println("\n" +"========================Workspace: Enterprise================================== " );

        return Task.where("{0} click Enterprise inside Workspace of Refine Results",
                Click.on(enterprise_Workspace_DataProduct_count));
    }

    public String enterprise_Workspace_DataProduct_count() {
        String enterprise_DataProduct_Count = BrowseTheWeb.as(actor).find(enterprise_Workspace_DataProduct_count).getText();

        System.out.println("Enterprise DataProduct Count: " + enterprise_DataProduct_Count);

        return enterprise_DataProduct_Count;
    }

    public String get_RefineResult_count() {

        String refined_DataProduct_Count = BrowseTheWeb.as(actor).find(refine_result_DataProduct_count).getText();

        System.out.println("Refined Search Result Data Product Count: " + refined_DataProduct_Count);



        return refined_DataProduct_Count;

       // return Task.where("{0} click FEMADex-Team-Developers inside Workspace of Refine Results",
              //  Click.on(fEMADex_Team_Developers_DataProduct_count));

    }

    public Performable click_FEMADex_Team_Developers_Workspace() {
        System.out.println("\n" +"========================Workspace: FEMADex-Team-Developers================================== " );

        return Task.where("{0} click FEMADex-Team-Developers inside Workspace of Refine Results",
                Click.on(fEMADex_Team_Developers_DataProduct_count));
    }

    public String get_fEMADex_Team_Developers_DataProduct_count() {
        String fEMADex_Team_Developers_DataProduct_Count = BrowseTheWeb.as(actor).find(fEMADex_Team_Developers_DataProduct_count).getText();

        System.out.println("FEMADex-Team-Developers DataProduct Count: " + fEMADex_Team_Developers_DataProduct_Count);

        return fEMADex_Team_Developers_DataProduct_Count;
    }


    public Performable click_Data_Product_Type_Filter() {
        System.out.println("\n" +"========================Data Product Type================================== " );

        return Task.where("{0} click Data product Type",
                Click.on(Data_Product_Type_Filter));
    }

    public Performable click_Decision_Support() {
        System.out.println("\n" +"========================Data Product Type: Decision Support================================== " );

        return Task.where("{0} click Decision_Support",
                Click.on(decisionSupport_DataProduct_count));
    }

    public String get_Decision_Support_DataProduct_count() {
        String decision_Support_DataProduct_count = BrowseTheWeb.as(actor).find(decisionSupport_DataProduct_count).getText();

        System.out.println("Decision Support DataProduct count: " + decision_Support_DataProduct_count);

        return decision_Support_DataProduct_count;
    }
    public Performable click_Derived_Data() {
        System.out.println("\n" +"========================Data Product Type: Derived Data================================== " );
        return Task.where("{0} click Derived Data",
                Click.on(derivedData_DataProduct_count));
    }

    public String get_DerivedData_DataProduct_count() {
        String derived_Data_DataProduct_count = BrowseTheWeb.as(actor).find(derivedData_DataProduct_count).getText();

        System.out.println("Derived Data DataProduct Count: " + derived_Data_DataProduct_count);

        return derived_Data_DataProduct_count;
    }
    public Performable click_Raw_Data() {
        System.out.println("\n" +"========================Data Product Type: Raw Data================================== " );

        return Task.where("{0} click Raw Data",
                Click.on(rawData_DataProduct_count));
    }

    public String get_RawData_DataProduct_count() {
        String raw_Data_DataProduct_count = BrowseTheWeb.as(actor).find(rawData_DataProduct_count).getText();

        System.out.println("Raw Data DataProduct Count: " + raw_Data_DataProduct_count);

        return raw_Data_DataProduct_count;
    }


    public Performable click_Tools(){
        System.out.println("\n" +"========================Tools========================================= " );

        return Task.where("{0} click Tools",
                Click.on(tools));
    }

    public Performable click_ArcGIS(){
        System.out.println("\n" +"========================Tools: ArcGIS ================================= " );

        return Task.where("{0} click ArcGIS", Click.on(arcGIS));
    }

    public String get_ArcGIS_Count(){

        String arcGIS_Count=BrowseTheWeb.as(actor).find(arcGIS).getText();
        System.out.println("ArcGIS Data Product Count: " + arcGIS_Count);

        return arcGIS_Count;
    }

    public Performable click_Azure_Data_Lake(){
        System.out.println("\n" +"========================Tools: Azure Data Lake ================================= " );

        return Task.where("{0} click Azure Data Lake", Click.on(azure_Data_Lake));
    }

    public String get_Azure_Data_Lake_Count(){

        String azure_Data_Lake_Count = BrowseTheWeb.as(actor).find(azure_Data_Lake).getText();
        System.out.println("Azure Data Lake Data Product Count: " + azure_Data_Lake_Count);

        return azure_Data_Lake_Count;
    }

    public Performable click_Databricks() {

        System.out.println("\n" + "========================Tools: Databricks ================================= ");

        return  Task.where("{0} click Databricks", Click.on(databricks));
    }




    public String get_Databricks_Count(){

        String databricks_Count = BrowseTheWeb.as(actor).find(databricks).getText();

        System.out.println("Databricks Data Product Count: " + databricks_Count);

        return databricks_Count;
    }


    public Performable click_PowerBI(){

        System.out.println("\n" +"========================Tools: Power BI ================================= " );

        return  Task.where("{0} click Power BI", Click.on(powerBI));
    }

    public String get_PowerBI_Count(){

        String powerBI_Count = BrowseTheWeb.as(actor).find(powerBI).getText();
        System.out.println("Power BI Data Product Count: " + powerBI_Count);

        return powerBI_Count;
    }


    public Performable click_Tableau(){

        System.out.println("\n" +"========================Tools: Tableau================================= " );

        return  Task.where("{0} click Tableau", Click.on(tableau));

    }

    public String get_TableauCount(){

        String tableau_Count = BrowseTheWeb.as(actor).find(tableau).getText();

        System.out.println("Tableau Data Product Count: " + tableau_Count);

        return tableau_Count;
    }


    public Performable click_Program_Events(){

        System.out.println("\n" +"========================Program & Events================================= " );

        return Task.where("{0} click Program & Events", Click.on(program_Events));

    }


    public Performable click_PublicAssistance(){
        System.out.println("\n" +"========================Program & Events: Public Assistance================================= " );

        return Task.where("{0} click Public Assistance", Click.on(publicAssistance));

    }

    public String get_PublicAssistanceCount(){

        String publicAssistance_Count = BrowseTheWeb.as(actor).find(publicAssistance).getText();
        System.out.println("Public Assistance Data Product Count: " + publicAssistance_Count);

        return publicAssistance_Count;
    }

    public Performable click_DataDomain(){

        System.out.println("\n" +"========================Data Domains================================= " );

        return Task.where("{0} click Data Domain", Click.on(dataDomains));
    }

    public Performable click_FieldOperations(){

        System.out.println("\n" +"========================Data Domains: Field Operations================================= " );

        return  Task.where("{0} click Field Operations", Click.on(field_Operations));

    }

    public String get_FieldOperations_Count(){

        String fieldOperations_Count = BrowseTheWeb.as(actor).find(field_Operations).getText();

        System.out.println("Field Operations Data Product Count: " + fieldOperations_Count );

        return fieldOperations_Count;
    }


    public Performable click_Grants(){

        System.out.println("\n" +"========================Data Domains: Grants================================= " );

            return  Task.where("{0} click Grants", Click.on(grants));
    }


    public String get_Grants_Count(){

        String Grants_Count = BrowseTheWeb.as(actor).find(grants).getText();

        System.out.println("Grants Data Product Count: " + Grants_Count );

        return Grants_Count;
    }

    public Performable click_HumanCapital(){

        System.out.println("\n" +"========================Data Domains: Human Capital ================================= " );

        return   Task.where("{0} click Human Capital", Click.on(humanCapital));

    }


    public String get_HumanCapital_Count(){

        String humanCapital_Count = BrowseTheWeb.as(actor).find(humanCapital).getText();
        System.out.println("Human Capital Data Product Count: " + humanCapital_Count);

        return humanCapital_Count;
    }

    public Performable click_ResponseRecovery(){

        System.out.println("\n" +"========================Data Domains: Response and Recovery================================= " );

            return Task.where("{0} click Response and Recovery", Click.on(response_and_Recovery));
    }


    public String get_ResponseRecovery_Count(){

        String responseRecovery_Count = BrowseTheWeb.as(actor).find(response_and_Recovery).getText();

        System.out.println("Response and Recovery Data Product Count: " + responseRecovery_Count);

        return responseRecovery_Count;
    }


    public Performable click_USFA(){
        System.out.println("\n" +"========================Data Domains: USFA ================================= " );

        return Task.where("{0} click USFA", Click.on(uSFA));
    }


    public String get_USFA_Count(){

        String uSFA_Count = BrowseTheWeb.as(actor).find(uSFA).getText();

        System.out.println("USFA Data Product Count: " +  uSFA_Count);

        return  uSFA_Count;
    }



    public Performable click_Sensitivity(){
        System.out.println("\n" +"========================Sensitivity ================================= " );

        return Task.where("{0} click Sensitivity", Click.on(sensitivity));
    }


    public Performable click_Controlled(){
        System.out.println("\n" +"========================Sensitivity: Controlled ================================= " );

        return Task.where("{0} click Controlled", Click.on(controlled));
    }
    public String get_Controlled_Count(){

        String controlled_Count = BrowseTheWeb.as(actor).find(controlled).getText();

        System.out.println("Sensitivity Data Product Count: " +  controlled_Count);

        return  controlled_Count;
    }

    public Performable click_Public(){
        System.out.println("\n" +"========================Sensitivity: Public ================================= " );

        return Task.where("{0} click Public", Click.on(public_));
    }
    public String get_Public_Count(){

        String public_Count = BrowseTheWeb.as(actor).find(public_).getText();

        System.out.println("Public Data Product Count: " +  public_Count);

        return  public_Count;
    }

    public Performable click_Restricted(){
        System.out.println("\n" +"========================Sensitivity: Restricted ================================= " );

        return Task.where("{0} click Restricted", Click.on(restricted));
    }
    public String get_Restricted_Count(){

        String restricted_Count = BrowseTheWeb.as(actor).find(restricted).getText();

        System.out.println("Restricted Data Product Count: " +  restricted_Count);

        return  restricted_Count;
    }

    public Performable click_Tags(){
        System.out.println("\n" +"======================== Tags =============================================== " );

        return Task.where("{0} click Tags", Click.on(tags));
    }

    public Performable click_Algorithm(){
        System.out.println("\n" +"======================== Tags: Algorithm =============================================== " );

        return Task.where("{0} click Algorithm", Click.on(algorithm));
    }



    public String get_Algorithm_Count(){

        String algorithm_Count = BrowseTheWeb.as(actor).find(algorithm).getText();

        System.out.println("Algorithm Data Product Count: " +  algorithm_Count );

        return  algorithm_Count ;
    }

    public Performable click_Analysis(){
        System.out.println("\n" +"======================== Tags: Analysis =============================================== " );

        return Task.where("{0} click Analysis", Click.on(analysis));
    }



    public String get_Analysis_Count(){

        String analysis_Count = BrowseTheWeb.as(actor).find(analysis).getText();

        System.out.println("Analysis Data Product Count: " +  analysis_Count );

        return  analysis_Count ;
    }

    public Performable click_Appeal(){
        System.out.println("\n" +"======================== Tags: Appeal =============================================== " );

        return Task.where("{0} click Appeal", Click.on(appeal));
    }



    public String get_Appeal_Count(){

        String appeal_Count = BrowseTheWeb.as(actor).find(appeal).getText();

        System.out.println("Appeal Data Product Count: " +  appeal_Count );

        return  appeal_Count;
    }

    public Performable click_Applicant(){
        System.out.println("\n" +"======================== Tags: Applicant =============================================== " );

        return Task.where("{0} click Applicant", Click.on(applicant));
    }



    public String get_Applicant_Count(){

        String applicant_Count = BrowseTheWeb.as(actor).find(applicant).getText();

        System.out.println("Applicant Data Product Count: " +  applicant_Count );

        return  applicant_Count;
    }

    public Performable click_Diversity(){
        System.out.println("\n" +"======================== Tags: Diversity =============================================== " );

        return Task.where("{0} click Diversity", Click.on(diversity));
    }



    public String get_Diversity_Count(){

        String diversity_Count = BrowseTheWeb.as(actor).find(diversity).getText();

        System.out.println("Diversity Data Product Count: " +  diversity_Count );

        return  diversity_Count;
    }

    public Performable click_Equity(){
        System.out.println("\n" +"======================== Tags: Equity =============================================== " );

        return Task.where("{0} click Equity", Click.on(equity));
    }



    public String get_Equity_Count(){

        String equity_Count = BrowseTheWeb.as(actor).find(equity).getText();

        System.out.println("Equity Data Product Count: " +  equity_Count);

        return  equity_Count;
    }





    //SCENARIO: 3 ============================================================================= SCENARIO: 3 ====================================================================================================================

    public int getVerticalDistance_of_Filter_Name_from_top_left_corner_of_the_screen() {
        Point enterprise_filterName_Location = BrowseTheWeb.as(actor).find(enterprise_Workspace_filterName_at_the_top_0f_Search_Results).getLocation();

        int verticalDistance_of_enterprise_filterName_from_TopLeftCorner = enterprise_filterName_Location.y;

        System.out.println(verticalDistance_of_enterprise_filterName_from_TopLeftCorner);
        return verticalDistance_of_enterprise_filterName_from_TopLeftCorner;

    }

    public int getVerticalDistance_of_Search_Result_from_top_left_corner_of_the_screen() {

        Point searchResultLocation = BrowseTheWeb.as(actor).find(dataProduct_search_Results_Filtered_By_enterprise_Workspace).getLocation();

        int verticalDistance_of_searchResult_from_TopLeftCorner = searchResultLocation.y;

        System.out.println(verticalDistance_of_searchResult_from_TopLeftCorner);

        return verticalDistance_of_searchResult_from_TopLeftCorner;

    }

    //============================================================================= SCENARIO: 4 ====================================================================================================================

    public Performable click_MyFilters() {
        return Task.where("{0} click My Filters",
                Click.on(myFilters));
    }




}
