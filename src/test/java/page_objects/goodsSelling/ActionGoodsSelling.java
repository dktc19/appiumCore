package page_objects.goodsSelling;

import com.lazerycode.selenium.util.Query;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.fpt.utils.PropertyUtils;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static constants.CommonNewInternetSale.input_PhoneNumber;
import static constants.CommonSelling.*;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static net.fpt.utils.DateUtil.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.FlutterActionUtil.Time.*;
import static net.fpt.utils.FlutterActionUtil.scrollDownUntilTextVisible;
import static net.fpt.utils.PushImagesUtils.pushImages;
import static net.fpt.utils.StaticActionUtil.*;
import static net.fpt.utils.TesseractOcrUtil.*;
import static net.fpt.utils.WaitUtils.*;
import static net.fpt.utils.FlutterActionUtil.Direction.*;

public class ActionGoodsSelling extends ElementsGoodsSelling{
    public int explicitWaitDefault = PropertyUtils.getIntegerProperty("explicitWait", 60);
    WebDriverWait wait = new WebDriverWait(driver, explicitWaitDefault );

    /**
     * To verify the existence of the title of customer information
     *
     * */
    public String isCustomerInfoTitleVisible() {
        waitForElementToBeVisible(title_CustomerInfo, wait);
        return title_CustomerInfo.getText();
    }

    /**
     * To access the selling screen
     *
     * */
    public void accessSellingFunction() throws IOException, InterruptedException {
        tapByExactCoordinates(getTextCoordinate(option_sellingGoods).getX(),getTextCoordinate(option_sellingGoods).getY());
    }

    /**
     * Scroll screen up and down to check the elements in array exist or not
     *
     * */
    public void checkTitleWithAsterisk() throws TesseractException, IOException, InterruptedException {
        String[] array = {title_type,title_customer_type,title_name,title_birthday,title_id,title_date_of_issue,title_place_of_issue,title_gender,title_address_on_id,title_district,title_ward,title_street,title_type_of_house};
        for (int i = 0; i <= 12; i++) {
            scrollDownUntilTextVisible(array[i],20);
        }
        System.out.println("End check");
    }

    /**
     * Pick day, month, year from rolling calendar
     *
     * @param pick_time
     * */
    public void pickDateFromRollingCalendar(List<String> pick_time) {
        int current_day = getCurrentDay();
        int current_year = getCurrentYear() - 1;
        int current_month = getCurrentMonth();
        Integer[] current_time = {current_year,current_month,current_day};
        Time[] date = {YEAR,MONTH,DAY};
        swipeCalendar(UP,YEAR,735,1572,1500,1500);
        for (int i = 0; i < 3; i++) {
            if (current_time[i] < Integer.parseInt(pick_time.get(i))) {
                scrollDirectUntilVisible(DOWN,date[i],Integer.parseInt(pick_time.get(i)) - current_time[i]);
            }
            if (current_time[i] > Integer.parseInt(pick_time.get(i))) {
                scrollDirectUntilVisible(UP,date[i],current_time[i] - Integer.parseInt(pick_time.get(i)));
            }
        }
        clickToElement(button_Confirm);
    }

    /**
     * Pick day, month, year from rolling calendar
     *
     * @param pick_time
     * */
    public void pickCalendarEstablishedDate(List<String> pick_time) {
        int current_day = getCurrentDay();
        int current_year = getCurrentYear();
        int current_month = getCurrentMonth();
        Integer[] current_time = {current_year,current_month,current_day};
        Time[] date = {YEAR,MONTH,DAY};
        swipeCalendar(UP,YEAR,735,1572,1500,1500);
        for (int i = 0; i < 3; i++) {
            if (current_time[i] < Integer.parseInt(pick_time.get(i))) {
                scrollDirectUntilVisible(DOWN,date[i],Integer.parseInt(pick_time.get(i)) - current_time[i]);
            }
            if (current_time[i] > Integer.parseInt(pick_time.get(i))) {
                scrollDirectUntilVisible(UP,date[i],current_time[i] - Integer.parseInt(pick_time.get(i)));
            }
        }
        clickToElement(button_Confirm);
    }

    /**
     * Scroll the exact direction using native API. Function scroll until item is visible
     *
     * @param dir
     * @param time
     * @param roll_times
     */
    public void scrollDirectUntilVisible(Direction dir, Time time, int roll_times) {
        boolean foo = false;
        int count = 0;
        while (!foo) {
            swipeCalendar(dir,time,735,1572,1500,1500);
            if (count == roll_times - 1) {
                foo = true;
            } else {
                ++count;
                sleepTo(500);
            }
        }
    }

