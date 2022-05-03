import java.util.*;

public class Main{
    public static void main(String[] args){
        String s1 = "forxxorfxdofr";
        String s2 = "for";
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        int k = s2.length();
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s1.length();
        
        int count = 0;
        
        while(j < n){
            char ch = s1.charAt(j);
            // System.out.println(ch); 
            
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            
            int window_size = j - i + 1;
            
            if(window_size < k){
                j++;
            }
            else if(window_size == k){
                boolean flag = true;
                for(Character key : map1.keySet()){
                    if(!map2.containsKey(key)){
                        flag = false;
                        break;
                    }
                    else{
                        int frq1 = map1.get(key);
                        int frq2 = map2.get(key);
                        if(frq1 != frq2){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag){
                    count ++;
                }
                char st_charOf_window = s1.charAt(i);
                int frq = map2.get(st_charOf_window);
                if(frq == 1)
                    map2.remove(st_charOf_window);
                else{
                    map2.put(st_charOf_window, frq - 1);
                }
                i++;
                j++;
            }
            // System.out.println(map2);
        }
        System.out.println(count);
    }
}
