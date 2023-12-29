package constants;

import java.util.ArrayList;
import java.util.List;
import net.fpt.utils.ReadingJsonUtil;

public final class CommonLogin {
    public static ReadingJsonUtil jsonUtil = new ReadingJsonUtil();

    // Login Screen
    public static final String DATA_TEST_FILE_PATH_COMMON_LOGIN = System.getProperty("user.dir")
            + "/src/test/java/data_file/LoginData.json";
    public static String username1 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_LOGIN, "username1");
    public static String password1 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_LOGIN, "password1");
    public static String username2 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_LOGIN, "username2");
    public static String password2 = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_LOGIN, "password2");

    public static String text_UsernameBox = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_LOGIN,"text_UsernameBox");
    public static String text_PasswordBox = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_LOGIN,"text_PasswordBox");
    public static String text_Login = jsonUtil.getStringUTF8(DATA_TEST_FILE_PATH_COMMON_LOGIN,"login_text");

}