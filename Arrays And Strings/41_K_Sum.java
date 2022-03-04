https://nados.io/question/k-sum-target-sum-unique-set?zen=true




import java.util.*;

public class Main {

  public static List<List<Integer>> twoSum(int[] nums, int left, int right, int tar, int k){
    int n = nums.length;
    List<List<Integer>> ans = new ArrayList<>();
    if(n - left < k){
      return ans;
    }
    while(left < right){
        int sum = nums[left] + nums[right];
        if(sum == tar){
            List<Integer> list = new ArrayList<>();
            list.add(nums[left]);
            list.add(nums[right]);
            ans.add(list);
            
            while(left < right && nums[left] == nums[left + 1]){
                left++;
            }
            while(left < right && nums[right] == nums[right - 1]){
                right--;
            }
            
            left++;
            right--;
        }
        else if(sum < tar){
            left++;
        }
        else{
            right--;
        }
    }
    return ans;
  }

  public static List<List<Integer>> kSum(int[] arr, int target, int k, int si) {
    // write your code here
    int n = arr.length;
    Arrays.sort(arr);
    if(k == 2){
      return twoSum(arr, si, n - 1, target, k);
    }
    List<List<Integer>> ans = new ArrayList<>();
    if(n < k){
      return ans;
    }
    for(int i = si; i <= n - k; i++){
      if(i != si && arr[i] == arr[i - 1]){
        continue;
      }
      List<List<Integer>> list = kSum(arr, target - arr[i], k - 1, i + 1);
      for(List<Integer> l : list){
          l.add(arr[i]);
          ans.add(l);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> res = kSum(arr, target, k, 0);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}
