package page_objects.login;

import io.appium.java_client.MobileElement;
import page_objects.BasePageObject;
import pro.truongsinh.appium_flutter.FlutterFinder;

public class ElementsLogin extends BasePageObject {
    public FlutterFinder find;

    ElementsLogin(){
        find = new FlutterFinder(driver);

        this.textfield_UserName = find.byValueKey("btAccount");
        this.textfield_Password = find.byValueKey("btPassword");
        this.button_Login = find.byValueKey("btnLogin");
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

    public MobileElement textfield_UserName;
    public MobileElement textfield_Password;
    public MobileElement button_Login;
}