    /**
     * Add image from gallery
     *
     * @param str
     * */
    public void addImage(String str) {
        accessRootMenu();
        driver.context("NATIVE_APP");
        staticWait(1000);
        WebElement searchBox =  wait.until(ExpectedConditions.elementToBeClickable(button_searchBox.by()));
        searchBox.click();
        WebElement inputSearchBox =  wait.until(ExpectedConditions.elementToBeClickable(textBox_searchBox.by()));
        inputSearchBox.sendKeys(str);
        staticWait(1000);
        driver.context("FLUTTER");
        tapByCoordinates(point_Image.x, point_Image.y);
        sleepTo(1000);
        clickToElement(button_used);
    }

    /**
     * Function to choose image without click use button
     *
     * @param str
     * */
    public void addImageWithoutClickUse(String str) {
        accessRootMenu();
        driver.context("NATIVE_APP");
        staticWait(1000);
        WebElement searchBox =  wait.until(ExpectedConditions.elementToBeClickable(button_searchBox.by()));
        searchBox.click();
        WebElement inputSearchBox =  wait.until(ExpectedConditions.elementToBeClickable(textBox_searchBox.by()));
        inputSearchBox.sendKeys(str);
        staticWait(1000);
        driver.context("FLUTTER");
        tapByCoordinates(point_Image.x, point_Image.y);
    }

