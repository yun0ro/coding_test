class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;

        for(int a = 0; a < nums.length; a++){
            for(int b = a+1; b < nums.length; b++){
                for(int c = b+1; c < nums.length; c++){
                    sum = nums[a] + nums[b] + nums[c];
                    System.out.println(sum);
                    // 소수인지 판별
                    // 짝수
                    if(sum%2 == 0) {
                        sum -= nums[c];
                        continue;
                    }
                    // 홀수들
                    for(int i = 3; i < sum/2; i += 2){
                        if(sum % i == 0){
                            sum -= nums[c];
                            answer--;
                            break;
                        }
                    }
                    answer += 1;
                }
            }
        }
        return answer;
    }
}