import java.util.ArrayList;
import java.util.Collections;

public class ShellSort extends Algorithm {

    public static void sort(int[] arr, ArrayList<Integer> distances) {
        if(arr==null||arr.length==0||distances.size()==0){
            throw new IllegalArgumentException();
        }
        int it = 1;
        int distance = distances.get(it-1);
        int value;
        int index;

        while (distance >= 1) {
            for (int i = distance; i < arr.length; i++) { //kolejne podciągi wyznaczone przez odstępy sortowane na zasadzie insertion sort
                value = arr[i];
                index = i;
                while (index >= distance && value < arr[index - distance]) {
                    arr[index] = arr[index - distance];
                    index = index - distance;
                }
                arr[index] = value;
            }
            distance = distances.get(++it-1); //pobieram kolejny odstęp zwiekszajac iteracje
        }
    }

    public static ArrayList<Integer> generateShellDistances(int length){ //generowanie ciągu odstępów Shella
        ArrayList<Integer> generatedDistances=new ArrayList<>();
        int it=1;
        int generated;
        do{
            generated=length/(int)Math.pow(2,it);
            generatedDistances.add(generated);
            it++;
        }
        while(generated>0); //ciąg malejacy więc gemeruje je dopóki są większe niż 0
        return generatedDistances;
    }


    public static ArrayList<Integer> generateSedgewickDistances(int length){ //generowanie ciągu odstępów Sedgewicka
        ArrayList<Integer> generatedDistances=new ArrayList<>();
        int generated=0;
        int it=0;
        while(generated<length){
            if(generatedDistances.isEmpty()){
                generatedDistances.add(0);
                generatedDistances.add(1);
            }
            else{
                generated=(int)(Math.pow(4,it)+3*Math.pow(2,it-1)+1); //jak wchodzi tu to iteracja już jest 1
                if(generated<length){ //ciąg rosnący nieskończony więc generuje dopóki odstępy nie są większe niż długość tablicy
                    generatedDistances.add(generated);
                }
            }
            it++;
        }
        Collections.reverse(generatedDistances); //ciąg rosnący więc odwracam
        return generatedDistances;
    }
}