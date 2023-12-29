package page_objects.newInternetSale;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Point;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

public class ElementsNewInternetSale extends BasePageObject {
    public FlutterFinder find;

    ElementsNewInternetSale() {
        find = new FlutterFinder(driver);

        this.button_Continue = find.text("Tiếp tục");
        this.button_BuyServices = find.text("Mua dịch vụ");
        this.button_BuyMoreServices = find.text("Mua thêm dịch vụ");
        this.button_Confirm = find.text("Xác nhận");
        this.dropList_ServicePackage = find.text("Lựa chọn gói dịch vụ");
        this.dropList_Implementation = find.text("Lựa chọn triển khai");
        this.button_BookPort = find.byValueKey("btnBookport");
        this.button_Add = find.text("Thêm");
        this.button_Reject = find.text("Hủy");
        this.dropList_DataPackage_AddOnInternet = find.text("Lựa chọn");
        this.button_Edit = find.text("Sửa");
        this.button_Delete = find.text("Xóa");
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
     * Locators gotten by MobileELement
     * */
    public MobileElement button_Continue;
    public MobileElement button_BuyServices;
    public MobileElement button_BuyMoreServices;
    public MobileElement button_Confirm;
    public MobileElement button_BookPort;
    public MobileElement button_Add;
    public MobileElement button_Reject;
    public MobileElement button_Edit;
    public MobileElement button_Delete;

    public MobileElement dropList_ServicePackage;
    public MobileElement dropList_Implementation;
    public MobileElement dropList_DataPackage_AddOnInternet;

    /**
     * Locators gotten from Point
     * */
    public Point point_FirstCombo_Super80 = new Point(500,1300);
    public Point point_InternetPackage = new Point(136,391);
    public Point point_FPTPlayPackage = new Point(406,391);
    public Point point_FPTCameraComboPackage = new Point(676,391);
    public Point point_FPTCameraOnlyPackage = new Point(946,391);
    public Point point_FPTPlayStandAlonePackage = new Point(136,684);
    public Point point_OtherProductsPackage = new Point(406,684);
    public Point point_ButtonAdd = new Point(981,757);
    public Point point_ChooseG97RG6M = new Point(937,285);
    public Point point_ChooseG97RG3 = new Point(937,485);
    public Point point_ChooseHubN300C = new Point(937,685);
    public Point point_ChooseHubAC1000F = new Point(937,885);
    public Point point_DropListDataPackage = new Point(535,672);
    public Point point_DropListDevices = new Point(535,1200);
    public Point point_AddOnInternetService = new Point(1022,1390);
    public Point point_ChooseServicePackage_AddOnInternet = new Point(535,350);
    public Point point_ButtonEditAddOnInternetPackage = new Point(987,1575);
    public Point point_ButtonEditInternetService = new Point(975,757);
    public Point point_FTTHSuper80InternetPackage = new Point(490,1300);



}
