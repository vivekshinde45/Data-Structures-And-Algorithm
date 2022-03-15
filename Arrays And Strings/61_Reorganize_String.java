https://leetcode.com/problems/reorganize-string/




class Solution {
    class pair implements Comparable<pair>{
        char ch;
        int frq;
        
        pair(char ch, int frq){
            this.ch = ch;
            this.frq = frq;
        }
        
        public int compareTo(pair o){
            return o.frq - this.frq;
        }
    }
    
    public String reorganizeString(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // System.out.println(map);
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(Character ch : map.keySet()){
            int frq = map.get(ch);
            pq.add(new pair(ch, frq));
        }
        // System.out.println(pq.size());
        StringBuilder sb = new StringBuilder();
        pair block = new pair('0' , -1);
        while(pq.size() > 0){
            pair rem = pq.poll();
            
            sb.append(rem.ch);
            rem.frq = rem.frq - 1;
            if(block.frq > 0){
                pq.add(block);
            }
            block = rem;
        }
        // System.out.println(sb);
        if(n == sb.length()){
            return sb.toString();
        }
        return "";
    }
}
