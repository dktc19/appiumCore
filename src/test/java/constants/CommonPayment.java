package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.List;


public class CommonPayment {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static final String DATA_TEST_FILE_PATH_COMMON_PAYMENT = System.getProperty("user.dir")
            + "/src/test/java/data_file/PaymentData.json";

    public static String title_ImplementProgressAtHomePage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_implement_progress");
    public static String title_ScanQRCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_scan_qr_code");

    public static String text_PaymentType = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"text_payment_type");
    public static String text_PaymentStatus = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"text_payment_status");
    public static String text_FPTPlayPrice = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"text_fpt_play_price");
    public static String text_BillPaid = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"text_bill_paid");
    public static String text_QRCodePayment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"text_qr_code_payment");

    public static String tab_CustomerInformation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"tab_customer_information");
    public static String tab_Bill = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"tab_bill");
    public static String tab_OrderTracking = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"tab_order_tracking");

    public static List list_ContractInformationBlock = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"list_contract_information_block");
    public static List list_BillInformationBlock = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"list_bill_information_block");
    public static List list_OrderInformationQRCodePaymentScreen = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"list_order_information");

    public static String notice_CheckingForPayment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"notice_checking_for_payment");
    public static String notice_NoneReceivePayment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"notice_none_receive_payment");







    // Version 3.2.0.10
    public static String title_ContractInformation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_contract_information");
    public static String title_OrderInformation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_order_information");
    public static String title_Payment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_payment");
    public static String notice_PaymentSuccessCOD = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"notice_payment_cod_success");
    public static String notice_DetailPaymentSuccessFul = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"notice_detail_payment_successful");
    public static String title_PaymentProgressRunning = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_payment_progress");
    public static String title_DetailOrder = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_detail_order");
    public static String title_ReturnHomePage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"title_return_homepage");
    public static String regex_ContractCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_PAYMENT,"regex_contract_code");
}
