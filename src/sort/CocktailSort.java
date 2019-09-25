package sort;

import java.util.Arrays;

/**
 * @author han
 * @Date 2019-09-12 16:36
 **/
public class CocktailSort {
    public static void sort(int[] array) {
        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //标记是否有位置交换
            boolean isSorted = true;
            for (int j = i; j < array.length - i - 1; j++) {
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

            //标记是否有位置交换
            isSorted = true;
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    isSorted = false;
                }
            }
            //没有位置交换时表明已经是有序的了
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
