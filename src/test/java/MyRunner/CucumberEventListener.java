package MyRunner;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import net.fpt.utils.SquashAPIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.fpt.utils.SquashAPIUtil.*;

/**
*  Khai báo các Listener của cucumber.
* */
public class CucumberEventListener implements ConcurrentEventListener {
    static final Logger logger = LoggerFactory.getLogger(CucumberEventListener.class);
    public static String screenshotAbsolutePath;
    List<SquashAPIUtil.TestCaseOBJ> listObjFeature = SingletonListTestCase.getInstance().listObjFeature;
    private EventHandler<TestStepFinished> eventHandler = new EventHandler<TestStepFinished>() {
        public void receive(TestStepFinished event) {
            try {
                //Get uri test case is running
                String fileFeature = String.valueOf(event.getTestCase().getUri());
                String[] result = fileFeature.split("//");
                String fileURL = result[1];
                //Read file .feature
                List<String> lines = Files.readAllLines(new File(fileURL).toPath());
                //Extract caseID data from 1st line of feature
                String textCaseID = getStringFromOtherString(lines.get(0),"#(\\d+)");
                //Loop and find testcase obj is running on listObjFeature
                for (SquashAPIUtil.TestCaseOBJ obj: listObjFeature) {
                    //get only obj same TestcaseID
                    if (obj.getIDTestCase().equals(textCaseID)){
                        ArrayList listExecution = obj.getExecutions();
                        //Check
                        for(int i=0; i < listExecution.size(); i++){
                            //Call API Squash get execution data
                            String data = getExecutions(listExecution.get(0).toString());
                            ArrayList execution_steps = JsonPath.parse(data).read("$.execution_steps[*]", ArrayList.class);
                            String updatestepID= "";
                            String updateResutlStatus= "";
                            Map<String, ArrayList> dataSetSquash =  obj.getDataSet();

                            for(int j=0; j < execution_steps.size(); j++){
                                String dataStep = execution_steps.get(j).toString();
                                //StepID on Squash
                                String stepID = getStringFromOtherString(dataStep,"id=(\\d+)");
                                //Step on Squash
                                String action = getStringFromOtherString(dataStep,"action=(\\D+),\\sexpected_result.*").split(" ", 2)[1];;
                                logger.debug("stepID: " + stepID + " action:"+ action);
                                //Get result form cucumber even
                                if (event.getTestStep() instanceof PickleStepTestStep) {
                                    String message = ((PickleStepTestStep) event.getTestStep()).getStep().getText();
                                    String getPattern = ((PickleStepTestStep) event.getTestStep()).getPattern();
                                    //Get Argument input form step
                                    List<Argument> DefinitionArgument = ((PickleStepTestStep) event.getTestStep()).getDefinitionArgument();
                                    //Only get data form step had argument
                                    if(DefinitionArgument.size() > 0) {
                                        //loop to get pair argument
                                        for(int h=0; h < DefinitionArgument.size(); h+=2) {
                                            String pairDataSet = DefinitionArgument.get(h).getValue() +" - "+ DefinitionArgument.get(h+1).getValue();
                                            message = message.replace(pairDataSet,getValueFromSquashDataSet(dataSetSquash, DefinitionArgument.get(h).getValue(), DefinitionArgument.get(h+1).getValue())) ;
                                        }
                                    }
                                    logger.info( "Map step: "+ message  + " VS "+ action );
                                    if(action.equals(message)) {
                                        updatestepID = stepID;
                                        updateResutlStatus= event.getResult().getStatus().toString();
                                        break;
                                    }
                                }
                            }
                            //if the step had a status, update it.
                            if (!updatestepID.isEmpty()){
                                logger.info("Update status stepID: " + updatestepID + " updateResutl: "+ updateResutlStatus);
                                if(updateResutlStatus.equals("PASSED")){
                                    updateExecutionStepByID(updatestepID,"success");
                                }
                                if(updateResutlStatus.equals("FAILED")){
                                    updateExecutionStepByID(updatestepID,"failure");
                                    SingletonListTestCase.getInstance().setCurrentStepFail(updatestepID);

                                }
                                if(updateResutlStatus.equals("SKIPPED")){
                                    updateExecutionStepByID(updatestepID,"untestable");
                                }
                            }
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    private EventHandler<TestCaseFinished> eventHandlerTestCaseFinished = new EventHandler<TestCaseFinished>() {
        public void receive(TestCaseFinished event) {
            try {
                //Get uri test case is running
                String fileFeature = String.valueOf(event.getTestCase().getUri());
                String[] result = fileFeature.split("//");
                String fileURL = result[1];
                //Read file .feature
                List<String> lines = Files.readAllLines(new File(fileURL).toPath());
                //Extract caseID data from 1st line of feature
                String textCaseID = getStringFromOtherString(lines.get(0),"#(\\d+)");
                logger.info("eventHandlerTestCaseFinished: " + event.getResult().getStatus());
                switch (event.getResult().getStatus()) {
                    case FAILED:
                        updateExecution(listObjFeature, textCaseID,"FAILURE");
                        updateExecutionComment(listObjFeature,"Cause: "+ textCaseID,event.getResult().getError().toString());
                        break;
                    case PASSED:
                        updateExecution(listObjFeature, textCaseID,"SUCCESS");
                        break;
                    case PENDING:
                        updateExecution(listObjFeature, textCaseID,"untestable");
                        break;
                    case UNDEFINED:
                        updateExecution(listObjFeature, textCaseID,"untestable");
                        break;
                    case SKIPPED:
                        updateExecution(listObjFeature, textCaseID,"not-run");
                        break;
                    default:
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };


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

    /**
     * Hàm lấy dữ liệu theo dòng cột trong biến map chứa dataset từ squash
     * author: minhlh5
     * Input:   Map<String, ArrayList>
     * Output: data thỏa điều kine65
     * */
    public static String getValueFromSquashDataSet(Map<String, ArrayList> data , String name, String cul ) {
        String query = "$."+ name +"[?(@.parameter_name == '"+cul+"')]";
        query = query.replaceAll("\"","");
        ArrayList<String> dataset = JsonPath.parse(data).read(query, ArrayList.class);
        String result = getStringFromOtherString(dataset.toString(),"\"parameter_value\":\"(.)\"");
        logger.debug(result);
        return result;
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        //Update result step test case
        publisher.registerHandlerFor(TestStepFinished.class, eventHandler);
        //Update result execution plan
        publisher.registerHandlerFor(TestCaseFinished.class, eventHandlerTestCaseFinished);
    }
}
