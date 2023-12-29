package page_objects.goodsSelling;

import com.lazerycode.selenium.util.Query;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

public class ElementsGoodsSelling extends BasePageObject {
    public FlutterFinder find;

    ElementsGoodsSelling() {
        find = new FlutterFinder(driver);
        this.title_goodsSelling = find.text("Bán hàng");
        this.textfield_inputPhone = find.text("Số điện thoại Giao dịch, liên hệ * (Nhận SMS)\\nNhập số điện thoại");
        this.title_CustomerInfo = find.text("Thông tin khách hàng");
        this.button_Continue = find.text("Tiếp tục");
        this.textfield_birthday = find.text("Chọn ngày sinh");
        this.button_Reject = find.text("Hủy");
        this.option_typePersonal = find.text("Cá nhân");
        this.option_typeOrganize = find.text("Tổ chức");
        this.option_cusTypeFamily = find.text("Gia đình/Hộ gia đình");
        this.option_cusTypeStudent = find.text("Học sinh, sinh viên");
        this.option_cusTypeStranger = find.text("KH nước ngoài");
        this.textfield_Name = find.text("Nhập họ tên đầy đủ");
        this.textfield_IdCard = find.text("Nhập số CMND/CCCD/Hộ chiếu");
        this.option_DateofIssue = find.text("Chọn ngày cấp");
        this.textfield_PlaceofIssue = find.text("Nhập nơi cấp");
        this.textfield_AddressOnIDCard = find.text("Nhập địa chỉ trên CMND/CCCD/Hộ chiếu");
        this.textfield_PhoneNumber = find.text("Nhập số điện thoại");

        this.selector_Camera = find.text("Camera");
        this.button_used = find.text("Sử dụng");
        this.button_RetakePhoto = find.text("Chụp lại");
        this.textfield_HouseNumber = find.text("Nhập số nhà");
        this.selector_CustomerType = find.text("Lựa chọn loại khách hàng");
        this.textfield_inputOrganizeName = find.text("Nhập tên tổ chức/doanh nghiệp");
        this.textfield_TaxCode = find.text("Nhập số giấy tờ");
        this.option_chooseEstablishedDate = find.text("Chọn ngày thành lập");
        this.title_EstablishedDate = find.text("Ngày thành lập *");
        this.title_AddressOnBusinessAllowance = find.text("Địa chỉ trên GPKD *");
        this.textfield_AddressOnBusinessAllowance = find.text("Nhập địa chỉ trên giấy phép ĐKKD");
        this.title_InputMail = find.text("Email");
        this.textfield_InputMail = find.text("Nhập địa chỉ email");
        this.title_OrganizePhone = find.text("Số điện thoại tổ chức/doanh nghiệp *");
        this.textfield_OrganizePhone = find.text("Nhập số điện thoại tổ chức/doanh nghiệp");
        this.option_MarketingChannel = find.text("Lựa chọn kênh tiếp thị");
        this.title_BankAccount = find.text("Tài khoản ngân hàng");
        this.textfield_AccountNumber = find.text("Nhập số tài khoản");
        this.textfield_BankName = find.text("Nhập tên ngân hàng");
        this.title_Representative = find.text("Người đại diện");
        this.title_BirthdayInRepresentativeField = find.text("Ngày sinh");
        this.title_IDCardInRepresentativeField = find.text("Số CMND/CCCD/Hộ chiếu");
        this.title_DateOfIssueInRepresentativeField = find.text("Ngày cấp");
        this.title_SpecialCustomer = find.text("Khách hàng đặc biệt");
        this.title_StaffCode = find.text("Mã nhân viên *");
        this.textfield_StaffCode = find.text("Nhập mã nhân viên");
        this.title_SubCompany = find.text("Công ty thành viên *");
        this.textfield_SubCompany = find.text("Nhập tên công ty thành viên");
        this.title_IDCardImage = find.text("Ảnh CMND/CCCD *");
        this.title_AdditionalFilesImage = find.text("Ảnh hồ sơ bổ sung");
        this.title_OtherISPFileImage = find.text("Ảnh hồ sơ ISP khác *");
        this.button_AddOtherISPFileImage = find.text("Thêm ảnh hồ sơ ISP khác (Tối đa 3 ảnh)");
        this.selector_OtherContactInfo = find.text("Thông tin người liên hệ khác (nếu có)");
        this.title_NameWithoutAsterick = find.text("Họ tên");
        this.title_Phone = find.text("Số điện thoại");
        this.title_AddressNote = find.text("Ghi chú địa chỉ");
        this.textfield_AddressNote = find.text("Nhập nội dung ghi chú về địa chỉ");
        this.title_ImplementNote = find.text("Ghi chú triển khai");
        this.textfield_ImplementNote = find.text("Nhập nội dung ghi chú về triển khai");
        this.title_AddressOnReceipt = find.text("Địa chỉ trên hóa đơn");
        this.title_AddressToCollectFee = find.text("Địa chỉ thu cước");
        this.button_BuyServices = find.text("Mua dịch vụ");
        this.button_Yes = find.text("Có");
        this.button_No = find.text("Không");
        this.button_AddPassportImage = find.text("Thêm ảnh hộ chiếu");
        this.title_OtherImages = find.text("Ảnh giấy tờ khác *");
        this.button_OtherImages = find.text("Thêm ảnh giấy tờ (Tối đa 5 ảnh)");
        this.title_SetUpLocation = find.text("Địa chỉ lắp đặt");
        this.radioButton_Male = find.byValueKey("rdoMale");
        this.radioButton_Female = find.byValueKey("rdoFemale");
        this.title_HousePointer = find.text("Vị trí nhà *");
        this.title_HouseNumber = find.text("Số nhà *");
        this.dropList_HousePointer = find.text("Lựa chọn vị trí nhà");
        this.title_NameOfApartment = find.text("Tên chung cư");
        this.dropList_NameOfApartment = find.text("Lựa chọn chung cư");
        this.textfield_BlockNumber = find.text("Nhập số lô");
        this.textfield_FloorNumber = find.text("Nhập số tầng");
        this.textfield_RoomNumber = find.text("Nhập số phòng");
        this.dropList_District = find.byValueKey("dptDistrict");
        this.dropList_Ward = find.byValueKey("dptWard");
        this.dropList_Street = find.byValueKey("dptStress");
        this.dropList_HouseType = find.byValueKey("dptHouseType");
        this.button_EditAddressInvoice = find.byValueKey("btnEditAddressInvoice");
        this.button_EditAddressFeesAtHome = find.byValueKey("btnEditAddressFeesAtHome");
        this.button_Save = find.text("Lưu");
        this.button_Choice = find.text("Lựa chọn");
        this.point_AddIDCardImages = new Point(545,700);



        // Version 3.2.0.10
        this.button_AllServices = find.byValueKey("lgAllServices");
        this.button_createNew = find.text("Bán mới");
        this.button_Confirm = find.text("Xác nhận");
        this.button_AddressSearching = find.byValueKey("btnSearch");
        this.button_ConfirmAndSave = find.text("Xác nhận & Lưu");
        this.button_UpdateInfo = find.text("Cập nhật");
        this.button_ChangeImage = find.text("Thay đổi ảnh");
        this.button_AddExtraService = find.byValueKey("btnAddExtra");
        this.button_EraseExtraService = find.byValueKey("btnEraseExtra");
        this.dropdown_CusType = find.byValueKey("dlCusType");
        this.button_AddMoreService = find.byValueKey("btnAddMoreServices");
        this.button_EraseServicePackage = find.byValueKey("btnErasePackage");
        this.button_Detail = find.text("Chi tiết");
        this.button_addIdCardImage = find.text("Thêm ảnh");
        this.button_addFrontImage = find.text("Ảnh mặt trước");
        this.button_addBehindImage = find.text("Ảnh mặt sau");
        this.selector_imageGallery = find.text("Thư viện ảnh");
        this.button_AddFileImage = find.text("Thêm ảnh hồ sơ (Tối đa 5 ảnh)");
        this.button_EditPackage = find.byValueKey("btnEditPackage");
        this.button_Order = find.text("Đơn hàng");
        this.button_All = find.text("Tất cả");

        this.point_SuggestComboInternet1T = new Point(220,1300);
        this.point_IconXPaymentMethod = new Point(140,760);
        this.point_BackIcon = new Point(90,155);
        this.point_BtnSearch = new Point(990,330);
        this.point_BtnAddExtra = new Point(1004,673);
        this.point_BtnEraseExtra = new Point(1004,795);
        this.point_BtnAddMoreServices = new Point(985,160);
        this.point_BtnErasePackage = new Point(1018,470);
        this.point_BtnMoreOptions = new Point(1015,150);
        this.point_OptionAddress = new Point(550,500);
        this.point_IconAddress = new Point(550,1750);
        this.point_DropdownCusType = new Point(545,595);
        this.point_BtnAllowNotificationsPermission = new Point(920,1305);
        this.point_BtnBackInSystem = new Point(76,152);
        this.point_alarmAllowAccess = new Point(540,1080);
        this.point_BtnNotification = new Point(205,1390);
        this.point_GenderMale = new Point(500,1555);
        this.point_GenderFemale = new Point(535,1555);
        this.point_ComboSuper80 = new Point(710,1020);
        this.point_OptionalSuper80 = new Point(200,1250);
        this.point_OptionPriceCommand = new Point(890,1274);
        this.point_ServicePackage = new Point(440,560);
        this.point_DropdownInternetPackage = new Point(245,540);
        this.point_BtnAddFileImage = new Point(530,650);
        this.point_Image = new Point(216,626);
        this.point_Download = new Point(333,495);
    }

