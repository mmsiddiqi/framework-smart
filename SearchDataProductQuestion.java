package portal.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import portal.screenplay.pages.SearchDataProductPage;

public class SearchDataProductQuestion {

    public static Question<String> noSearchResultsDisplayed() {
        return Text.of(SearchDataProductPage.SEARCH_RESULTS_MESSAGE)
                .describedAs("We couldn't find anything for your search 'QWERTY'")
                .asString();
    }

    public static Question<String> get_Enterprise_Workspace_DataProducts_RefineResult() {

        return Text.of(SearchDataProductPage.refine_result_DataProduct_count);
               /*.describedAs("Showing 1 - 7 of 7 results") //actual
                .asString();*/
    }


}
