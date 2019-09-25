package algorithm;

/**
 * @author han
 * @Date 2019-09-19 09:43
 * 得到最大公约数
 **/
public class GreatestCommonDivisor {
    //辗转相除法
    public static int getGeatestCommonDivisorV2(int a, int b) {
        int big = a > b ? a:b;
        int small = a < b ? a:b;
        if(big % small == 0) {
            return small;
        }
        return getGeatestCommonDivisorV2(big % small, small);
    }

    //更相减损法
    public static int getGeatestCommonDivisorV3(int a, int b) {
        if(a == b) {
            return a;
        }

        int big = a > b ? a:b;
        int small = a < b ? a:b;

        return getGeatestCommonDivisorV2(big - small, small);
    }

    //当a和b都是偶数时 gcd(a, b) = 2 x gcd(a/2, b/2) = 2 X gcd(a>>1, b>>1)
    //当a为偶数， b为奇数时  gcd(a, b) = gcd(a/2, b) = gcd(a>>1, b)
    //当a为奇数 b为偶数时 gcd(a, b) = gcd(a, b/2) = gcd(a, b>>1)
    public static int getGeatestCommonDivisorV4(int a, int b) {
        if(a == b) {
            return a;
        }
        if((a & 1) == 0 && (b & 1) == 0) {
            return getGeatestCommonDivisorV4(a>>1, b>>1)<<1;
        } else if(( a & 1) == 0 && (b & 1) != 0) {
            return getGeatestCommonDivisorV4(a>>1, b);
        } else if((a & 1) != 0 && (b & 1) == 0) {
            return getGeatestCommonDivisorV4(a, b>>1);
        } else {
            int big = a > b ? a:b;
            int small = a < b ? a:b;
            return getGeatestCommonDivisorV4(big - small, small);
        }
    }

    public static void main(String[] args) {
        System.out.println(getGeatestCommonDivisorV2(25, 5));
        System.out.println(getGeatestCommonDivisorV2(100, 80));
        System.out.println(getGeatestCommonDivisorV2(27, 14));
    }
}
