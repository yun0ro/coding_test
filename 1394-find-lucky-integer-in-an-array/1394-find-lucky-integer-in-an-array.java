class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int equalMax = -1;

        for(int num : arr){
            if(frequency.containsKey(num)){
                frequency.put(num, frequency.get(num) + 1);
            }
            else{
                frequency.put(num, 1);
            }
        }
        for(Map.Entry<Integer, Integer> freq : frequency.entrySet()){
            if(freq.getKey() == freq.getValue() && equalMax < freq.getKey()){
                equalMax = freq.getKey();
            }
        }
        return equalMax;
    }
}