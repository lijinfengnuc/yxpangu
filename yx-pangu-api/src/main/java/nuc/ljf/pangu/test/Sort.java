/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.test;

import java.util.Arrays;

/**
 * ClassName: Sort <br/>
 * Function: <br/>
 * date: 2019年05月07日 15:36 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

public class Sort {

    public static void main(String[] args) {
        int[] data = {9,8,7,6,5,4,3,2,1};
        int[] data1 = Arrays.copyOf(data, data.length);
        bubbleSort(data1);
        int[] data2 = Arrays.copyOf(data, data.length);
        insertionSort(data2);
        int[] data3 = Arrays.copyOf(data, data.length);
        selectionSort(data3);
    }

    private static void bubbleSort(int[] data) {
        int n = data.length;
        for(int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for(int j = 0; j < n - i - 1; j++) {
                if(data[j] > data[j+1]) {
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(data));
    }

    private static void insertionSort(int[] data) {
        int n = data.length;
        for(int i = 1; i < n; i++){
            int tmp = data[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                if(data[j] > tmp){
                    data[j+1] = data[j];
                }else{
                    break;
                }
            }
            data[j+1] = tmp;
        }
        System.out.println(Arrays.toString(data));
    }

    private static void selectionSort(int[] data) {
        int n = data.length;
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int tmp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(data));
    }

    private static void mergeSort(int[] data) {

    }





}
