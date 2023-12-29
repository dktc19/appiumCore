package page_objects.home;

public class ActionHome extends ElementsHome {

    public void clickToOrder(){
        flutterActionUtil.waitFor(button_order);
        flutterActionUtil.clickToElement(button_order);
    }
}
