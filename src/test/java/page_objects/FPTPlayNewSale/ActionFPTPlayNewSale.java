package page_objects.FPTPlayNewSale;

import net.fpt.utils.PropertyUtils;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import static constants.CommonFPTPlayNewSale.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.StaticActionUtil.sleepTo;
import static org.assertj.core.api.Assertions.assertThat;
import static page_objects.FPTPlayNewSale.ActionFPTPlayNewSale.Implement.*;
import static page_objects.FPTPlayNewSale.ActionFPTPlayNewSale.ServicePackage.*;

public class ActionFPTPlayNewSale extends ElementsFPTPlayNewSale{
    public int explicitWaitDefault = PropertyUtils.getIntegerProperty("explicitWait", 60);
    WebDriverWait wait = new WebDriverWait(driver, explicitWaitDefault );

    /**
     * Variables utilized for set up Device Box with the first option at all.
     *
     * */
    public String deviceType_DeviceBox = Arrays.asList(DeviceTypesOfServicePackage(list_ServicePackageFPTPlay.get(1).toString())).get(0);
    public String deviceType_DeviceBox_opt2 = Arrays.asList(DeviceTypesOfServicePackage(list_ServicePackageFPTPlay.get(1).toString())).get(1);

    public String device_DeviceBox = Arrays.asList(returnDevicesInDeviceBox(deviceType_DeviceBox)).get(0);
    public String device_DeviceBox_opt2 = Arrays.asList(returnDevicesInDeviceBox(deviceType_DeviceBox)).get(0);

    public String implementationInfo_DeviceBox = Arrays.asList(ImplementPackageOfExactDevice(device_DeviceBox)).get(0);

    /**
     *  Array of genres of data packages of iZi package
     *
     * */
    public String[] dataPackageIZI() {
        return new String[] {list_DataPackageFPTPlay.get(4).toString()
                            ,list_DataPackageFPTPlay.get(7).toString()};
    }

    /**
     *  Array of genres of data packages of Max package
     *
     * */
    public String[] dataPackageMax() {
        return new String[] {list_DataPackageFPTPlay.get(0).toString()
                            ,list_DataPackageFPTPlay.get(1).toString()
                            ,list_DataPackageFPTPlay.get(2).toString()
                            ,list_DataPackageFPTPlay.get(3).toString()
                            ,list_DataPackageFPTPlay.get(4).toString()
                            ,list_DataPackageFPTPlay.get(5).toString()
                            ,list_DataPackageFPTPlay.get(6).toString()
                            ,list_DataPackageFPTPlay.get(7).toString()
                            ,list_DataPackageFPTPlay.get(8).toString()
                            ,list_DataPackageFPTPlay.get(9).toString()
                            ,list_DataPackageFPTPlay.get(10).toString()};
    }

    /**
     *  Array of genres of data packages of VIP package
     *
     * */
    public String[] dataPackageVip() {
        return new String[] {list_DataPackageFPTPlay.get(0).toString()
                            ,list_DataPackageFPTPlay.get(1).toString()
                            ,list_DataPackageFPTPlay.get(2).toString()
                            ,list_DataPackageFPTPlay.get(3).toString()
                            ,list_DataPackageFPTPlay.get(4).toString()
                            ,list_DataPackageFPTPlay.get(5).toString()
                            ,list_DataPackageFPTPlay.get(6).toString()
                            ,list_DataPackageFPTPlay.get(7).toString()
                            ,list_DataPackageFPTPlay.get(8).toString()
                            ,list_DataPackageFPTPlay.get(9).toString()
                            ,list_DataPackageFPTPlay.get(10).toString()
                            ,list_DataPackageFPTPlay.get(11).toString()};
    }

