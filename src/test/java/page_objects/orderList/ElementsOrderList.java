package page_objects.orderList;


import org.openqa.selenium.Point;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

public class ElementsOrderList extends BasePageObject {
    public FlutterFinder find;

    ElementsOrderList(){
        find = new FlutterFinder(driver);
    }

}
