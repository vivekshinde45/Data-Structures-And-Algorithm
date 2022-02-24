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
