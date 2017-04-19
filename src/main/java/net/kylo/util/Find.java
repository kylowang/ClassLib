/**
 * net.kylo.util.Find.java
 * <p>
 * ver     date      		author
 * ──────────────────────────────────
 * 1.0   2017/4/18 10:10  wangxiaoming
 * <p>
 * Copyright (c) 2017, TNT All Rights Reserved.
 */
package net.kylo.util;

import com.sun.tools.corba.se.idl.InterfaceGen;

/**
 * <p>ClassName: Find</p>
 * <p>Description: 查找</p>
 * @author wangxiaoming
 * @Date 2017-04-18 10:10
 */
public class Find {
    /**
     * 顺序查找开始
     */
    /**
     * <p>Description: 顺序查找</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/18 10:16
     */
    public static int sequenceSearch(Integer[] arr, Integer value) {
        for ( int i = 0; i < arr.length; i++ ) {
            if ( arr[i] == value ) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 顺序查找结束
     */


    /**
     * 二分查找
     */
    /**
     * <p>Description: 普通二分查找</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/18 10:30
     */
    public static int binarySearch(Integer[] arr, Integer value) {
        int begin = 0;
        int end = arr.length;
        while ( begin <= end ) {
            int mid = (begin + end) / 2;
            if ( arr[mid] == value ) {
                return mid;
            } else if ( arr[mid] > value ) {
                end = mid - 1;
            } else if ( arr[mid] < value ) {
                begin = mid + 1;
            }
        }
        return -1;
    }
    /**
     * <p>Description: 递归二分查找</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/18 10:38
     */
    public static int recursiveBinarySearch(Integer[] arr, Integer value) {
        return recursiveBinarySearch(arr, value, 0, arr.length - 1);
    }
    public static int recursiveBinarySearch(Integer[] arr, Integer value, int b, int e) {

        int mid = (b + e) / 2;
        if ( arr[mid] == value ) {
            return mid;
        } else if ( arr[mid] > value ) {
            return recursiveBinarySearch(arr, value, b, mid - 1);
        } else {
            return recursiveBinarySearch(arr, value, mid + 1, e);
        }
    }
    /**
     * 二分查找结束
     */

    /**
     * 插值排序开始
     */
    /**
     * <p>Description: 普通插值查找</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/18 10:48
     */
    public static int insertionSearch(Integer[] arr, Integer value) {
        int b = 0;
        int e = arr.length - 1;
        while ( b <= e ) {
            int mid = b + (value - arr[b]) / ((arr[e] - arr[b]) * (e - b));
            if ( arr[mid] == value ) {
                return mid;
            }
            if ( arr[mid] > value ) {
                e = mid - 1;
            }
            if ( arr[mid] < value ) {
                b = mid + 1;
            }
        }
        return -1;
    }

    /**
     * <p>Description: 递归插值排序</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/18 10:56
     */
    public static int recursiveInsertionSearch(Integer[] arr, Integer values) {
        return recursiveInsertionSearch(arr, values, 0, arr.length - 1);
    }

    private static int recursiveInsertionSearch(Integer[] arr, Integer values, int b, int e) {
        int mid = b + (values - arr[b]) / ((arr[e] - arr[b]) * (e - b));
        if ( arr[mid] == values ) {
            return mid;
        } else if ( arr[mid] > values ) {
            return recursiveInsertionSearch(arr, values, b, mid - 1);
        } else {
            return recursiveInsertionSearch(arr, values, mid + 1, e);
        }
    }
    /**
     * 插值排序结束
     */

    /**
     * 斐波那契查找开始
     */
    /**
     * <p>Description: 斐波那契查找</p>
     *
     * @Author wangxiaoming
     * @Date 2017/4/18 12:39
     */
    public static int fibonacciSearch(Integer[] arr, Integer value) {
        int low = 0;
        int high = arr.length - 1;

        Integer[] F = new Integer[20];
        fibonacci(F);

        int k = 0;
        while ( F[k] - 1 < arr.length ) {
            ++k;
        }

        Integer[] temp = new Integer[F[k] - 1];
        for ( int i = 0; i < arr.length; i++ ) {
            temp[i] = arr[i];
        }
        for ( int i = arr.length; i < F[k] - 1; i++ ) {
            temp[i] = arr[arr.length - 1];
        }

        while ( low <= high ) {
            int mid = low + F[k - 1] - 1;
            if ( value > temp[mid] ) {
                low = mid + 1;
                k -= 2;
            } else if ( value < temp[mid] ) {
                high = mid - 1;
                k -= 1;
            } else {
                if ( mid < arr.length ) {
                    return mid;
                } else {
                    return arr.length - 1;
                }
            }
        }
        return -1;
    }

    public static void fibonacci(Integer[] f) {
        f[0] = 1;
        f[1] = 1;
        for ( int i = 2; i < 20; i++ ) {
            f[i] = f[i - 1] + f[i - 2];
        }
    }
    /**
     * 斐波那契查找结束
     */

    public static void main(String[] args) {

        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(sequenceSearch(arr, 2));
//        System.out.println(binarySearch(arr, 7));
//        System.out.println(recursiveBinarySearch(arr, 7));
//        System.out.println(insertionSearch(arr, 7));
//        System.out.println(recursiveInsertionSearch(arr, 7));
        System.out.println(fibonacciSearch(arr, 7));
    }
}
