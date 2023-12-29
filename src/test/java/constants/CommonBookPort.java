package constants;

import net.fpt.utils.ReadingJsonUtil;
import java.util.List;

public class CommonBookPort {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static final String DATA_TEST_FILE_PATH_COMMON_BOOK_PORT = System.getProperty("user.dir")
            + "/src/test/java/data_file/BookPortData.json";


    public static String button_NoneAllowAppAccessLocation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"button_no_allow_app_access_location");
    public static String dropdown_InputDataManualBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"dropdown_input_data_manual_book_port");

    public static String title_BookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_book_port");
    public static String title_CreateOrder = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_create_order");
    public static String title_FTTHNew = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_ftth_new");
    public static String title_FTTH = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_ftth");
    public static String title_ADSL = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_adsl");
    public static String title_CustomerAddressBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_customer_address");
    public static String title_GridTypeFTTHBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_grid_type");
    public static String title_ContractTypeFTTHBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_contract_type");
    public static String title_ChoosePaymentMethod = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_choose_payment_method");

    public static String text_NegativeInteger = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"text_negative_integer");
    public static String text_SpecialCharacter = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"text_special_character");

    public static List list_TitleManualBookPort = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"list_title_manual_book_port");
    public static List list_BookPortDetailInfo = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"list_book_port_detail");

    public static String notice_BookPortSuccess = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_book_port_success");
    public static String notice_AutoBookPortFail = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_auto_book_port_fail");
    public static String notice_RecallBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_recall");
    public static String notice_NoneSetIndoorIndexBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_none_set_indoor_index");
    public static String notice_NoneSetOutdoorIndexBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_none_set_outdoor_index");
    public static String notice_NoneSetGridTypeBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_none_set_grid_type");
    public static String notice_NoneSetContractTypeBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_none_set_contract_type");
    public static String notice_ManualBookPortFail = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_manual_book_port_fail");
    public static String notice_ManualBookPortSuccess = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_manual_book_port_success");
    public static String notice_OvertimeToBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notice_overtime_to_book_port");











    //version 3.2.0.10
    public static String title_ManualBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"title_manual_book_port");
    public static String texBox_InputDataManualBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"text_box_input_data_manual_book_port");
    public static String button_AllowAppAccessLocation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"button_allow_app_access_location");

    public static String notification_NoneBookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"notification_none_book_port");

    public static List list_GridTypeFTTHBookPort = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"list_grid_type");
    public static List list_ContractTypeFTTHBookPort = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"list_contract_type");
    public static List list_IndoorOutdoorIndexManualBookPort = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_BOOK_PORT,"list_indoor_outdoor_index");
}
