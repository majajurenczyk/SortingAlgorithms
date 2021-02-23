import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TimeData {

    public static int QUICKSORT_TYPE=1;
    public static int MERGESORT_TYPE=2;
    public static int SHELLSORT_SHELL_TYPE=3;
    public static int SHELLSORT_SEDGEWICK_TYPE=4;

    public static long getOneTime(int [] arr, int type){
        long start; long end;
        int [] copy;
        long time;
        if(type==QUICKSORT_TYPE) {
            start = System.nanoTime();
            QuickSort.sort(arr, arr.length-1);
            end = System.nanoTime();
            time=end-start;
        }
        else if(type==MERGESORT_TYPE){
            start = System.nanoTime();
            MergeSort.sort(arr);
            end = System.nanoTime();
            time=end-start;
        }
        else if(type==SHELLSORT_SHELL_TYPE){
            start = System.nanoTime();
            ShellSort.sort(arr, ShellSort.generateShellDistances(arr.length));
            end = System.nanoTime();
            time=end-start;
        }
        else if(type==SHELLSORT_SEDGEWICK_TYPE){
            start = System.nanoTime();
            ShellSort.sort(arr, ShellSort.generateSedgewickDistances(arr.length));
            end = System.nanoTime();
            time=end-start;
        }
        else{
            throw new IllegalArgumentException();
        }
        return time;

    }

    @SuppressWarnings("Duplicates")
    public static ArrayList<Long> getAllTimes(int[][] arr, int type){
        ArrayList<Long> times=new ArrayList<>();
        long start; long end;
        int [] copy;
        for(int i=0; i<arr.length; i++){
            if(type==QUICKSORT_TYPE) {
                copy=Arrays.copyOf(arr[i], arr[i].length);
                start = System.nanoTime();
                QuickSort.sort(copy, copy.length-1);
                end = System.nanoTime();
                times.add(end - start);
            }
            else if(type==MERGESORT_TYPE){
                copy=Arrays.copyOf(arr[i], arr[i].length);
                start = System.nanoTime();
                MergeSort.sort(copy);
                end = System.nanoTime();
                times.add(end - start);
            }
            else if(type==SHELLSORT_SHELL_TYPE){
                copy=Arrays.copyOf(arr[i], arr[i].length);
                start = System.nanoTime();
                ShellSort.sort(copy, ShellSort.generateShellDistances(copy.length));
                end = System.nanoTime();
                times.add(end - start);
            }
            else if(type==SHELLSORT_SEDGEWICK_TYPE){
                copy=Arrays.copyOf(arr[i], arr[i].length);
                start = System.nanoTime();
                ShellSort.sort(copy, ShellSort.generateSedgewickDistances(copy.length));
                end = System.nanoTime();
                times.add(end - start);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        return times;
    }
@SuppressWarnings("Duplicates")
    public static void saveTimesToFile(int [][] arr, String nameOfFile){
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(new File(nameOfFile)));

            ArrayList<Long> quick=getAllTimes(arr, QUICKSORT_TYPE);
            ArrayList<Long> merge=getAllTimes(arr, MERGESORT_TYPE);
            ArrayList<Long> shell_shell=getAllTimes(arr, SHELLSORT_SHELL_TYPE);
            ArrayList<Long> shell_sedgewick=getAllTimes(arr, SHELLSORT_SEDGEWICK_TYPE);

            writer.write("QUICK SORT");
            for(int i=0; i<quick.size();i++){
                writer.newLine();
                writer.write(String.valueOf(quick.get(i)));
            }
            writer.newLine();
            writer.write("MERGE SORT");
            for(int i=0; i<merge.size();i++){
                writer.newLine();
                writer.write(String.valueOf(merge.get(i)));
            }
            writer.newLine();
            writer.write("SHELL SHELL-GAPPED SORT");
            for(int i=0; i<shell_shell.size();i++){
                writer.newLine();
                writer.write(String.valueOf(shell_shell.get(i)));
            }
            writer.newLine();
            writer.write("SHELL SEDGEWICK-GAPPED SORT");
            for(int i=0; i<shell_sedgewick.size();i++){
                writer.newLine();
                writer.write(String.valueOf(shell_sedgewick.get(i)));
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