    /**
     * Dynamic flutter finder following text
     *
     * @param str
     * */
    public MobileElement dynamic_finder(String str) {
        find = new FlutterFinder(driver);
        return find.text(str);
    }

    /**
     * Locator in Selling Page
     * */
    public MobileElement title_goodsSelling;

    public MobileElement textfield_inputPhone;
    public MobileElement textfield_birthday;

    /**
     * Locator in Create Order
     */
    public MobileElement title_CustomerInfo;
    public MobileElement button_Continue; // Nút có chữ xác nhận
    public MobileElement option_typePersonal; // Loại hình cá nhân
    public MobileElement option_typeOrganize; // Loại hình tổ chức
    public MobileElement option_cusTypeFamily; // Loại khách hàng hộ gia dình
    public MobileElement option_cusTypeStudent; // Loại khách hàng học sinh
    public MobileElement option_cusTypeStranger; // Loại khách hàng KH nước ngoài
    public MobileElement textfield_Name; // Ô nhập tên
    public MobileElement textfield_IdCard; // Ô nhập cmnd
    public MobileElement option_DateofIssue; // Ô chọn ngày cấp CMND/CCCD
    public MobileElement textfield_PlaceofIssue; // Ô nhập nơi cấp CMND/CCCD
    public MobileElement textfield_AddressOnIDCard; // Ô nhập địa chỉ trên chứng minh
    public MobileElement textfield_PhoneNumber; // Ô nhập sdt
    public MobileElement button_addIdCardImage;
    public MobileElement button_addFrontImage;
    public MobileElement button_addBehindImage;
    public MobileElement selector_imageGallery;
    public MobileElement selector_Camera;
    public MobileElement button_used;
    public MobileElement button_RetakePhoto;
    public MobileElement textfield_HouseNumber; // Ô nhập số nhà
    public Point point_ButtonClosePopup = new Point(127,1716);
    public MobileElement selector_CustomerType;
    public MobileElement textfield_inputOrganizeName;
    public MobileElement textfield_TaxCode;
    public MobileElement option_chooseEstablishedDate;
    public MobileElement title_EstablishedDate;
    public MobileElement title_AddressOnBusinessAllowance;
    public MobileElement textfield_AddressOnBusinessAllowance;
    public MobileElement title_InputMail;
    public MobileElement textfield_InputMail;
    public MobileElement title_OrganizePhone;
    public MobileElement textfield_OrganizePhone;
    public MobileElement option_MarketingChannel;
    public MobileElement title_BankAccount;
    public MobileElement textfield_AccountNumber;
    public MobileElement textfield_BankName;
    public MobileElement title_Representative;
    public MobileElement title_BirthdayInRepresentativeField;
    public MobileElement title_IDCardInRepresentativeField;
    public MobileElement title_DateOfIssueInRepresentativeField;
    public MobileElement title_SpecialCustomer;
    public Point point_IconXSpecialCustomer = new Point(124,775);
    public MobileElement title_StaffCode;
    public MobileElement textfield_StaffCode;
    public MobileElement title_SubCompany;
    public MobileElement textfield_SubCompany;
    public MobileElement title_IDCardImage;
    public MobileElement title_AdditionalFilesImage;

