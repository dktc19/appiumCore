package page_objects.TotalPayment;

import net.fpt.utils.PropertyUtils;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static constants.CommonTotalPayment.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.StaticActionUtil.sleepTo;
import static net.fpt.utils.TesseractOcrUtil.getTextLocation;

public class ActionTotalPayment extends ElementsTotalPayment {

    /**
     * Return list of all options in payment method
     *
     * */
    public List listTextPaymentMethod() throws TesseractException, IOException, InterruptedException {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < list_PaymentMethod.size(); i++) {
            scrollDownUntilTextVisible(list_PaymentMethod.get(i).toString(),10);
            strList.add(dynamic_finder(list_PaymentMethod.get(i).toString()).getText());
        }
        return strList;
    }

    /**
     * Change to the "Payment" step from Total Payment View
     *
     * */
    public void createOrder() {
        try {
            tapByExactCoordinates((Integer) getTextLocation(button_CreateOrder,2,1,70).get(0),(Integer) getTextLocation(button_CreateOrder,2,1,70).get(1));
            clickToElement(button_Confirm);
        } catch (NoSuchElementException e){
            System.out.println("NoSuchElementException");
        } catch (TimeoutException e){
            System.out.println("TimeoutException");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Change to the "Payment" step from Total Payment View
     *
     * */
    public void createOrderWithQRCode() {
        clickToElement(dynamic_finder(list_PaymentMethod.get(2).toString()));
        clickToElement(button_Confirm);
        try {
            tapByExactCoordinates((Integer) getTextLocation(button_CreateOrder,2,1,70).get(0),(Integer) getTextLocation(button_CreateOrder,2,1,70).get(1));
            clickToElement(button_Confirm);
        } catch (NoSuchElementException e){
            System.out.println("NoSuchElementException");
        } catch (TimeoutException e){
            System.out.println("TimeoutException");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
