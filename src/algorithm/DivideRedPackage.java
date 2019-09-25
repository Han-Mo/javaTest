package algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author han
 * @Date 2019-09-23 11:11
 **/
public class DivideRedPackage {
    public static List<Integer> handler(Integer totalAmount, Integer totalPeopleNUm) {
        List<Integer> amountList = new ArrayList<Integer>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNUm;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNUm - 1; i++) {
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = handler(1000, 10);
        for (Integer amount : amountList) {
            System.out.println(" 抢到金额: " + new BigDecimal(amount));
        }
    }
}
