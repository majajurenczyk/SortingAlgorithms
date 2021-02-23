public class QuickSort extends Algorithm {

    public static void swap(int[]array, int firstIndex, int otherIndex){
        int tmp=array[firstIndex];
        array[firstIndex]=array[otherIndex];
        array[otherIndex]=tmp;
    }

    public static void sort(int[]array, int toIndex){
        if(array==null||array.length==0){
            throw new IllegalArgumentException();
        }
        if(toIndex<0||toIndex>=array.length){
            throw new IndexOutOfBoundsException();
        }
        quickSort(array,0,toIndex);
    }

    private static void quickSort(int[]arr, int left, int right){
        if(left>=right){ //kończy dla pojedynczego elementu
            return;
        }
        int border=QuickSort.partition(arr,left,right);
        if(border-left<right-border) { //zmniejszanie głębokości rekurencji-najpierw rozwiązuję krótszy podproblem
            quickSort(arr, left, border - 1);
            quickSort(arr, border + 1, right);
        }
        else{
            quickSort(arr, border + 1, right);
            quickSort(arr, left, border - 1);
        }
    }
    private static int partition(int[]arr, int left, int right){
        int pivot=findPivot(arr,left,right);
        int border=left-1;
        int it=left;

        while(it<right){ //tablice przeszukuje i przed granicę wstawiam wartości mniejsze od pivota zamieniając
            if(arr[it]<pivot){
                border++;
                if(border!=it){
                    QuickSort.swap(arr,border,it);
                }
            }
            it++;
        }

        border++;  //pierwszy element za granicą zamianiam z pivotem żeby był na właściwym miejscu
        if(border!=right){
            swap(arr,border,right);
        }
        return border;
    }
    private static int findPivot(int arr[], int left, int right){
        int midIndex=left+(right-left)/2; //pivot wybieram jako element ze środka tablicy ale umieszczam go na ostatnim indeksie
        int pivot=arr[midIndex];
        swap(arr,midIndex,right);
        return pivot;
    }
}
