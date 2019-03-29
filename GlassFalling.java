/**
 * Glass Falling
 * Author: Jingwei Chen
 */
public class GlassFalling {

    // Do not change the parameters!
    public int glassFallingRecur(int floors, int sheets) {
        // Fill in here and change the return
        // base case: if only 1 sheet, worst case is to try all the floors
        if (sheets == 1) return floors;
        // base case: 0 or 1 floor the solution is guaranteed
        if (floors == 0 || floors == 1) return floors;
        int minTrials = -1;
        int temp;
        for (int i = 1; i <= floors; i++) {
            /* take the worst case of the two posibilites:
               if break, lost one sheet, check floor below it,
               if does not break, number of sheets remains, check the rest of the remaining floor
             */
            temp = Math.max(glassFallingRecur(i - 1, sheets - 1), glassFallingRecur(floors - i, sheets));
            // among all the floors with the worst case, find the lowest trial
            if (temp < minTrials || minTrials == -1) minTrials = temp;
        }
        // account for the initial trial
        return minTrials + 1;
    }

    // Optional:
    // Pick whatever parameters you want to, just make sure to return an int.
    public int glassFallingMemoized() {
        // Fill in here and change the return
        return 0;
    }

    // Do not change the parameters!
    public int glassFallingBottomUp(int floors, int sheets) {
        // Fill in here and change the return
        return 0;
    }


    public static void main(String args[]) {
        GlassFalling gf = new GlassFalling();

        // Do not touch the below lines of code, and make sure
        // in your final turned-in copy, these are the only things printed
        int minTrials1Recur = gf.glassFallingRecur(27, 2);
        int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
        int minTrials2Recur = gf.glassFallingRecur(100, 3);
        int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
        System.out.println(minTrials1Recur + " " + minTrials1Bottom);
        System.out.println(minTrials2Recur + " " + minTrials2Bottom);
    }
}
