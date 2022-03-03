https://leetcode.com/problems/boats-to-save-people/



Time -> 0(NlogN)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n =  people.length;
        Arrays.sort(people);
        int i = 0;
        int j = n - 1;
        int count = 0;
        while(i <= j){
            int sum = people[i] + people[j];
            // System.out.println(sum);
            if(sum <= limit){
                i++;
                j--;
            }
            else{
                j--;
            }
            count++;
        }
        return count;
    }
}
