package page_objects.contractCreation;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Point;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

public class ElementsContractCreation extends BasePageObject {
    public FlutterFinder find;

    ElementsContractCreation() {
        find = new FlutterFinder(driver);

        this.boxText_OrderCode = find.byValueKey("txtOrderID");
        this.button_Confirm = find.text("Xác nhận");
        this.point_PageBack = new Point(77,124);

        // Version 3.2.0.10
        this.button_LinkBookPort = find.byValueKey("btnLinkBookport");
        this.dropdown_PaymentMethod = find.byValueKey("dlPayment");
        this.button_CreateContract = find.text("Tạo hợp đồng");
        this.button_Update = find.text("Cập nhật");

        this.point_BtnCreateOrder = new Point(800,1720);
        this.point_BtnCreateContract = new Point(540,1734);
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
     *
     * */
    public MobileElement boxText_OrderCode;
    public MobileElement button_Confirm;

    /**
     * Locators gotten by Point
     *
     * */
    public Point point_PageBack;



    /**
     * Version 3.2.0.10
     *
     * */
    public MobileElement button_LinkBookPort;
    public MobileElement dropdown_PaymentMethod;
    public MobileElement button_CreateContract;
    public MobileElement button_Update;

    public Point point_BtnCreateOrder;
    public Point point_BtnCreateContract;
}
