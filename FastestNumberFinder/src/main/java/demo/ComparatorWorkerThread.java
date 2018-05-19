package demo;
import demo.MyFastestComparator.SharedResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComparatorWorkerThread implements Runnable{
    private int value1;
    private CustomNumberEntity value2;
    private SharedResult result;
    private FastestComparator comparator;
    private static Logger LOGGER = LoggerFactory.getLogger(ComparatorWorkerThread.class);

    public ComparatorWorkerThread(int value1, CustomNumberEntity value2, SharedResult result){
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
        this.comparator = new FastestComparator();
    }

    public void run() {
        LOGGER.info("ComparatorWorker initialized: Values " + value1 + " & " + value2 + " will be compared");
        String comparatorStr = "";
        if(comparator.compare(value1, value2) == 0){
            result.setResultTrue();
            comparatorStr = "==";
        }else{
            comparatorStr = "!=";
        }
        LOGGER.info("ComparatorWorker finished: Result " + value1 + comparatorStr + value2);
    }
}
