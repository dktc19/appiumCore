package page_objects.BookPort;

import io.appium.java_client.MobileElement;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

import java.awt.*;

public class ElementsBookPort extends BasePageObject {
    public FlutterFinder find;

    ElementsBookPort() {
        find = new FlutterFinder(driver);

        this.button_Confirm = find.text("Xác nhận");
        this.button_Continue = find.text("Tiếp tục");
        this.button_AddBookPort = find.byValueKey("btnBookport");

        this.button_Edit = find.text("Sửa");
        this.button_Delete = find.text("Xóa");

        this.point_ButtonAllowUsingDeviceLocation = new Point(561,1367);
        this.point_ButtonOnlyOneUsingDeviceLocation = new Point(550,1515);
        this.point_ButtonDenyUsingDeviceLocation = new Point(550,1650);
        this.point_ButtonPageBack = new Point(90,127);
        this.point_ButtonChangeMode = new Point(60,1405);
        this.point_ButtonEllipsisBookPort = new Point(990,1620);
        this.point_ButtonBookPort = new Point(800,1925);
        this.point_ButtonChangeMapModeBookPort = new Point(1020,1400);
        this.point_ManualChooseLocation = new Point(475,800);
        this.point_ButtonXManualBookPort = new Point(124,309);
        this.point_TextFieldIndoorManualBookPort = new Point(160,1360);
        this.point_TextFieldOutdoorManualBookPort = new Point(160,1558);
        this.point_ButtonChooseGridType = new Point(160,1755);
        this.point_ButtonChooseContractType = new Point(160,1955);



        //version 3.2.0.10
        this.button_BookPortLink = find.byValueKey("btnLinkBookport");
        this.button_ADSL = find.text("ADSL");
        this.button_CheckPointSet = find.text("Kiểm tra tập điểm");
        this.button_RecallBookPort = find.text("Thu hồi");
        this.button_BookPort = find.text("Book Port");
        this.button_CompleteBookPort = find.text("Hoàn thành");

        this.point_PointSetManualBookPort = new Point(525,715);
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
    public MobileElement button_Confirm;
    public MobileElement button_Continue;
    public MobileElement button_AddBookPort;
    public MobileElement button_Edit;
    public MobileElement button_Delete;

    /**
     * Locators gotten from Point
     *
     * */
    public Point point_ButtonAllowUsingDeviceLocation;
    public Point point_ButtonOnlyOneUsingDeviceLocation;
    public Point point_ButtonDenyUsingDeviceLocation;
    public Point point_ButtonPageBack;
    public Point point_ButtonChangeMode;
    public Point point_ButtonEllipsisBookPort;
    public Point point_ButtonBookPort;
    public Point point_ButtonChangeMapModeBookPort;
    public Point point_ManualChooseLocation;
    public Point point_ButtonXManualBookPort;
    public Point point_TextFieldIndoorManualBookPort;
    public Point point_TextFieldOutdoorManualBookPort;
    public Point point_ButtonChooseGridType;
    public Point point_ButtonChooseContractType;





    // version 3.2.0.10
    public MobileElement button_BookPortLink;
    public MobileElement button_ADSL;
    public MobileElement button_CheckPointSet;
    public MobileElement button_RecallBookPort;
    public MobileElement button_BookPort;
    public MobileElement button_CompleteBookPort;

    public Point point_PointSetManualBookPort;

}
