


import java.util.*;

public class Main {

  // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
  public static List<List<Integer>> twoSum(int[] arr, int target) {
    // write your code here
    int n = arr.length;
    Arrays.sort(arr);
    List<List<Integer>> ans = new ArrayList<>();
    int left = 0;
    int right = n - 1;
    while(left < right){
        if(left != 0 && arr[left] == arr[left - 1]){
            left++;
            continue;
        }
        
        int sum = arr[left] + arr[right];
        
        if(sum == target){
            List<Integer> list = new ArrayList<>();
            list.add(arr[left]);
            list.add(arr[right]);
            ans.add(list);
            left++;
            right--;
        }
        else if(sum > target){
            right--;
        }
        else{
            left++;
        }
    }
    return ans;
  }

  // ~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = twoSum(arr, target);
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
