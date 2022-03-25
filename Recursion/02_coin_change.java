public class MyClass {
    
    public static int coinChangePermute_In(int[] coins, int tar, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            int val = coins[i];
            if(tar - val >= 0){
                count += coinChangePermute_In(coins, tar - val, psf + val);
            }
        }
        return count;
    }
    
    public static int coinChangeCombi_In(int[] coins, int tar, int idx, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < coins.length; i++){
            if(tar - coins[i] >= 0){
                count += coinChangeCombi_In(coins, tar - coins[i], i, psf + coins[i]);
            }
        }
        return count;
    }
    
    public static int coinChangePermute_Sin(int[] coins, int tar, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            int val = coins[i];
            if(coins[i] > 0 && tar - coins[i] >= 0){
                coins[i] = -val;
                count += coinChangePermute_Sin(coins, tar - val, psf + val);
                coins[i] = val;
            }
        }
        return count;
    }
    
    public static int coinChangeCombi_Sin(int[] coins, int tar, int idx, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < coins.length; i++){
            if(tar - coins[i] >= 0){
                count += coinChangeCombi_Sin(coins, tar - coins[i], i + 1, psf + coins[i]);
            }
        }
        return count;
    }
    
    public static void main(String args[]) {
        int[] coins = {2, 3, 5, 7};
        int tar = 10;
    //   System.out.println(coinChangePermute_In(coins, tar, ""));
    //   System.out.println(coinChangeCombi_In(coins, tar, 0, ""));
//         System.out.println(coinChangePermute_Sin(coins, tar, ""));
        // System.out.println(coinChangeCombi_Sin(coins, tar, 0, ""));
    }
}