    /**
     * To return an array of data packages of each service package
     *
     * @param servicePackage
     * */
    public String[] listDataPackageOfExactServicePackageFPTPlay(String servicePackage) {
        String[][] arrayModel = {Objects.requireNonNull(OPTION1.getServicePackage())
                                ,Objects.requireNonNull(OPTION2.getServicePackage())
                                ,Objects.requireNonNull(OPTION3.getServicePackage())};
        String[][] array = {dataPackageIZI(),dataPackageMax(),dataPackageVip()};
        String[] returnArray = {};

        for (int i = 0; i < arrayModel.length; i++) {
            for (String str : arrayModel[i]) {
                if (str.equals(servicePackage)) {
                    returnArray = array[i];
                    break;
                }
            }
        }
        return returnArray;
    }

    enum ServicePackage {
        OPTION1, OPTION2, OPTION3;

        public String[] getServicePackage() {
            switch (this) {
                case OPTION1:
                    return new String[] {list_ServicePackageFPTPlay.get(0).toString()};
                case OPTION2:
                    return new String[] {list_ServicePackageFPTPlay.get(1).toString()};
                case OPTION3:
                    return new String[] {list_ServicePackageFPTPlay.get(2).toString()};
                default:
                    return null;
            }
        }
    }

    /**
     * To create the list of all text of each data package of iZi
     *
     * */
    public List getListTextOptionsOfDataPackageIZIFPTPlay() {
        List<String> strList = new ArrayList<>();
        for(int i = 0; i < Arrays.asList(listDataPackageOfExactServicePackageFPTPlay(list_ServicePackageFPTPlay.get(0).toString())).size(); i++) {
            if (displayed(dynamic_finder(Arrays.asList(listDataPackageOfExactServicePackageFPTPlay(list_ServicePackageFPTPlay.get(0).toString())).get(i)),2)) {
                strList.add(dynamic_finder(Arrays.asList(listDataPackageOfExactServicePackageFPTPlay(list_ServicePackageFPTPlay.get(0).toString())).get(i)).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * To return all options of iZi package in device
     *
     * */
    public String[] DeviceTypeOfIZIPackage() {
        return new String[] {list_TypeOfDeviceInDeviceBoxFPTPlay.get(1).toString()};
    }

    /**
     * To return all options of Max package in device
     *
     * */
    public String[] DeviceTypeOfMaxVipPackage() {
        return new String[] {list_TypeOfDeviceInDeviceBoxFPTPlay.get(0).toString()
                            ,list_TypeOfDeviceInDeviceBoxFPTPlay.get(1).toString()};
    }

    /**
     * To return all options of first option "Vât tư IPTV" in device box
     *
     * */
    public String[] listDeviceOfIPTV() {
        return new String[] {list_ChooseDevicesInDeviceBoxFPTPlay.get(4).toString()
                            ,list_ChooseDevicesInDeviceBoxFPTPlay.get(5).toString()};
    }

    /**
     * To return all options of second option "Vat tu FPT Play box" in device box
     *
     * */
    public String[] listDeviceOfFPTPlayBox() {
        return new String[] {list_ChooseDevicesInDeviceBoxFPTPlay.get(0).toString()
                            ,list_ChooseDevicesInDeviceBoxFPTPlay.get(1).toString()
                            ,list_ChooseDevicesInDeviceBoxFPTPlay.get(2).toString()
                            ,list_ChooseDevicesInDeviceBoxFPTPlay.get(3).toString()};
    }

    /**
     * To return all options of device type according to service package
     *
     * @param servicePackage
     * */
    public String[] DeviceTypesOfServicePackage(String servicePackage) {
        if (Objects.equals(servicePackage, list_ServicePackageFPTPlay.get(0).toString())) {
            return DeviceTypeOfIZIPackage();
        } else {
            return DeviceTypeOfMaxVipPackage();
        }
    }

    /**
     * To return all options of device could choose according to each device
     *
     * @param deviceType
     * */
    public String[] returnDevicesInDeviceBox(String deviceType) {
        if (Objects.equals(deviceType, list_TypeOfDeviceInDeviceBoxFPTPlay.get(0).toString())) {
            return listDeviceOfIPTV();
        } else {
            return listDeviceOfFPTPlayBox();
        }
    }

    /**
     * To return the list string of "TIN/PNC" and "Sale"
     *
     * */
    public String[] arrayOption1() {
        return new String[] {list_ImplementationServiceInDeviceBoxFPTPlay.get(0).toString()
                            ,list_ImplementationServiceInDeviceBoxFPTPlay.get(1).toString()};
    }

    /**
     * To return the list string of "TIN/PNC" and "Quầy"
     *
     * */
    public String[] arrayOption2() {
        return new String[] {list_ImplementationServiceInDeviceBoxFPTPlay.get(0).toString()
                            ,list_ImplementationServiceInDeviceBoxFPTPlay.get(2).toString()};
    }

    /**
     * To return the list string of "TIN/PNC" and "Sale" and "Quầy"
     *
     * */
    public String[] arrayOption3() {
        return new String[] {list_ImplementationServiceInDeviceBoxFPTPlay.get(0).toString()
                            ,list_ImplementationServiceInDeviceBoxFPTPlay.get(1).toString()
                            ,list_ImplementationServiceInDeviceBoxFPTPlay.get(2).toString()};
    }

    /**
     * To return an array string of implement packages of each varying device
     *
     * @param device
     * */
    public String[] ImplementPackageOfExactDevice(String device) {
        String[][] implementModel = {OPT1.getImplement(),OPT2.getImplement(),OPT3.getImplement()};
        String[][] array = {arrayOption1(),arrayOption2(),arrayOption3()};
        String[] arrayReturn = {};

        for (int i = 0; i < implementModel.length; i++) {
            for (String str : implementModel[i]) {
                if (Objects.equals(str, device)) {
                    arrayReturn = array[i];
                    break;
                }
            }
        }
        return arrayReturn;
    }

    enum Implement {
        OPT1,OPT2,OPT3;

        public String[] getImplement() {
            switch (this) {
                case OPT1:
                    return new String[] {list_ChooseDevicesInDeviceBoxFPTPlay.get(0).toString()};
                case OPT2:
                    return new String[] {list_ChooseDevicesInDeviceBoxFPTPlay.get(2).toString()
                                        ,list_ChooseDevicesInDeviceBoxFPTPlay.get(3).toString()};
                case OPT3:
                    return new String[] {list_ChooseDevicesInDeviceBoxFPTPlay.get(1).toString()};
                default:
                    return null;
            }
        }
    }

    /**
     * To set up all options of device box
     *
     * @param servicePackage
     * */
    public void setUpDeviceBox(String servicePackage) {
        String strDeviceType = Arrays.asList(DeviceTypesOfServicePackage(servicePackage)).get(0);
        String strDevice = Arrays.asList(returnDevicesInDeviceBox(strDeviceType)).get(0);
        String strImplement = Arrays.asList(ImplementPackageOfExactDevice(strDevice)).get(0);

        tapByCoordinates(point_DropListDeviceTypeFPTPlay.x,point_DropListDeviceTypeFPTPlay.y);
        clickToElement(dynamic_finder(strDeviceType));
        clickToElement(button_Confirm);

        tapByCoordinates(point_DropListChooseDeviceFPTPlay.x,point_DropListChooseDeviceFPTPlay.y);
        clickToElement(dynamic_finder(strDevice));
        clickToElement(button_Confirm);

        tapByCoordinates(point_DropListImplementFPTPlay.x,point_DropListImplementFPTPlay.y);
        clickToElement(dynamic_finder(strImplement));
        clickToElement(button_Confirm);

        clickToElement(button_Add);
    }

    /**
     * Get text of all titles in device box screen
     *
     * */
    public List listTextTitleDeviceBox() {
        List<String> strList = new ArrayList<>();
        for (Object str : list_TitleDeviceBoxFPTPlay) {
            if (displayed(dynamic_finder(str.toString()))) {
                strList.add(dynamic_finder(str.toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Get text of all options in a package's dropdown
     *
     * @param list
     * */
    public List checkTextExistOnList(List list) {
        List<String> strList = new ArrayList<>();
        for (Object str : list) {
            if (displayed(dynamic_finder(str.toString()))) {
                strList.add(dynamic_finder(str.toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * Get text of all options of data package in the Max package's dropdown
     *
     * */
    public List listTextDataPackageOfMaxPackage() {
        return checkTextExistOnList(Arrays.asList(dataPackageMax()));
    }

    /**
     * Set up choice of implementation info in device box 1
     *
     * */
    public void setUpImplementInfoInDeviceBox1() {
        tapByCoordinates(point_DropListImplementFPTPlayService.x,point_DropListImplementFPTPlayService.y);
        clickToElement(dynamic_finder(implementationInfo_DeviceBox));
        clickToElement(button_Confirm);
    }

    /**
     * Check all options titles exist on device box 2
     *
     * */
    public List listTextTitleDeviceBox2() {
        return checkTextExistOnList(list_TiTleDeviceBox2FPTPlay);
    }

    /**
     * To return list of device type according to service package in device box 2
     *
     * @param servicePackage
     * */
    public String[] returnDeviceTypeDeviceBox2(String servicePackage) {
        if (Objects.equals(servicePackage,list_ServicePackageFPTPlay.get(0).toString())) {
            return new String[] {list_TypeOfDeviceInDeviceBoxFPTPlay.get(1).toString()};
        } else {
            return new String[] {list_TypeOfDeviceInDeviceBoxFPTPlay.get(0).toString()
                                ,list_TypeOfDeviceInDeviceBoxFPTPlay.get(1).toString()};
        }
    }

    /**
     * To return list of device according to device type in device box 2
     *
     * @param deviceType
     * */
    public String[] returnDeviceDeviceBox2(String deviceType) {
        if (Objects.equals(deviceType,list_TypeOfDeviceInDeviceBoxFPTPlay.get(0).toString())) {
            return new String[] {list_DeviceInDeviceBox2FPTPlay.get(4).toString()
                                ,list_DeviceInDeviceBox2FPTPlay.get(5).toString()};
        } else {
            return new String[] {list_DeviceInDeviceBox2FPTPlay.get(0).toString()
                                ,list_DeviceInDeviceBox2FPTPlay.get(1).toString()
                                ,list_DeviceInDeviceBox2FPTPlay.get(2).toString()
                                ,list_DeviceInDeviceBox2FPTPlay.get(3).toString()};
        }
    }

    /**
     * To return implement info list according to each device
     *
     * @param device
     * */
    public String[] returnImplementationInfoDeviceBox2(String device) {
        String[] option1 = {list_ImplementationServiceInDeviceBoxFPTPlay.get(0).toString()};
        String[] option2 = {list_ImplementationServiceInDeviceBoxFPTPlay.get(0).toString()
                            ,list_ImplementationServiceInDeviceBoxFPTPlay.get(1).toString()
                            ,list_ImplementationServiceInDeviceBoxFPTPlay.get(2).toString()};
        String[] array = {list_DeviceInDeviceBox2FPTPlay.get(0).toString(),list_DeviceInDeviceBox2FPTPlay.get(1).toString(),list_DeviceInDeviceBox2FPTPlay.get(3).toString()};

        if (Arrays.asList(array).contains(device)) {
            return option2;
        } else {
            return option1;
        }
    }

    /**
     * Return option of Max combo in device box 2
     *
     * */
    public String DeviceType_DeviceBox2_opt1 = Arrays.asList(returnDeviceTypeDeviceBox2(list_ServicePackageFPTPlay.get(1).toString())).get(0);
    public String DeviceType_DeviceBox2_opt2 = Arrays.asList(returnDeviceTypeDeviceBox2(list_ServicePackageFPTPlay.get(1).toString())).get(1);
    public String Device_DeviceBox2_opt1 = Arrays.asList(returnDeviceDeviceBox2(DeviceType_DeviceBox2_opt2)).get(0);
    public String Device_DeviceBox2_opt2 = Arrays.asList(returnDeviceDeviceBox2(DeviceType_DeviceBox2_opt2)).get(1);

    /**
     * To click increase quantity of device in device box 2
     *
     * @param n
     * */
    public void clickIncreaseDeviceBox2(int n) {
        for (int i = 0; i < n; i++) {
            sleepTo(500);
            tapByCoordinates(point_ButtonIncreaseQuantityDeviceBox2FPTPlay.x,point_ButtonIncreaseQuantityDeviceBox2FPTPlay.y);
        }
    }

    /**
     * To click decrease quantity of device in device box 2
     *
     * @param n
     * */
    public void clickDecreaseDeviceBox2(int n) {
        for (int i = 0; i < n; i++) {
            sleepTo(500);
            tapByCoordinates(point_ButtonDecreaseQuantityDeviceBox2FPTPlay.x,point_ButtonDecreaseQuantityDeviceBox2FPTPlay.y);
        }
    }

    /**
     * To return a list of notices appeared in device box 2
     *
     * */
    public List listTextNoticeInDeviceBox2() {
        return checkTextExistOnList(Arrays.asList(arrayNoticeDeviceBox2()));
    }

    /**
     * Return an array of all notices in device box 2 when none set up anything
     *
     * */
    public String[] arrayNoticeDeviceBox2() {
        return new String[] {notice_NoneSetDeviceTypeInDeviceBox2FPTPlay
                ,notice_NoneSetDeviceInDeviceBox2FPTPlay
                ,notice_NoneSetDeviceStatusInDeviceBox2FPTPlay
                ,notice_NoneSetOldDeviceCollectionInDeviceBox2FPTPlay
                ,notice_NoneSetQuantityDeviceInDeviceBox2FPTPlay
                ,notice_NoneSetImplementationUnitInDeviceBox2FPTPlay};
    }

    /**
     * Return the text of all options of service package in extra play
     *
     * */
    public List listTextServicePackageExtraFPTPlay() {
        return checkTextExistOnList(list_ServicePackageExtraFPTPlay);
    }

    /**
     * To click increase quantity of device in device box 2
     *
     * @param n
     * */
    public void clickIncreaseExtraFPTPlay(int n) {
        for (int i = 0; i < n; i++) {
            tapByCoordinates(point_ButtonIncreaseQuantityExtraFPTPlay.x,point_ButtonIncreaseQuantityExtraFPTPlay.y);
        }
    }

    /**
     * To click decrease quantity of device in device box 2
     *
     * @param n
     * */
    public void clickDecreaseExtraFPTPlay(int n) {
        for (int i = 0; i < n; i++) {
            tapByCoordinates(point_ButtonDecreaseQuantityExtraFPTPlay.x,point_ButtonDecreaseQuantityExtraFPTPlay.y);
        }
    }

    /**
     * Return a list after check the popup of data package in  extra fpt play
     *
     * */
    public List checkListDataPackage() {
        List<String> strList = new ArrayList<>();
        int count = 0;
        for (Object str : list_DataPackageExtraFPTPlay) {
            while (!(displayed(dynamic_finder(str.toString())))) {
                swipeOffset(100);
                if (count > 2) {
                    strList.add(null);
                    break;
                }
                count++;
            }
            strList.add(dynamic_finder(str.toString()).getText());
        }
        return strList;
    }

    /**
     * return list text of title at screen FPT Play service
     *
     * */
    public List checkTitleFPTPlayServiceScreen() {
        return checkTextExistOnList(listTiTleFPTPlayServiceScreen());
    }

    public List listTiTleFPTPlayServiceScreen() {
        String[] array = {title_FPTPlayServiceScreen
                ,title_FPTPlayChooseServicePackage
                ,title_FPTPlayChooseDataPackage
                ,title_FPTPlayChooseImplementation
                ,title_FPTPlayDeviceBox1
                ,title_FPTPlayDeviceBox2
                ,title_ExtraServiceFPTPlay};
        return Arrays.asList(array);
    }

    /**
     * Set VIP package with more than 5 device boxes
     *
     * */
    public void setVipWithOver5DeviceBox() {
        tapByCoordinates(point_DropListServicePackageFPTPlayService.x,point_DropListServicePackageFPTPlayService.y);
        clickToElement(dynamic_finder(list_ServicePackageFPTPlay.get(2).toString()));
        clickToElement(button_Confirm);

        tapByCoordinates(point_DropListDataPackageFPTPlayService.x,point_DropListDataPackageFPTPlayService.y);
        clickToElement(dynamic_finder(Arrays.asList(dataPackageVip()).get(2)));
        clickToElement(button_Confirm);

        tapByCoordinates(point_ButtonAddDeviceBox2.x,point_ButtonAddDeviceBox2.y);
        waitFor(dynamic_finder(title_FPTPlayDeviceBox2));
        tapByCoordinates(point_DropListDeviceTypeDeviceBox2FPTPlay.x,point_DropListDeviceTypeDeviceBox2FPTPlay.y);

        String deviceType = Arrays.asList(returnDeviceTypeDeviceBox2(list_ServicePackageFPTPlay.get(2).toString())).get(1);
        clickToElement(dynamic_finder(deviceType));
        clickToElement(button_Confirm);

        tapByCoordinates(point_DropListChooseDeviceDeviceBox2FPTPlay.x,point_DropListChooseDeviceDeviceBox2FPTPlay.y);
        String device = Arrays.asList(returnDeviceDeviceBox2(deviceType)).get(0);
        clickToElement(dynamic_finder(device));
        clickToElement(button_Confirm);

        clickIncreaseDeviceBox2(6);

        tapByCoordinates(point_DropListImplementDeviceBox2FPTPlay.x,point_DropListImplementDeviceBox2FPTPlay.y);
        clickToElement(dynamic_finder(Arrays.asList(returnImplementationInfoDeviceBox2(device)).get(0)));
        clickToElement(button_Confirm);
    }

    /**
     * Set extra box
     *
     * */
    public void setExtraBox() {
        tapByCoordinates(point_ButtonAddExtraFPTPlay.x,point_ButtonAddExtraFPTPlay.y);
        waitFor(dynamic_finder(title_ExtraServiceFPTPlay));

        tapByCoordinates(point_DropListServicePackageExtraFPTPlay.x,point_DropListServicePackageExtraFPTPlay.y);
        clickToElement(dynamic_finder(list_ServicePackageExtraFPTPlay.get(0).toString()));
        clickToElement(button_Confirm);

        tapByCoordinates(point_DropListDataPackageExtraFPTPlay.x,point_DropListDataPackageExtraFPTPlay.y);
        clickToElement(dynamic_finder(list_DataPackageExtraFPTPlay.get(1).toString()));
        clickToElement(button_Confirm);

        clickIncreaseExtraFPTPlay(1);
        clickToElement(button_Add);
    }

    /**
     * Set package extra fpt play
     *
     * */
    public void setExtraFPTPlay() {
        tapByCoordinates(point_DropListServicePackageExtraFPTPlay.x,point_DropListServicePackageExtraFPTPlay.y);
        clickToElement(dynamic_finder(list_ServicePackageExtraFPTPlay.get(0).toString()));
        clickToElement(button_Confirm);
        tapByCoordinates(point_DropListDataPackageExtraFPTPlay.x,point_DropListDataPackageExtraFPTPlay.y);
        clickToElement(dynamic_finder(list_DataPackageExtraFPTPlay.get(1).toString()));
        clickToElement(button_Confirm);
        clickIncreaseExtraFPTPlay(2);
        clickToElement(button_Add);
    }
}
