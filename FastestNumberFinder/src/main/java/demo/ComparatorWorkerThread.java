package demo;
import demo.MyFastestComparator.SharedResult;

public class ComparatorWorkerThread implements Runnable{
    private int value1;
    private CustomNumberEntity value2;
    private SharedResult result;
    private FastestComparator comparator;

    public ComparatorWorkerThread(int value1, CustomNumberEntity value2, SharedResult result){
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
        this.comparator = new FastestComparator();
    }

    public void run() {
        if(comparator.compare(value1, value2) == 0){
            result.setResultTrue();
        }else{

        }
    }
}
