package constants;

import net.fpt.utils.ReadingJsonUtil;

import java.util.List;

public class CommonNewInternetSale {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static final String DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET = System.getProperty("user.dir")
            + "/src/test/java/data_file/NewInternetSaleData.json";

    public static String input_PhoneNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"customer_phone_number");
    public static String input_ImplementUnit = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"implement_unit");
    public static String package_Max7Month = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"package_max");
    public static String button_SelectInternetDevice = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"button_select");
    public static String button_UnselectedInternetDevice = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"button_unselected");

    public static String title_OrderCreation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_order_creation");
    public static String title_ComboServices = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_combo_services");
    public static String title_ServicesList = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_services_list");
    public static String title_Implementation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_implementation");
    public static String title_Devices = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_device");
    public static String title_AddOnInternetService = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_add_on_internet_service");
    public static String title_No = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_no");
    public static String title_ExtraNetUltraFast = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_extra_net_ultrafast");
    public static String title_ExtraNetFSafe = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_extra_net_fsafe");

    public static List list_ComboName_Super80 = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"list_combo_name");
    public static List list_ServiceInfo_FirstCombo_Super80 = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"list_service_info_of_first_super80_combo");
    public static List list_ServicePackage = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"list_service_packages_internet_services");
    public static List list_GenresOfDataPackage = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"list_genres_of_data_package_internet_services");
    public static List list_InternetDevices_AddOnInternet = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"list_devices_internet_add_on_internet");
    public static List list_ServicePackages_AddOnInternet = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"list_service_packages_add_on_internet");
    public static List list_GenresOfDataPackage_AddOnInternet = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"list_genres_of_data_package_add_on_internet");

    public static String notice_NoneChooseServicePackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"notice_none_choose_service_package");
    public static String notice_NoneChooseDataPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"notice_none_choose_data_package");
    public static String notice_NoneChooseImplementUnit = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"notice_none_choose_implement_unit");
    public static String notice_NoneChooseServicePackage_AddOnInternet = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"notice_none_choose_service_package_add_on_internet");
    public static String notice_NoneChooseDataPackage_AddOnInternet = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"notice_none_choose_data_package_add_on_internet");
    public static String notice_NoneChooseImplementUnit_AddOnInternet = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"notice_none_choose_implement_unit_add_on_internet");






    public static String regex_CustomerAddress = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"regex__customer_address");
    public static String title_Services = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_service");
    public static String title_ServicePackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_service_package");
    public static String title_DataPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_data_package");
    public static String button_ShoppingCart = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"button_shopping_cart");
    public static String title_BoughtService = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_bought_service");
    public static String title_ShoppingCartScreen = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_INTERNET,"title_shopping_cart_screen");
}
