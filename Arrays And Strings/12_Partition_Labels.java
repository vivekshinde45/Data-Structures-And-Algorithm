https://leetcode.com/problems/partition-labels/



class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), i);
        }
        
        int prev = -1;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            max = Math.max(map.get(ch), max);
            if(max == i){
                list.add(max - prev);
                prev = max;
            }
        }
        return list;
    }
}




========= WRONG ANSWER =========
class Solution {
    public void print1D(char[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        char[] leftMax = new char[n + 1];
        char[] rightMin = new char[n + 1];
        Arrays.fill(leftMax, 'A');
        Arrays.fill(rightMin, '~');
        
        char max = s.charAt(0);
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch > max){
                max = ch;
            }
            leftMax[i] = max;
        }
        char min = s.charAt(n - 1);
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch < min){
                min = ch;
            }
            rightMin[i] = min;
        }
        print1D(leftMax);
        print1D(rightMin);
        
        int len = 0;
        int j = -1;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char ch1 = leftMax[i];
            char ch2 = rightMin[i + 1];
            // System.out.println(ch1 + "  " + ch2);
            if(ch1 < ch2){
                System.out.println(i + "---" + ch1 + "  " + ch2);
                len = i - j;
                j = i;
                list.add(len);
                count++;
            }
        }
        // System.out.println(count);
        return list;
    }
}
