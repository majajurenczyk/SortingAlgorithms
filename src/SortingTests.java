import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTests {
    @Test
    void quickSortTest(){
       int [] arr={2,4,1,6,0};
       int [] arrSorted={0,1,2,4,6};
       int [][] arr1 = Generator.generateRandom(1, 100000);
       QuickSort.sort(arr,arr.length-1);
       QuickSort.sort(arr1[0], arr1[0].length-1);

       assertTrue(Algorithm.sortingTest(arr1[0]));
       assertArrayEquals(arr, arrSorted);
    }

    @Test
    void mergeSortTest(){
        int [] arr={2,4,1,6,0};
        int [] arrSorted={0,1,2,4,6};
        int [][] arr1 = Generator.generateRandom(1, 100000);

        MergeSort.sort(arr);
        MergeSort.sort(arr1[0]);

        assertTrue(Algorithm.sortingTest(arr1[0]));
        assertArrayEquals(arr, arrSorted);
    }

    @Test
    void shellShellSortTest(){
        int [] arr={2,4,1,6,0};
        int [] arrSorted={0,1,2,4,6};
        int [][] arr1 = Generator.generateRandom(1, 100000);
        ShellSort.sort(arr,ShellSort.generateShellDistances(arr.length));
        ShellSort.sort(arr1[0], ShellSort.generateShellDistances(arr1[0].length));

        assertTrue(Algorithm.sortingTest(arr1[0]));
        assertArrayEquals(arr, arrSorted);
    }

    @Test
    void shellSedgewickSortTest(){
        int [] arr={2,4,1,6,0};
        int [] arrSorted={0,1,2,4,6};
        int [][] arr1 = Generator.generateRandom(1, 100000);
        ShellSort.sort(arr,ShellSort.generateSedgewickDistances(arr.length));
        ShellSort.sort(arr1[0], ShellSort.generateSedgewickDistances(arr1[0].length));

        assertTrue(Algorithm.sortingTest(arr1[0]));
        assertArrayEquals(arr, arrSorted);
    }
    @Test
    void singleElementTest(){
        int [] arr={1};
        int [] arrTest={1};
        QuickSort.sort(arr, arr.length-1);
        MergeSort.sort(arr);
        ShellSort.sort(arr, ShellSort.generateShellDistances(arr.length));
        ShellSort.sort(arr, ShellSort.generateSedgewickDistances(arr.length));

        assertArrayEquals(arr, arrTest);
    }

    @Test
    void emptyArrayTest() {
        int[] arrQuick = new int[0];
        int[] arrMerge = new int[0];
        int[] arrShell = new int[0];

        assertThrows(IllegalArgumentException.class,
                () -> {
                    QuickSort.sort(arrQuick, arrQuick.length);
                });

        assertThrows(IllegalArgumentException.class,
                () -> {
                    MergeSort.sort(arrMerge);
                });

        assertThrows(IllegalArgumentException.class,
                () -> {
                    ShellSort.sort(arrShell, ShellSort.generateShellDistances(arrShell.length));
                });


    }
}

