package constants;

import net.fpt.utils.ReadingJsonUtil;
import java.util.List;


public class CommonTotalPayment {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static final String DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT = System.getProperty("user.dir")
            + "/src/test/java/data_file/TotalPaymentData.json";

    public static String title_PaymentMethod = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_payment_method");
    public static String title_PaymentMethodPopup = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_payment_method_popup");
    public static String title_ChosenServiceDetail = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_chosen_service_detail");
    public static String title_PriceCommandList = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_price_command_list");
    public static String title_DetailPriceCommand = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_detail_price_command");
    public static String title_MonthlyServicePaymentMethod = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_monthly_service_fee_payment_method");
    public static String title_MonthlyServicePaymentMethodPopup = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_monthly_service_fee_payment_method_popup");
    public static String title_VoucherPopup = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_voucher_popup");
    public static String title_InputVoucher = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"title_input_voucher");
    public static String button_CreateOrder = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"button_create_order");

    public static String text_RegexPrice = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"text_regex_price");
    public static String text_PriceSuper80 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"text_price");
    public static String text_VoucherHint = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"text_voucher_hint");
    public static String text_VoucherExist = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"text_voucher_exist");
    public static String text_VoucherNoneExist = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"text_voucher_none_exist");

    public static List list_PaymentMethod = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"list_payment_method");
    public static List list_PriceCommandSuper80 = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"list_price_command_ftth_super80");
    public static List list_MonthlyServicePaymentMethod = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"list_monthly_service_payment_method");

    public static String notice_InfoUsedBefore = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"notice_id_card_used_before");
    public static String notice_NoneExistVoucher = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_TOTAL_PAYMENT,"notice_none_exist_voucher");
}
