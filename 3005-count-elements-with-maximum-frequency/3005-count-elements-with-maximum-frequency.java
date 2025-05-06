class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxValue = 1;
        int sum = 0;

        for(int num : nums){
            // 이미 존재할 경우 value +1
            if(frequency.containsKey(num)){
                frequency.put(num, frequency.get(num) + 1);
                // 가장 많이 존재하는 수일 경우
                if(maxValue < frequency.get(num)){
                    maxValue = frequency.get(num);
                }
            }
            // 새로운 수가 들어올 경우
            else {
                frequency.put(num, 1);
            }
        }

        // maxValue인 key들을 더한다.
        for(Map.Entry<Integer, Integer> freq : frequency.entrySet()){
            if(freq.getValue() == maxValue){
                sum += freq.getValue();
            }
        }
        return sum;
    }
}