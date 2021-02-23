public class MergeSort extends Algorithm {
    private static int [] extraArray;

    public static void sort(int [] array){
        if(array==null||array.length==0){
            throw new IllegalArgumentException();
        }
        extraArray=new int[array.length];
        mergeSort(array, 0, array.length-1);
    }
    private static void mergeSort(int []arr, int left, int right){
        if(left<right){
            int mid=(left+right)/2; //kolejno rekurencyjnie dziele aż do uzyskania jednoelementowych podproblemów
            mergeSort(arr, left, mid);
            mergeSort(arr,mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int []arr, int left, int mid, int right){ //scalam podproblemy, tworze tablice uporządkowane z dwóch uporządkowanych
        for(int i=left; i<=right; i++){
            extraArray[i]=arr[i]; //potrzebna dodatkowa struktura do przechowania już uporządkowanych elementów
        }
        int actual=left;
        int beginFirst=left; //poczatek pierwszego podproblemu
        int beginSecond=mid+1; //poczatek drugiego podproblemu
        while(beginFirst<=mid&&beginSecond<=right){ //kolejno porównuje pierwsze elementy pod problemów i odpowiednio wstawiam do dodatkowej struktury
            if(extraArray[beginFirst]<=extraArray[beginSecond]){
                arr[actual]=extraArray[beginFirst];
                beginFirst++;
            }
            else{
                arr[actual]=extraArray[beginSecond];
                beginSecond++;
            }
            actual++;
        }
        while(beginFirst<=mid){ //przypadek kiedy skonczy sie drugi podproblem
            arr[actual]=extraArray[beginFirst];
            actual++;
            beginFirst++;
        }
    }
}
