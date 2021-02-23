public class BubbleSort extends Algorithm {

    public static void sort(int[] array, int toIndex) {
        if(toIndex>=array.length||toIndex<0){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i<=toIndex; i++) {
            for (int j = 1; j<=toIndex; j++) {
                if (array[j]<array[j-1]) {
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
