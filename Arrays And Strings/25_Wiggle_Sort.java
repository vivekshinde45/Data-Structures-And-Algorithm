https://www.lintcode.com/problem/wiggle-sort/description




=============== Brute Force ================
Taking a another array 
Time Complexity  -> 0(nlogn)
Space Complexity -> 0(n)
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int[] arr = new int[n];
        int k = 0;
        int count = 0;
        while(i <= j){
            if(count % 2 == 0){
                arr[k++] = nums[i++];
            }
            else{
                arr[k++] = nums[j--];
            }
            count++;
        }
        // System.out.println(k);
        for(int idx = 0; idx < n; idx++){
            nums[idx] = arr[idx];
        }
    }
}


=============== Optimized =================
Time ->  0(n)
Space -> 0(1)
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void wiggleSort(int[] arr) {
        // write your code here
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            if(i % 2 == 0){
                // even
                if(arr[i + 1] < arr[i]){
                    swap(arr, i, i + 1);
                }
            }
            else{
                // odd
                if(arr[i + 1] > arr[i]){
                    swap(arr, i, i + 1);
                }
            }
        }
    }
}
