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

// 1ms 걸리는 코드
// class Solution {
//     public int findLucky(int[] arr) {
//         int [] freq = new int[501];
//         for(int num : arr){
//             freq[num]++;
//         }

//         int max = -1;
//         for(int i=1;i<freq.length;i++){
//             if(freq[i]  == i){
//                     max = Math.max(max,freq[i]); 
//             }
//         }
//             return max;
//     }
// }