package net.fpt.listeners;

import net.fpt.utils.SquashAPIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.fpt.utils.SquashAPIUtil.updateExecutionByID;

public class ReportSquashListener extends TestListenerAdapter {
    static final Logger logger = LoggerFactory.getLogger(ReportSquashListener.class);

    /**
     *
     * onStart - method to log data before any tests start
     *
     * @param testContext
     */
    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
    }
    /**
     * onFinish - method to log data after all tests are complete
     *
     * @param testContext
     */
    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
    }

    @Override
    public void onTestStart(ITestResult tr) {
        //updateExecution(tr,"RUNNING","");
        super.onTestStart(tr);
    }

    /**
     * onTestFailure method
     * @param tr
     */
    @Override
    public void onTestFailure(ITestResult tr) {
        updateExecution(tr,"FAILURE","Cause: "+tr.getThrowable().getMessage() + " - " + tr.getThrowable().getMessage());
        super.onTestFailure(tr);
    }

    /**
     * onTestSuccess method
     *
     * @param tr
     */
    @Override
    public void onTestSuccess(ITestResult tr) {
        updateExecution(tr,"SUCCESS","Passed");
        super.onTestSuccess(tr);
    }

    /**
     * onTestSuccess method
     */
    @Override
    public void onTestSkipped(ITestResult tr) {
        updateExecution(tr,"BLOCKED","Skipped");
        super.onTestSuccess(tr);
    }

    /**
     * onTestSuccess method
     *
     * Điều kiện để report cập nhật được trên squash thì feature phải có thông tin case tương ứng
     * vd: Feature: Add new item to ToDO list #7
     * @param tr
     */
    public void updateExecution(ITestResult tr, String exection_status, String comment){
        ITestContext context= tr.getTestContext();
        String cucumberFeature= context.getAttribute("cucumberFeature").toString();
        String resultTextCaseID = getStringFromOtherString(cucumberFeature,"#(\\d+)");
        ArrayList<SquashAPIUtil.TestCaseOBJ>  listObjFeature= (ArrayList<SquashAPIUtil.TestCaseOBJ>) context.getAttribute("listObjFeature");
        for (SquashAPIUtil.TestCaseOBJ obj: listObjFeature ) {
            if(obj.getIDTestCase().equals(resultTextCaseID)) {
                logger.debug( obj.getExecutions().toString());
                ArrayList listExecutions = obj.getExecutions();
                for (int i = 0; i < listExecutions.size(); i++ ) {
                    String ID = listExecutions.get(i).toString();
                    logger.debug(ID);
                    updateExecutionByID(ID,exection_status);
                }
            }
        }
    }

    /**
     * Hàm lấy một chuỗi ký tự từ một chuỗi
     * author: HungNDT2
     * Input: String - patternRegex: là chuỗi regular expression mẫu dùng để so sánh
     *        String - str: là chuỗi ban đầu
     * Output: trả ra chuỗi cần lấy
     * */
    public static String getStringFromOtherString(String str,String patternRegex) {
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
