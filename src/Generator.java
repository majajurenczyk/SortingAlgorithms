import java.io.*;
import java.util.Random;

public class Generator {



    private static void reverse(int [] arr){
        int temp;
        for(int i = 0; i < arr.length/2; i++)
        {
            temp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i];
            arr[i] = temp;
        }
    }

    public static int [][] generateRandom(int numberOfSeries, int numberOfElements){
        int [][] arr = new int [numberOfSeries][numberOfElements];
        Random rand = new Random();
        for(int i = 0 ; i < arr.length; i ++){
            for(int j = 0 ; j < arr[i].length ; j++){
                arr[i][j] = rand.nextInt(numberOfElements);
            }
        }
        return arr;
    }
    @SuppressWarnings("Duplicates")
    public static int [][] generateHalfSorted(int numberOfSeries, int numberOfElements){
        int [][] arr = generateRandom(numberOfSeries, numberOfElements);
       for(int i = 0 ; i < arr.length; i ++){
           QuickSort.sort(arr[i], arr[i].length/2);
        }
        return arr;
    }

    @SuppressWarnings("Duplicates")
    public static int [][] generateSorted(int numberOfSeries, int numberOfElements){
        int [][] arr = generateRandom(numberOfSeries, numberOfElements);
        for(int i = 0 ; i < arr.length; i ++){
            QuickSort.sort(arr[i], arr[i].length-1);
        }
        return arr;
    }


    public static int [][] generateReversed(int numberOfSeries, int numberOfElements){
        int [][] arr=generateSorted(numberOfSeries, numberOfElements);
        for(int i=0; i<arr.length; i++){
            Generator.reverse(arr[i]);
        }
        return  arr;
    }

    public static void saveToFile(String nameOfFile, int[][] Object) throws IOException{
        try{
            ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nameOfFile));
            writer.writeObject(Object);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] readFromFile(String nameOfFile)throws IOException{
        int[][]arr;
        try{
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nameOfFile));
            arr=(int[][])reader.readObject();
            return arr;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
