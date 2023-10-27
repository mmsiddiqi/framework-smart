package portal.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import portal.screenplay.pages.DataProductCardPage;

public class DataProductCardQuestions {

    public static Question<String> dataProductCardModalTitle() {
        return Text.of(DataProductCardPage.FIRST_DATA_PRODUCT_CARD_MODAL_TITLE).describedAs("First Data Product Card Modal Title").asString();
    }

    public static Question<String> dataProductCardModalDataType() {
        return Text.of(DataProductCardPage.FIRST_DATA_PRODUCT_CARD_MODAL_DATA_TYPE).describedAs("First Data Product Card Modal Data Type").asString();
    }

    public static Question<String> dataProductCardModalOpenDataBtn() {
        return Text.of(DataProductCardPage.FIRST_DATA_PRODUCT_CARD_MODAL_OPEN_DATA_BTN).describedAs("First Data Product Card Modal Open Data Product Button").asString();
    }

    public static Question<String> firstDataProductCardModalTabOneTitle() {
        return Text.of(DataProductCardPage.FIRST_DATA_PRODUCT_CARD_MODAL_TAB_ONE_TITLE).describedAs("First Data Product Card Modal Tab One Title").asString();
    }

    public static Question<String> firstDataProductCardModalTabTwoTitle() {
        return Text.of(DataProductCardPage.FIRST_DATA_PRODUCT_CARD_MODAL_TAB_TWO_TITLE).describedAs("Second Data Product Card Modal Tab Two Title").asString();
    }

    public static Question<String> firstDataProductCardModalSection1Title() {
        return Text.of(DataProductCardPage.FIRST_DATA_PRODUCT_CARD_MODAL_SECTION_ONE_TITLE).describedAs("First Data Product Card Modal Tab One Title").asString();
    }

    public static Question<String> firstDataProductCardModalSection2Title() {
        return Text.of(DataProductCardPage.FIRST_DATA_PRODUCT_CARD_MODAL_SECTION_TWO_TITLE).describedAs("Second Data Product Card Modal Tab Two Title").asString();
    }

    public static Question<String> dataProductModalSensitivityIconTitle() {
        return   Text.of(DataProductCardPage.SENSITIVITY_ICON_TITLE).describedAs("Data Product Modal Sensitivity Icon Title").asString();
    }

    public static Question<String> dataAndResourcesTitle() {
        return  Text.of(DataProductCardPage.DATA_AND_RESOURCES_TITLE).describedAs("Data Product Modal Data and Resources Title").asString();
    }

    public static Question<String> dataAndResourcesDescription() {
        return Text.of(DataProductCardPage.DATA_AND_RESOURCES_Description).describedAs("Data Product Modal Data and Resources Description").asString();
    }

    public static Question<String> tagsTitle() {
        return Text.of(DataProductCardPage.TAGS_TITLE).describedAs("Data Product Modal Tags Title").asString();
    }


}
