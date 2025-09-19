class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b){
            answer = a;
        }
        else {
            if(a > b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            for(int i = a; a <= b; a++)
                answer += a;
        }
        return answer;
    }
}