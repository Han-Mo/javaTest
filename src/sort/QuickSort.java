package sort;

import java.util.Arrays;

/**
 * @author han
 * @Date 2019-09-12 17:05
 **/
public class QuickSort {
    public static void quicksort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition(arr, startIndex, endIndex);
        quicksort(arr, startIndex, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, endIndex);

    }

    //双边
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            //控制right指针比较并且左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并且右移
            while (left < right && arr[left] <= pivot) {
                right++;
            }

            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }

        }
        //pivot 和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    //单边
    private static int partition1(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //pivot 和指针重合点交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
