package net.fpt.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static net.fpt.utils.PropertyUtils.*;
import static com.jayway.jsonpath.JsonPath.parse;
import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class SquashAPIUtil {
    static final Logger logger = LoggerFactory.getLogger(SquashAPIUtil.class);
    static String squashURL = getProperty("squash.server.url");
    static String user = getProperty("squash.server.user");
    static String pwd = getProperty("squash.server.pwd");


    public static void getAllProjects() {
        String body = Unirest.get(squashURL + "/api/rest/latest/projects")
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .queryString("page", "0")
                .queryString("size", "3")
                .asString().getBody();
    }

    public static void getAllCampaigns() {
        String body = Unirest.get(squashURL + "/api/rest/latest/campaigns")
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .queryString("size", "0")
                .asString().getBody();
        logger.info("List Runner feature" + body);
    }

    public static String getCampaignByID(String id) {
        logger.info("getCampaignByID");
        String body = Unirest.get(squashURL + "/api/rest/latest/campaigns/{id}")
                .routeParam("id", id)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .queryString("size", "0")
                .asString().getBody();
        return body;
    }

    public static String getIterationByID(String id) {
        logger.info("getIterationByID");
        String body = Unirest.get(squashURL + "/api/rest/latest/test-cases/{testcaseID}")
                .routeParam("testcaseID", id)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .asString().getBody();
        return body;
    }

    public static String getTestCaseByID(String id) {
        logger.info("getTestCaseByID");
        String body = Unirest.get(squashURL + "/api/rest/latest/test-cases/{testcaseID}")
                .routeParam("testcaseID", id)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .asString().getBody();
        return body;
    }

    public static String getScriptFeatureByTestCase(String id) {
        logger.info("getScriptFeatureByTestCase");
        return JsonPath.parse(getTestCaseByID(id))
                .read("$.automated_test_reference");
    }

    public static String getExecutions(String executionID) {
        logger.info("getExecutions: "+ executionID);
        String body = Unirest.get(squashURL + "/api/rest/latest/executions/{executionID}")
                .routeParam("executionID", executionID)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .asString().getBody();
        return body;
    }

    public static String getIterationsTestPlanByID(String iterationID) {
        logger.info("getIterationsTestPlanByID: "+ iterationID);
        String body = Unirest.get(squashURL + "/api/rest/latest/iterations/{iterationID}/test-plan?size=1000")
                .routeParam("iterationID", iterationID)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .asString().getBody();
        return body;
    }

    public static String createExecutionOfTestPlan(String TestPlanID) {
        logger.info("createExecutionOfTestPlan:" + TestPlanID);
        String body = Unirest.post(squashURL + "/api/rest/latest/iteration-test-plan-items/{TestPlanID}/executions")
                .routeParam("TestPlanID", TestPlanID)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .asString().getBody();
        logger.debug("createExecutionOfTestPlan body \n" + body);
        return body;
    }

   public static void updateExecutionByID(String executionID,String execution_status) {
        logger.info("updateExecutionByID:" + executionID);
        Date nowDate = new Date();
        //String studentJsonData= "{\"_type\" : \"execution\",\"execution_status\" : \""+ execution_status +"\", \"comment\" : \"<p>"+ comment +"</p>\",\"last_executed_on\" : \""+ nowDate.getTime() +"\" }";
       String studentJsonData= "{\"_type\" : \"execution\",\"execution_status\" : \""+ execution_status +"\",\"last_executed_on\" : \""+ nowDate.getTime() +"\" }";
        Unirest.patch(squashURL + "/api/rest/latest/executions/{executionID}")
                .routeParam("executionID", executionID)
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(studentJsonData)
                .basicAuth(user, pwd)
                .asJson();
    }

    public static class bodyObj {

        private String _type;
        private String comment;
        private String prerequisite;

        public bodyObj(String execution, String comment, String s) {
            this._type = execution;
            this.comment=comment;
            this.prerequisite=s;
        }
    }

    public static void updateExecutionCommentByID(String executionID, String comment) {

        logger.info("updateExecutionCommentByID:" + executionID);
        Date nowDate = new Date();
        Unirest.patch(squashURL + "/api/rest/latest/executions/{executionID}")
                .routeParam("executionID", executionID)
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(new bodyObj("execution",comment,""))
                .basicAuth(user, pwd)
                .asJson()
                .ifFailure(response -> {
                    logger.error("Oh No! Status" + response.getStatus());
                    logger.error(String.valueOf(response.getBody()));
                });
    }

    public static void updateExecutionStepByID(String executionStepID,String executionStepStatus) {
        logger.info("updateExecutionStepByID:" + executionStepID);
        Unirest.patch(squashURL + "/api/rest/latest/execution-steps/{executionStepID}/execution-status/{executionStepStatus}")
                .routeParam("executionStepID", executionStepID)
                .routeParam("executionStepStatus", executionStepStatus)
                .header("Content-Type", "application/json;charset=UTF-8")
                .basicAuth(user, pwd)
                .asJson();
    }

    public static void updateCommentExecutionStepByID(String executionStepID,String comment) {
        logger.info("updateCommentExecutionStepByID:" + executionStepID);
        Date nowDate = new Date();
        String studentJsonData= "{\"_type\" : \"execution-step\",\"comment\" : \"<p>"+ comment +"</p>\" }";
        Unirest.patch(squashURL + "/api/rest/latest/execution-steps/{executionID}")
                .routeParam("executionID", executionStepID)
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(new bodyObj("execution-step",comment,""))
                .basicAuth(user, pwd)
                .asJson()
                .ifFailure(response -> {
                    logger.error("Oh No! Status" + response.getStatus());
                    logger.error(String.valueOf(response.getBody()));
                });
    }

    /**
     * Lấy thông tin dataset của test case
     *
     * @param TestcaseID ID test case
     * @param dataSetName Tên dòng
     * @param parameterName tên cột
     * @return
     */

    public static String getDateSetByID(String TestcaseID, String dataSetName, String parameterName) {
        logger.info("getDateSetByID:" + TestcaseID);
        String jsonRes = Unirest.get(squashURL + "/api/rest/latest/test-cases/{testcaseID}/datasets?size=1000")
                .routeParam("testcaseID", TestcaseID)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .asString().getBody();
        List<String> listDataSets = JsonPath.parse(jsonRes).read("$._embedded.datasets", List.class);
        for (int k = 0; k < listDataSets.toArray().length; k++) {
            String nameRes = JsonPath.parse(listDataSets.toArray()[k]).read("$.name", String.class);
            logger.info("nameRes:" + nameRes);
            if (nameRes.equals(dataSetName)){
                ArrayList<String> list_parameter_values = JsonPath.parse(listDataSets.toArray()[k]).read("$.parameter_values", ArrayList.class);
                for (int i = 0; i < list_parameter_values.toArray().length; i++) {
                    String parameterNameRes = JsonPath.parse(list_parameter_values.toArray()[i]).read("$.parameter_name", String.class);
                    if(parameterNameRes.equals(parameterName)){
                        return JsonPath.parse(list_parameter_values.toArray()[i]).read("$.parameter_value", String.class);
                    }
                }
            }
        }
        return "";
    }

    /**
     * Lấy thông tin dataset của test case
     *
     * @param TestcaseID ID test case
     * @return
     */

    public static  HashMap<String, ArrayList> getHashMapDataSetByID(String TestcaseID) {
        HashMap<String, ArrayList> restulData = new HashMap<String, ArrayList>();
        logger.info("getHashMapDateSetByID:" + TestcaseID);
        String jsonRes = Unirest.get(squashURL + "/api/rest/latest/test-cases/{testcaseID}/datasets?size=1000")
                .routeParam("testcaseID", TestcaseID)
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .asString().getBody();
        List<String> listDataSets = JsonPath.parse(jsonRes).read("$._embedded.datasets", List.class);
        for (int k = 0; k < listDataSets.toArray().length; k++) {
            String nameRes = JsonPath.parse(listDataSets.toArray()[k]).read("$.name", String.class);
            ArrayList<String> listParameterValues = JsonPath.parse(listDataSets.toArray()[k]).read("$.parameter_values", ArrayList.class);
            restulData.put(nameRes,listParameterValues);
        }
        return restulData;
    }


    /**
     * Lấy danh sách tất cả các campaign tồn tại trong squash API , dùng ID của campaign để lộc ra thông tin các iterations có trang thái là IN_PROGRESS (user tự set trên web)
     * từ đó lấy test-plan từ iterations chứa thông tin testcase (gọi API để lấy testScriptFeature) và executions (khởi tạo khi chạy một test case) chỉ lấy các test-plan có trạng thái là READY
     * nếu chưa có executions thì tạo để cập nhật thông tin từ auto trả về. Khi đầy đủ các thông tin thì tạo TestCaseOBJ để lưu thông tin từng case. add từ case vào danh sách
     *
     * @return
     */

    public static List<TestCaseOBJ> getlistCucumber() {
        logger.info("listCucumberFeatures");
        ArrayList<TestCaseOBJ> results = new ArrayList<TestCaseOBJ>();
        // Danh sách các campaigns
        JSONArray jsonArray = Unirest.get(squashURL + "/api/rest/latest/campaigns")
                .basicAuth(user, pwd)
                .header("Accept", "application/json")
                .queryString("size", "0")
                .queryString("fields", "id")
                .asJson()
                .getBody()
                .getObject()
                .getJSONObject("_embedded")
                .getJSONArray("campaigns");

        // khởi tạo một danh sách chi tiết các campaign để lọc thông tin từ json
        ArrayList<String> arrayListCampaignDetail = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            //Dựa vào ID tìm dc, gọi api lấy thông tin chi tiết của tất cả các Campaign thêm vào trong danh sách.
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            arrayListCampaignDetail.add(getCampaignByID(jsonObject.getString("id")));
        }
        logger.debug("List arrayListCampaignDetail \n"+arrayListCampaignDetail.toString());

        //Lọc lấy thông tin các iterations thỏa điều kiện thuộc các campaigns có trạng thái là 'IN_PROGRESS' -> test maual thực hiện
        List<String> listIterationsTestPlanAvailable = JsonPath.parse(arrayListCampaignDetail.toString())
                .read("[?(@.status == 'IN_PROGRESS')].iterations.[*].id", List.class);
        //logger.debug("List iterations available \n"+listIterationsTestPlanAvailable.toString());

        for (int y = 0; y < listIterationsTestPlanAvailable.size(); y++) {
            logger.info("List iterations available : "+y);
            //Lấy thông tin Test Plan trong iterations, bên trong test plan list các iteration-test-plan-item tương tứng với 1 testcase và các executions
            String jsonRes = getIterationsTestPlanByID(String.valueOf(listIterationsTestPlanAvailable.get(y)));

            //Lọc id testcase các execution có trạng thái execution_status của test-plan là ready nếu ko có thì gọi IP tạo

            List<String> listTestPlan = JsonPath.parse(jsonRes).read("$._embedded.test-plan", List.class);

            for (int k = 0; k < listTestPlan.toArray().length; k++) {
                String testPlanItem = JsonPath.parse(listTestPlan.toArray()[k]).read("$.id", String.class);
                String executionStatus = JsonPath.parse(listTestPlan.toArray()[k]).read("$.execution_status", String.class);
                ArrayList<String> executions = JsonPath.parse(listTestPlan.toArray()[k]).read("$.executions[*].id", ArrayList.class);
                String idTestCase = JsonPath.parse(listTestPlan.toArray()[k]).read("$.referenced_test_case.id", String.class);
                String automatedReference = getScriptFeatureByTestCase(idTestCase);
                //lấy dataset của test case
                HashMap<String, ArrayList> dataSet = null;
                //fix Data Set trả về null
                try {
                    dataSet = getHashMapDataSetByID(idTestCase);
                } catch (Exception e){

                }
                //logger.info("Feature \n" + obj.IDTestCase);
                logger.info("\n"+testPlanItem + "-"+executionStatus + "- "+executions + "-"+idTestCase + "-"+ automatedReference);
                //xác định test case có execution hay chưa, nếu chưa có thì tạo và thêm vào list testcase
                logger.info("Executions site: "+executions.size() );
                logger.info("Results leng: "+results.size() );

                if (executionStatus.equals("READY") && executions.size() == 0) {
                    ArrayList getExecutionsList = new ArrayList<>();
                    getExecutionsList.add(JsonPath.parse(createExecutionOfTestPlan(testPlanItem))
                            .read("$.id"));

                    TestCaseOBJ testCaseOBJ;
                    if(dataSet== null){
                        testCaseOBJ =new TestCaseOBJ(idTestCase,automatedReference, getExecutionsList);
                    }else {
                        testCaseOBJ=new TestCaseOBJ(idTestCase,automatedReference, getExecutionsList, dataSet);
                    }
                    System.out.println(testCaseOBJ);
                    results.add(testCaseOBJ);
                }

                //nếu đã có thì add vào list
                if (executionStatus.equals("READY") && executions.size() > 0) {
                    TestCaseOBJ obj = new TestCaseOBJ(idTestCase,automatedReference, executions, dataSet );
                    logger.debug("No executions\n"+ obj);
                    results.add(obj);
                }

                logger.debug( y + "-" + listTestPlan.size());
            }
        }
        logger.info("Number cases run " + results.size());
        return results;
    }

    /**
     *
     * @param data
     * @return
     */
    public static String getlistCucumberFeatures(List<TestCaseOBJ> data) {
        logger.info("getlistCucumberFeatures");
        ArrayList<String> results = new ArrayList<>();
        for (TestCaseOBJ obj: data) {
            String script = obj.getTestScriptFeature();
            results.add(script);
        }
        return results.toString();
    }

    public static ArrayList<String> getlistExecutionsByTestScriptFeature(List<TestCaseOBJ> data ,String testScriptFeature) {
        logger.info("getlistExecutionsByTestScriptFeature");
        ArrayList<String> results = new ArrayList<>();;
        for (TestCaseOBJ obj: data) {
            if(obj.getTestScriptFeature().equals(testScriptFeature)){
                results.addAll(obj.getExecutions());
            }
        }
        return results;
    }

    /**
     * onTestSuccess method
     *
     * Điều kiện để report cập nhật được trên squash thì feature phải có thông tin case tương ứng
     * vd: Feature: Add new item to ToDO list #7
     * @param
     */
    public static void updateExecution(List<SquashAPIUtil.TestCaseOBJ> listObjFeature,String resultTextCaseID,String exection_status){
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
     *  Cập nhật comment vào bên trong testcase do mỗi testcase khi thực thi tạo ra một execution
     *
     * Điều kiện để report cập nhật được trên squash thì feature phải có thông tin case tương ứng
     * vd: Feature: Add new item to ToDO list #7
     * @param
     */
    public static void updateExecutionComment(List<SquashAPIUtil.TestCaseOBJ> listObjFeature,String resultTextCaseID, String comment){
        for (SquashAPIUtil.TestCaseOBJ obj: listObjFeature ) {
            if(obj.getIDTestCase().equals(resultTextCaseID)) {
                logger.info( obj.getExecutions().toString());
                ArrayList listExecutions = obj.getExecutions();
                for (int i = 0; i < listExecutions.size(); i++ ) {
                    String ID = listExecutions.get(i).toString();
                    updateExecutionCommentByID(ID,comment);
                }
            }
        }
    }


    /**
     * Lưu thông tin case từ squash api
    * */

    public static class TestCaseOBJ {

        public String IDTestCase;
        public ArrayList executions;
        public String testScriptFeature; //automated_test_reference
        public HashMap<String, ArrayList> dataSet;

        public TestCaseOBJ(String IDTestCase,String automatedReference,ArrayList list,  HashMap<String, ArrayList> dataSet) {
            this.IDTestCase = IDTestCase;
            this.testScriptFeature= automatedReference;
            this.executions = list;
            this.dataSet= dataSet;
        }

        public TestCaseOBJ(String IDTestCase,String automatedReference,ArrayList list) {
            this.IDTestCase = IDTestCase;
            this.testScriptFeature= automatedReference;
            this.executions = list;
        }

        public String getIDTestCase() {
            return this.IDTestCase;
        }

        public String getTestScriptFeature() {
            return this.testScriptFeature;
        }

        public ArrayList getExecutions() {
            return this.executions;
        }

        public HashMap<String, ArrayList> getDataSet() {return this.dataSet;}
    }
}