    public MobileElement title_OtherISPFileImage;
    public MobileElement button_AddOtherISPFileImage;
    public Point point_PageBack = new Point(77,124);
    public MobileElement selector_OtherContactInfo;
    public MobileElement title_NameWithoutAsterick;
    public MobileElement title_Phone;
    public MobileElement title_AddressNote;
    public MobileElement textfield_AddressNote;
    public MobileElement title_ImplementNote;
    public MobileElement textfield_ImplementNote;
    public MobileElement title_AddressOnReceipt;
    public MobileElement title_AddressToCollectFee;
    public MobileElement button_BuyServices;
    public Point point_ID = new Point(218,312);
    public Point point_Passport = new Point(518,312);
    public Point point_OtherPaper = new Point(870,312);
    public Point point_iconXAddImage = new Point(124,1678);
    public Point point_iconXDeleteChosenImage = new Point(456,666);
    public Point point_iconXDeleteSecondChosenImage = new Point(951,666); //Nút xóa ảnh mặt sau CCCD
    public Point point_AddImageButtonOfAdditionalFiles = new Point(937,983);
    public Point point_AddImageButtonOfOtherISP = new Point(937,1426);
    public Point point_AddImageButtonOfOtherFile = new Point(937,450);  // Nút thêm ảnh - tab giấy tờ khác
    public Point point_iconXDeleteChosenImageOfOtherISP = new Point(441,1537);  // tab CMND/CCCD
    public Point point_iconXDeleteChosenAdditionalFileImage = new Point(435,1100);
    public Point point_iconXDeleteChosenImageOfOtherISP_PassportTab = new Point(438,1552);
    public Point point_iconXDeleteChosenImageOfOtherISP_OtherPaper = new Point(438,1112);
    public Point point_iconXDeleteChosenPassportImages = new Point (682,681);
    public Point point_iconXDeleteChosenAdditionalFileImage_OtherPaperTab = new Point(456,666);  // Xóa ảnh hồ sơ khác - tab giấy tờ khác
    public Point point_AddImageButtonOfOtherISP_OtherFilesTab = new Point(937,1000);
    public MobileElement button_Yes;
    public MobileElement button_No;
    public MobileElement button_AddPassportImage;
    public MobileElement title_OtherImages;
    public MobileElement button_OtherImages;
    public MobileElement button_Reject;
    public MobileElement title_SetUpLocation;
    public MobileElement radioButton_Male;
    public MobileElement radioButton_Female;
    public MobileElement dropList_HouseType;
    public MobileElement title_HousePointer;
    public MobileElement title_HouseNumber;
    public MobileElement dropList_HousePointer;
    public MobileElement title_NameOfApartment;
    public MobileElement dropList_NameOfApartment;
    public MobileElement textfield_BlockNumber;
    public MobileElement textfield_FloorNumber;
    public MobileElement textfield_RoomNumber;
    public MobileElement dropList_District;
    public MobileElement dropList_Ward;
    public MobileElement dropList_Street;
    public MobileElement button_EditAddressInvoice;
    public MobileElement button_EditAddressFeesAtHome;
    public Point point_iconXReturnFromAddressInvoice = new Point(86,124);
    public MobileElement button_Save;
    public MobileElement button_Choice;
    public Point point_AddIDCardImages;

