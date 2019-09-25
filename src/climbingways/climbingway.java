package climbingways;

import java.util.HashMap;

/**
 * 动态规划
 * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 *
 * 比如，每次走1级台阶，一共走10步，这是其中一种走法。我们可以简写成 1,1,1,1,1,1,1,1,1,1。
 * @author han
 * @Date 2019-09-04 11:19
 **/
public class climbingway {
    int getClimbingwaysA(int n){
        if(n < 1){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        return getClimbingwaysA(n-1) + getClimbingwaysA(n - 2);
    }

    int getClimbingwaysB(int n, HashMap<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if(map.containsKey(n)) {
            return map.get(n);
        }else {
            int value = getClimbingwaysB(n-1, map) + getClimbingwaysB(n - 2, map);
            map.put(n,value);
            return value;
        }
    }

    int getClimbingwaysC(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int temp = 0;

        for (int i=3; i<n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

}
