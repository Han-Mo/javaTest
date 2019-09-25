package heap;

/**
 * 二叉堆
 * @author han
 * @Date 2019-09-12 09:15
 **/
public class heap {
    /**
      *
      * 上浮调整
      * @author han
      * @date 09:38 2019-09-12
      * @param
      * @return void
    */
    public static void upAdjust(int[] array){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];

        while (childIndex > 0 && temp < array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    public static void downAdjust(int[] array,int parentIndex){
        int length = array.length;
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length){
            if(childIndex + 1 <length && array[childIndex + 1] < array[childIndex]){
                childIndex++;
            }

            if(temp <= array[childIndex]){
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array){
        for (int i = (array.length - 2)/2;i>=0; i--){
            downAdjust(array,i);
        }
    }

    public static void main(String[] args) {
        //int array = new int[]
    }
}
