package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import net.fpt.driver.CreateDriver;
import net.fpt.utils.PropertyUtils;
import net.sourceforge.tess4j.TesseractException;
import org.opentestfactory.exception.ParameterFormatException;
import org.opentestfactory.util.ParameterService;
import page_objects.BookPort.ActionBookPort;
import page_objects.Payment.ActionPayment;
import page_objects.contractCreation.ActionContractCreation;
import page_objects.goodsSelling.ActionGoodsSelling;
import page_objects.login.ActionLogin;
import java.io.IOException;

import static constants.CommonBookPort.*;
import static constants.CommonContract.*;
import static constants.CommonContract.title_BookPort;
import static constants.CommonLogin.*;
import static constants.CommonNewInternetSale.*;
import static constants.CommonPayment.*;
import static constants.CommonSelling.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.FlutterActionUtil.waitFor;
import static net.fpt.utils.ImageAnalyzeUtil.*;
import static net.fpt.utils.TesseractOcrUtil.*;
import static net.fpt.utils.WaitUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class toDoStepInternetCreateOrderSucceed {
    ActionLogin login;
    ActionGoodsSelling sell;
    ActionContractCreation bond;
    ActionPayment pay;
    ActionBookPort bp;

    private static String servicePackage;

    private void loginAppAndNavigateToServiceScreen() throws TesseractException, IOException {
        login = new ActionLogin();
        login.loginApp();
        sell = new ActionGoodsSelling();
        waitForOCR(title_Order);
        clickToElementByOCR(title_All);
        waitForOCR(title_AllServicesScreen);
        clickToElement(sell.button_createNew);
        sell.clearUnPaidContractWarning();
        waitForOCR(title_AddressInfo);
    }

    /**
     * Select customer's address from service screen
     *
     * @param address
     *
     * */
    private void selectLocationForServices(String address) throws TesseractException {
        tapByExactCoordinates(sell.point_BtnSearch.x,sell.point_BtnSearch.y);
        waitForOCR(textBox_AddressSearching);
        inputTextByOcrTech(textBox_AddressSearching,address);
        clickToElement(sell.dynamic_finder(button_Searching));
        waitForAbsent(sell.dynamic_finder(button_Searching));
        tapByExactCoordinates(sell.point_OptionAddress.x,sell.point_OptionAddress.y);
        waitForAbsent(sell.dynamic_finder(title_AddressSearchScreen));
        tapByExactCoordinates(sell.point_IconAddress .x,sell.point_IconAddress .y);
        waitForAbsent(sell.dynamic_finder(dropdown_AddressDefault));
        clickToElement(sell.button_Confirm);
    }

    /**
     * Select internet package
     *
     * @param service
     * @param dataPackage
     *
     * */
    private void selectComboInternet(String service, String dataPackage) throws TesseractException, IOException {
        servicePackage = service + " (" + dataPackage + ")";
        waitForTappable(sell.button_Confirm);
        clickToElementByOCR(dropdown_ServicePackage);
        waitForOCR(title_ServicePackage);
        clickToElementByOCR(service,1,0,70);
        waitForOCR(title_Internet);
        clickToElementByOCR(dropdown_DataPackage);
        waitForOCR(title_DataPackage);
        clickToElementByOCR(dataPackage,1,0,70);
        waitForOCR(title_Internet);
        clickConfirm();
    }

    /**
     * Select Device Smart Home package
     *
     * @param service
     *
     * */
    private void selectComboSmartHome(String service) throws IOException, TesseractException {
        waitForTappable(sell.button_Confirm);
        tapByExactCoordinates(getWhiteTextCoordinate(dropdown_Device,1,1,70).getX(),getWhiteTextCoordinate(dropdown_Device,1,1,70).getY());
        waitForOCR(title_SmartHome);
        clickToElement(sell.dynamic_finder(text_DeviceSmartHome));
        waitForOCR(title_SmartHome);
        inputTextByOcrTech(texBox_DeviceQuantity,text_SmartHomeDeviceQuantity,4,0);
        waitForOCR(text_SmartHomeDeviceQuantity);
        tapByExactCoordinates(getWhiteTextCoordinate(dropdown_ImplementationUnit,4,0,70).getX(),getWhiteTextCoordinate(dropdown_ImplementationUnit,4,0,70).getY());
        clickToElement(sell.dynamic_finder(option_TINAndPNC));
        waitForOCR(title_SmartHome);
        clickConfirm();
    }

    /**
     * Function to select the service inside the ohter product popup
     *
     * @param device
     * @param deviceType
     * @param quantity
     *
     * */
    private void selectOtherProduct(String deviceType, String device, String quantity) throws IOException {
        waitFor(sell.button_Confirm);
        tapByExactCoordinates(getWhiteTextCoordinate(dropdown_DeviceType,1,0,70).getX(),getWhiteTextCoordinate(dropdown_DeviceType,1,0,70).getY());
        waitFor(sell.dynamic_finder(title_DeviceType));
        clickToElement(sell.dynamic_finder(deviceType));
        waitFor(sell.button_Confirm);
        tapByExactCoordinates(getWhiteTextCoordinate(dropdown_Device,1,0,70).getX(),getWhiteTextCoordinate(dropdown_Device,1,0,70).getY());
        waitFor(sell.dynamic_finder(title_Device));
        clickToElement(sell.dynamic_finder(device));
        waitFor(sell.button_Confirm);
        inputTextByOcrTech(texBox_DeviceQuantity,quantity);
        clickConfirm();
    }

    private void selectHintAddressWithOption(String address) {
        address = ParameterService.INSTANCE.getString("DS_DiaChi",address);
        waitForAbsent(sell.dynamic_finder(button_Searching));
        tapByExactCoordinates(sell.point_OptionAddress.x,sell.point_OptionAddress.y);
    }

    private void clickIconAddressAndConfirmLocationWithOption(String address) {
        address = ParameterService.INSTANCE.getString("DS_DiaChi",address);
        waitForAbsent(sell.dynamic_finder(title_AddressSearchScreen));
        tapByExactCoordinates(sell.point_IconAddress .x,sell.point_IconAddress .y);
        waitForAbsent(sell.dynamic_finder(dropdown_AddressDefault));
        clickToElement(sell.button_Confirm);
    }

    private void createThreeCODSmartHomeContract() throws TesseractException, IOException {
        for (int i = 0; i < 4; i++) {
            clickToElementByOCR(title_All);
            waitForOCR(title_AllServicesScreen);
            clickToElement(sell.button_createNew);
            sell.clearUnPaidContractWarning();
            waitForOCR(title_AddressInfo);

            selectLocationForServices(text_Address);

            waitForOCR(title_AddressInfo);

            scrollDownUntilTextVisible(title_SmartHome,10);
            clickToElement(sell.dynamic_finder(title_SmartHome));
            selectComboSmartHome(text_DeviceSmartHome);
            accessDetailInfoScreen();
            clickConfirm();

            waitForOCR(title_CreateOther);

            clickToElement(sell.button_UpdateInfo);
            waitFor(sell.button_addIdCardImage);
            sell.addIdentifyCard();
            sell.pickGender(list_GenderOption.get(0).toString());
            sell.inputPhone(input_Phone);
            clickToElement(sell.button_ConfirmAndSave);
            waitForOCR(title_CreateOther);
            tapByExactCoordinates(getWhiteTextCoordinate(option_CashPayment,1,0,70).getX(),getWhiteTextCoordinate(option_CashPayment,1,0,70).getY());
            tapByExactCoordinates(getWhiteTextCoordinate(option_CODCashPayment,1,0,70).getX(),getWhiteTextCoordinate(option_CODCashPayment,1,0,70).getY());

            bond = new ActionContractCreation();
            tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
            sell.clearUnPaidContractWarning();
            waitFor(bond.dynamic_finder(title_DetailOrderScreen));
            tapByExactCoordinates(bond.point_BtnCreateContract.x,bond.point_BtnCreateContract.y);
            waitForOCR(title_ContractInformation);

            pay = new ActionPayment();
            tapByExactCoordinates(pay.point_BtnPayment.x,pay.point_BtnPayment.y);
            waitForOCR(title_Payment);
            clickToElement(pay.button_ReturnHomeMenu);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Given("User mở app")
    public void userOpenApp() {
        login = new ActionLogin();
    }

    @When("Nhập username")
    public void inputUserName() {
        login.inputUserName(username1);
    }

    @And("Nhập password")
    public void inputPassWord() {
        login.inputPassword(password1);
    }

    @And("Nhấn nút đăng nhập")
    public void clickOnLoginButton() throws IOException, InterruptedException {
//        login.clickToLogin();
        login.clickLoginOCR();
    }

    @Then("Kiểm tra đăng nhập thành công")
    public void loginPass() throws Exception {
        sell = new ActionGoodsSelling();
//        assertThat(displayed(sell.dynamic_finder("Allow"),10)).isTrue();
        clickToElementByOCR("Đơn",4,0,70);
        System.out.println("Click thành công");
        waitForOCR("Theo dõi đơn hàng");
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////


    @Given("Login vào tk SPF thành công bằng {string} và {string}") @Given("Login vào tk SPF thành công bằng bằng {string}và {string}")
    public void loginSPFAppWithGivenAccount(String username, String password) throws TesseractException {
        login = new ActionLogin();
        username = ParameterService.INSTANCE.getString("DS_Account",username);
        password = ParameterService.INSTANCE.getString("DS_Password",password);
        login.inputUserName(username);
        login.inputPassword(password);
        login.clickToLogin();
        sell = new ActionGoodsSelling();
        waitForOCR(title_Order);
    }

    @When("Nhấn Tất cả dịch vụ tại màn hình trang chủ")
    public void selectAllServicesButtonAtMenuScreen() throws IOException, TesseractException {
        clickToElementByOCR(title_All);
        waitForOCR(title_AllServicesScreen);
    }

    @And("Nhấn button Bán mới")
    public void clickNewSellingButton() {
        clickToElement(sell.button_createNew);
        sell.clearUnPaidContractWarning();
    }

    @And("Nhập địa chỉ {string} muốn tìm kiếm và nhấn tìm kiếm") @And("Nhập địa chỉ {string} và Tap button Tìm kiếm")
    public void searchAddressFromMap(String address) throws TesseractException {
        address = ParameterService.INSTANCE.getString("DS_DiaChi",address);
        waitForOCR(textBox_AddressSearching);
        inputTextByOcrTech(textBox_AddressSearching,address);
        clickToElement(sell.dynamic_finder(button_Searching));
    }

    @And("Chọn địa chỉ phù hợp ở list địa chỉ gợi ý")
    public void selectHintAddress() {
        waitForAbsent(sell.dynamic_finder(button_Searching));
        tapByExactCoordinates(sell.point_OptionAddress.x,sell.point_OptionAddress.y);
    }

    @And("Nhấn icon địa chỉ đang được tìm trên map và nhấn xác nhận")
    public void clickIconAddressAndConfirmLocation() {
        waitForAbsent(sell.dynamic_finder(title_AddressSearchScreen));
        tapByExactCoordinates(sell.point_IconAddress .x,sell.point_IconAddress .y);
        waitForAbsent(sell.dynamic_finder(dropdown_AddressDefault));
        clickConfirm();
    }

    @Then("Hiển thị màn hình dịch vụ")
    public void displayServiceScreen() throws TesseractException {
        waitForOCR(title_AddressInfo);
        assertThat(isTextOnScreen(title_AddressInfo))
                .as("Kiểm tra truy cập màn hình Dịch vụ").isTrue();
    }

    @When("Tại combo tùy chọn nhấn icon Internet")
    public void clickIconInternetAtOptionalCombo() throws TesseractException {
        waitForOCR(title_AddressInfo);
        scrollDownUntilTextVisible(title_OtherProduct,10);
        clickToElement(sell.dynamic_finder(title_Internet));
    }

    @And("Chờ màn hình tạo đơn hàng tải thành công")
    public void waitingForOrderCreationSuccess() throws TesseractException {
        waitForOCR(title_CreateOther);
    }

    @When("Chọn gói dịch vụ {string}, Chọn gói tính cước {string}") @And("Chọn Gói dịch vụ {string} và Gói tính cước Net {string}")
    public void selectServiceAndPaymentPackage(String service, String dataPackage) throws TesseractException, IOException {
        service = ParameterService.INSTANCE.getString("DS_DichVu",service);
        dataPackage = ParameterService.INSTANCE.getString("DS_GoiTinhCuoc",dataPackage);
        servicePackage = service + " (" + dataPackage + ")";
        waitForTappable(sell.button_Confirm);
        clickToElementByOCR(dropdown_ServicePackage);
        waitForOCR(title_ServicePackage);
        clickToElementByOCR(service,1,0,70);
        waitForOCR(title_Internet);
        clickToElementByOCR(dropdown_DataPackage);
        waitForOCR(title_DataPackage);
        clickToElementByOCR(dataPackage,1,0,70);
        waitForOCR(title_Internet);
    }

    @And("Nhấn xác nhận") @And("Tap button Xác nhận")
    public void clickConfirm() {
        clickToElement(sell.button_Confirm);
    }

    @Then("Truy cập màn hình chi tiết") @Then("Hiển thị màn hình chi tiết thông tin dịch đã chọn")
    public void accessDetailInfoScreen() {
        waitFor(sell.dynamic_finder(title_BoughtService));
        clickToElement(sell.dynamic_finder(button_ShoppingCart));
        waitFor(sell.dynamic_finder(title_ShoppingCartScreen));
    }

    @When("Nhấn cập nhật thông tin khách hàng") @And("Nhấn button cập nhật") @When("Nhấn cập nhật Thông tin khách hàng") @When("When xem chi tiết thông tin khách hàng") @When("Check xem chi tiết thông tin khách hàng")
    public void clickUpdatePrivateInfoButton() throws TesseractException {
        waitForOCR(title_CreateOther);
        clickToElement(sell.button_UpdateInfo);
    }

    @And("Nhập thông tin khách hàng")
    public void inputCusInfo() throws IOException, TesseractException {
        waitFor(sell.button_addIdCardImage);
        sell.addIdentifyCard();
        sell.pickGender(list_GenderOption.get(0).toString());
        sell.inputPhone(input_Phone);
    }

    @And("Nhấn xác nhận & lưu") @And("Tap button Xác nhận & Lưu")
    public void clickConfirmAndSave() {
        clickToElement(sell.button_ConfirmAndSave);
    }

    @Then("Hiển thị màn hình tạo đơn hàng có thông tin khách hàng đã nhập")
    public void verifyCusInfoWasUpdated() {
        waitFor(sell.dynamic_finder(title_customerInformation));
        assertThat(displayed(sell.dynamic_finder(list_InfoFromID.get(0).toString())))
                .as("Kiểm tra tên của khách hàng").isTrue();
        assertThat(displayed(sell.dynamic_finder(input_Phone)))
                .as("Kiểm tra số điện thoại của khách hàng").isTrue();
        assertThat(displayed(sell.dynamic_finder(list_InfoFromID.get(2).toString())))
                .as("Kiểm tra CCCD/CMND của khách hàng").isTrue();
    }

    @When("Chọn phương thức thanh toán tiền mặt")
    public void selectCashForPaymentMethod() throws TesseractException {
        bond = new ActionContractCreation();
        waitForTappable(bond.button_Update);
        assertThat(isTextOnScreen(list_PaymentMethod.get(0).toString()))
                .as("Kiểm tra phương thức thanh toán bằng tiền mặt đã được chọn").isTrue();
    }

    @Then("Kiểm tra thông tin dịch vụ Internet")
    public void verifyInternetPackageInfo() throws TesseractException {
        scrollDownUntilTextVisible(servicePackage,10);
        assertThat(isTextOnScreen(servicePackage))
                .as("Kiểm tra gói dịch vụ Internet đã được ghi nhận").isTrue();
    }

    @And("Kiểm tra book port")
    public void checkBookPort() throws TesseractException {
        scrollDownUntilTextVisible(title_BookPort,10);
        assertThat(matchFound(regex_BookPortCode,extractTextFromImage(captureScreenAndReturnFile())))
                .as("Kiểm tra mã book port của hệ thống").isTrue();
    }

    @And("Kiểm tra thông tin thanh toán")
    public void verifyPaymentInfo() throws TesseractException {
        scrollDownUntilTextVisible(title_TotalPrice,10);
        assertThat(matchFound(regex_CostOfService,extractTextFromImage(captureScreenAndReturnFile())))
                .as("Kiểm tra giá tiền").isTrue();
    }

    @When("Nhấn button tạo đơn hàng") @And("Nhấn button Tạo đơn hàng") @And("Nhấn bút Tạo đơn hàng")
    public void clickOrderCreationButton() {
        bond = new ActionContractCreation();
        tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
    }

    @Then("Tạo đơn hàng thành công và hiển thị màn hình chi tiết đơn hàng")
    public void verifyOrderCreationSuccess() throws TesseractException {
        sell.clearUnPaidContractWarning();
        waitFor(bond.dynamic_finder(title_DetailOrderScreen));
        assertThat(isTextOnScreen(title_OrderCode))
                .as("Kiểm tra màn hình chi tiết đơn hàng").isTrue();
    }

    @When("Tại combo gợi ý của bạn chọn gói dịch vụ Internet")
    public void selectSuggestComboInternet() {
        tapByExactCoordinates(sell.point_ComboSuper80.x,sell.point_ComboSuper80.y);
        tapByExactCoordinates(sell.point_OptionalSuper80.x,sell.point_OptionalSuper80.y);
    }

    @When("Chọn gói dịch vụ {string}, Chọn gói tính cước {string} Chọn gói Extra")
    public void selectServiceAndPaymentPackageAndExtra(String service, String dataPackage) throws TesseractException {
        service = ParameterService.INSTANCE.getString("DS_DichVu",service);
        dataPackage = ParameterService.INSTANCE.getString("DS_GoiTinhCuoc",dataPackage);
        servicePackage = service + " (" + dataPackage + ")";
        waitForTappable(sell.button_Confirm);
        clickToElement(sell.dynamic_finder(dropdown_ServicePackage));
        waitFor(sell.dynamic_finder(title_ServicePackage));
        clickToElement(sell.dynamic_finder(service));
        assertThat(displayed(sell.dynamic_finder(service)))
                .as("Kiểm tra gói dịch vụ đã được chọn").isTrue();
        clickToElement(sell.dynamic_finder(dropdown_DataPackage));
        waitFor(sell.dynamic_finder(title_DataPackage));
        clickToElement(sell.dynamic_finder(dataPackage));
        assertThat(displayed(sell.dynamic_finder(dataPackage)))
                .as("Kiểm tra gói tính cước đã được chọn").isTrue();
        tapByExactCoordinates(sell.point_BtnAddExtra.x,sell.point_BtnAddExtra.y);
        waitForOCR(dropdown_ServicePackage);
        clickToElement(sell.dynamic_finder(dropdown_ServicePackage));
        waitFor(sell.dynamic_finder(title_ServicePackage));
        clickToElement(sell.dynamic_finder(list_ExtraServiceInternet.get(0).toString()));
        clickConfirm();
    }

    @And("Chọn địa chỉ {string} và Tap địa chỉ {string} trên Tab Tìm kiếm và Tap button Xác nhận")
    public void selectHintAddressAndClickIconAddressAndConfirmLocation(String address, String address2) throws IOException {
        address = ParameterService.INSTANCE.getString("DS_DiaChi",address);
        address2 = ParameterService.INSTANCE.getString("DS_DiaChi",address2);
        waitForAbsent(sell.dynamic_finder(button_Searching));
        tapByExactCoordinates(sell.point_OptionAddress.x,sell.point_OptionAddress.y);
        waitForAbsent(sell.dynamic_finder(title_AddressSearchScreen));
        tapByExactCoordinates(sell.point_IconAddress .x,sell.point_IconAddress .y);
        waitForAbsent(sell.dynamic_finder(dropdown_AddressDefault));
        clickToElement(sell.button_Confirm);
    }

    @And("Kiểm tra hiển thị thông tin gói package")
    public void verifyAllSuggestPackages() throws TesseractException, IOException {
        waitForOCR(title_SuggestCombo);
        scrollDownUntilTextVisible(title_SuggestPackage, 10);
    }

    @Then("Hệ thống sẽ hiển thị thông tin package tương ứng với địa chỉ được chọn")
    public void verifySuggestPackageFollowAddress() throws TesseractException {
        assertThat(isTextOnScreen(title_SuggestPackage))
                .as("Hệ thống sẽ hiển thị thông tin package tương ứng với địa chỉ được chọn").isTrue();
    }

    @Given("Tap icon Tìm kiếm địa chỉ")
    public void clickSearchIcon() throws TesseractException, IOException {
        loginAppAndNavigateToServiceScreen();
        tapByExactCoordinates(sell.point_BtnSearch.x,sell.point_BtnSearch.y);
    }

    @Then("Điều hướng đến màn hình Thông tin địa chỉ")
    public void navigateToAddressInfoScreen() throws TesseractException {
        waitForOCR(textBox_AddressSearching);
    }

    @When("Tap Dropdownlist Đối tượng khách hàng")
    public void tapDropdownCusType() throws TesseractException, IOException {
        loginAppAndNavigateToServiceScreen();
        tapByExactCoordinates(sell.point_DropdownCusType.x,sell.point_DropdownCusType.y);
        waitForOCR(title_CusType);
    }

    @And("Chọn Đối tượng khách hàng")
    public void selectCusType() throws TesseractException, IOException {
        clickToElementByOCR(list_CusType.get(0).toString(),1,0,70);
    }

    @Then("Đóng popup & tại Dropdownlist hiển thị Đối tượng khách hàng được chọn")
    public void verifyCusTypePopupClosedAndOptionChosen() throws TesseractException {
        assertThat(isTextOnScreen(list_CusTypeOrganization.get(0).toString()))
                .as("Kiểm tra option loại khách hàng được chọn").isTrue();
    }

    @Given("Truy cập vào màn hình bản đồ")
    public void accessMapScreen() throws TesseractException, IOException {
        loginAppAndNavigateToServiceScreen();
        tapByExactCoordinates(sell.point_BtnSearch.x,sell.point_BtnSearch.y);
        waitForOCR(textBox_AddressSearching);
    }

    @When("Check Tap thanh tìm kiếm")
    public void tapAddressSearchBar() throws TesseractException, IOException {
        clickToElementByOCR(textBox_AddressSearching,1,0,70);
    }

    @Then("Điều hướng đến màn hình Tìm kiếm địa chỉ")
    public void verifyAppNavigateToAddressSearchScreen() {
        assertThat(displayed(sell.dynamic_finder(title_AddressSearchScreen)))
                .as("Kiểm tra điều hướng đến màn hình Tìm kiếm địa chỉ").isTrue();
    }

    @Then("Thông tin tab Nhập địa chỉ sẽ tự động điền vào các field bên tab Tìm kiếm")
    public void verifyAddressFilledOnAddressInfoScreen() {
        assertThat(displayed(sell.dynamic_finder(dropdown_AddressDefault),10))
                .as("Kiểm tra thông tin tab Nhập địa chỉ sẽ tự động điền vào các field bên tab Tìm kiếm").isFalse();
    }

    @When("^Tại màn hình Thông tin địa chỉ/Tab Tìm kiếm Tap thanh tìm kiếm$")
    public void atAddressInfoScreenClickSearchBar() throws TesseractException, IOException {
        clickSearchIcon();
        navigateToAddressInfoScreen();
    }

    @When("Tại Combo tùy chọn của màn hình dịch vụ Tap dịch vụ Internet với {string}") @When("Tại popup Internet Tap Dropdown list Gói dịch vụ Net {string}")
    public void clickInternetServiceAtOptionalCombo(String address) throws TesseractException {
        address = ParameterService.INSTANCE.getString("DS_DiaChi",address);
        searchAddressFromMap(address);
        selectHintAddressWithOption(address);
        clickIconAddressAndConfirmLocationWithOption(address);
        displayServiceScreen();
        clickIconInternetAtOptionalCombo();
    }

    @And("Tap Icon Thêm Extra")
    public void clickAddExtraService() throws TesseractException, IOException {
        accessDetailInfoScreen();
        tapByExactCoordinates(sell.point_BtnAddMoreServices.x,sell.point_BtnAddMoreServices.y);
        clickIconInternetAtOptionalCombo();
        waitingForOrderCreationSuccess();
    }

    @And("Chọn Gói dịch vụ {string} và Gói tính cước Extra {string}")
    public void selectExtraServiceAndDataPackage(String service, String dataPackage) throws TesseractException, IOException {
        tapByExactCoordinates(sell.point_BtnAddExtra.x,sell.point_BtnAddExtra.y);
        waitForOCR(dropdown_ServicePackage);
        service = ParameterService.INSTANCE.getString("DS_DichVuExtra",service);
        dataPackage = ParameterService.INSTANCE.getString("DS_GoiTinhCuoc",dataPackage);
        servicePackage = service + " (" + dataPackage + ")";
        clickToElementByOCR(dropdown_ServicePackage);
        waitForOCR(title_ServicePackage);
        clickToElementByOCR(service,1,0,70);
        waitForOCR(title_Internet);
        clickToElementByOCR(dropdown_DataPackage);
        waitForOCR(title_ServicePackage);
        clickToElementByOCR(dataPackage,1,0,70);
        waitForOCR(title_Internet);
        clickConfirm();
    }

    @When("Nhấn tạo hợp đồng") @When("Nhấn button Tạo hợp đồng")
    public void clickCreateContractButton() {
        tapByExactCoordinates(bond.point_BtnCreateContract.x,bond.point_BtnCreateContract.y);
    }

    @Then("Tạo hợp đồng thành công và hiển thị màn hình thanh toán") @Then("Sau khi tạo hợp đồng thành công chuyển sang màn hình Thanh toán") @Then("Chuyển sang màn hình Thanh toán")
    public void verifyPaymentScreen() throws TesseractException {
        waitForOCR(title_ContractInformation);
        assertThat(isTextOnScreen(title_Payment))
                .as("Kiểm tra hiển thị màn hình thanh toán").isTrue();
    }

    @When("Nhấn button thanh toán") @And("Tap button thanh toán") @When("Nhấn Button Thanh toán") @When("Tap button thanh toán lần 2")
    public void clickPaymentButton() {
        pay = new ActionPayment();
        tapByExactCoordinates(pay.point_BtnPayment.x,pay.point_BtnPayment.y);
    }

    @Then("Hiển thị thanh toán thành công và button chi tiết đơn hàng button về trang chủ")
    public void verifyPaymentSucceed() throws TesseractException {
        waitForOCR(notice_PaymentSuccessCOD);
        assertThat(isTextOnScreen(notice_DetailPaymentSuccessFul))
                .as("Kiểm tra thông báo thanh toán thành công").isTrue();
        assertThat(displayed(pay.button_OrderDetail))
                .as("Kiểm tra nút chi tiết đơn hàng").isTrue();
        assertThat(displayed(pay.button_ReturnHomeMenu))
                .as("Kiểm tra nút về trang chủ").isTrue();
    }

    @When("Tại màn hình dịch vụ sau khi gói dịch trên combo gợi ý cho bạn")
    public void atServiceScreenWithSelectedLocation() throws IOException, TesseractException {
        loginAppAndNavigateToServiceScreen();
        selectLocationForServices(text_Address);
        selectSuggestComboInternet();
        waitFor(sell.dynamic_finder(title_customerInformation));
    }

    @Then("Hiển thị màn hình tạo đơn hàng và tab thông dịch vụ đã chọn")
    public void verifyOrderCreationScreen() throws TesseractException {
        assertThat(isTextOnScreen(title_CreateOther))
                .as("Kiểm tra hiển thị màn hình tạo đơn hàng").isTrue();
        assertThat(isTextOnScreen(title_ServiceInfo))
                .as("Kiểm tra thông dịch vụ đã chọn").isTrue();
    }

    @When("Nhấn button chi tiết")
    public void clickDetailButton() {
        clickToElement(sell.button_Detail);
    }

    @Then("Hiển thị màn hình chi tiết")
    public void verifyDetailScreen() {
        assertThat(displayed(sell.dynamic_finder(title_ShoppingCartScreen)))
                .as("Kiểm tra hiển thị màn hình chi tiết").isTrue();
    }

    @Given("Tại màn hình dịch vụ dịch vụ sau khi chọn thông tin gói dịch vụ Internet")
    public void atServiceScreen() throws IOException, TesseractException {
        loginAppAndNavigateToServiceScreen();
        selectLocationForServices(text_Address);
        clickIconInternetAtOptionalCombo();
        selectComboInternet(list_PackageService.get(0).toString(),list_PackageService.get(1).toString());
    }

    @Given("Tại màn hình chi tiết")
    public void accessDetailScreen() throws IOException, TesseractException {
        atServiceScreen();
        accessDetailInfoScreen();
    }

    @When("Nhấn icon xóa dịch vụ")
    public void deleteChosenService() {
        tapByExactCoordinates(sell.point_BtnErasePackage.x,sell.point_BtnErasePackage.y);
    }

    @Then("Xóa dịch vụ ra khỏi màn hình chi tiết")
    public void verifyServicePackageWasClearedFromDetailInfoScreen() {
        assertThat(displayed(sell.dynamic_finder(servicePackage),10))
                .as("Kiểm tra dịch vụ bị xóa ra khỏi màn hình chi tiết").isFalse();
    }

    @When("Tab vào dịch vụ Internet")
    public void clickToServiceInternet() {
        waitForTappable(sell.button_Confirm);
        tapByExactCoordinates(sell.point_ServicePackage.x,sell.point_ServicePackage.y);
    }

    @Then("Hiển thị thông tin chi tiết từng dịch vụ")
    public void verifyInfoInternet() throws TesseractException {
        waitForTappable(sell.button_Confirm);
        assertThat(isTextOnScreen(list_PackageService.get(0).toString()))
                .as("Kiểm tra gói dịch vụ").isTrue();
        assertThat(isTextOnScreen(list_PackageService.get(1).toString()))
                .as("Kiểm tra gói cước").isTrue();
    }

    @When("Chọn lại thông tin dịch vụ Internet")
    public void reSelectInternetPackage() throws IOException, TesseractException {
        waitForOCR(title_Internet);
        tapByExactCoordinates(sell.point_DropdownInternetPackage.x,sell.point_DropdownInternetPackage.y);
        waitForOCR(title_ServicePackage);
        tapByExactCoordinates(getWhiteTextCoordinate(list_PackageService2.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PackageService2.get(0).toString(),1,0,70).getY());
        waitForOCR(title_Internet);
        clickToElementByOCR(dropdown_DataPackage);
        waitForOCR(title_DataPackage);
        tapByExactCoordinates(getWhiteTextCoordinate(list_PackageService2.get(1).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PackageService2.get(1).toString(),1,0,70).getY());
        servicePackage = null;
        servicePackage = list_PackageService2.get(0).toString() + " " + list_PackageService2.get(1).toString();
        clickConfirm();
    }

    @Then("Check phép chọn lại gói và hiển thị thông tin sau khi chọn")
    public void verifyPackageServiceChanged() throws TesseractException {
        waitFor(sell.dynamic_finder(title_ShoppingCartScreen));
        assertThat(isTextOnScreen(servicePackage))
                .as("Kiểm tra gói dịch vụ được chọn lại").isTrue();
    }

    @When("Nhấn icon mua thêm")
    public void clickAddMoreService() {
        tapByExactCoordinates(sell.point_BtnAddMoreServices.x,sell.point_BtnAddMoreServices.y);
    }

    @Then("Hiển thị màn hình mua thêm dịch vụ")
    public void verifyBuyMoreServicesScreen() throws TesseractException {
        assertThat(isTextOnScreen(title_BuyMoreServiceScreen))
                .as("Kiểm tra hiển thị màn hình mua thêm dịch vụ").isTrue();
    }

    @When("Tại màn hình Tạo đơn hàng kiểm tra Thông tin địa chỉ") @Given("Tại màn hình Tạo đơn hàng click chọn vùng Thông tin địa chỉ") @Given("Tại màn hình Tạo đơn hàng click chọn Đối tượng khách hàng") @Given("Tại màn hình Tạo đơn hàng Tab về Chọn địa chỉ") @Given("Tại màn hình Tạo đơn hàng Tab về màn hình dịch vụ") @Given("Tại màn hình Tạo đơn hàng đã nhập thông tin khách hàng") @Given("Tại màn hình tạo đơn hàng đã chọn thông tin dịch vụ trước đó") @Given("Tại màn hình Tạo đơn hàng") @Given("Tại màn hình Tạo đơn hàng, Tap Dropdownlist Đối tượng khách hàng") @Given("Tại màn hình Tạo đơn hàng, Kiểm tra các trường Thông tin thanh toán") @When("Tại màn hình đơn hàng kiểm tra Đối tượng khách hàng") @Given("Tại màn hình tạo đơn hàng")
    public void accessOrderCreationScreen() throws IOException, TesseractException {
        atServiceScreen();
        accessDetailInfoScreen();
        clickConfirm();
    }

    @Then("Hiển thị màn hình thông tin địa chỉ mặc địn Tab tìm kiếm")
    public void verifyAddressAtOrderCreationScreen() throws TesseractException {
        waitForOCR(title_CreateOther);
        assertThat(isTextOnScreen(text_Address))
                .as("Kiểm tra thông tin địa chỉ mặc địn Tab tìm kiếm").isTrue();
    }

    @When("Cập nhật lại địa chỉ tại Tab Thông tin địa chỉ") @When("Thay đổi địa chỉ, tỉnh thành") @When("^Thay đổi địa chỉ, Quận/Huyện$") @When("^Thay đổi địa chỉ,Phường/Xã$")
    public void updateAddressFromOrderCreationScreen() throws IOException, TesseractException {
        waitForOCR(title_CreateOther);
        clickToElementByOCR(text_Address,1,0,70);
        waitForOCR(title_AddressInfo);
        clickToElement(sell.dynamic_finder(button_Searching));
        waitForOCR(textBox_AddressSearching);
        inputTextByOcrTech(textBox_AddressSearching,text_Address2);
        clickToElement(sell.dynamic_finder(button_Searching));
        waitForAbsent(sell.dynamic_finder(button_Searching));
        tapByExactCoordinates(sell.point_OptionAddress.x,sell.point_OptionAddress.y);
        waitForAbsent(sell.dynamic_finder(title_AddressSearchScreen));
        tapByExactCoordinates(sell.point_IconAddress .x,sell.point_IconAddress .y);
        waitForAbsent(sell.dynamic_finder(dropdown_AddressDefault));
        waitFor(sell.button_Confirm);
        clickConfirm();
    }

    @Then("Xác nhận thông tin địa chỉ đã chọn. Chuyển người dùng về màn hình Tạo đơn hàng với thông tin địa chỉ mới đã cập nhật") @Then("Hệ thông kiểm tra và hiện thị thông tin đã cập nhật địa chỉ")
    public void verifyAddressUpdatedFromOrderCreationScreen() throws TesseractException {
        waitForOCR(title_CreateOther);
        assertThat(isTextOnScreen(text_Address2))
                .as("Xác nhận thông tin địa chỉ đã chọn").isTrue();
    }

    @When("Kiểm tra tab nhập địa chị")
    public void verifyAddressTabFromOrderCreationScreen() throws IOException, TesseractException {
        waitForOCR(title_CreateOther);
        tapByExactCoordinates(getWhiteTextCoordinate(text_Address,1,0,70).getX(), getWhiteTextCoordinate(text_Address,1,0,70).getY());
        waitFor(sell.dynamic_finder(title_AddressInfo));
    }

    @Then("^Hiển thị thông tin đã chọn/nhập trước đó ở màn hình Dịch vụ$")
    public void verifyAddressGivenBefore() throws TesseractException {
        assertThat(isTextOnScreen(list_Address.get(0).toString()))
                .as("Kiểm tra thông tin đã chọn/nhập trước đó").isTrue();
        assertThat(isTextOnScreen(list_Address.get(1).toString()))
                .as("Kiểm tra thông tin đã chọn/nhập trước đó").isTrue();
    }

    @When("Kiểm tra thông tin Đối tượng khách hàng đã chọn") @Then("Hiên thị thông tin Đối tượng khách hàng đã chọn ở màn hình Dịch vụ")
    public void verifyCusTypeSelectedBefore() throws TesseractException {
        waitForOCR(title_CreateOther);
        assertThat(isTextOnScreen(list_CusTypeIndividual.get(0).toString()))
                .as("Kiểm tra thông tin Đối tượng khách hàng đã chọn").isTrue();
    }

    @And("Nhấn chọn lại Đối tượng khác hàng khác không được phép bán hàng") @When("Chọn lại đối tượng khách hàng")
    public void updateCusType() throws IOException {
        tapByExactCoordinates(getWhiteTextCoordinate(list_CusTypeIndividual.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_CusTypeIndividual.get(0).toString(),1,0,70).getY());
        tapByExactCoordinates(getWhiteTextCoordinate(list_CusType.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_CusType.get(0).toString(),1,0,70).getY());
    }

    @Then("^Disable Loại hình/ Loại KH không được phép bán$") @Then("Hiển thị thông tin đã cập nhật")
    public void verifyCusTypeChanged() throws TesseractException {
        assertThat(isTextOnScreen(list_CusTypeOrganization.get(0).toString()))
                .as("Kiểm tra đối tượng khách hàng đã đổi").isTrue();
    }

    @When("Không thay đổi địa chỉ nhấn quay lại màn hinh Tạo đơn hàng")
    public void accessUpdateAddressScreenButReturnWithoutChanged() throws IOException, TesseractException {
        verifyAddressTabFromOrderCreationScreen();
        clickConfirm();
    }

    @Then("App vẫn giữ nguyên thông tin Màn hình Tạo đơn hàng")
    public void verifyAddressNotUpdated() throws TesseractException {
        assertThat(isTextOnScreen(text_Address))
                .as("App vẫn giữ nguyên thông tin Màn hình Tạo đơn hàng").isTrue();
    }

    @When("Không thay đổi thông tin quay lại màn hinh Tạo đơn hàng")
    public void accessUpdateServiceScreenButReturnWithoutChanged() {
        clickToElement(sell.dynamic_finder(title_Detail));
        waitFor(sell.dynamic_finder(title_Detail));
        clickConfirm();
        waitFor(sell.dynamic_finder(title_Detail));
    }

    @Then("App vẫn giữ nguyên thông tin dịch vụ tại Màn hình Tạo đơn hàng")
    public void verifyServiceNotUpdated() throws TesseractException {
        assertThat(isTextOnScreen(servicePackage))
                .as("App vẫn giữ nguyên thông tin dịch vụ tại Màn hình Tạo đơn hàng").isTrue();
    }

    @Then("Không cập nhật thông tin khách hàng và nhấn button tạo đơn hàng")
    public void notSupplyCusInfoAndClickCreateOrder() throws TesseractException {
        clickToElement(sell.dynamic_finder(button_OrderCreation));
        assertThat(isTextOnScreen(notification_InsufficientCusInfo))
                .as("Kiểm tra thông báo thiếu thông tin khách hàng").isTrue();
    }

    @Then("^App show popup thông báo \\'Địa chỉ và CMND\\/CCCD\\/Mã số thuế này đã được sử dụng trước đó. Bạn có muốn tiếp tục tạo đơn hàng không\\?\\'$")
    public void verifyNotificationPrivateInfoUsedBefore() throws TesseractException {
        assertThat(isTextOnScreen(notification_PrivateInfoUsedBefore))
                .as("Kiểm tra thông báo CMND đã được sử dụng").isTrue();
    }

    @When("Nhập thông tin đã được sử dụng trước đó")
    public void inputIDCardUsedBefore() throws IOException, TesseractException {
        waitFor(sell.dynamic_finder(title_customerInformation));
        clickToElement(sell.button_UpdateInfo);
        waitFor(sell.button_addIdCardImage);
        sell.addIdentifyCard();
        sell.pickGender(list_GenderOption.get(0).toString());
        sell.inputPhone(input_Phone);
        clickToElement(sell.button_ConfirmAndSave);
    }

    @When("Cập nhật thông tin khách hàng")
    public void updateCusInfoButDoNotSave() throws IOException, TesseractException {
        waitFor(sell.dynamic_finder(title_customerInformation));
        clickToElement(sell.button_UpdateInfo);
        waitFor(sell.button_addIdCardImage);
        sell.addIdentifyCard();
        sell.pickGender(list_GenderOption.get(0).toString());
        sell.inputPhone(input_Phone);
    }

    @And("Thay đổi thông tin khách hàng")
    public void changeCusInfo() throws IOException, TesseractException {
        clickToElement(sell.dynamic_finder(button_ChangeIDImage));
        sell.addIdentifyCard();
    }

    @Then("Hiển thị thông tin khách hàng đã thay đổi")
    public void verifyCusInfoChanged() throws TesseractException {
        assertThat(isTextOnScreen(list_InfoFromID2.get(0).toString()))
                .as("Hiển thị thông tin khách hàng đã thay đổi").isTrue();
    }

    @Given("Tại màn hình Thông tin đơn hàng Tap button Chi tiết và Không cập nhật thông tin ở màn hình Chi tiết")
    public void clickDetailButtonAtOrderCreationScreen() throws IOException, TesseractException {
        accessOrderCreationScreen();
        waitForOCR(title_CreateOther);
        clickToElement(sell.dynamic_finder(title_Detail));
        waitFor(sell.dynamic_finder(title_Detail));
    }

    @Then("Thông tin tại màn hình Tạo đơn hàng không đổi")
    public void verifyInfoAtOrderCreationNotChanged() throws TesseractException {
        assertThat(isTextOnScreen(servicePackage))
                .as("Kiểm tra thông tin gói dịch vụ không đổi").isTrue();
    }

    @When("Cập nhật thông tin tại màn hình Chi tiết")
    public void updateInfoInternet() throws IOException, TesseractException {
        waitForOCR(title_CreateOther);
        clickToElement(sell.dynamic_finder(title_Detail));
        waitFor(sell.dynamic_finder(title_Detail));
        clickToServiceInternet();
        reSelectInternetPackage();
        clickConfirm();
    }

    @Then("^Cập nhật lại thông tin sản phẩm/ dịch vụ theo câu lệnh giá của chính sách phù hợp$")
    public void verifyInfoInternetUpdated() throws TesseractException {
        waitForOCR(title_CreateOther);
        scrollDownUntilTextVisible(servicePackage,10);
        assertThat(isTextOnScreen(servicePackage))
                .as("Kiểm tra thông tin đã được cập nhật").isTrue();
    }

    @When("Chọn Đối tượng khách hàng là Doanh nghiệp")
    public void selectCusTypeOrganization() throws IOException, TesseractException {
        waitForTappable(sell.button_Detail);
        scrollDownUntilTextVisible(list_CusTypeIndividual.get(0).toString(),10);
        tapByExactCoordinates(getWhiteTextCoordinate(list_CusTypeIndividual.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_CusTypeIndividual.get(0).toString(),1,0,70).getY());
        tapByExactCoordinates(getWhiteTextCoordinate(list_CusType.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_CusType.get(0).toString(),1,0,70).getY());
    }

    @When("Hiển thị Data được chọn tại Dropdownlist")
    public void verifyCusTypeOrganizationWasChosen() throws TesseractException {
        waitForOCR(title_CreateOther);
        assertThat(isTextOnScreen(list_CusType.get(0).toString()))
                .as("Hiển thị Data được chọn tại Dropdown").isTrue();
    }

    @Then("Hiển thị các thông tin gồm: - Tổng tiền - Chiết khấu - Voucher -Thành tiền")
    public void verifyPaymentInfoField() throws TesseractException {
        waitForOCR(title_CreateOther);
        scrollDownUntilTextVisible(list_PaymentInfoField.get(3).toString(),10);
        assertThat(isTextOnScreen(list_PaymentInfoField.get(0).toString()))
                .as("Kiểm tra voucher").isTrue();
        assertThat(isTextOnScreen(list_PaymentInfoField.get(1).toString()))
                .as("Kiểm tra tổng tiền").isTrue();
        assertThat(isTextOnScreen(list_PaymentInfoField.get(2).toString()))
                .as("Kiểm tra chiết khấu").isTrue();
        assertThat(isTextOnScreen(list_PaymentInfoField.get(3).toString()))
                .as("Kiểm tra thành tiền").isTrue();
    }

    @Given("Tại màn hình Tạo đơn hàng, Tap button Cập nhật")
    public void accessOrderCreationScreenAndChangeCusTypeToOrganization() throws IOException, TesseractException {
        accessOrderCreationScreen();
        selectCusTypeOrganization();
    }

    @When("^Tap Button Thêm ảnh và thêm ảnh \\(Tối đa 5 ảnh\\)$")
    public void addFileImage() throws IOException, InterruptedException, TesseractException {
        waitForOCR(title_customerInformation);
        clickToElement(sell.button_UpdateInfo);
        clickToElement(sell.button_addIdCardImage);
        sell.clickFileImage();
        sell.addImage(PropertyUtils.getProperty("image.additional.file"));
        clickConfirm();
    }

    @And("^Nhập (.*) vào Tên tổ chức/doanh nghiệp$")
    public void inputOrganizationName(String organizationName) throws TesseractException {
        organizationName = ParameterService.INSTANCE.getString("DS_TenToChucDN",organizationName);
        scrollDownUntilTextVisible(textBox_InputOrganizeName,10);
        inputTextByOcrTech(textBox_InputOrganizeName,organizationName,4,2);
        waitFor(sell.dynamic_finder(organizationName));
    }

    @And("^Nhập ([0-9.]*) vào Mã số thuê/Mã số ĐKKD$")
    public void inputTaxCode(int taxCode) throws ParameterFormatException, TesseractException {
        taxCode = ParameterService.INSTANCE.getInt("DS_MaSoThue",taxCode);
        scrollDownUntilTextVisible(textBox_TaxCode,10);
        inputTextByOcrTech(textBox_TaxCode, String.valueOf(taxCode),4,1);
        waitFor(sell.dynamic_finder(String.valueOf(taxCode)));
    }

    @And("Nhập {string} và {string} vào Ngày cấp và Nơi cấp")
    public void inputDateAndPlaceIssue(String dateIssue, String placeIssue) throws TesseractException, IOException {
        dateIssue = ParameterService.INSTANCE.getString("DS_MaSoThue",dateIssue);
        placeIssue = ParameterService.INSTANCE.getString("DS_MaSoThue",placeIssue);
        scrollDownUntilTextVisible(textBox_DateIssue,10);
        tapByExactCoordinates(getWhiteTextCoordinate(textBox_DateIssue,4,1,70).getX(),getWhiteTextCoordinate(textBox_DateIssue,4,1,70).getY());
        sell.pickDateFromCalendar();
        inputTextByOcrTech(textBox_PlaceIssue,placeIssue,4,1);
        waitFor(sell.dynamic_finder(placeIssue));
    }

    @And("Nhập {string} vào Ngày thành lập")
    public void inputDateOfPublish(String datePublished) throws TesseractException, IOException {
        datePublished = ParameterService.INSTANCE.getString("DS_NgayThanhLap",datePublished);
        scrollDownUntilTextVisible(textBox_DateOfPublish,10);
        tapByExactCoordinates(getWhiteTextCoordinate(textBox_DateOfPublish,4,2,70).getX(),getWhiteTextCoordinate(textBox_DateOfPublish,4,2,70).getY());
        sell.pickDateFromCalendar();
    }

    @And("Nhập {string} vào Địa chỉ trên GPKD")
    public void inputAddressOnLicense(String addressOnLicense) throws TesseractException {
        addressOnLicense = ParameterService.INSTANCE.getString("DS_DiaChiTrenGPKD",addressOnLicense);
        scrollDownUntilTextVisible(title_AddressBusinessAllowance,10);
        inputTextByOcrTech(title_AddressBusinessAllowance,addressOnLicense,4,0);
        waitFor(sell.dynamic_finder(addressOnLicense));
    }

    @And("^Nhập ([0-9.]*) vào Số điện thoại tổ chức/doanh nghiệp$")
    public void inputOrganizationPhone(int phone) throws ParameterFormatException, TesseractException {
        phone = ParameterService.INSTANCE.getInt("DS_SDTToChuc",phone);
        scrollDownUntilTextVisible(title_OrganizePhone,10);
        inputTextByOcrTech(title_OrganizePhone, String.valueOf(phone),4,1);
        waitForAbsent(sell.dynamic_finder(title_OrganizePhone));
    }

    @And("Nhập {int} vào Số điện thoại giao dịch, liên hệ")
    public void inputTradingPhone(int tradingPhone) throws ParameterFormatException, TesseractException {
        tradingPhone = ParameterService.INSTANCE.getInt("DS_SDTLienHe",tradingPhone);
        scrollDownUntilTextVisible(title_Mail,10);
        inputTextByOcrTech(textBox_InputPhone, String.valueOf(tradingPhone),4,2);
        waitForAbsent(sell.dynamic_finder(textBox_InputPhone));
    }

    @And("Nhập {string} vào Họ tên người đại diện")
    public void inputRepresentativeName(String name) throws TesseractException {
        name = ParameterService.INSTANCE.getString("DS_HoTenNguoiDaiDien",name);
        scrollDownUntilTextVisible(textBox_InputName,10);
        inputTextByOcrTech(textBox_InputName,name,4,1);
    }

    @Then("Quay về màn hình Tạo đơn hàng và thông tin {string}, {int}, {int} được lưu tại màn hình Tạo đơn hàng")
    public void appNavigateToOrderCreationScreenAndUpdateOrganizeInfo(String organizationName, int taxCode, int phone) throws ParameterFormatException, TesseractException {
        organizationName = ParameterService.INSTANCE.getString("DS_TenToChucDN",organizationName);
        taxCode = ParameterService.INSTANCE.getInt("DS_MaSoThue",taxCode);
        phone = ParameterService.INSTANCE.getInt("DS_SDTToChuc",phone);
        assertThat(isTextOnScreen(title_CreateOther))
                .as("Kiểm tra hệ thống quay về màn hình Tạo đơn hàng").isTrue();
        assertThat(isTextOnScreen(organizationName))
                .as("Kiểm tra tên tổ chức được cập nhật").isTrue();
        assertThat(isTextOnScreen(String.valueOf(taxCode)))
                .as("Kiểm tra MST tổ chức được cập nhật").isTrue();
        assertThat(isTextOnScreen(String.valueOf(phone)))
                .as("Kiểm tra SDT tổ chức được cập nhật").isTrue();
    }

    @Then("Hiện thị màn hình nhập thông tin khách hàng")
    public void verifyCusInfoScreen() throws TesseractException {
        assertThat(isTextOnScreen(title_customerInformation))
                .as("Hiện thị màn hình nhập thông tin khách hàng").isTrue();
    }

    @Then("Hiển thị màn hình thông tin khách hàng các field về khách hàng cá nhân") @Then("Kiểm tra các trường bắt buộc của loại hình khách hàng cá nhân")
    public void verifyFieldsForPrivateCus() throws TesseractException {
        sell.checkRequestedField(list_RequestedTitlePrivateCus);
    }

    @When("Tại màn hình thông tin khách hàng cá nhân")
    public void accessToUpdateCusInfoScreen() throws IOException, TesseractException {
        accessOrderCreationScreen();
        clickUpdatePrivateInfoButton();
    }

    @And("Kiểm tra thông tin hiển thị dịch vụ")
    public void verifyServiceInfoBlock() throws TesseractException {
        waitForOCR(title_CreateOther);
        scrollDownUntilTextVisible(title_ServiceInfo,10);
    }

    @Then("Hiển thị danh sách thông tin theo block từng dịch vụ")
    public void verifyBlockServiceAndDevices() throws TesseractException {
        scrollDownUntilTextVisible(servicePackage,10);
        assertThat(isTextOnScreen(servicePackage))
                .as("Kiểm tra thông tin block dịch vụ").isTrue();
        scrollDownUntilTextVisible(text_DeviceName,10);
        assertThat(isTextOnScreen(text_DeviceName))
                .as("Kiểm tra thông tin thiết bị").isTrue();
    }

    @When("Nhấn icon chỉnh sửa tại tiền dịch vụ")
    public void clickEditPackage() throws TesseractException {
        scrollDownUntilTextVisible(servicePackage,10);
        clickToElement(sell.button_EditPackage);
    }

    @And("Kiểm tra popup danh sách câu lệch giá")
    public void verifyPriceCommandPopup() throws TesseractException {
        waitForOCR(title_ListPriceCommand);
        assertThat(isTextOnScreen(title_ListPriceCommand))
                .as("Kiểm tra popup danh sách câu lệch giá").isTrue();
    }

    @Then("Hiển thị danh sách câu lệch giá theo chính sách trả ra")
    public void verifyListOfPriceCommand() throws TesseractException {
        assertThat(isTextOnScreen(text_PriceCommand))
                .as("Kiểm tra câu lệnh giảm giá").isTrue();
    }

    @When("Chọn câu lệnh giá")
    public void clickPriceCommand() {
        tapByExactCoordinates(sell.point_OptionPriceCommand.x,sell.point_OptionPriceCommand.y);
    }

    @Then("^Hiển thị câu lệnh giá đã chọn với text \\' Cập nhật giá\\'$")
    public void verifyResultAfterPriceCommandSelected() {
        assertThat(displayed(sell.dynamic_finder(title_ResultAfterPriceCommandSelected),10))
                .as("Kiểm tra thông báo câu lệnh giá được chọn").isTrue();
    }

    @Given("Click vào thẻ thông tin KH sau khi cập nhật thông tin KH")
    public void clickUpdateToViewGivenInfo() throws IOException, TesseractException {
        accessOrderCreationScreen();
        clickUpdatePrivateInfoButton();
        inputCusInfo();
        clickConfirmAndSave();
        waitFor(sell.dynamic_finder(title_customerInformation));
    }

    @Then("Hiển thị đầy đủ thông tin khách hàng đã nhập")
    public void verifyCusInfoInputted() throws TesseractException {
        scrollDownUntilTextVisible(list_InfoFromID.get(0).toString(),10);
        assertThat(isTextOnScreen(list_InfoFromID.get(0).toString()))
                .as("Kiểm tra tên").isTrue();

        scrollDownUntilTextVisible(list_InfoFromID.get(1).toString(),10);
        assertThat(isTextOnScreen(list_InfoFromID.get(1).toString()))
                .as("Kiểm tra ngày sinh").isTrue();

        scrollDownUntilTextVisible(list_InfoFromID.get(0).toString(),10);
        assertThat(isTextOnScreen(list_InfoFromID.get(2).toString()))
                .as("Kiểm tra CMND").isTrue();

        scrollDownUntilTextVisible(list_InfoFromID.get(0).toString(),10);
        assertThat(isTextOnScreen(list_InfoFromID.get(3).toString()))
                .as("Kiểm tra ngày cấp CMND").isTrue();
    }

    @Then("Hiển thị đầy đủ thông tin khách hàng người dùng đã nhập. Các thông tin người dùng không nhập sẽ không được hiển thị trên màn hình này.")
    public void verifyGivenInfoVisibleAndNoneInputted() throws TesseractException {
        verifyCusInfoInputted();
        scrollDownUntilTextVisible(textBox_Mail,10);
        assertThat(isTextOnScreen(textBox_Mail))
                .as("Trường thông tin không nhập").isTrue();
    }

    @When("Tap droplist Hình thức thanh toán hàng tháng")
    public void findAndClickOnMonthlyPaymentWayDropDown() throws TesseractException, IOException {
        waitForOCR(title_CreateOther);
        scrollDownUntilTextVisible(list_WayOfPaymentMonthly.get(0).toString(),10);
        tapByExactCoordinates(getWhiteTextCoordinate(list_WayOfPaymentMonthly.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_WayOfPaymentMonthly.get(0).toString(),1,0,70).getY());
    }

    @When("Hiển thị popup Danh sách Hình thức thanh toán cước hàng tháng")
    public void verifyMonthlyPaymentWayDropDown() throws TesseractException {
        assertThat(isTextOnScreen(title_MonthlyPaymentWayDropdown))
                .as("Hiển thị popup Danh sách Hình thức thanh toán cước hàng tháng").isTrue();
    }

    @When("Chọn option {string} trong Danh sách")
    public void selectOptionMonthlyPaymentWayDropDown(String method) throws TesseractException, IOException {
        method = ParameterService.INSTANCE.getString("DS_HinhThucThanhToanCuoc",method);
        findAndClickOnMonthlyPaymentWayDropDown();
        clickToElement(sell.dynamic_finder(method));
    }

    @Then("Kiểm tra hiển thị {string} được chọn trên giao diện")
    public void verifyOptionMonthlyPaymentWaySelected(String method) throws TesseractException {
        method = ParameterService.INSTANCE.getString("DS_HinhThucThanhToanCuoc",method);
        assertThat(isTextOnScreen(method))
                .as("Kiểm tra hình thức thanh toán hàng tháng đã được chọn").isTrue();
    }

    @Given("Tại màn hình Tạo đơn hàng với loại dịch vụ không có hình thức thanh toán cước hàng tháng")
    public void accessOrderCreationScreenWith() throws IOException, TesseractException {
        loginAppAndNavigateToServiceScreen();
        selectLocationForServices(text_Address);
        scrollDownUntilTextVisible(title_OtherProduct,10);
        tapByExactCoordinates(getWhiteTextCoordinate(title_OtherProduct,1,0,70).getX(),getWhiteTextCoordinate(title_OtherProduct,1,0,70).getY());
        selectOtherProduct(list_ServiceOfOtherProduct.get(0).toString(),list_ServiceOfOtherProduct.get(1).toString(),list_ServiceOfOtherProduct.get(2).toString());
        accessDetailInfoScreen();
        clickConfirm();
    }

    @Then("^Hiển thị mặc định \\'Không có thanh toán cước\\'$")
    public void verifyServiceNotHaveMonthlyPayment() throws TesseractException {
        waitForOCR(title_CreateOther);
        scrollDownUntilTextVisible(text_NoneMonthlyPaymentWay,10);
        assertThat(isTextOnScreen(text_NoneMonthlyPaymentWay))
                .as("Kiểm tra hiển thị hình thức thanh toán cước hàng tháng mặc định").isTrue();
    }

    @When("Kiểm tra giá trị mặc định chọn Phương thưc thanh toán")
    public void scrollToFindPaymentMethod() throws TesseractException {
        waitForOCR(title_CreateOther);
        scrollDownUntilTextVisible(list_PaymentWay.get(0).toString(),10);
    }

    @Then("Phương thưc thanh toán mặc định là Tiền mặt")
    public void verifyDefaultPaymentMethod() throws TesseractException {
        assertThat(isTextOnScreen(list_PaymentWay.get(0).toString()))
                .as("Phương thưc thanh toán mặc định là Tiền mặt").isTrue();
    }

    @When("Chọn Phương thưc thanh toán")
    public void changePaymentMethod() throws IOException {
        tapByExactCoordinates(getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getY());
        tapByExactCoordinates(getWhiteTextCoordinate(list_PaymentWay.get(1).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PaymentWay.get(1).toString(),1,0,70).getY());
    }

    @Then("Cho phép chọn PTTT có trong danh sách trả về. Gía trị được chọn được in đậm và có dấu tích chọn")
    public void verifyPaymentMethodChanged() throws TesseractException {
        assertThat(isTextOnScreen(list_PaymentWay.get(1).toString()))
                .as("PTTT mới đã được chọn").isTrue();
    }

    @When("Click popup PTTT")
    public void clickPopupPTTT() throws TesseractException, IOException {
        scrollToFindPaymentMethod();
        tapByExactCoordinates(getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getY());
        waitFor(sell.dynamic_finder(title_PaymentMethod));
    }

    @And("Tap buton X")
    public void tapButtonX() {
        tapByExactCoordinates(sell.point_IconXPaymentMethod.x,sell.point_IconXPaymentMethod.y);
    }

    @Then("Đóng popup Phương thưc thanh toán Hiển thị Phương thức thanh toán đã chọn")
    public void verifyPaymentMethodClosed() throws TesseractException {
        assertThat(isTextOnScreen(title_PaymentMethod))
                .as("Đóng popup Phương thưc thanh toán").isFalse();
    }

    @Given("Tại màn hình thanh toán với dịch vụ Smart Home")
    public void accessOrderCreationScreenWithSmartHome() throws IOException, TesseractException {
        loginAppAndNavigateToServiceScreen();
        selectLocationForServices(text_Address);
        waitForOCR(title_AddressInfo);
        scrollDownUntilTextVisible(title_SmartHome,10);
        clickToElement(sell.dynamic_finder(title_SmartHome));
        selectComboSmartHome(text_DeviceSmartHome);
        accessDetailInfoScreen();
        clickConfirm();
    }

    @When("Cập thêm thông tin tại màn hình Tạo đơn hàng và nhấn tạo đơn hàng")
    public void updateMoreInfoFromOrderCreationScreen() throws IOException, TesseractException {
        waitForOCR(title_CreateOther);
        clickToElement(sell.button_UpdateInfo);
        waitFor(sell.button_addIdCardImage);
        sell.addIdentifyCard();
        sell.pickGender(list_GenderOption.get(0).toString());
        sell.inputPhone(input_Phone);
        clickToElement(sell.button_ConfirmAndSave);
        waitForOCR(title_CreateOther);
        tapByExactCoordinates(getWhiteTextCoordinate(option_CashPayment,1,0,70).getX(),getWhiteTextCoordinate(option_CashPayment,1,0,70).getY());
        tapByExactCoordinates(getWhiteTextCoordinate(option_CODCashPayment,1,0,70).getX(),getWhiteTextCoordinate(option_CODCashPayment,1,0,70).getY());
        bond = new ActionContractCreation();
        tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
    }

    @Then("^Hiển thị thông báo \\'Đơn hàng đã được tạo khoản thu COD. Vui lòng kiểm tra lại.\\'$")
    public void verifyCODHasBeenExisted() throws TesseractException {
        waitForOCR(notification_CODHasBeenExisted);
        assertThat(isTextOnScreen(notification_CODHasBeenExisted))
                .as("Hiển thị khoản thu đã tồn tại").isTrue();
    }

    @Then("Gửi thông báo thanh toán thành công và chuyển sang màn hình thông báo thanh toán thành công với mã đơn hàng và số tiền tương ứng") @Then("Hiển thị màn hình Thanh toán thành công") @When("Check TH thanh toán thành công") @Then("Khi có tín hiệu thanh toán thành công thì mới gửi thông báo thanh toán thành công và chuyển sang màn hình thông báo thanh toán thành côngvới mã đơn hàng và số tiền tương ứng")
    public void verifyPaymentSucceedSmartHome() throws TesseractException {
        waitForOCR(notification_PaymentSucceed);
        assertThat(isTextOnScreen(notification_PaymentSucceed))
                .as("Kiểm tra thanh toán thành công").isTrue();
    }

    @Given("Tại màn hình Thông tin đơn hàng")
    public void accessOrderInfoScreen() throws IOException, TesseractException {
        accessOrderCreationScreen();
        clickUpdatePrivateInfoButton();
        inputCusInfo();
        clickConfirmAndSave();
        waitForOCR(title_CreateOther);
        bond = new ActionContractCreation();
        waitForTappable(bond.button_Update);
        tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
    }

    @Given("Tại màn hình Thanh toán với Hình thức thanh toán là MB Bank")
    public void clickPayAtPaymentScreenWithMBBankPayment() throws IOException, TesseractException {
        accessOrderCreationScreen();
        waitForOCR(title_CreateOther);
        clickUpdatePrivateInfoButton();
        inputCusInfo();
        clickConfirmAndSave();
        waitForOCR(title_CreateOther);
        tapByExactCoordinates(getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getY());
        tapByExactCoordinates(getWhiteTextCoordinate(list_PaymentWay.get(2).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PaymentWay.get(2).toString(),1,0,70).getY());
        waitForOCR(title_CreateOther);
        bond = new ActionContractCreation();
        waitForTappable(bond.button_Update);
        tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
        sell.clearUnPaidContractWarning();
        waitFor(bond.dynamic_finder(title_DetailOrderScreen));
        clickCreateContractButton();
        waitForOCR(title_ContractInformation);
    }

    @Given("Tại màn hình Thanh toán với Hình thức thanh toán là Tiền mặt")
    public void clickPayAtPaymentScreenWithCash() throws IOException, TesseractException {
        accessOrderCreationScreen();
        clickUpdatePrivateInfoButton();
        inputCusInfo();
        clickConfirmAndSave();
        waitForOCR(title_CreateOther);
        bond = new ActionContractCreation();
        tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
        sell.clearUnPaidContractWarning();
        waitFor(bond.dynamic_finder(title_DetailOrderScreen));
        clickCreateContractButton();
        waitForOCR(title_ContractInformation);
    }

    @Then("Chuyển sang màn hình FPT Telecom Payment Gateway") @Then("Chuyển sang màn hình Thanh toán bằng QR Code")
    public void verifyNavigationToFPTTelecomPaymentGateway() throws TesseractException {
        waitForOCR(notification_NavigateToFPTPaymentGateway);
        assertThat(isTextOnScreen(notification_NavigateToFPTPaymentGateway))
                .as("Kiểm tra hiển thị thông báo điều hướng sang cổng thanh toán FPT Payment Gateway").isTrue();
    }

    @Given("Tại màn hình thanh toán , Tap button thanh toán lần 1")
    public void paymentContractFirstTime() throws IOException, TesseractException {
        clickPayAtPaymentScreenWithMBBankPayment();
        waitForOCR(title_ContractInformation);
        clickPaymentButton();
        waitForOCR(notification_NavigateToFPTPaymentGateway);
        clickConfirm();
    }

    @Then("App show thông báo trong 1 popup notification 1 nút Đóng: 'Đang trong thời gian kiểm tra thông tin thanh toán. Vui lòng thử lại sau ít phút nữa.'")
    public void verifyPaymentProcessReload() {
        assertThat(displayed(sell.dynamic_finder(notification_PaymentProcessReload)))
                .as("Kiểm tra thông báo thử lại quá trình thanh toán sau ít phút").isTrue();
    }

    @Given("Tại màn hình Thanh toán với Hình thức thanh toán là VNPay hoặc QR FoxPay")
    public void clickPayAtPaymentScreenWithVNPayOrQRFoxPay() throws IOException, TesseractException {
        accessOrderCreationScreen();
        clickUpdatePrivateInfoButton();
        inputCusInfo();
        clickConfirmAndSave();
        waitForOCR(title_CreateOther);
        tapByExactCoordinates(getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PaymentWay.get(0).toString(),1,0,70).getY());
        tapByExactCoordinates(getWhiteTextCoordinate(list_PaymentWay.get(3).toString(),1,0,70).getX(),getWhiteTextCoordinate(list_PaymentWay.get(3).toString(),1,0,70).getY());
        waitForOCR(title_CreateOther);
        bond = new ActionContractCreation();
        tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
        sell.clearUnPaidContractWarning();
        waitFor(bond.dynamic_finder(title_DetailOrderScreen));
        clickCreateContractButton();
        waitForOCR(title_ContractInformation);
    }

    @Given("Tại màn hình Danh sách đơn hàng, Chọn đơn hàng Chưa thanh toán")
    public void createUnpaidOrderAndAccessOrderListScreenWithUnpaidContract() throws IOException, TesseractException {
        loginAppAndNavigateToServiceScreen();
        selectLocationForServices(text_Address);
        clickIconInternetAtOptionalCombo();
        selectComboInternet(list_PackageService.get(0).toString(),list_PackageService.get(1).toString());
        accessDetailInfoScreen();
        clickConfirm();
        waitFor(sell.dynamic_finder(title_AddressInfo));
        clickOrderCreationButton();
        bond = new ActionContractCreation();
        clickCreateContractButton();
        sell.backUntilTextVisible(title_ImplementationProgress);
        clickToElement(sell.dynamic_finder(title_Order));
        waitFor(sell.dynamic_finder(title_OrderTracking));
        tapByExactCoordinates(getWhiteTextCoordinate(title_Unpaid,1,0,70).getX(),getWhiteTextCoordinate(title_Unpaid,1,0,70).getY());
        waitForOCR(title_Payment);
    }

    @When("^Tap button 'Thanh toán'$")
    public void clickPaymentAtContractScreen() {
        pay = new ActionPayment();
        tapByExactCoordinates(pay.point_BtnPayment.x,pay.point_BtnPayment.y);
    }

    @Given("Tại Danh sách đơn hàng, Tap xem chi tiết đơn hàng")
    public void accessOrderListScreenWithPaidContract() throws IOException, TesseractException {
        login = new ActionLogin();
        login.loginApp();
        sell = new ActionGoodsSelling();
        waitForOCR(title_Order);
        clickToElementByOCR(title_Order);
        waitForOCR(title_OrderTracking);
        clickToElementByOCR(title_All);
        waitForOCR(textBox_SearchContract);
        inputTextByOcrTech(textBox_SearchContract,text_PaidContract);
        tapByExactCoordinates(getWhiteTextCoordinate(title_CompletedContract,1,0,70).getX(),getWhiteTextCoordinate(title_CompletedContract,1,0,70).getY());
    }

    @When("Tại màn hình Chi tiết đơn hàng, Check Button thanh toán")
    public void waitForOrderDetailScreen() throws TesseractException {
        waitForOCR(title_OrderDetailScreen);
    }

    @Then("^Ẩn button 'Thanh toán' khi trạng thái thanh toán là 'Đã thanh toán'$")
    public void verifyPaymentButtonAbsentWhenContractWasPaid() throws TesseractException {
        bond = new ActionContractCreation();
        waitForOCR(title_Payment);
        assertThat(isTextOnScreen(title_Payment))
                .as("Ẩn button Thanh toán khi trạng thái thanh toán là Đã thanh toán").isFalse();
    }

    @Given("Tại màn hình Thanh toán, Tap Button thanh toán và thực hiện thanh toán thành công") @Given("Tại màn hình Thanh toán, Tap Button thanh toán")
    public void performPaymentSuccess() throws IOException, TesseractException {
        loginAppAndNavigateToServiceScreen();
        selectLocationForServices(text_Address);
        clickIconInternetAtOptionalCombo();
        selectComboInternet(list_PackageService.get(0).toString(),list_PackageService.get(1).toString());
        accessDetailInfoScreen();
        clickConfirm();
        waitForOCR(title_CreateOther);
        clickUpdatePrivateInfoButton();
        inputCusInfo();
        clickConfirmAndSave();
        bond = new ActionContractCreation();
        waitForTappable(bond.button_Update);
        clickOrderCreationButton();
        sell.clearUnPaidContractWarning();
        waitFor(bond.dynamic_finder(title_DetailOrderScreen));
        clickCreateContractButton();
        waitForOCR(title_ContractInformation);
        pay = new ActionPayment();
        clickPaymentButton();
    }

    @When("^Tap Button 'Chi tiết đơn hàng'$")
    public void clickOrderDetailButton() {
        clickToElement(pay.button_OrderDetail);
    }

    @Then("^Chuyển sang màn hình Thông tin đơn hàng ở tab 'Thông tin đơn hàng'$")
    public void verifyOrderInfoScreen() throws TesseractException {
        waitForOCR(title_OrderInformation);
        assertThat(isTextOnScreen(title_OrderInformation))
                .as("Chuyển sang màn hình Thông tin đơn hàng").isTrue();
    }

    @Given("Tại màn hình Thanh toán, thực hiện thanh toán theo phương thức tiền mặt")
    public void toDoPayCashAtPaymentScreen() throws IOException, TesseractException {
        clickPayAtPaymentScreenWithCash();
        pay = new ActionPayment();
        waitForOCR(title_ContractInformation);
        clickPaymentButton();
    }

    @When("Ở màn hình Thanh toán chờ tín hiệu")
    public void waitingPaymentProgressScreen() throws TesseractException {
        waitForOCR(title_PaymentProgressRunning);
        assertThat(isTextOnScreen(title_PaymentProgressRunning))
                .as("Màn hình chờ thanh toán").isTrue();
    }

    @When("Truy cập book port thủ công")
    public void accessManualBookPortScreen() throws TesseractException, IOException {
        bp = new ActionBookPort();
        bp.accessManualBookPort();
    }

    @And("Nhập thông tin cần thiết và nhấn book port")
    public void inputInfoBookPort() {
        inputTextByOcrTech(texBox_InputDataManualBookPort,list_IndoorOutdoorIndexManualBookPort.get(0).toString(),1,0);
        inputTextByOcrTech(texBox_InputDataManualBookPort,list_IndoorOutdoorIndexManualBookPort.get(1).toString(),1,0);
        clickToElement(bp.button_BookPort);
        clickToElement(bp.button_CompleteBookPort);
    }

    @Given("Tại màn hình Thanh toán, Thực hiện thanh toán theo phương thức tiền mặt")
    public void performPaymentSucceed() throws IOException, TesseractException {
        accessOrderCreationScreen();
        clickUpdatePrivateInfoButton();
        inputCusInfo();
        clickConfirmAndSave();
        bond = new ActionContractCreation();
        tapByExactCoordinates(bond.point_BtnCreateOrder.x,bond.point_BtnCreateOrder.y);
        sell.clearUnPaidContractWarning();
        waitFor(bond.dynamic_finder(title_DetailOrderScreen));
        clickCreateContractButton();
        pay = new ActionPayment();
        waitForOCR(title_ContractInformation);
        clickPaymentButton();
    }

    @Then("Check sau khi xử lý gạch nợ khoản thu và ghi nhận thanh toán thành công")
    public void verifyClearDebt() throws TesseractException, IOException {
        waitFor(pay.dynamic_finder(notice_PaymentSuccessCOD));
        String contractCode = getStringFromOtherString(regex_ContractCode,extractTextFromImage(captureScreenAndReturnFile()));
        clickToElement(pay.dynamic_finder(title_ReturnHomePage));
        staticMinuteWait(5);
        tapByExactCoordinates(getWhiteTextCoordinate(title_Order,1,0,70).getX(),getWhiteTextCoordinate(title_Order,1,0,70).getY());
        clickToElement(sell.button_All);
        inputTextByOcrTech(textBox_SearchContract,contractCode);
        assertThat(isTextOnScreen(title_CompletedContract))
                .as("Check sau khi xử lý gạch nợ khoản thu và ghi nhận thanh toán thành công").isFalse();
    }

    @Given("Tại màn hình tạo đơn hàng Chọn các thông tin bắt buộc")
    public void accessOrderCreationScreenAndInputNeededInfo() throws IOException, TesseractException {
        accessOrderCreationScreen();
        clickToElement(sell.button_UpdateInfo);
        waitFor(sell.button_addIdCardImage);
        sell.addIdentifyCard();
        sell.pickGender(list_GenderOption.get(0).toString());
        sell.inputPhone(input_Phone);
        clickConfirmAndSave();
    }

    @When("Không thực hiện book port")
    public void recallBookPort() {
        bp = new ActionBookPort();
        scrollDownNativeUntilVisible(bp.button_BookPortLink,10);
        clickToElement(bp.button_BookPortLink);
        clickToElement(bp.button_RecallBookPort);
        tapByExactCoordinates(sell.point_BackIcon.x,sell.point_BackIcon.y);
        waitFor(bp.dynamic_finder(title_ManualBookPort));
    }

    @Then("^App show message: 'Vui lòng thực hiện thao tác bookport trước khi tạo đơn hàng.'$")
    public void verifyNotificationNoneBookPort() throws TesseractException {
        assertThat(isTextOnScreen(notification_NoneBookPort))
                .as("Kiểm tra thông báo khi không book port").isTrue();
    }

    @When("Kill app")
    public void killApp() throws Exception {
        System.out.println("kill app");
        CreateDriver.getInstance().closeDriver();
        System.out.println("re-open app");
        CreateDriver.getInstance().setDriver("android",
                "android",
                "local"
        );
    }

    @And("Mở lại app và kiểm tra danh sách đơn hàng")
    public void reOpenApp() throws TesseractException, IOException {
        login.loginApp();
        waitForOCR(title_Order);
        clickToElementByOCR(title_Order);
        waitForOCR(title_AllServicesScreen);
        clickToElement(sell.button_createNew);
    }

    @Then("Hệ thống vẫn lưu lại thông tin đơn hàng trước đó")
    public void verifySystemStoredUncompletedOrder() throws TesseractException {
        waitFor(sell.button_Confirm);
        assertThat(isTextOnScreen(notification_UncompletedOrder))
                .as("Hệ thống vẫn lưu lại thông tin đơn hàng trước đó").isTrue();
    }

    @Given("Truy cập màn hình Dịch vụ")
    public void accessServiceScreenAndTapSearchLocation() throws TesseractException, IOException {
        loginAppAndNavigateToServiceScreen();
        tapByExactCoordinates(sell.point_BtnSearch.x,sell.point_BtnSearch.y);
        waitForOCR(textBox_AddressSearching);
    }

    @Then("Hiển thị popup Internet")
    public void verifyPopupInternet() throws TesseractException {
        assertThat(isTextOnScreen(title_Internet))
                .as("Hiển thị popup Internet").isTrue();
    }

    @Then("Hiển thị thông tin đã chọn ở màn hình Tạo đơn hàng và Highlight Icon Internet tại màn hình Dịch vụ")
    public void verifyExtraServiceChosen() throws TesseractException {
        tapByExactCoordinates(sell.point_BackIcon.x,sell.point_BackIcon.y);
        assertThat(isTextOnScreen(servicePackage))
                .as("Hiển thị thông tin đã chọn").isTrue();
    }

    @And("Truy cập màn hình nhập địa chỉ")
    public void accessInputAddressScreen() throws TesseractException {
        waitForOCR(title_AddressInfo);
        tapByExactCoordinates(sell.point_BtnSearch.x,sell.point_BtnSearch.y);
    }

    @When("Truy cập màn hình Dịch vụ từ màn hình Menu")
    public void accessServiceScreenFromMenuScreen() throws TesseractException, IOException {
        clickToElementByOCR(title_All);
        waitForOCR(title_AllServicesScreen);
        clickToElement(sell.button_createNew);
        sell.clearUnPaidContractWarning();
        waitForOCR(title_AddressInfo);
    }

    @And("Nhập địa chỉ khách hàng")
    public void supplyCusAddress() throws TesseractException {
        selectLocationForServices(text_Address);
    }

    @And("Chọn dịch vụ Smart Home")
    public void selectSmartHomeService() throws TesseractException, IOException {
        waitForOCR(title_AddressInfo);
        scrollDownUntilTextVisible(title_SmartHome,10);
        clickToElement(sell.dynamic_finder(title_SmartHome));
        selectComboSmartHome(text_DeviceSmartHome);
        accessDetailInfoScreen();
        clickConfirm();
    }

    @And("Di chuyển đến màn hình Tạo đơn hàng")
    public void navigateToOrderCreationScreen() throws TesseractException {
        waitForOCR(title_CreateOther);
    }

    @And("Chọn phương thức thanh toán COD")
    public void changeToCODPaymentMethodAndInputNeededInfo() throws TesseractException, IOException {
        clickToElement(sell.button_UpdateInfo);
        waitFor(sell.button_addIdCardImage);
        sell.addIdentifyCard();
        sell.pickGender(list_GenderOption.get(0).toString());
        sell.inputPhone(input_Phone);
        clickToElement(sell.button_ConfirmAndSave);
        waitForOCR(title_CreateOther);
        tapByExactCoordinates(getWhiteTextCoordinate(option_CashPayment,1,0,70).getX(),getWhiteTextCoordinate(option_CashPayment,1,0,70).getY());
        tapByExactCoordinates(getWhiteTextCoordinate(option_CODCashPayment,1,0,70).getX(),getWhiteTextCoordinate(option_CODCashPayment,1,0,70).getY());
    }

    @Then("^Hiển thị message: 'Đã xảy ra lỗi trong quá trình tạo đơn hàng Vui lòng thử lại.'$")
    public void verifyErrorMessageWithCODPayment() {
        assertThat(displayed(bond.dynamic_finder(notification_ErrorMessageCreateOrder)))
                .as("Kiểm tra message lỗi").isTrue();
    }

    @And("^Chọn dịch vụ Smart Home với tổng tiền bằng 0$")
    public void selectSmartHomeServiceWithZeroCost() throws TesseractException, IOException {
        waitForOCR(title_AddressInfo);
        scrollDownUntilTextVisible(title_SmartHome,10);
        clickToElement(sell.dynamic_finder(title_SmartHome));
        waitForTappable(sell.button_Confirm);
        tapByExactCoordinates(getWhiteTextCoordinate(dropdown_Device,1,1,70).getX(),getWhiteTextCoordinate(dropdown_Device,1,1,70).getY());
        waitForOCR(title_SmartHome);
        clickToElement(sell.dynamic_finder(text_DeviceSmartHomeZeroCost));
        waitForOCR(title_SmartHome);
        inputTextByOcrTech(texBox_DeviceQuantity,text_SmartHomeDeviceQuantity,4,0);
        waitForOCR(text_SmartHomeDeviceQuantity);
        tapByExactCoordinates(getWhiteTextCoordinate(dropdown_ImplementationUnit,4,0,70).getX(),getWhiteTextCoordinate(dropdown_ImplementationUnit,4,0,70).getY());
        clickToElement(sell.dynamic_finder(option_TINAndPNC));
        waitForOCR(title_SmartHome);
        clickConfirm();
        accessDetailInfoScreen();
        clickConfirm();
    }

    @Then("^Hiển thị message: 'Tổng tiền dịch vụ\\/sản phẩm phải lớn hơn 0 đồng thì được phép sử dụng phương thức thanh toán COD.'$")
    public void verifyErrorMessageWithZeroPaymentCOD() {
        assertThat(displayed(bond.dynamic_finder(notification_ErrorMessageZeroCost)))
                .as("Kiểm tra message lỗi").isTrue();
    }

    @And("^Chọn dịch vụ không triển khai TIN\\/PNC$")
    public void selectSmartHomeServiceWithoutTIN() throws TesseractException, IOException {
        waitForOCR(title_AddressInfo);
        scrollDownUntilTextVisible(title_SmartHome,10);
        clickToElement(sell.dynamic_finder(title_SmartHome));
        waitForTappable(sell.button_Confirm);
        tapByExactCoordinates(getWhiteTextCoordinate(dropdown_Device,1,1,70).getX(),getWhiteTextCoordinate(dropdown_Device,1,1,70).getY());
        waitForOCR(title_SmartHome);
        clickToElement(sell.dynamic_finder(text_DeviceSmartHomeWithoutTIN));
        waitForOCR(title_SmartHome);
        inputTextByOcrTech(texBox_DeviceQuantity,text_SmartHomeDeviceQuantity,4,0);
        waitForOCR(text_SmartHomeDeviceQuantity);
        clickConfirm();
        accessDetailInfoScreen();
        clickConfirm();
    }

    @Then("^Hiển thị message: 'Đơn hàng phải tồn tại dịch vụ\\/sản phẩm có triển khai và không có các hình thức triển khai là sale giao hoặc đối tác giao hàng thì được phép sử dụng phương thức thanh toán COD.'$")
    public void verifyErrorMessageWithoutTIN() {
        assertThat(displayed(bond.dynamic_finder(notification_ErrorMessageWithoutTIN)))
                .as("Kiểm tra message lỗi").isTrue();
    }

    @Then("^Hiển thị message: 'Bạn không được phép sử dụng phương thức thanh toán này'$")
    public void verifyErrorMessage() {
        assertThat(displayed(bond.dynamic_finder(notification_ErrorMessageWithPayment)))
                .as("Kiểm tra message lỗi").isTrue();
    }

    @When("^Tạo 3 đơn hàng có dịch vụ thanh toán bằng COD$")
    public void createThreeCODOrder() throws TesseractException, IOException {
        createThreeCODSmartHomeContract();
    }

    @And("Tạo một đơn hàng có dịch vụ thanh toán bằng COD")
    public void createCODOrder() throws TesseractException, IOException {
        waitForOCR(title_Order);
        accessServiceScreenFromMenuScreen();
        supplyCusAddress();
        selectSmartHomeService();
        navigateToOrderCreationScreen();
        changeToCODPaymentMethodAndInputNeededInfo();
        clickOrderCreationButton();
    }
}
