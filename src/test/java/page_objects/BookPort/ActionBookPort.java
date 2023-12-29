package page_objects.BookPort;

import net.fpt.utils.PropertyUtils;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static constants.CommonContract.regex_BookPortCode;
import static constants.CommonContract.title_BookPort;
import static net.fpt.utils.FlutterActionUtil.*;
import java.util.ArrayList;
import java.util.List;

import static constants.CommonBookPort.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.ImageAnalyzeUtil.captureScreenAndReturnFile;
import static net.fpt.utils.ImageAnalyzeUtil.extractTextFromImage;
import static net.fpt.utils.StaticActionUtil.sleepTo;
import static net.fpt.utils.TesseractOcrUtil.clickToElementByOCR;
import static net.fpt.utils.TesseractOcrUtil.getWhiteTextCoordinate;

public class ActionBookPort extends ElementsBookPort {
    public int explicitWaitDefault = PropertyUtils.getIntegerProperty("explicitWait", 60);
    WebDriverWait wait = new WebDriverWait(driver, explicitWaitDefault );

    /**
     * Return the image model using for compare the map when login book port
     *
     * */
    public BufferedImage imageModel() throws IOException {
        String image = System.getProperty("user.dir") + "/model_images/image_book_port_1.png";
        return ImageIO.read(new File(image));
    }

    /**
     * Swipe Map
     *
     * */
    public void swipeMap() {
        swipeOffset(200);
    }

    /**
     * Set up indoor and outdoor index for manual book port
     *
     * */
    public void setUpIndoorOutdoorIndexManualBookPort() {
        tapByCoordinates(point_TextFieldIndoorManualBookPort.x,point_TextFieldIndoorManualBookPort.y);
        inputTextNotClick(list_IndoorOutdoorIndexManualBookPort.get(0).toString());

        tapByCoordinates(point_TextFieldOutdoorManualBookPort.x,point_TextFieldOutdoorManualBookPort.y);
        inputTextNotClick(list_IndoorOutdoorIndexManualBookPort.get(1).toString());
    }

    /**
     * Return list of all options in grid type
     *
     * */
    public List listTextGridType() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_GridTypeFTTHBookPort.size(); i++) {
            if (displayed(dynamic_finder(list_GridTypeFTTHBookPort.get(i).toString()))) {
                strList.add(dynamic_finder(list_GridTypeFTTHBookPort.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Return list of all options in contract type
     *
     * */
    public List listTextContractType() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_ContractTypeFTTHBookPort.size(); i++) {
            if (displayed(dynamic_finder(list_ContractTypeFTTHBookPort.get(i).toString()))) {
                strList.add(dynamic_finder(list_ContractTypeFTTHBookPort.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Return list of all options in book port detail info
     *
     * */
    public List listTextBookPortDetailInfo() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_BookPortDetailInfo.size(); i++) {
            scrollDownNativeUntilVisible(dynamic_finder(list_BookPortDetailInfo.get(i).toString()),5);
            if (displayed(dynamic_finder(list_BookPortDetailInfo.get(i).toString()))) {
                strList.add(dynamic_finder(list_BookPortDetailInfo.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Choose one of grid
     *
     * */
    public void setUpGridType() {
        tapByCoordinates(point_ButtonChooseGridType.x,point_ButtonChooseGridType.y);
        clickToElement(dynamic_finder(list_GridTypeFTTHBookPort.get(0).toString()));
        clickToElement(button_Confirm);
    }

    /**
     * Choose one of contract type
     *
     * */
    public void setUpContractType() {
        tapByCoordinates(point_ButtonChooseContractType.x,point_ButtonChooseContractType.y);
        clickToElement(dynamic_finder(list_ContractTypeFTTHBookPort.get(0).toString()));
        clickToElement(button_Confirm);
    }

    /**
     * To set up book port
     *
     * */
    public void setUpBookPort() {
        scrollDownNativeUntilVisible(button_AddBookPort,10);
        swipeOffset(800);
        clickToElement(button_AddBookPort);
        tapByCoordinates(point_ButtonAllowUsingDeviceLocation.x,point_ButtonAllowUsingDeviceLocation.y);
        waitFor(dynamic_finder(title_CustomerAddressBookPort));
        tapByCoordinates(point_ButtonBookPort.x,point_ButtonBookPort.y);
        clickToElement(button_CompleteBookPort);
        waitFor(dynamic_finder(title_CreateOrder));
        clickToElement(button_Continue);
    }

    /**
     * Access manual book port
     *
     * */
    public void accessManualBookPort() throws TesseractException, IOException {
        scrollDownUntilTextVisible(title_BookPort,10);
//        clickToElement(button_BookPortLink);
        clickToElementByOCR(getStringFromOtherString(regex_BookPortCode,extractTextFromImage(captureScreenAndReturnFile())));
        sleepTo(1000);
        if (!isTextOnScreen(button_AllowAppAccessLocation)) {
            tapByExactCoordinates(getWhiteTextCoordinate(button_AllowAppAccessLocation,1,0,70).getX(),getWhiteTextCoordinate(button_AllowAppAccessLocation,1,0,70).getY());
        }
        clickToElement(button_ADSL);
        clickToElement(button_CheckPointSet);
        tapByExactCoordinates(point_PointSetManualBookPort.x,point_PointSetManualBookPort.y);
        waitFor(dynamic_finder(title_ManualBookPort));
    }

}
