package page_objects.home;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Point;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

public class ElementsHome extends BasePageObject {
    public FlutterFinder find;

    ElementsHome(){
        this.find = new FlutterFinder(driver);
    }

    public MobileElement button_order = find.text("Đơn hàng");
    public Point point_icon_homePage = new Point(108,2128);
    public Point point_icon_reports = new Point(538,2128);
    public Point point_icon_notifications = new Point(756,2128);
    public Point point_icon_account = new Point(971,2128);
}
