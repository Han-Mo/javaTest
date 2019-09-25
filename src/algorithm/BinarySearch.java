package algorithm;

/**
 * @author han
 * @Date 2019-08-30 15:39
 **/
public class BinarySearch {
    public static int binarySearch(int []array,int target){
        int start = 0;
        int end = array.length - 1;
        //查找范围中位数
        int mid;
        System.out.println(end+" # "+start);
        System.out.println((end-start)/2);
        while(start<=end){
            //mid=(start+end)/2 有可能溢出
            mid=start+(end-start)/2;
            if(array[mid]==target){
                return mid;
            }else if(array[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[1000];
        for(int i=0; i<1000;i++){
            array[i] = i;
        }
        System.out.println(binarySearch(array, 173));
    }
}
