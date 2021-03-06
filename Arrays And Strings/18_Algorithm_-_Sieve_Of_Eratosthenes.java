import java.util.*;

public class Main {
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        // write your code here
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for(int div = 2; div * div <= n; div++){
            if(isPrime[div] == true){
                // making all multiple's of div not prime
                for(int i = div + div; i <= n; i+= div){
                    isPrime[i] = false; // false -> not prime
                }
            }
            else{
                continue;
            }
        }
        for(int i = 2; i <= n; i++){
            if(isPrime[i] == true){
                System.out.print(i + " ");
            }
        }
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
