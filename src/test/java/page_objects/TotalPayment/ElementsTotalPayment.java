package page_objects.TotalPayment;

import io.appium.java_client.MobileElement;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;
import java.awt.*;

public class ElementsTotalPayment extends BasePageObject {
    public FlutterFinder find;

    ElementsTotalPayment() {
        find = new FlutterFinder(driver);

        this.text_OrderCode = find.byValueKey("txtOrderID");
        this.text_ContractCode = find.byValueKey("txtContractID");
        this.button_ChoosePaymentMethod = find.text("Lựa chọn");
        this.button_Confirm = find.text("Xác nhận");
        this.option_CashPaymentMethod = find.text("Tiền mặt");
        this.text_TotalPrice = find.text("Thành tiền");
        this.button_EditTotalPaymentInternetPackage = find.byValueKey("btnEditTotalAmountInternet");
        this.button_EditTotalPaymentInternetRoamingFee = find.byValueKey("btnEditTotalAmountConectFees");
        this.button_EditTotalPaymentInternetDevices = find.byValueKey("btnEditTotalAmountDevice");
        this.button_MoreDetailInPriceCmd = find.text("Xem thêm");
        this.button_ReturnInDetailPriceCmd = find.text("Quay lại");
        this.button_ChoosePriceCmd = find.text("Chọn");
        this.button_VoucherList = find.text("Danh sách mã ưu đãi");
        this.button_Input = find.text("Nhập");

        this.point_ButtonXPaymentMethodPopup = new Point(124,1130);
        this.point_ButtonXPriceCmdDetail = new Point(136,578);
        this.point_ButtonXPriceCmd = new Point(124,312);
        this.point_ButtonCreateOrder = new Point(550,2010);
        this.point_ButtonXMonthlyServicePaymentMethodPopup = new Point(127,550);
        this.point_ButtonXVoucherPopup = new Point(127,312);
        this.point_ButtonXVoucher = new Point(1111111,11111111);
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
    public MobileElement text_OrderCode;
    public MobileElement text_ContractCode;
    public MobileElement button_ChoosePaymentMethod;
    public MobileElement button_Confirm;
    public MobileElement option_CashPaymentMethod;
    public MobileElement text_TotalPrice;
    public MobileElement button_EditTotalPaymentInternetPackage;
    public MobileElement button_EditTotalPaymentInternetRoamingFee;
    public MobileElement button_EditTotalPaymentInternetDevices;
    public MobileElement button_MoreDetailInPriceCmd;
    public MobileElement button_ReturnInDetailPriceCmd;
    public MobileElement button_ChoosePriceCmd;
    public MobileElement button_VoucherList;
    public MobileElement button_Input;

    /**
     * Locators gotten from Point
     *
     * */
    public Point point_ButtonXPaymentMethodPopup;
    public Point point_ButtonXPriceCmdDetail;
    public Point point_ButtonXPriceCmd;
    public Point point_ButtonCreateOrder;
    public Point point_ButtonXMonthlyServicePaymentMethodPopup;
    public Point point_ButtonXVoucherPopup;
    public Point point_ButtonXVoucher;

}
