package MyRunner;

import net.fpt.utils.SquashAPIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SingletonListTestCase {
    static final Logger logger = LoggerFactory.getLogger(SingletonListTestCase.class);
    // Singleton class for get/set data to listObjFeature
    public List<SquashAPIUtil.TestCaseOBJ> listObjFeature;
    public LinkedList<String> currentStepFail = new LinkedList<>();

    private static SingletonListTestCase instance = null;

    public static SingletonListTestCase getInstance(){
        if(instance==null){
            instance = new SingletonListTestCase();
        }
        return instance;
    }

    public void setCurrentStepFail(String input) {
        logger.info("Queue: " + this.currentStepFail);
        if (!(currentStepFail.indexOf(input) >0)) {
            currentStepFail.add(input);
        }
    }
}