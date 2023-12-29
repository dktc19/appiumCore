package page_objects.Payment;

import io.appium.java_client.MobileElement;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

import java.awt.*;

public class ElementsPayment extends BasePageObject {
    public FlutterFinder find;

    ElementsPayment() {
        find = new FlutterFinder(driver);
        this.button_Check = find.text("Kiểm tra");
        this.point_ButtonPayment = new Point(550,2010);
        this.point_PageBack = new Point(77,124);


        // Version 3.2.0.10
        this.button_OrderDetail = find.text("Chi tiết đơn hàng");
        this.button_ReturnHomeMenu = find.text("Về trang chủ");

        this.point_BtnPayment = new Point(540,1734);
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
     *
     * */
    public MobileElement button_Check;

    /**
     * Locators gotten from Point
     *
     * */
    public Point point_ButtonPayment;
    public Point point_PageBack;



    /**
     * Version 3.2.0.10
     *
     * */
    public MobileElement button_OrderDetail;
    public MobileElement button_ReturnHomeMenu;

    public Point point_BtnPayment;

}
