package page_objects.FPTPlayNewSale;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Point;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

public class ElementsFPTPlayNewSale extends BasePageObject {
    public FlutterFinder find;

    ElementsFPTPlayNewSale() {
        find = new FlutterFinder(driver);

        this.button_Continue = find.text("Tiếp tục");
        this.button_Confirm = find.text("Xác nhận");
        this.button_BuyServices = find.text("Mua dịch vụ");
        this.dropList_ChooseServicePackage = find.text("Lựa chọn gói dịch vụ");
        this.dropList_ChooseImplement = find.text("Lựa chọn triển khai");
        this.dropList_ChooseDataPackage = find.text("Lựa chọn");
        this.textfield_PhoneNumber = find.text("Nhập số điện thoại");
        this.button_Add = find.text("Thêm");
        this.button_Reject = find.text("Hủy");
        this.button_Edit = find.text("Sửa");
        this.button_Delete = find.text("Xóa");
        this.field_OrderCode = find.byValueKey("txtOrderID");
        this.field_ContractCode = find.byValueKey("txtContractID");
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
     * Locators gotten from MobileElement
     * */
    public MobileElement button_Continue;
    public MobileElement button_Confirm;
    public MobileElement button_BuyServices;
    public MobileElement button_Add;
    public MobileElement button_Reject;
    public MobileElement button_Edit;
    public MobileElement button_Delete;

    public MobileElement dropList_ChooseServicePackage;
    public MobileElement dropList_ChooseDataPackage;
    public MobileElement dropList_ChooseImplement;

    public MobileElement textfield_PhoneNumber;

    public MobileElement field_OrderCode;
    public MobileElement field_ContractCode;

    /**
     * Locators gotten from Point
     * */
    public Point point_FPTPlayPackage = new Point(406,391);
    public Point point_ButtonConfirmBuyService = new Point(800,2000);
    public Point point_AddServiceForFPTPlayPackage = new Point(981,754);
    public Point point_ButtonAddDeviceBox1 = new Point(1022,1065);
    public Point point_ButtonAddDeviceBox2 = new Point(1022,1220);
    public Point point_ButtonAddExtraFPTPlay = new Point(1022,1379);
    public Point point_ButtonAddMoreInfo = new Point(1022,1540);
    public Point point_ButtonPageBack = new Point(86,127);
    public Point point_ButtonXServicePackageFPTPlay = new Point(127,1440);
    public Point point_ButtonXDataPackageFPTPlay_iZi = new Point(124,1587);
    public Point point_DropListDeviceTypeFPTPlay = new Point(289,353);
    public Point point_DropListChooseDeviceFPTPlay = new Point(289,550);
    public Point point_DropListDeviceStatusFPTPlay = new Point(289,745);
    public Point point_DropListOldDeviceCollectionFPTPlay = new Point(289,942);
    public Point point_DropListImplementFPTPlay = new Point(289,1140);
    public Point point_TextFieldPhoneNumberFPTPlayService = new Point(400,1730);
    public Point point_DropListServicePackageFPTPlayService = new Point(400,475);
    public Point point_DropListDataPackageFPTPlayService = new Point(400,675);
    public Point point_DropListImplementFPTPlayService = new Point(400,875);
    public Point point_DropListDeviceTypeDeviceBox2FPTPlay = new Point(289,353);
    public Point point_DropListChooseDeviceDeviceBox2FPTPlay = new Point(289,550);
    public Point point_DropListDeviceStatusDeviceBox2FPTPlay = new Point(289,745);
    public Point point_DropListOldDeviceCollectionDeviceBox2FPTPlay = new Point(289,942);
    public Point point_ButtonIncreaseQuantityDeviceBox2FPTPlay = new Point(1022,1144);
    public Point point_ButtonDecreaseQuantityDeviceBox2FPTPlay = new Point(850,1144);
    public Point point_DropListImplementDeviceBox2FPTPlay = new Point(289,1325);
    public Point point_DropListServicePackageExtraFPTPlay = new Point(250,345);
    public Point point_DropListDataPackageExtraFPTPlay = new Point(250,545);
    public Point point_ButtonIncreaseQuantityExtraFPTPlay = new Point(1022,750);
    public Point point_ButtonDecreaseQuantityExtraFPTPlay = new Point(855,750);
    public Point point_DropListImplementInfoExtraFPTPlay = new Point(250,930);
    public Point point_ButtonXDataPackageExtraFPTPlay = new Point(124,309);
    public Point point_ButtonEllipsisDeviceBox1FPTPlay = new Point(990,1205);
    public Point point_ButtonEllipsisDeviceBox2FPTPlay = new Point(990,1385);
    public Point point_ButtonEllipsisExtraFPTPlay = new Point(990,1540);
    public Point point_ButtonEllipsisServiceFPTPlayScreen = new Point(975,755);
    public Point point_ButtonShortenServiceFPTPlayScreen = new Point(275,750);

}
