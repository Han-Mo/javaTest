package sort;

import java.util.Arrays;

/**
 * @author han
 * 冒泡排序
 * @Date 2019-09-12 15:33
 **/
public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //标记是否有位置交换
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                }
            }
            //没有位置交换时表明已经是有序的了
            if (isSorted) {
                break;
            }
        }
    }

    public static void sort2(int[] array) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //记录边界
        int sortBorder = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            //标记是否有位置交换
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            //没有位置交换时表明已经是有序的了
            if (isSorted) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
