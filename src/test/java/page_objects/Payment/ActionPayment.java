package page_objects.Payment;

import net.fpt.utils.PropertyUtils;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static constants.CommonPayment.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.FlutterActionUtil.clickToElement;

public class ActionPayment extends ElementsPayment {
    /**
     * get separate titles of contract block
     *
     * */
    public List listTextContractBlock() throws TesseractException, IOException, InterruptedException {
        List<String> strList = new ArrayList<>();
        for (Object o : list_ContractInformationBlock) {
            scrollDownUntilTextVisible(o.toString(),15);
            strList.add(dynamic_finder(o.toString()).getText());
        }
        return strList;
    }

    /**
     * get separate titles of bill block
     *
     * */
    public List listTextBillBlock() throws TesseractException, IOException, InterruptedException {
        List<String> strList = new ArrayList<>();
        for (Object o : list_BillInformationBlock) {
            scrollDownUntilTextVisible(o.toString(),15);
            strList.add(dynamic_finder(o.toString()).getText());
        }
        return strList;
    }

    /**
     * get separate titles of order information at QR payment screen
     *
     * */
    public List listTextOrderInformationQRPaymentScreen() throws TesseractException, IOException, InterruptedException {
        List<String> strList = new ArrayList<>();
        for (Object o : list_OrderInformationQRCodePaymentScreen) {
            scrollDownUntilTextVisible(o.toString(),15);
            strList.add(dynamic_finder(o.toString()).getText());
        }
        return strList;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