    /**
     * Locator in gallery when add images of ID card (Native element)
     * */
    public Query button_searchBox = new Query().defaultLocator(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]")).usingDriver(driver);
    public Query textBox_searchBox = new Query().defaultLocator(By.id("com.google.android.documentsui:id/search_src_text")).usingDriver(driver);
    public Query button_Root = new Query().defaultLocator(By.xpath("//android.widget.ImageButton[@content-desc=\"Show roots\"]")).usingDriver(driver);
    public Query selector_VirtualPhoneMemory = new Query().defaultLocator(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView")).usingDriver(driver);
    public Query selector_Download = new Query().defaultLocator(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]")).usingDriver(driver);
    public Query title_Folder = new Query().defaultLocator(By.xpath("//android.widget.TextView[@text=\"sdk_gphone64_x86_64\"]")).usingDriver(driver);


    /**
     * App version 3.2.0.10
     * */
    public MobileElement button_AllServices;
    public MobileElement button_createNew;
    public MobileElement button_Confirm;
    public MobileElement button_AddressSearching;
    public MobileElement button_ConfirmAndSave;
    public MobileElement button_UpdateInfo;
    public MobileElement button_ChangeImage;
    public MobileElement button_AddExtraService;
    public MobileElement button_EraseExtraService;
    public MobileElement dropdown_CusType;
    public MobileElement button_AddMoreService;
    public MobileElement button_Detail;
    public MobileElement button_EraseServicePackage;
    public MobileElement button_AddFileImage;
    public MobileElement button_EditPackage;
    public MobileElement button_Order;
    public MobileElement button_All;

    public Point point_SuggestComboInternet1T; //Device Nexus 5
    public Point point_IconXPaymentMethod;
    public Point point_BackIcon;
    public Point point_BtnSearch;
    public Point point_BtnAddExtra;
    public Point point_BtnEraseExtra;
    public Point point_BtnAddMoreServices;
    public Point point_BtnErasePackage;
    public Point point_BtnMoreOptions;
    public Point point_OptionAddress;
    public Point point_IconAddress;
    public Point point_DropdownCusType;
    public Point point_BtnAllowNotificationsPermission;
    public Point point_BtnBackInSystem;
    public Point point_alarmAllowAccess;
    public Point point_BtnNotification;
    public Point point_GenderMale;
    public Point point_GenderFemale;
    public Point point_ComboSuper80;
    public Point point_OptionalSuper80;
    public Point point_OptionPriceCommand;
    public Point point_ServicePackage;
    public Point point_DropdownInternetPackage;
    public Point point_BtnAddFileImage;
    public Point point_Image;
    public Point point_Download;
}
