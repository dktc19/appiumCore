package constants;

import java.util.ArrayList;
import java.util.List;
import net.fpt.utils.ReadingJsonUtil;

public final class CommonContract {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static final String DATA_TEST_FILE_PATH_COMMON_CONTRACT = System.getProperty("user.dir")
            + "/src/test/java/data_file/ContractData.json";

    public static String title_CustomerInfoTab = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_customer_info_tab");
    public static String title_TotalPaymentTab = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_total_payment_tab");
    public static String title_OrderTrackTab = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_order_track");
    public static String text_RegexOrderCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"text_regex_order_code");
    public static String notice_PayFee = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"notice_pay_fee");




    // App version 3.2.0.10
    public static String title_OrderInfo = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_order_info");
    public static String title_BookPort = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_book_port");
    public static String regex_BookPortCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"regex_book_port_code");
    public static String title_PaymentMethodPopup = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_payment_method_popup");
    public static String regex_CostOfService = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"regex_price_of_service");
    public static String title_TotalPrice = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_total_price");
    public static String title_DetailOrderScreen = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_detail_order_screen");
    public static String button_OrderCreation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"button_order_creation");
    public static String title_ContractCreationInProgress = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_contract_creation_in_progress");
    public static String title_OrderCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_order_code");
    public static String title_ContractCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"title_contract_code");

    public static String notification_ErrorMessageCreateOrder = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"notification_error_message_create_order");
    public static String notification_ErrorMessageZeroCost = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"notification_error_message_zero_cost");
    public static String notification_ErrorMessageWithoutTIN = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"notification_error_message_without_tin");
    public static String notification_ErrorMessageWithPayment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"notification_error_message_with_payment");

    public static List list_PaymentMethod = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_CONTRACT,"list_payment_method");
}
