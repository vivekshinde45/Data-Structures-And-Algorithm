import java.util.*;


public class MyClass {
    public static int coinChangePermutation_IN_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0){
            count += coinChangePermutation_IN_Sub(coins, tar - coins[idx], 0, psf + coins[idx]);
        }
        count += coinChangePermutation_IN_Sub(coins, tar, idx + 1, psf);

        return count;
    }

    public static int coinChangeCombination_IN_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        
        if(tar - coins[idx] >= 0){
            count += coinChangePermutation_IN_Sub(coins, tar - coins[idx], idx, psf + coins[idx]);
        }
        count += coinChangePermutation_IN_Sub(coins, tar, idx + 1, psf);

        return count;
    }
    
    public static int coinChangePermute_Sin_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(coins[idx] > 0 && tar - coins[idx] >= 0){
            int val = coins[idx];
            coins[idx] = -coins[idx];
            count += coinChangePermute_Sin_Sub(coins, tar - val, 0, psf + val);
            coins[idx] = -coins[idx];
        }
        count += coinChangePermute_Sin_Sub(coins, tar, idx + 1, psf);

        return count;
    }
    

    public static int coinChangeCombination_Sin_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if(tar - coins[idx] >= 0){
            count += coinChangeCombination_Sin_Sub(coins, tar - coins[idx], idx + 1, psf + coins[idx]);
        }
        count += coinChangeCombination_Sin_Sub(coins, tar, idx + 1, psf);

        return count;
    }
    
    public static void main(String args[]) {
        int[] coins = {2, 3, 5, 7};
        int tar = 10;
        System.out.println(coinChangePermute_Sin_Sub(coins, tar, 0, ""));
    }
}
