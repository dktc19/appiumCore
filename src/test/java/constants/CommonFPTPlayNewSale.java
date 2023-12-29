package constants;

import net.fpt.utils.ReadingJsonUtil;
import java.util.List;

public class CommonFPTPlayNewSale {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    public static final String DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY = System.getProperty("user.dir")
            + "/src/test/java/data_file/FPTPlayNewSaleData.json";

    public static String input_PhoneNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"customer_phone_number");
    public static String title_FPTPlayPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"fpt_play_package");
    public static String button_ConfirmFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"button_confirm_fpt_play");
    public static String dropdown_ServicePackageFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"dropdown_service_package_fpt_play");
    public static String dropdown_DataPackageFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"dropdown_data_package_fpt_play");
    public static String textBox_InputPhoneNumberFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"text_box_input_phone_number_fpt_play");

    public static String title_OrderCreation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_order_creation");
    public static String title_FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_fpt_play");
    public static String title_FPTPlayServiceScreen = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_fpt_play_service_screen");
    public static String title_FPTPlayChooseServicePackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_choose_service_package_fpt_play");
    public static String title_FPTPlayChooseDataPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_choose_data_package_fpt_play");
    public static String title_FPTPlayChooseImplementation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_implementation_fpt_play");
    public static String title_FPTPlayDeviceBox1 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_DeviceBox1");
    public static String title_FPTPlayDeviceBox2 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_DeviceBox2");
    public static String title_ExtraServiceFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_ExtraServiceFPTPlay");
    public static String title_No = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_No");
    public static String title_InputPhoneFPTPlayService = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_input_phone_fpt_play_service");
    public static String title_ServiceInformation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_service_information");
    public static String title_ServiceFPTPlayPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"title_service_fpt_play_package");

    public static List list_ServicePackageFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_service_package_fpt_play");
    public static List list_DataPackageFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_data_package_fpt_play");
    public static List list_TypeOfDeviceInDeviceBoxFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_type_of_devices_in_device_box");
    public static List list_ChooseDevicesInDeviceBoxFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_choose_devices_in_device_box");
    public static List list_ImplementationServiceInDeviceBoxFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_implement_devices_in_device_box");
    public static List list_TitleDeviceBoxFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_title_device_box");
    public static List list_DeviceStatusInDeviceBoxFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_device_status");
    public static List list_OldDevicesCollectionInDeviceBoxFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_collect_old_devices");
    public static List list_TiTleDeviceBox2FPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_title_device_box_2");
    public static List list_DeviceInDeviceBox2FPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_choose_devices_in_device_box_2");
    public static List list_ServicePackageExtraFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_service_package_extra_fpt_play");
    public static List list_DataPackageExtraFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_data_package_extra_fpt_play");
    public static List list_ImplementExtraFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_implement_extra_fpt_play");
    public static List list_TiTleExtraFPTPlay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"list_title_extra_fpt_play");

    public static String notice_NoneChooseServicePackageFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_choose_service_package_fpt_play");
    public static String notice_NoneChooseDataPackageFPTPlay =jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_choose_data_package_fpt_play");
    public static String notice_NoneChooseImplementationFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_choose_implementation_fpt_play");
    public static String notice_NoneInputPhoneNumberFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_input_phone_number_fpt_play");
    public static String notice_DeviceBoxDeletedChangeInfoChangedFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_device_box_1_2_deleted");
    public static String notice_NoneSetDeviceTypeInDeviceBox1FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_device_type_in_device_box_1");
    public static String notice_NoneSetDeviceInDeviceBox1FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_device_in_device_box_1");
    public static String notice_NoneSetDeviceStatusInDeviceBox1FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_device_status_in_device_box_1");
    public static String notice_NoneSetOldDeviceCollectionInDeviceBox1FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_old_device_collection_in_device_box_1");
    public static String notice_NoneSetImplementationUnitInDeviceBox1FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_implementation_unit_in_device_box_1");
    public static String notice_NoneSetDeviceTypeInDeviceBox2FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_device_type_in_device_box_2");
    public static String notice_NoneSetDeviceInDeviceBox2FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_device_in_device_box_2");
    public static String notice_NoneSetDeviceStatusInDeviceBox2FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_device_status_in_device_box_2");
    public static String notice_NoneSetOldDeviceCollectionInDeviceBox2FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_old_device_collection_in_device_box_2");
    public static String notice_NoneSetQuantityDeviceInDeviceBox2FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_quantity_device_in_device_box_2");
    public static String notice_NoneSetImplementationUnitInDeviceBox2FPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_implementation_unit_in_device_box_2");
    public static String notice_NoneSetServicePackageExtraFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_service_package_extra_fpt_play");
    public static String notice_NoneSetDataPackageExtraFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_data_package_extra_fpt_play");
    public static String notice_NoneSetQuantityPackageExtraFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_quantity_package_extra_fpt_play");
    public static String notice_NoneSetImplementExtraFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_none_set_implement_extra_fpt_play");
    public static String notice_SetOverLimitDevicesOnMaxPackageFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_max_package_choose_over_3_devices");
    public static String notice_SetBox2WithoutBox1 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_set_box2_without_box_1");
    public static String notice_SetOverLimitDevicesOnVipPackageFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_vip_package_choose_over_5_devices");
    public static String notice_ExtraBoxGreaterThanDeviceBoxFPTPlay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_extra_box_greater_device_box");
    public static String notice_SetExtraPackageWithoutFPTPlayPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_NEW_SALE_FPT_PLAY,"notice_set_extra_package_without_fpt_play_package");

}
