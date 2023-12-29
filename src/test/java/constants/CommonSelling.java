package constants;

import java.util.ArrayList;
import java.util.List;
import net.fpt.utils.ReadingJsonUtil;

public final class CommonSelling {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    // Selling Screen
    public static final String DATA_TEST_FILE_PATH_COMMON_SELLING = System.getProperty("user.dir")
            + "/src/test/java/data_file/SellingData.json";
    public static String textBox_IdCardNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_id_number");
    public static String textBox_IdPublishedPlace = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_id_published_place");
    public static String textBox_AddressOnIDCard = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_address_on_id_card");
    public static String textBox_EstablishedDate = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_established_date");
    public static String textBox_AddressOnBusinessAllowance = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_address_on_business_allowance");
    public static String textBox_OrganizePhone = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_organize_phone");
    public static String title_BankAccount = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_bank_account");
    public static String textBox_BankAccount = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_bank_account");
    public static String title_Representative = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_representative");
    public static String title_BirthdayInRepresentativeField = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_birthday_in_representative_field");
    public static String title_IdCardInRepresentativeField = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_id_card_in_representative_field");
    public static String title_SpecialCustomer = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_special_customer");
    public static String title_type = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "type");
    public static String title_customer_type = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "customer_type");
    public static String title_name = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "name");
    public static String title_birthday = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "title_birthday");
    public static String title_id = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "id");
    public static String title_date_of_issue = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "title_date_of_issue");
    public static String title_place_of_issue = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "title_place_of_issue");
    public static String title_gender = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "gender");
    public static String title_address_on_id = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "address_on_id");
    public static String title_MarketingChannel = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"marketing_channel");
    public static String title_district = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "district");
    public static String title_ward = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "ward");
    public static String title_street = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "street");
    public static String title_type_of_house = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "type_of_house");
    public static String title_AddPassportImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"add_passport_image");
    public static String title_AddOtherPaper = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"add_other_paper");
    public static String title_AddIDCardImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"add_id_card_image");
    public static String title_AddFileImages = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_add_file_images");
    public static String title_AddPassportImages = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_passport_images");
    public static String title_AddressInvoice = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_address_invoice");
    public static String title_AddressFeeAtHome = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_address_fee_at_home");
    public static String title_ImplementProcess = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_implement_process");
    public static String title_AddressNote = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_address_note");
    public static String title_ImplementNote = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_implement_note");
    public static String textBox_BlockNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_block_number");
    public static String textBox_FloorNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_floor_number");
    public static String textBox_RoomNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_room_number");
    public static String textBox_AddressNote = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_address_note");
    public static String textBox_ImplementNote = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_implement_note");
    public static String textBox_HouseAddress = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_house_number");
    public static String title_SetupLocation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_set_up_location");
    public static String dropDown_ApartmentSelection = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_apartment_selection");
    public static String title_AddressOnReceipt = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_address_on_receipt");
    public static String title_HousePointer = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_house_pointer");
    public static String title_AddressToCollectFee = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_address_to_collect_fee");
    public static String button_AddFrontImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_front_image");
    public static String button_AddBehindImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_behind_image");
    public static String title_OtherISPFileImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_other_isp_file_image");

    public static String selector_district = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"setup_district");
    public static String selector_ward = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"setup_ward");
    public static String selector_street = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"setup_street");
    public static String selector_houseType = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"setup_house_type");
    public static String selector_houseNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"setup_house_number");

    public static List list_InfoUpdateFromChangeID = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_id_card_update");
    public static List list_Birthday = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"birthday");
    public static List list_idIssueDate = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"id_issue_date");
    public static List list_titleOrganizeType = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_title_organize_type");
    public static List list_optionCustomerType = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_option_customer_type");
    public static List list_EstablishedDate = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"established_date");
    public static List list_SpecialCustomer = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"special_customer");
    public static List list_HouseTypes = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING, "house_types");
    public static List list_HousePointer = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"option_house_pointer");
    public static List list_TitleOptionsOfApartment = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_options_of_apartment");
    public static List list_InfoApartment = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"info_apartment");
    public static List list_InfoSetUpAddress = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"info_setup_address");
    public static List list_InfoSetUpAddressAlternative = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"info_setup_address_alternative");
    public static List list_InfoSetUpApartment = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"info_setup_apartment");
    public static List list_TabInAddImages = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_tab_add_images");

    public static String selector_usedTypePersonal = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"used_type_personal");
    public static String selector_usedTypeOrganize = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"used_type_organize");
    public static String selector_customerTypeFamily = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"customer_type_family");
    public static String selector_customerTypeStudent = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"customer_type_student");
    public static String selector_customerTypeStranger = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"customer_type_stranger");
    public static String selector_MarketingChannel = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"selector_marketing_channel");
    public static String selector_MarketingChannelD2D = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"marketing_channel_D2D");
    public static String selector_MarketingChannelOnline = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"marketing_channel_online");

    public static String input_SpecialCharacter = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"special_character");
    public static String input_AreaCodePhoneNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"area_code_phone_number");
    public static String input_OrganizeName = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"organize_name");
    public static String input_taxCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"tax_code");
    public static String input_PlaceIssueTaxCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"place_of_issue_tax");
    public static String input_AddressOnBusinessAllowance = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"address_on_business_allowance");
    public static String input_EmailAddress = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"email_address");
    public static String input_AccountNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"account_number");
    public static String input_BankName = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"bank_name");
    public static String input_TestText = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text");
    public static String input_ContentOfAddressOnReceipt = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"address_on_receipt_content");
    public static String input_ContentOfAddressToCollectFee = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"address_to_collect_fee");
    public static String input_Name = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"input_name_id_card");

    public static String notice_OtherISP = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"other_isp_notice");
    public static String notice_AddIDCardError = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notice_add_id_error");
    public static String notice_ConfirmToUpdateInfoFromImages = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notice_update_id_follow_image");
    public static String notice_AddPassportImages = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notice_passport_images");
    public static String notice_UpdateFromChangeImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notice_update_from_change_image");
    public static String notice_ChangeVerifiedImagesToOther = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notice_change_verified_images_to_other");
    public static String notice_InsufficientImageSupply = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notice_insufficient_image_supply");
    public static String notice_InsufficientInfoSupply = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notice_insufficient_info_supply");




    // App version 3.2.0.10
    public static String option_sellingGoods = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"selling_goods_option");
    public static String title_AllServicesScreen = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_AllServicesScreen");
    public static String title_Order = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_order");
    public static String title_All = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_all");
    public static String textBox_SearchContract = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_search_contract");
    public static String text_PaidContract = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_paid_contract");
    public static String title_AddressInfo = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_AddressInfo");
    public static String textBox_AddressSearching = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"textBox_AddressSearching");
    public static String button_Searching = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_Searching");
    public static String title_AddressSearchScreen = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_AddressSearchScreen");
    public static String title_OtherProduct = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_OtherProduct");
    public static String title_Internet = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_Internet");
    public static String title_CreateOther = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_create_order");
    public static String title_ServiceInfo = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_service_info");
    public static String dropdown_GenderDefault = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_gender_default");
    public static String textBox_PhoneNumber = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_phone_number");
    public static String input_Phone = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"phone_number");
    public static String title_customerInformation = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING, "title_customer_info");
    public static String title_CusType = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_cus_type");
    public static String dropdown_AddressDefault = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_address_default");
    public static String button_ViewAll = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_view_all");
    public static String title_SuggestCombo = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_suggest_combo");
    public static String title_SuggestPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_suggest_package");
    public static String text_Address = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_address");
    public static String title_Detail = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_detail");
    public static String dropdown_ServicePackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_service_package");
    public static String dropdown_DataPackage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_data_package");
    public static String title_BuyMoreServiceScreen = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_buy_more_services");
    public static String text_Address2 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_address_2");
    public static String button_ChangeIDImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_change_id_image");
    public static String button_AllowOfNotification = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_allow_of_notification");
    public static String textBox_InputOrganizeName = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_input_organize_name");
    public static String textBox_TaxCode = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_tax_code");
    public static String textBox_DateIssue = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_date_issue");
    public static String textBox_PlaceIssue = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_place_issue");
    public static String textBox_DateOfPublish = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_date_of_publish");
    public static String title_AddressBusinessAllowance = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_address_on_business_allowance");
    public static String title_OrganizePhone = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_organize_phone");
    public static String title_Mail = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_mail");
    public static String textBox_InputPhone = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_input_phone");
    public static String textBox_InputName = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_name_input");
    public static String text_DeviceName = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_device_name");
    public static String title_ListPriceCommand = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_list_price_command");
    public static String text_PriceCommand = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_price_command");
    public static String button_PriceCommand = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_select_price_command");
    public static String title_ResultAfterPriceCommandSelected = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_result_after_price_command_selected");
    public static String textBox_Mail = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_field_mail");
    public static String title_MonthlyPaymentWayDropdown = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_monthly_payment_way_dropdown");
    public static String text_NoneMonthlyPaymentWay = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_none_monthly_payment_way");
    public static String dropdown_DeviceType = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_device_type");
    public static String title_DeviceType = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_device_type");
    public static String dropdown_Device = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_device");
    public static String title_Device = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_device");
    public static String texBox_DeviceQuantity = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_box_quantity_device");
    public static String option_CashPayment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"option_cash_payment");
    public static String option_CODCashPayment = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"option_cod_cash_payment");
    public static String title_PaymentMethod = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_payment_method");
    public static String text_DeviceSmartHome = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_device_smart_home");
    public static String text_DeviceSmartHomeZeroCost = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_device_smart_home_zero_cost");
    public static String text_DeviceSmartHomeWithoutTIN = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_device_smart_home_without_tin");
    public static String text_SmartHomeDeviceQuantity = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"text_smart_home_device_quantity");
    public static String dropdown_ImplementationUnit = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"dropdown_implementation_unit");
    public static String option_TINAndPNC = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"option_tin_pnc");
    public static String title_SmartHome = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_smart_home");
    public static String title_Unpaid = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_unpaid");
    public static String title_OrderTracking = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_order_tracking");
    public static String title_CompletedContract = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_completed_contract");
    public static String title_OrderDetailScreen = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_detail_order");
    public static String title_ImplementationProgress = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_implementation_progress");
    public static String title_SupplyIDCard = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"title_supply_id_card");
    public static String button_AddFileImage = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"button_add_file_image");

    public static String notification_InsufficientCusInfo = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notification_insufficient_cus_info");
    public static String notification_PrivateInfoUsedBefore = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notification_private_info_used_before");
    public static String notification_CODHasBeenExisted = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notification_cod_has_been_existed");
    public static String notification_PaymentSucceed = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notification_payment_succeed");
    public static String notification_NavigateToFPTPaymentGateway = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notification_navigation_to_fpt_payment_gateway");
    public static String notification_PaymentProcessReload = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notification_payment_process_reload");
    public static String notification_UncompletedOrder = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_SELLING,"notification_uncompleted_order");

    public static List list_GenderOption = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_gender_option");
    public static List list_InfoFromID = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"info_id_card");
    public static List list_InfoFromID2 = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"info_id_card_2");
    public static List list_ExtraServiceInternet = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_extra_service");
    public static List list_CusType = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_cus_type");
    public static List list_CusTypeOrganization = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_cus_type_organization");
    public static List list_CusTypeIndividual = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_cus_type_individual");
    public static List list_CusTypeSpecial= jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_cus_type_special");
    public static List list_PackageService = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_package_service");
    public static List list_PackageService2= jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_package_service_2");
    public static List list_Package = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_package");
    public static List list_Address = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_address");
    public static List list_Address2 = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_address_2");
    public static List list_PaymentInfoField = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_payment_info_field");
    public static List list_RequestedTitlePrivateCus = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_requested_title_private_cus");
    public static List list_WayOfPaymentMonthly = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_way_of_payment_monthly");
    public static List list_ServiceOfOtherProduct = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_service_of_other_product");
    public static List list_PaymentWay = jsonUtil.docFileJSON(DATA_TEST_FILE_PATH_COMMON_SELLING,"list_payment_method");
}
