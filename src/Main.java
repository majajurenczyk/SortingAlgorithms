import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("Duplicates")
    public static void main(String[]args) throws IOException {

        /*int[][] random100k= Generator.readFromFile("Random100k");
        TimeData.saveTimesToFile(random100k, "RESULTS_Random100k");

        int[][] random500k= Generator.readFromFile("Random500k");
        TimeData.saveTimesToFile(random500k, "RESULTS_Random500k");

        int[][] random1kk= Generator.readFromFile("Random1kk");
        TimeData.saveTimesToFile(random1kk, "RESULTS_Random1kk");

        int[][] random2kk= Generator.readFromFile("Random2kk");
        TimeData.saveTimesToFile(random2kk, "RESULTS_Random2kk");*/

        /*int[][] sorted100k= Generator.readFromFile("Sorted100k");
        TimeData.saveTimesToFile(sorted100k, "RESULTS_Sorted100k");

        int[][] sorted500k= Generator.readFromFile("Sorted500k");
        TimeData.saveTimesToFile(sorted500k, "RESULTS_Sorted500k");

        int[][] sorted1kk= Generator.readFromFile("Sorted1kk");
        TimeData.saveTimesToFile(sorted1kk, "RESULTS_Sorted1kk");

        int[][] sorted2kk= Generator.readFromFile("Sorted2kk");
        TimeData.saveTimesToFile(sorted2kk, "RESULTS_Sorted2kk");*/


       /*  int[][] halfSorted100k= Generator.readFromFile("HalfSorted100k");
        TimeData.saveTimesToFile(halfSorted100k, "RESULTS_HalfSorted100k");

        int[][] halfSorted500k= Generator.readFromFile("HalfSorted500k");
        TimeData.saveTimesToFile(halfSorted500k, "RESULTS_HalfSorted500k");

        int[][] halfSorted1kk= Generator.readFromFile("HalfSorted1kk");
        TimeData.saveTimesToFile(halfSorted1kk, "RESULTS_HalfSorted1kk");

        int[][] halfSorted2kk= Generator.readFromFile("HalfSorted2kk");
        TimeData.saveTimesToFile(halfSorted2kk, "RESULTS_HalfSorted2kk");*/

        /*int[][] reversed100k= Generator.readFromFile("Reversed100k");
        TimeData.saveTimesToFile(reversed100k, "RESULTS_Reversed100k");

        int[][] reversed500k= Generator.readFromFile("Reversed500k");
        TimeData.saveTimesToFile(reversed500k, "RESULTS_Reversed500k");

        int[][] reversed1kk= Generator.readFromFile("Reversed1kk");
        TimeData.saveTimesToFile(reversed1kk, "RESULTS_Reversed1kk");

        int[][] reversed2kk= Generator.readFromFile("Reversed2kk");
        TimeData.saveTimesToFile(reversed2kk, "RESULTS_Reversed2kk");*/

       Scanner sc= new Scanner(System.in);
       Menu ui=new Menu();
       ui.menuStart(sc);

        /*ArrayList<Long> times=new ArrayList<>();
        long start; long end;
        for(int i=0; i<arr.length; i++){
                start = System.nanoTime();
                QuickSort.sort(arr[i], arr[i].length-1);
                end = System.nanoTime();
                times.add(end - start);
            }
        System.out.println(Arrays.toString(times.toArray()));*/
    }
}
