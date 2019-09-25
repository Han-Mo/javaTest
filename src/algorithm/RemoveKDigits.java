package algorithm;

/**
 * @author han
 * @Date 2019-09-20 11:07
 **/
public class RemoveKDigits {
    public static String removeKDigits(String num, int k) {
        String numNew = num;

        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            int numNewLength = numNew.length() - 1;
            for (int j = 0; j < numNewLength; j++) {
                if (numNew.charAt(j) > numNew.charAt((j + 1))){
                    numNew = numNew.substring(0, j) + numNew.substring(j + 1, numNew.length());
                    hasCut = true;
                    break;
                }
            }

            if (!hasCut) {
                numNew = numNew.substring(0, numNewLength);
            }

            numNew = removeZero(numNew);
        }
        return numNew;
    }

    //去掉最前面的0
    private static String removeZero(String num) {
        int numLength = num.length() - 1;
        for (int i = 0; i < numLength; i++) {
            if(num.charAt(0) != '0') {
                break;
            }
            num = num.substring(1,num.length());
        }
        return num;
    }

    public static String removeKDigits1(String num, int k) {
        int newLength = num.length() - k;

        char[] stack = new char[num.length()];
        int top = 0;
        int numLength = num.length();
        for (int i = 0; i < numLength; i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }

            stack[top++] = c;
        }

        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);

    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("541270936", 3));


        System.out.println(removeKDigits1("1593212", 3));
        System.out.println(removeKDigits1("30200", 1));
        System.out.println(removeKDigits1("10", 2));
        System.out.println(removeKDigits1("541270936", 3));
    }
}
