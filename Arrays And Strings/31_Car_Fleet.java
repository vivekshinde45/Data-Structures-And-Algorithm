https://leetcode.com/problems/car-fleet/




class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] carData = new double[n][2];
        // 0'th idx -> car position
        // 1'st idx -> time taken to reach target for that perticular position
        for(int i = 0; i < n; i++){
            carData[i][0] = position[i] * 1d;
            carData[i][1] = ((target - position[i]) * 1d) / speed[i];
        }
        Arrays.sort(carData, (a, b) -> (Double.compare(a[0], b[0])));
        double timeTakenToReachTar = carData[n - 1][1];
        
        int nof = 1; // NUMBER OF FLEET
        
        for(int i = n - 2; i >= 0; i--){
            if(carData[i][1] > timeTakenToReachTar){
                nof++;
                timeTakenToReachTar = carData[i][1];
            }
        }
        return nof;
    }
}
