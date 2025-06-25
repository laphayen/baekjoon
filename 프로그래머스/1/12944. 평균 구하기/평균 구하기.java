class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int size = arr.length;
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        // System.out.println(sum);
        // System.out.println(sum / arr.length);
        
        answer = sum / arr.length;
        
        return answer;
    }
}