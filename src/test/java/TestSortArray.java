import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestSortArray {

    @Test
    public void test() {
        {
            int[] array = {7, 4, 3, 6, 3, 7, 1, 7, 7, 0, 0, 8, 8, 0, 0, 0};
            int[] correctArray = {1, 4,6, 3, 3, 8, 8, 7, 7, 7, 7, 0, 0, 0, 0,0};
            int[] arrayForCheck = SortArrayByElementCount.sortArrayByElementCount(array);
            Assert.assertTrue(String.format("Arrays are not equal, correct array is %s, the function's result is %s",
                    SortArrayByElementCount.arrayToString(correctArray),
                    SortArrayByElementCount.arrayToString(arrayForCheck)),
                    SortArrayByElementCount.areArraysEqual(correctArray, arrayForCheck));
        }
        {
            int[] array = {1, 10, 3, 5, 4, 9, 6, 6, 3, 5, 5, 5};
            int[] correctArray = {1, 4, 9, 10, 3, 3, 6, 6, 5, 5, 5, 5};
            int[] arrayForCheck = SortArrayByElementCount.sortArrayByElementCount(array);
            Assert.assertTrue(String.format("Arrays are not equal, correct array is %s, the function's result is %s",
                    SortArrayByElementCount.arrayToString(correctArray),
                    SortArrayByElementCount.arrayToString(arrayForCheck)),
                    SortArrayByElementCount.areArraysEqual(correctArray, arrayForCheck));
        }
        {
            int[] array = {1, 2, 1, 3, 2, 1};
            int[] correctArray = {3, 2, 2, 1, 1, 1};
            int[] arrayForCheck = SortArrayByElementCount.sortArrayByElementCount(array);
            Assert.assertTrue(String.format("Arrays are not equal, correct array is %s, the function's result is %s",
                    SortArrayByElementCount.arrayToString(correctArray),
                    SortArrayByElementCount.arrayToString(arrayForCheck)),
                    SortArrayByElementCount.areArraysEqual(correctArray, arrayForCheck));
        }

    }


    @Test(expected = ArraySortException.class)
    public void testException() {
        int[] array = {};
        SortArrayByElementCount.sortArrayByElementCount(array);
    }


}
