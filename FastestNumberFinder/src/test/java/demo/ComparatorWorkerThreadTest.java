package demo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ComparatorWorkerThreadTest extends MyFastestComparator{

    @Test
    public void readFromFileTest() {
        {
            CustomNumberEntity num = buildCustomNumberEntity("99");
            SharedResult result = new SharedResult();
            Runnable r = new ComparatorWorkerThread(99, num, result);
            r.run();
            assertTrue("The numbers are equal", result.getResult());
        }
        {
            CustomNumberEntity num = buildCustomNumberEntity("0");
            SharedResult result = new SharedResult();
            Runnable r = new ComparatorWorkerThread(99, num, result);
            r.run();
            assertTrue("The numbers are different", !result.getResult());
        }
    }
}
