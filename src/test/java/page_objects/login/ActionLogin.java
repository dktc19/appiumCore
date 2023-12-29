package page_objects.login;

import java.io.IOException;

import static constants.CommonLogin.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.FlutterActionUtil.waitFor;
import static net.fpt.utils.TesseractOcrUtil.*;

public class ActionLogin extends ElementsLogin {

    public void inputUserName(String username){
//        inputText(textfield_UserName,username);
        waitFor(dynamic_finder("Nhớ mật khẩu"));
        inputTextByOcrTech("tài khoản mobisale",username,2,0);
    }

    public void inputPassword(String password){
//        inputText(textfield_Password,password);
        waitFor(dynamic_finder("Nhớ mật khẩu"));
        inputTextByOcrTech("mật khẩu",password,2,0);
    }

    public void clickToLogin() {
        clickToElement(button_Login);
    }

    public void loginApp() {
        inputUserName(username1);
        inputPassword(password1);
        clickToElement(button_Login);
    }

    public void loginAppWithDynamicParams(String username, String password) {
        inputUserName(username);
        inputPassword(password);
        clickToLogin();
    }

    public void inputUsernameOCR(String username) throws IOException, InterruptedException {
        inputTextByOcrTech(text_UsernameBox,username,1,0);
    }

    public void inputPasswordOCR(String password) throws IOException, InterruptedException {
        inputTextByOcrTech(text_PasswordBox,password,1,0);
    }

    public void clickLoginOCR() throws IOException, InterruptedException {
        tapByExactCoordinates(getWhiteTextCoordinate(text_Login,0,1,40).getX(),getWhiteTextCoordinate(text_Login,0,1,40).getY());
    }
}
