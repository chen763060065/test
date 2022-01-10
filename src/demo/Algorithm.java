package demo;

import java.util.Arrays;

public class Algorithm {

    public static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    public static void bubbleSort(int[] input){
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if(input[j]>input[j+1]){
                    swap(input, j, j+1);
                }
            }
        }
    }
    public static void selectionSort(int[] input){
        for (int i = 0; i < input.length; i++) {
            int min = i;
            for(int j = i + 1; j < input.length; j++){
                if(input[j]<input[min]){
                    min = j;
                }
            }
            swap(input, i, min);
        }
    }
    public static void insertionSort(int[] input){
        for (int i = 1; i < input.length-1; i++) {
            int j = i;
            while(j>=1 && input[j]<input[j-1]){
                swap(input, j-1, j);
                j--;
            }
        }
    }
    public static void shellSort(int[] input){
        int gap = input.length/2;
        while(gap>0){
            for(int i = gap; i<input.length; i++){
                int j = i;
                while(j>=gap&& input[j]< input[j - gap]) {
                    swap(input, j, j - gap);
                    j -=gap;
                }
            }
            gap/=2;
        }
    }

    public static void mergeSort(int[] input){
        int low = 0;
        int high = input.length-1;
        mergeSort(input, low, high);
    }
    public static void mergeSort(int[]input, int low, int high){
        if(high<=low) return;
        int mid = low+(high-low)/2;
        mergeSort(input, low, mid);
        mergeSort(input, mid+1, high);
        merge(input, low, mid, high);
    }
    public static void merge(int[]input, int low, int mid, int high){
        int i = low;
        int j = high;
        int[] tmpArray = input.clone();
        for(int k = low; k <high; k++){

        }
    }

    public static void main(String[] args) {
        int[] array = {5,1,4,3,2,1,6};
        //bubbleSort(array);
        //selectionSort(array);
        //insertionSort(array);
        shellSort(array);
        Arrays.stream(array).forEach(System.out::print);
    }
}
