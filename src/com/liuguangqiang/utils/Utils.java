package com.liuguangqiang.utils;

import java.util.List;

/**
 * Created by Eric on 14/10/2017.
 */
public class Utils {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("");
    }

    public static void printLists(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            printList(lists.get(i));
        }
    }

    public static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.print("]");
        System.out.println("");
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
