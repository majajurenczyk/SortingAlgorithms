public abstract class Algorithm {

    public static boolean sortingTest(int [] arr){
        int it=1;
        while(it<arr.length){
            if(arr[it]<arr[it-1]){
                return false;
            }
            it++;
        }
        return true;
    }
}