    public Boolean isElementVisible(Query q) {
        driver.context("NATIVE_APP");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(q.by()));
            q.findWebElement();
            return true;
        } catch (TimeoutException e) {
            return false;
        } finally {
            driver.context("FLUTTER");
        }
    }

    /**
     * Function to access gallery
     *
     * @param el
     * */
    public void accessGallery(MobileElement el) throws IOException, TesseractException {
        clickToElement(button_addIdCardImage);
        clickToElement(el);
        clickToElement(selector_imageGallery);
        sleepTo(2000);
        tapByExactCoordinates(point_alarmAllowAccess.x,point_alarmAllowAccess.y);
        applyNotificationPermission();
    }

    public void clickFileImage() throws TesseractException, IOException {
        waitForTappable(button_Confirm);
        tapByExactCoordinates(point_BtnAddFileImage.x,point_BtnAddFileImage.y);
        clickToElement(selector_imageGallery);
        sleepTo(2000);
        tapByExactCoordinates(point_alarmAllowAccess.x,point_alarmAllowAccess.y);
        applyNotificationPermission();
    }

    /**
     * Access root menu in gallery
     */
    public void accessRootMenu() {
        driver.context("NATIVE_APP");
        staticWait(1000);
        WebElement rootButton = wait.until(ExpectedConditions.elementToBeClickable(button_Root.by()));
        rootButton.click();
        WebElement btnDownload = wait.until(ExpectedConditions.elementToBeClickable(selector_Download.by()));
        btnDownload.click();
        driver.context("FLUTTER");
    }

    /**
     * To select the place where set up service package
     * */
    public void selectSetUpPlace() {
        String[] data = {selector_district,selector_ward,selector_street,selector_houseType};
        String[] dataTitle = {title_district,title_ward,title_street,title_type_of_house};
        // function to click select locator
        for (int i = 0; i < 4; i++) {
            scrollDownNativeUntilVisible(dynamic_finder(dataTitle[i]),10);
            swipeOffset(200);
            System.out.println(dataTitle[i]);
            scrollDownNativeUntilVisible(dynamic_finder(data[i]),5);
            clickToElement(dynamic_finder(data[i]));
        }
        inputText(textfield_HouseNumber,selector_houseNumber);
    }

    /**
     * Function to check personal information were updated after input id card images
     *
     * */
    public List checkInfoUpdateFromImage() throws TesseractException, IOException, InterruptedException {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_InfoFromID.size(); i++) {
            scrollDownUntilTextVisible(list_InfoFromID.get(i).toString(),10);
            strList.add(dynamic_finder(list_InfoFromID.get(i).toString()).getText());
        }
        return strList;
    }

    /**
     * Function to check personal information were updated after change id card images
     *
     * */
    public List checkInfoUpdateFromChangeIDImage() throws TesseractException, IOException, InterruptedException {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_InfoUpdateFromChangeID.size(); i++) {
            scrollDownUntilTextVisible(list_InfoUpdateFromChangeID.get(i).toString(),20);
            strList.add(dynamic_finder(list_InfoUpdateFromChangeID.get(i).toString()).getText());
        }
        return strList;
    }

    /**
     * get separate titles of organized business type
     *
     * */
    public List listTextTitleOrganizeType() throws TesseractException, IOException, InterruptedException {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_titleOrganizeType.size(); i++) {
            scrollDownUntilTextVisible(list_titleOrganizeType.get(i).toString(),20);
            strList.add(dynamic_finder(list_titleOrganizeType.get(i).toString()).getText());
        }
        return strList;
    }

    /**
     * Get text of options in customer type selector
     *
     * */
    public List listTextOptionCustomerType() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_optionCustomerType.size(); i++) {
            if (displayed(dynamic_finder(list_optionCustomerType.get(i).toString()))) {
                strList.add(dynamic_finder(list_optionCustomerType.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Get text of options in house pointer selector
     *
     * */
    public List listTextOptionHousePointer() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_HousePointer.size(); i++) {
            if (displayed(dynamic_finder(list_HousePointer.get(i).toString()))) {
                strList.add(dynamic_finder(list_HousePointer.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Get text of options of title appeared after apartment of house style chosen
     *
     * */
    public List listTextTitleOptionsOfApartment() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_TitleOptionsOfApartment.size(); i++) {
            if (displayed(dynamic_finder(list_TitleOptionsOfApartment.get(i).toString()))) {
                strList.add(dynamic_finder(list_TitleOptionsOfApartment.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Function to create String from list date
     *
     * @param list
     * */
    public String dateString(List list) {
        if (Integer.parseInt(list.get(1).toString()) > 9) {
            return list.get(2).toString() + "/" + list.get(1).toString() + "/" + list.get(0).toString();
        } else {
            return list.get(2).toString() + "/0" + list.get(1).toString() + "/" + list.get(0).toString();
        }
    }

    /**
     * Get text from options of special customer
     * */
    public List listTextSpecialCustomer() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_SpecialCustomer.size(); i++) {
            if (displayed(dynamic_finder(list_SpecialCustomer.get(i).toString()))) {
                strList.add(dynamic_finder(list_SpecialCustomer.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Get text from options of house types
     * */
    public List listHouseTypes() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_HouseTypes.size(); i++) {
            if (displayed(dynamic_finder(list_HouseTypes.get(i).toString()))) {
                strList.add(dynamic_finder(list_HouseTypes.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Get text from options of house types
     * */
    public List listTitleAddressFeeAtHome() {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_InfoSetUpAddress.size(); i++) {
            if (displayed(dynamic_finder(list_InfoSetUpAddress.get(i).toString()))) {
                strList.add(dynamic_finder(list_InfoSetUpAddress.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * To access the gallery to add front image of id card
     *
     * */
    public void accessGalleryInputFrontIDImage() {
        clickToElement(button_addIdCardImage);
        clickToElement(button_addFrontImage);
    }

    /**
     * Tp check gallery opened
     *
     * */
    public Boolean canAccessGallery() {
        driver.context("NATIVE_APP");
        try {
            return isElementVisible(button_searchBox);
        } catch (TimeoutException e) {
            return false;
        } finally {
            driver.context("FLUTTER");
        }
    }

    /**
     * To access "add images" and click to "Add File Images (Maximum 3 pictures)"
     *
     * */
    public void accessGalleryClickAddFileImage() {
        clickToElement(button_addIdCardImage);
        clickToElement(button_AddFileImage);
    }

    /**
     * To add 3 pictures of files into additional files
     *
     * */
    public void addThreeFileImages() throws IOException, InterruptedException, TesseractException {
        accessGallery(button_AddFileImage);
        addImage(PropertyUtils.getProperty("image.additional.file"));
        for (int i = 0; i < 2; i++) {
            tapByCoordinates(point_AddImageButtonOfAdditionalFiles.x,point_AddImageButtonOfAdditionalFiles.y);
            waitFor(selector_imageGallery);
            clickToElement(selector_imageGallery);
            addImage(PropertyUtils.getProperty("image.additional.file"));
        }
    }

    /**
     * To add 2 pictures of files into additional files
     * */
    public void addTwoFileImages() {
        for (int i = 0; i < 2; i++) {
            tapByCoordinates(point_AddImageButtonOfAdditionalFiles.x,point_AddImageButtonOfAdditionalFiles.y);
            waitFor(selector_imageGallery);
            clickToElement(selector_imageGallery);
            addImage(PropertyUtils.getProperty("image.additional.file"));
        }
    }

    /**
     * Function to choose and access "Input Images" screen of option "Other ISP" of "Special Customer" option
     *
     * */
    public void accessInputImageScreenOfOtherISP() {
        scrollDownNativeUntilVisible(title_SpecialCustomer,10);
        swipeOffset(300);
        waitFor(dynamic_finder(list_SpecialCustomer.get(7).toString()));
        clickToElement(dynamic_finder(list_SpecialCustomer.get(7).toString()));
        clickToElement(dynamic_finder(list_SpecialCustomer.get(0).toString()));
        waitFor(dynamic_finder(notice_OtherISP));
        clickToElement(button_Confirm);
    }

    /**
     *  Function to access gallery to upload images from Other ISP
     *
     * */
    public void clickAddImagesForOtherISP() throws IOException, InterruptedException {
        scrollDownNativeUntilVisible(title_SpecialCustomer,10);
        swipeOffset(300);
        waitFor(dynamic_finder(list_SpecialCustomer.get(7).toString()));
        clickToElement(dynamic_finder(list_SpecialCustomer.get(7).toString()));
        clickToElement(dynamic_finder(list_SpecialCustomer.get(0).toString()));
        waitFor(dynamic_finder(notice_OtherISP));
        clickToElement(button_Confirm);
        waitFor(dynamic_finder(title_AddFileImages));
        scrollDownNativeUntilVisible(title_OtherISPFileImage,5);
        swipeOffset(200);
        clickToElement(button_AddOtherISPFileImage);
        waitFor(selector_imageGallery);
        clickToElement(selector_imageGallery);
        tapByExactCoordinates(getTextCoordinate(button_AllowOfNotification).getX(),getTextCoordinate(button_AllowOfNotification).getY());
    }

    /**
     * Function to upload 3 pictures for other ISP
     * */
    public void addThreeImageOfOtherISP() {
        for (int i = 0; i < 2; i++) {
            tapByCoordinates(point_AddImageButtonOfOtherISP.x,point_AddImageButtonOfOtherISP.y);
            waitFor(selector_imageGallery);
            clickToElement(selector_imageGallery);
            addImage(PropertyUtils.getProperty("image.additional.file.blank"));
        }
    }

    /**
     * To add 2 images of ID card without click confirm
     *
     * */
    public void addImagesOfIdCard() throws IOException, InterruptedException {
        waitFor(dynamic_finder(title_AddFileImages));
        clickToElement(button_addFrontImage);
        waitFor(selector_imageGallery);
        clickToElement(selector_imageGallery);
        tapByExactCoordinates(getTextCoordinate(button_AllowOfNotification).getX(),getTextCoordinate(button_AllowOfNotification).getY());
        addImage(PropertyUtils.getProperty("image.id.front"));
        waitFor(dynamic_finder(title_AddFileImages));
        clickToElement(button_addBehindImage);
        waitFor(selector_imageGallery);
        clickToElement(selector_imageGallery);
        addImage(PropertyUtils.getProperty("image.id.behind"));
    }

    /**
     * To add 2 images of ID card without click confirm
     *
     * */
    public void addImagesOfSecondIdCard() throws IOException, InterruptedException {
        waitFor(dynamic_finder(title_AddFileImages));
        clickToElement(button_addFrontImage);
        waitFor(selector_imageGallery);
        clickToElement(selector_imageGallery);
        tapByExactCoordinates(getTextCoordinate(button_AllowOfNotification).getX(),getTextCoordinate(button_AllowOfNotification).getY());
        addImage(PropertyUtils.getProperty("image.id.front.2"));
        waitFor(dynamic_finder(title_AddFileImages));
        clickToElement(button_addBehindImage);
        waitFor(selector_imageGallery);
        clickToElement(selector_imageGallery);
        addImage(PropertyUtils.getProperty("image.id.behind"));
    }

    /**
     * To add 4 images into other file image of tab "other paper"
     *
     * tab: other files
     * */
    public void addFourImagesOfOtherFilesImages() {
        for (int i = 0; i < 4; i++) {
            tapByCoordinates(point_AddImageButtonOfOtherFile.x,point_AddImageButtonOfOtherFile.y);
            clickToElement(selector_imageGallery);
            addImage(PropertyUtils.getProperty("image.additional.file.blank"));
        }
    }

    /**
     * To add 2 images of other ISP of tab "other paper"
     *
     * tab: other paper
     * */
    public void addTwoImagesOfOtherISPInOtherPaper() {
        for (int i = 0; i < 2; i++) {
            tapByCoordinates(point_AddImageButtonOfOtherISP_OtherFilesTab.x,point_AddImageButtonOfOtherISP_OtherFilesTab.y);
            clickToElement(selector_imageGallery);
            addImage(PropertyUtils.getProperty("image.additional.file"));
        }
    }

    /**
     * Function to give text of address invoice for house option
     *
     * */
    public String textAddressInvoiceHouseOption() {
        return selector_houseNumber + " " + list_InfoSetUpAddress.get(2).toString() + ", " + list_InfoSetUpAddress.get(1).toString() + ", " + list_InfoSetUpAddress.get(0).toString() + ", Hồ Chí Minh.";
    }

    /**
     * Function to give text of address invoice for apartment option
     *
     * */
    public String textAddressInvoiceApartmentOption() {
        return "Tầng " + list_InfoSetUpApartment.get(1).toString() + ", Phòng" + list_InfoSetUpApartment.get(2).toString() + ", " + list_InfoSetUpApartment.get(0).toString() + ", " + list_InfoSetUpAddress.get(2).toString() + ", " + list_InfoSetUpAddress.get(1).toString() + ", " + list_InfoSetUpAddress.get(0).toString() + ", Hồ Chí Minh.";
    }

    /**
     * Function to give text of address invoice for no address house option
     *
     * */
    public String textAddressInvoiceNoAddressHouseOption() {
        return list_HousePointer.get(0).toString() + " " + textAddressInvoiceHouseOption();
    }

    /**
     * To access "Customer Info" screen from home screen
     *
     * */
    public void accessCustomerInfoScreen() throws IOException, InterruptedException {
        accessSellingFunction();
        clickToElement(button_createNew);
        if (displayed(button_Confirm)) {
            clickToElement(button_Confirm);
        }
    }

    /**
     * To fill all options about house's address
     *
     * */
    public void fillSetUpAddressHouseOption() throws TesseractException, IOException, InterruptedException {
        fillSetUpAddressWithoutHouseType();
        clickToElement(dropList_HouseType);
        scrollDownUntilTextVisible(list_HouseTypes.get(0).toString(),20);
        clickToElement(dynamic_finder(list_HouseTypes.get(0).toString()));
        scrollDownUntilTextVisible(textBox_HouseAddress,10);
        inputTextByOcrTech(textBox_HouseAddress,selector_houseNumber);
    }

    /**
     * To fill all options about house's address without house type
     *
     * */
    public void fillSetUpAddressWithoutHouseType() throws TesseractException, IOException, InterruptedException {
        scrollDownUntilTextVisible(title_SetupLocation,20);

        clickToElement(dropList_District);
        scrollDownUntilTextVisible(list_InfoSetUpAddress.get(0).toString(),20);
        clickToElement(dynamic_finder(list_InfoSetUpAddress.get(0).toString()));

        clickToElement(dropList_Ward);
        scrollDownUntilTextVisible(list_InfoSetUpAddress.get(1).toString(),20);
        clickToElement(dynamic_finder(list_InfoSetUpAddress.get(1).toString()));

        clickToElement(dropList_Street);
        scrollDownUntilTextVisible(list_InfoSetUpAddress.get(2).toString(),20);
        clickToElement(dynamic_finder(list_InfoSetUpAddress.get(2).toString()));
    }

    /**
     * Return the string of address that customer book to set up internet
     *
     * */
    public String customerAddress() {
        return selector_houseNumber + " " + list_InfoSetUpAddress.get(2).toString() + ", " + list_InfoSetUpAddress.get(1).toString() + ", " + list_InfoSetUpAddress.get(0).toString() + "Hồ Chí Minh.";
    }

    /**
     * To fill all need options of customer
     *
     * */
    public void enterServiceChoiceScreen() throws IOException, InterruptedException, TesseractException {
        accessCustomerInfoScreen();
        addIdentifyCard();
        scrollDownNativeUntilVisible(radioButton_Male,5);
        swipeOffset(800);
        clickToElement(radioButton_Male);
        swipeOffset(200);
        inputTextByCoordinates(textfield_PhoneNumber,340,input_PhoneNumber);
        fillSetUpAddressHouseOption();
        clickToElement(button_Continue);
    }

    /**
     * To clear warning popup, when account has lots of unpaid contract
     *
     * */
    public void clearUnPaidContractWarning() {
        boolean value;
        try {
            waitFor(button_Confirm,10);
            value = true;
        }catch (Exception e){
            value = false;
        }
        if (value) {
            clickToElement(button_Confirm);
        }
    }

    public void applyNotificationPermission() throws IOException, TesseractException {
        boolean value;
        try {
            waitFor(dynamic_finder("Cho phép quyền truy cập bộ nhớ"),10);
            value = true;
        }catch (Exception e){
            value = false;
        }
        if (value) {
            clickToElement(button_Confirm);
            tapByExactCoordinates(point_BtnNotification.x,point_BtnNotification.y);
            tapByExactCoordinates(point_BtnAllowNotificationsPermission.x,point_BtnAllowNotificationsPermission.y);
            for (int i = 0; i < 2; i++) {
                tapByExactCoordinates(point_BtnBackInSystem.x,point_BtnBackInSystem.y);
            }
            clickToElement(button_addFrontImage);
            clickToElement(selector_imageGallery);
        }
    }

    /**
     * Function to get gender at the private info customer declaration screen.
     * Note: Just used after ID card was inputted.
     *
     * @param gender
     *
     * */
    public void pickGender(String gender) throws IOException, TesseractException {
        if (displayed(button_ChangeImage)) {
            tapByExactCoordinates(getWhiteTextCoordinate(dropdown_GenderDefault,4,0,70).getX(),getWhiteTextCoordinate(dropdown_GenderDefault,4,0,70).getY());
        } else {
            tapByExactCoordinates(getWhiteTextCoordinate(dropdown_GenderDefault,4,1,70).getX(),getWhiteTextCoordinate(dropdown_GenderDefault,4,1,70).getY());
        }
//            clickToElementByOCR(gender);
        if (Objects.equals(gender, "Nam")) {
            tapByExactCoordinates(point_GenderMale.x,point_GenderMale.y);
        } else {
            tapByExactCoordinates(point_GenderFemale.x,point_GenderFemale.y);
        }
    }

    /**
     * Function to input phone number at the private info customer declaration screen.
     * Note: Just used after ID card was inputted.
     *
     * @param phone
     *
     * */
    public void inputPhone(String phone) {
        inputTextByOcrTech(textBox_PhoneNumber,phone);
    }

    /**
     * To add images of ID card when supplying personal info
     *
     * */
    public void addIdentifyCard() throws IOException, TesseractException {
        clickToElement(button_addIdCardImage);
        clickToElement(button_addFrontImage);
        clickToElement(selector_imageGallery);
        sleepTo(2000);
        tapByExactCoordinates(point_alarmAllowAccess.x,point_alarmAllowAccess.y);
        applyNotificationPermission();
        accessRootMenu();
        addImage(PropertyUtils.getProperty("image.id.front"));
        clickToElement(button_addBehindImage);
        clickToElement(selector_imageGallery);
        addImage(PropertyUtils.getProperty("image.id.behind"));
        clickToElement(button_Confirm);
    }

    /**
     * Roll random date for calendar
     *
     * */
    public void pickDateFromCalendar() {
        driver.context("NATIVE_APP");

        PointOption pointOptionStart, pointOptionEnd;

        // init start point = center of screen
        pointOptionStart = PointOption.point(775, 1380 );
        pointOptionEnd = PointOption.point(775,1480);

        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(300)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // ignore
        }finally {
            driver.context("FLUTTER");
        }

        clickToElement(button_Confirm);
    }

    /**
     * Check fields with asterisk for private cus
     *
     * */
    public void checkRequestedField(List list) throws TesseractException {
        for (int i = 0; i < list.size(); i++) {
            scrollDownUntilTextVisible(list.get(i).toString(),10);
        }
    }

    /**
     * Function to click back icon on top left of screen until expected text was found
     *
     * @param text
     *
     * */
    public void backUntilTextVisible(String text) throws TesseractException {
        if (!isTextOnScreen(text)) {
            tapByExactCoordinates(point_BackIcon.x,point_BackIcon.y);
        }
    }
}
