import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    int type;
    int length;
    int option;
    int arr[][];
    int copy[];
    int sortType;
    int resultType;


    public static void displayStart(){
        System.out.println("--MENU--");
        System.out.println("1 - WYBÓR CIĄGU");
        System.out.println("2 - WYJŚCIE");
        System.out.println("___________________");
    }
    public void displayType(){
        System.out.println("--WYBIERZ RODZAJ POSORTOWANIA CIĄGU--");
        System.out.println("1 - RANDOMOWY");
        System.out.println("2 - POŁOWICZNIE POSORTOWANY");
        System.out.println("3 - POSORTOWANY");
        System.out.println("4 - ODWROTNIE POSORTOWANY");
        System.out.println("___________________");
    }
    public void displayLong(){
        System.out.println("--PODAJ DŁUGOŚĆ CIĄGU-- ");
        System.out.println("___________________");
    }

    public void displaySort(){
        System.out.println("--WYBIERZ ALGORYTM SORTOWANIA--");
        System.out.println("1 - QUICKSORT");
        System.out.println("2 - MERGESORT");
        System.out.println("3 - SHELLSORT (ODSTĘPY SHELLA)");
        System.out.println("4 - SHELLSORT (ODSTĘPY SEDGEWICKA)");
        System.out.println("___________________");
    }
    public void displayResult(){
        System.out.println("--WYBIERZ JAKĄ INFORMACJĘ CHCESZ ZOBACZYĆ--");
        System.out.println("1 - WYŚWIETL CIĄG PRZED I PO SORTOWANIU (DLA CIĄGÓW NIEDŁUŻSZYCH NIŻ 1000 ELEMENTÓW)");
        System.out.println("2 - POKAŻ CZY CIĄG JEST POSORTOWANY POPRAWNIE I CZAS SORTOWANIA");
        System.out.println("___________________");
    }

    public void menuStart(Scanner sc) {
        boolean tmp = true;
        while (tmp) {
            displayStart();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    menu(sc);
                    break;
                case 2:
                    tmp = false;
                    break;

            }
        }
    }

    public void menu(Scanner sc){
        displayType();
        type=sc.nextInt();
        displayLong();
        length=sc.nextInt();
        while(length<0||length>2000000){
            System.out.println("PODANA DŁUGOŚĆ CIĄGU JEST NIEPRAWIDŁOWA, PODAJ INNĄ Z PRZEDZIAŁU 0 - 2000000");
            length=sc.nextInt();
        }
        switch(type){
            case 1:
                arr=Generator.generateRandom(1,length);
                break;
            case 2:
                arr=Generator.generateHalfSorted(1, length);
                break;
            case 3:
                arr=Generator.generateSorted(1, length);
                break;
            case 4:
                arr=Generator.generateReversed(1, length);
        }
        copy= Arrays.copyOf(arr[0], arr[0].length);
        displaySort();
        sortType=sc.nextInt();
        displayResult();
        resultType=sc.nextInt();

        copy = Arrays.copyOf(arr[0], arr[0].length);

        switch (resultType){
            case 1:
                if(arr[0].length<=1000) {
                    System.out.println(Arrays.toString(arr[0]));
                    if(sortType==1) {
                        QuickSort.sort(arr[0], arr[0].length - 1);
                        System.out.println(Arrays.toString(arr[0]));
                    }
                    else if(sortType==2) {
                        MergeSort.sort(arr[0]);
                        System.out.println(Arrays.toString(arr[0]));
                    }
                    else if(sortType==3) {
                        ShellSort.sort(arr[0],ShellSort.generateShellDistances(arr[0].length));
                        System.out.println(Arrays.toString(arr[0]));
                    }
                    else if(sortType==4) {
                        ShellSort.sort(arr[0],ShellSort.generateSedgewickDistances(arr[0].length));
                        System.out.println(Arrays.toString(arr[0]));
                    }
                }
                else {
                    System.out.println("Ciąg jest zbyt długi aby go wyświetlić");
                }
                break;
            case 2:
                if(sortType==1) {
                    System.out.println(TimeData.getOneTime(arr[0],TimeData.QUICKSORT_TYPE )+" ns");
                }
                else if(sortType==2) {
                    System.out.println(TimeData.getOneTime(arr[0],TimeData.MERGESORT_TYPE )+" ns");
                }
                else if(sortType==3) {
                    System.out.println(TimeData.getOneTime(arr[0],TimeData.SHELLSORT_SHELL_TYPE )+" ns");
                }
                else if(sortType==4) {
                    System.out.println(TimeData.getOneTime(arr[0],TimeData.SHELLSORT_SEDGEWICK_TYPE )+" ns");
                }
                System.out.println(Algorithm.sortingTest(arr[0]));
                break;

        }
    }
}
