import java.util.HashMap;

/**
 * Rod cutting problem described in Chapter 15 of textbook
 * Author: Jingwei Chen
 */
public class RodCutting {

    // Do not change the parameters!
    public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        int max_value = -1;
        // check for calculated value
        if (memo.containsKey(rodLength)) return memo.get(rodLength);
        // base case
        if (rodLength == 0) {
            max_value = 0;
        } else {
            // cut the rod and compare each, get the highest value
            for (int i = 1; i < rodLength; i++) {
                max_value = Math.max(max_value, lengthPrices[i] + rodCuttingRecur(rodLength - i - 1, lengthPrices));
            }
        }
        // save the calculated value
        memo.put(rodLength, max_value);
        return max_value;
    }

    // Do not change the parameters!
    public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {

        return 0;
    }


    public static void main(String args[]) {
        RodCutting rc = new RodCutting();

        // In your turned in copy, do not touch the below lines of code.
        // Make sure below is your only output.
        int length1 = 7;
        int[] prices1 = {1, 4, 7, 3, 19, 5, 12};
        int length2 = 14;
        int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};
        int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
        int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
        int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
        int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
        System.out.println(maxSell1Recur + " " + maxSell1Bottom);
        System.out.println(maxSell2Recur + " " + maxSell2Bottom);
    }
}
