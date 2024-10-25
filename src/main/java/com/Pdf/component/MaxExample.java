package com.Pdf.component;

public class MaxExample {

    public static void main(String[] args) {
        int[] array = {233,4,545,5, -355,2};

        int max= 0;

        for (int i = 0 ; i< array.length; i++){
            if(array[i]>max){
                max =array[i];
            }
        }
        System.out.println("The maximum number is: "+max);

        for (int i = 0 ; i< array.length; i++){
            if(array[i]<max){
                max =array[i];
            }
        }
        System.out.println( "The minimum number is: "+max);
    }



}
