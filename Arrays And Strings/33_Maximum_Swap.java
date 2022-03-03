https://leetcode.com/problems/maximum-swap/



=================== BRUTE FORCE =====================
Time  -> 0(n^2)
Space -> 0(NumberOFDIGITS)
  
class Solution {
    public void print1D(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public int maximumSwap(int num) {
        int nod = 0;
        int temp = num;
        while(temp != 0){
            nod++;
            temp /= 10;
        }
        int[] arr = new int[nod];
        int k = nod - 1;
        temp = num;
        int max = -(int)1e9;
        while(temp != 0){
            int dig = temp % 10;
            arr[k--] = dig;
            temp /= 10;
        }
        int idx = 0;
        // print1D(arr);
        for(int i = 0; i < nod; i++){
            max = -(int)1e9;
            for(int j = i + 1; j < nod; j++){
                if(arr[j] >= max){
                    max = arr[j];
                    idx = j;
                }
            }
            // System.out.println(arr[i] + "The Max is = " + max);
            if(max > arr[i]){
                // System.out.println("the i is = " + i + " and the idx is = " + idx);
                int t = arr[i];
                arr[i] = arr[idx];
                arr[idx] = t;
                break;
            }
        }
        int ans = 0;
        int p = 1;
        for(int i = nod - 1; i >= 0; i--){
            ans += arr[i] * p;
            p *= 10;
        }
        return ans;
    }
}


=================== OPTIMIZE =====================
Time  -> 0(N)
Space -> 0(N)

class Solution {
    public void print1D(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public int maximumSwap(int num) {
        int nod = 0;
        int temp = num;
        while(temp != 0){
            nod++;
            temp /= 10;
        }
        int[] arr = new int[nod];
        int k = nod - 1;
        temp = num;
        while(temp != 0){
            int dig = temp % 10;
            arr[k--] = dig;
            temp /= 10;
        }
        int idx = 0;
        // print1D(arr);
        
        int[][] max = new int[1][2];
        int[] rmax = new int[nod];
        int n = nod;
        rmax[n - 1] = n - 1;
        max[0][0] = arr[n - 1];
        max[0][1] = n - 1;
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] <= max[0][0]){
                rmax[i] = max[0][1];
                // System.out.println(i + " " + rmax[i]);
            }
            else if(arr[i] > max[0][0]){
                max[0][0] = arr[i];
                max[0][1] = i;
                rmax[i] = i;
            }
            // System.out.println("the i is = " + i + " the max num = " + max[0][0] + " it is present on idx = " + max[0][1]);
            // System.out.println
        }
        for(int i = 0; i < n; i++){
            if(arr[i] == arr[rmax[i]]){
                continue;
            }
            else if(arr[i] < arr[rmax[i]]){
                int place = rmax[i];
                int t = arr[i];
                arr[i] = arr[place];
                arr[place] = t;
                break;
            }
        }
        // print1D(rmax);
        
        int ans = 0;
        int p = 1;
        for(int i = nod - 1; i >= 0; i--){
            ans += arr[i] * p;
            p *= 10;
        }
        return ans;
    }
}
