public class mergesort {
    public static void main (String [] args){
        int [] array = {34, 23, 56, 22, 1, 200};
        System.out.println("Before Sorting: ");
        printArray(array);

        merge_sort(array);
        System.out.println("\nAfter sorting:");
        printArray(array);
    }
    public static void merge_sort(int [] array){
        //define base case:
        if(array.length <= 1){
            return;
        }
        int middlepoint = array.length / 2;
        // creating left and right subarrays:
        int [] leftarray = new int [middlepoint];
        int [] rightarray = new int [array.length - middlepoint];

        for (int i = 0; i<middlepoint; i++){
            leftarray[i] = array[i];
        }
        for (int i = middlepoint; i<array.length; i++){
            rightarray[i- middlepoint] = array[i];// i-middlepoint because, 1st case: i-middlepoint = 0, then as i++ so, 2nd case i-middlepoint = 1 and so on
        }
        // recursively calling the function itself to split the array in the middle point everytime.....
        merge_sort(leftarray);
        merge_sort(rightarray);

        merge(array, leftarray, rightarray);
    }
    //function to merge all arrays back together at the end...
    public static void merge(int[] array, int[] left, int[] right){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            
        }
    }
    //function to print the array......
    public static void printArray(int [] array){
        for (int num : array){ // for integer num in array
            System.out.println(num + " ");
        }
    }
}
