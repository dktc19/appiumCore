package page_objects.newInternetSale;

import net.fpt.utils.PropertyUtils;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.*;

import static constants.CommonNewInternetSale.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.FlutterActionUtil.tapByCoordinates;
import static net.fpt.utils.StaticActionUtil.sleepTo;
import static net.fpt.utils.TesseractOcrUtil.getTextLocation;
import static page_objects.newInternetSale.ActionNewInternetSale.ServicePackages.*;

public class ActionNewInternetSale extends ElementsNewInternetSale {

    /**
     *  Get text of all options in services package's dropdown
     *
     * */
    public List getListServicePackageName() {
        List<String> strList = new ArrayList<>();
        for(int i = 0; i < list_ServicePackage.size(); i++) {
            if (displayed(dynamic_finder(list_ServicePackage.get(i).toString()))) {
                strList.add(dynamic_finder(list_ServicePackage.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * To return an array list of data packages of each service package
     *
     * @param servicePackage
     * */
    public String[] listDataPackageOfExactServicePackage(String servicePackage) {
        String[][] arrayModel = {Objects.requireNonNull(OPTION1.getServicePackages())
                                ,Objects.requireNonNull(OPTION2.getServicePackages())
                                ,Objects.requireNonNull(OPTION3.getServicePackages())
                                ,Objects.requireNonNull(OPTION4.getServicePackages())
                                ,Objects.requireNonNull(OPTION5.getServicePackages())};
        String[][] array = {arrayOption1(),arrayOption2(),arrayOption3(),arrayOption4(),arrayOption5()};
        String[] returnArray = {};

        for (int i = 0; i < arrayModel.length; i++) {
            for (String str : arrayModel[i]) {
                if (str.equals(servicePackage)) {
                    returnArray = array[i];
                }
            }
        }
        return returnArray;
    }

    enum ServicePackages {
        OPTION1,OPTION2,OPTION3,OPTION4,OPTION5;

        public String[] getServicePackages() {
            switch (this) {
                case OPTION1:
                    return new String[] {list_ServicePackage.get(0).toString()
                                        ,list_ServicePackage.get(1).toString()
                                        ,list_ServicePackage.get(7).toString()};
                case OPTION2:
                    return new String[] {list_ServicePackage.get(2).toString()
                                        ,list_ServicePackage.get(3).toString()
                                        ,list_ServicePackage.get(5).toString()};
                case OPTION3:
                    return new String[] {list_ServicePackage.get(4).toString()};
                case OPTION4:
                    return new String[] {list_ServicePackage.get(6).toString()};
                case OPTION5:
                    return new String[] {list_ServicePackage.get(8).toString()
                                        ,list_ServicePackage.get(9).toString()};
                default:
                    return null;
            }
        }
    }

    /**
     * Array list of genres of data packages of super80, super100, super150
     *
     * */
    public String[] arrayOption1() {
        return new String[] {list_GenresOfDataPackage.get(0).toString()
                            ,list_GenresOfDataPackage.get(1).toString()
                            ,list_GenresOfDataPackage.get(2).toString()
                            ,list_GenresOfDataPackage.get(3).toString()
                            ,list_GenresOfDataPackage.get(4).toString()
                            ,list_GenresOfDataPackage.get(6).toString(),};
    }

    /**
     * Array list of genres of data packages of super200, super250, super400
     *
     * */
    public String[] arrayOption2() {
        return new String[] {list_GenresOfDataPackage.get(0).toString()
                            ,list_GenresOfDataPackage.get(2).toString()
                            ,list_GenresOfDataPackage.get(4).toString()
                            ,list_GenresOfDataPackage.get(5).toString()
                            ,list_GenresOfDataPackage.get(7).toString()
                            ,list_GenresOfDataPackage.get(8).toString()};
    }

    /**
     * Array list of genres of data packages of super30
     *
     * */
    public String[] arrayOption3() {
        return new String[] {list_GenresOfDataPackage.get(0).toString()
                            ,list_GenresOfDataPackage.get(2).toString()
                            ,list_GenresOfDataPackage.get(3).toString()
                            ,list_GenresOfDataPackage.get(4).toString()
                            ,list_GenresOfDataPackage.get(5).toString()
                            ,list_GenresOfDataPackage.get(6).toString()};
    }

    /**
     * Array list of genres of data packages of super500
     *
     * */
    public String[] arrayOption4() {
        return new String[] {list_GenresOfDataPackage.get(0).toString()
                            ,list_GenresOfDataPackage.get(2).toString()
                            ,list_GenresOfDataPackage.get(4).toString()
                            ,list_GenresOfDataPackage.get(5).toString()
                            ,list_GenresOfDataPackage.get(8).toString()};
    }

    /**
     * Array list of genres of data packages of lux500, lux800
     *
     * */
    public String[] arrayOption5() {
        return new String[] {list_GenresOfDataPackage.get(0).toString()
                            ,list_GenresOfDataPackage.get(3).toString()
                            ,list_GenresOfDataPackage.get(6).toString()};
    }

    /**
     *  Get text of all options in services package's dropdown
     *
     * */
    public List getListDeviceName() {
        List<String> strList = new ArrayList<>();
        for(int i = 0; i < list_InternetDevices_AddOnInternet.size(); i++) {
            if (displayed(dynamic_finder(list_InternetDevices_AddOnInternet.get(i).toString()))) {
                strList.add(dynamic_finder(list_InternetDevices_AddOnInternet.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     *  Get text of all options in services package's dropdown
     *
     * */
    public List getListServicePackagesAddOnInternet() {
        List<String> strList = new ArrayList<>();
        for(int i = 0; i < list_ServicePackages_AddOnInternet.size(); i++) {
            if (displayed(dynamic_finder(list_ServicePackages_AddOnInternet.get(i).toString()))) {
                strList.add(dynamic_finder(list_ServicePackages_AddOnInternet.get(i).toString()).getText());
            } else {
                strList.add(null);
            }
        }
        return strList;
    }

    /**
     * To return an array list of data packages of each service package in "Add-on Internet" page
     *
     * @param servicePackage
     * */
    public String[] listGenresOfDataPackageAddOnInternet(String servicePackage) {
        String[][] arrayDataPackage = {arrayFSafeAddOnInternet(),arrayDepositAddOnInternet(),arrayUltraFastAddOnInternet()};
        String[] arrayServicePackage = {list_ServicePackages_AddOnInternet.get(0).toString(),list_ServicePackages_AddOnInternet.get(1).toString(),list_ServicePackages_AddOnInternet.get(2).toString()};
        String[] returnArray = {};
        int i = 0;
        while (i < arrayServicePackage.length) {
            if (servicePackage.equals(arrayServicePackage[i])) {
                returnArray = arrayDataPackage[i];
                break;
            } else {
                i++;
            }
        }
        return returnArray;
    }

    /**
     * To return the array list of data packages of FSafe in Add-on Internet
     *
     * */
    public String[] arrayFSafeAddOnInternet() {
        return new String[] {list_GenresOfDataPackage_AddOnInternet.get(0).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(3).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(7).toString()};
    }

    /**
     * To return the array list of data packages of "Đặt cọc thuê bao" in Add-on Internet
     *
     * */
    public String[] arrayDepositAddOnInternet() {
        return new String[] {list_GenresOfDataPackage_AddOnInternet.get(10).toString()};
    }

    /**
     * To return the array list of data packages of UltraFast in Add-on Internet
     *
     * */
    public String[] arrayUltraFastAddOnInternet() {
        return new String[] {list_GenresOfDataPackage_AddOnInternet.get(0).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(1).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(2).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(3).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(4).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(5).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(6).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(7).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(8).toString()
                            ,list_GenresOfDataPackage_AddOnInternet.get(9).toString()};
    }

    /**
     * Edit package of Add-on Internet service
     *
     * */
    public void editAddOnInternetPackage() {
        clickToElement(dynamic_finder(list_ServicePackages_AddOnInternet.get(0).toString()));
        clickToElement(dynamic_finder(list_ServicePackages_AddOnInternet.get(2).toString()));
        clickToElement(button_Confirm);
        clickToElement(dropList_DataPackage_AddOnInternet);
        clickToElement(dynamic_finder(list_GenresOfDataPackage_AddOnInternet.get(0).toString()));
        clickToElement(button_Confirm);
        clickToElement(button_Add);
    }

    /**
     * To select the Internet Package
     *
     * */
    public void chooseFTTHSuper80InternetPackage() throws IOException, InterruptedException {
        clickToElement(button_BuyServices);
        tapByExactCoordinates((Integer) getTextLocation(package_Max7Month,3,0,70).get(0), (Integer) getTextLocation(package_Max7Month,3,0,70).get(1));
    }

}
