package demo;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyFastestComparatorTest {

    private MyFastestComparator comparator;

    @Before
    public void init() {
        comparator = new MyFastestComparator();
    }

    @Test
    public void readFromFileTest() {
        {
            String source1 = "src/main/resources/list1.json";
            List<CustomNumberEntity> list = comparator.readFromFile(source1);
            assertTrue("The list in " + source1 + " has 7 elements", list.size() == 7);
        }
        {
            String source2 = "src/main/resources/list2.json";
            List<CustomNumberEntity> list = comparator.readFromFile(source2);
            assertTrue("The list in " + source2 + " has 7 elements", list.size() == 2);
        }
        {
            String source3 = "src/main/resources/list3.json";
            List<CustomNumberEntity> list = comparator.readFromFile(source3);
            assertTrue("The list in " + source3 + " has 0 elements", list.size() == 0);
        }
    }

    @Test
    public void containsTest() {
        {
            String source1 = "src/main/resources/list1.json";
            List<CustomNumberEntity> list = comparator.readFromFile(source1);
            int num = 100;
            assertTrue("The number " + num + " is contained in the list", comparator.contains(num, list));
        }
        {
            String source2 = "src/main/resources/list4.json";
            List<CustomNumberEntity> list = comparator.readFromFile(source2);
            int num = 30;
            assertTrue("The number " + num + " is contained in the list", comparator.contains(num, list));
        }
        {
            String source2 = "src/main/resources/list4.json";
            List<CustomNumberEntity> list = comparator.readFromFile(source2);
            int num = 99;
            assertTrue("The number " + num + " should not be contained in the list", !comparator.contains(num, list));
        }

    }
}
