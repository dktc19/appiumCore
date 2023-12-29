package page_objects.contractCreation;

import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.CommonContract.*;
import static net.fpt.utils.FlutterActionUtil.*;
import static net.fpt.utils.ImageAnalyzeUtil.captureScreenAndReturnFile;
import static net.fpt.utils.ImageAnalyzeUtil.extractTextFromImage;

public class ActionContractCreation extends ElementsContractCreation {

    /**
     * This step requires order code published, then pass through the contract creation step with contract code made.
     *
     * */
    public void createContract() {
        try {
            if (displayed(dynamic_finder(title_OrderInfo))) {
                clickToElement(button_CreateContract);
            }
        } catch (NoSuchElementException e){
            System.out.println("NoSuchElementException");
        } catch (TimeoutException e){
            System.out.println("TimeoutException");
        }

        if (displayed(dynamic_finder(notice_PayFee))) {
            clickToElement(button_Confirm);
        }

    }

    /**
     * Function to get string of book port link at order creation screen
     *
     * */
    public String getStringBookPortLink() {
        scrollDownNativeUntilVisible(button_LinkBookPort,5);
        return button_LinkBookPort.getText();
    }

    /**
     * Function to select the cash for payment
     *
     * */
    public void selectCashPayment() {
        waitFor(dropdown_PaymentMethod);
        if (!Objects.equals(dropdown_PaymentMethod.getText(), list_PaymentMethod.get(0).toString())) {
            clickToElement(dropdown_PaymentMethod);
            waitFor(dynamic_finder(title_PaymentMethodPopup));
            clickToElement(dynamic_finder(list_PaymentMethod.get(0).toString()));
        }
    }
}
