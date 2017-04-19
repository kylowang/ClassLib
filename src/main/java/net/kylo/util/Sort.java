package net.kylo.util;

import java.util.Random;

public class Sort {
    /**
     * <p>Description: 转换数组下标的内容</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/16 17:50
     */
    public static <T> void swap(T arr[], int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * <p>Description: 打印数组</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/16 19:09
     */
    static void showArr(Integer[] arr) {
        for ( int i : arr ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }



    /**
     * 插入排序
     */
    /**
     * <p>Description: 普通插入排序</p>
     * 
     * @Author wangxiaoming
     * @Date 2017/4/16 17:23
     */
    public static void insertionSort(Integer[] arr) {
        for ( int i = 1; i < arr.length; i++ ) {
            int j = i - 1;
            int key = arr[i];

            while ( j >= 0 && arr[j] > key ) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void insert(Integer[] arr, int b, int e) {
        if ( (b >= arr.length || b < 0) || (e >= arr.length || e < 0) || b > e) {
            throw new RuntimeException("输入的参数下标不对");
        }
        int key = arr[e];
        int j = e - 1;
        while ( j >= b && arr[j] > key ) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }

    /**
     * <p>Description: 递归法插入排序</p>
     * 
     * @Author wangxiaoming
     * @Date 2017/4/16 17:47
     */
    public static void recursiveInsertionSort(Integer arr[], int b, int e) {
        if ( b < e ) {
            recursiveInsertionSort(arr, b, e - 1);
            insert(arr, b, e);
        }
    }
    /**
     * 插入排序结束
     */


    /**
     * 冒泡排序
     */
    /**
     * <p>Description: 普通冒泡排序</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/16 18:49
     */
    public static void bubbleSort(Integer arr[])  {
        for ( int i = 0; i < arr.length - 1; i++ ) {
            for ( int j = arr.length - 1; j > i; j-- ) {
                if ( arr[j] < arr[j - 1] ) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private static void findmin(Integer arr[], int b, int e) {
        if ( (b >= arr.length || b < 0) || (e >= arr.length || e < 0) || b > e) {
            throw new RuntimeException("输入的参数下标不对");
        }
        for ( int i = e; i > b; i-- ) {
            if ( arr[i] < arr[i - 1] ) {
                swap(arr, i, i - 1);
            }
        }
    }

    /**
     * <p>Description: 递归法冒泡排序</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/16 18:59
     */
    public static void recursiveBuubleSort(Integer arr[], int b, int e) {
        if ( b < e ) {
            findmin(arr, b, e);
            recursiveBuubleSort(arr, b + 1, e);
        }
    }

    public static void improvedBubbleSort(Integer arr[]) {
        boolean flag = true;
        for ( int i=0; i<arr.length-1; i++ ) {
            if ( flag ) {
                for ( int j = arr.length - 1; j > i; j-- ) {
                    flag = false;
                    if ( arr[j] < arr[j - 1] ) {
                        swap(arr, j, j - 1);
                        flag = true;
                    }
                }
            } else {
                return;
            }
        }
    }
    /**
     * 冒泡排序结束
     */


    /**
     * 选择排序开始
     */
    /**
     * <p>Description: 普通插入排序</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/16 19:13
     */
    public static void selectionSort(Integer arr[] ) {
        for ( int i = 0; i < arr.length - 1; i++ ) {
            int min = i;
            for ( int j = i + 1; j < arr.length; j++ ) {
                if ( arr[min] > arr[j] ) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    private static void findMin(Integer arr[], int b, int e) {
        int min = b;
        for ( int i = b + 1; i <= e; i++ ) {
            if ( arr[min] > arr[i] ) {
                min = i;
            }
        }
        swap(arr, min, b);
    }

    /**
     * <p>Description: 递归法选择排序</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/16 19:38
     */
    public static void recursiveSelectionSort(Integer arr[], int b, int e) {
        if ( b < e ) {
            findMin(arr, b, e);
            recursiveSelectionSort(arr, b + 1, e);
        }
    }
    /**
     * 选择排序结束
     */

    /**
     * 归并排序开始
     */
    /**
     * <p>Description: 归并排序</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/16 21:54
     */
    public static void mergeSort(Integer[] arr) {
        recursiveMergeSort(arr, 0, arr.length - 1);
    }

    public static void recursiveMergeSort(Integer[] arr, int b, int e) {
        if ( b < e ) {
            int m = (b + e) / 2;
            recursiveMergeSort(arr, b, m);
            recursiveMergeSort(arr, m + 1, e);
            merge(arr, b, m, e);
        }
    }

    private static void merge(Integer[] arr, int b, int m, int e) {
        int p = m - b + 1;
        int q = e - m;

        Integer left[] = new Integer[p + 1];
        Integer right[] = new Integer[q + 1];

        for ( int i = 0; i < p; i++ ) {
            left[i] = arr[b + i];
        }
        for ( int i = 0; i < q; i++ ) {
            right[i] = arr[m + 1 +i];
        }
        left[p] = Integer.MAX_VALUE;
        right[q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for ( int k = b; k <= e; k++ ) {
            if ( left[i] < right[j] ) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }
    /**
     * 归并排序结束
     */

    public static void quickSort(Integer[] arr) {
        recursiveQuickSort(arr, 0, arr.length - 1);
    }

    public static void recursiveQuickSort(Integer[] arr, int b, int e) {
        if ( b < e ) {
            int r = partition(arr, b, e);
//            int r = randomizedPartion(arr, b, e);
//            int r = simplePartiton(arr, b, e);
            recursiveQuickSort(arr, b, r - 1);
            recursiveQuickSort(arr, r + 1, e);
        }
    }

    private static int partition(Integer[] arr, int b, int e) {
        int i = b - 1;
        int pivot = arr[e];
        for ( int j = b; j < e; j++ ) {
            if ( arr[j] <= pivot ) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, e);
        return i + 1;
    }

    private static int randomizedPartion(Integer[] arr, int b, int e) {
        int gap = new Random(47).nextInt(e - b + 1);
        swap(arr, e, b + gap);
        return partition(arr, b, e);
    }

    private static int simplePartiton(Integer[] arr, int b, int e) {
        Integer pivot = arr[b];
        int left = b;
        int right = e;

        while ( left < right ) {
            while ( left < right && arr[right] >= pivot ) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot ) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        Integer arr[] = {6, 4, 2, 3, 5, 1, 7, 7, 4, 9, 8};
        showArr(arr);
//        insertionSort(arr);
//        recursiveInsertionSort(arr, 3, 8);
//        bubbleSort(arr);
//        recursiveBuubleSort(arr, 0, 8);
//        improvedBubbleSort(arr);
//        selectionSort(arr);
//        recursiveSelectionSort(arr, 0, 8);
//        mergeSort(arr);
        quickSort(arr);
        showArr(arr);
    }
}
