package net.fpt.utils;

import java.io.File;
import java.io.IOException;

import static net.fpt.utils.FlutterActionUtil.runCmd;
import static net.fpt.utils.WaitUtils.staticWait;

public class PushImagesUtils {
    private static final String DEVICE_NAME = PropertyUtils.getProperty("android.device.name");
    private static final String[] imageList = {PropertyUtils.getProperty("image.id.front"),
                            PropertyUtils.getProperty("image.id.front.2"),
                            PropertyUtils.getProperty("image.id.behind"),
                            PropertyUtils.getProperty("image.id.not.full.image"),
                            PropertyUtils.getProperty("image.id.blur"),
                            PropertyUtils.getProperty("image.additional.file"),
                            PropertyUtils.getProperty("image.additional.file.blank"),
                            PropertyUtils.getProperty("image.passport"),
                            PropertyUtils.getProperty("image.passport.blur")};

    private static final String imageDir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "source_images" + File.separator;

    public static String cmd(String inputString) {
        return "adb -s " + DEVICE_NAME + " push " + imageDir + inputString + " " + "/sdcard/Download";
    }

    public static void pushImages() {
        for (String s:imageList) {
            runCmd(cmd(s));
            staticWait(1000);
        }
    }
}
