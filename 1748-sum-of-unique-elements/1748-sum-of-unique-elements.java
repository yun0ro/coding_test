class Solution {
    public int sumOfUnique(int[] nums) {
        // 더할 숫자set과 중복된 숫자set
        Set<Integer> result = new HashSet<>();
        Set<Integer> except = new HashSet<>();
        int sum = 0;

        for(int num : nums){
            // 중복된 숫자set에 존재할 경우 continue
            if(except.contains(num)){
                continue;
            }
            // 처음 중복해서 들어갈 경우 삭제 후 except에 추가
            if(!result.add(num)){
                result.remove(num);
                except.add(num);
            }
        }
        for(int num : result){
            sum += num;
        }
        return sum;
    }
}