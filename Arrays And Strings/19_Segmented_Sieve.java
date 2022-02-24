import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~
  
  public static ArrayList<Integer> sieve(int n){
      boolean[] isPrime = new boolean[n + 1]; // false - prime || true - non prime
      for(int i = 2; i * i <= n; i++){
          if(isPrime[i] == false){
              for(int j = i * 2; j <= n; j += i){
                  isPrime[j] = true; // not prime
              }
          }
      }
      ArrayList<Integer> primes = new ArrayList<>();
      for(int i = 2; i <= n; i++){
          if(isPrime[i] == false){
              primes.add(i);
          }
      }
    //   System.out.println(primes);
      return primes;
  }

  public static void segmentedSieveAlgo(int a, int b) {
    // write your code here
    // 1 make a root of b
    int rootB = (int)Math.sqrt(b);
    
    // fill the primes array with the help of sieve
    ArrayList<Integer> primes = sieve(rootB);
    
    // make a boolean array of length (b - a + 1)
    boolean[] arr = new boolean[b - a + 1]; // false - prime || true - non prime
    
    // mark using prime
    for(int prime : primes){
        // find the starting index
        int multiple = (int) Math.ceil(a * 1.0 / prime);
        if(multiple == 1){
            multiple++;
        }
            
        int idx = (multiple * prime) - a;
        for(int i = idx; i < arr.length; i += prime){
            arr[i] = true; // not prime
        }
    }
    
    for(int i = 0; i < arr.length; i++){
        if(arr[i] == false && (i + a) != 1){
            int val = i + a;
            System.out.println(val);
        }
    }
    
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    segmentedSieveAlgo(a, b);
  }
}
