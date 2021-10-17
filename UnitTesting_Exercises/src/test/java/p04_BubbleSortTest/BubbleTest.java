package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testBubbleSortWorkWithCorrectInts() {
        int[] arr = {23,4,65,0,6,34};
        Bubble.sort(arr);
        int[] sortedArr = {0,4,6,23,34,65};

        Assert.assertArrayEquals(sortedArr,arr);
    }
}
