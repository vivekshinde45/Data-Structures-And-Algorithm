https://leetcode.com/problems/reverse-vowels-of-a-string/



=============== Brute Force =================
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        int j = n - 1;
        while(i <= j){
            char ch1 = arr[i];
            char ch2 = arr[j];
            
            // System.out.println(ch1);
            // System.out.println(ch2);
            
            if(((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') || (ch1 == 'A' || ch1 == 'E' || ch1 == 'I' || ch1 == 'O' || ch1 == 'U')) &&
               ((ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') || (ch2 == 'A' || ch2 == 'E' || ch2 == 'I' || ch2 == 'O' || ch2 == 'U'))){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            else if (((ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') || (ch1 == 'A' || ch1 == 'E' || ch1 == 'I' || ch1 == 'O' || ch1 == 'U')) &&
                    ((ch2 != 'a' || ch2 != 'e' || ch2 != 'i' || ch2 != 'o' || ch2 != 'u') || (ch2 != 'A' || ch2 != 'E' || ch2 != 'I' || ch2 != 'O' || ch2 != 'U'))){
                j--;
            }
            else if(((ch1 != 'a' || ch1 != 'e' || ch1 != 'i' || ch1 != 'o' || ch1 != 'u') || (ch1 != 'A' || ch1 != 'E' || ch1 != 'I' || ch1 != 'O' || ch1 != 'U')) &&
                     ((ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') || (ch2 == 'A' || ch2 == 'E' || ch2 == 'I' || ch2 == 'O' || ch2 == 'U'))){
                // System.out.println("----");
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        String str = "";
        for(int idx = 0; idx < n; idx++){
            str += arr[idx];
        }
        return str;
    }
}


==================Optimized====================   -> in terms of condition statements
class Solution {
    public boolean isVowel(char[] arr, int idx){
        char ch = arr[idx];
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
           ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }
    
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        int j = n - 1;
        while(i < j){
            while(i < j && isVowel(arr, i) == false){
                i++;
            }
            while(i < j && isVowel(arr, j) == false){
                j--;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        
        String str = "";
        for(int idx = 0; idx < n; idx++){
            str += arr[idx];
        }
        return str;
    }
}
