class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        // n / w + 1 = 최대 층 = maxFloor
        // num / w + 1 = 빼고 싶은 상자가 있는 층 = targetFloor
        // n % w = 가장 윗 층에 놓여있는 상자 개수
        // 층수를 홀짝으로 방향 구분할 필요없음 -> 빼야할 상자의 개수만 구하면 됨.
        // n, num이 w로 나눠떨어질 경우 따로 처리해준다.
        int maxFloor = n/w + 1;
        int targetFloor = num/w + 1;
        int maxFloorBox = n % w;
        if(n%w == 0) {
            maxFloor -= 1;
            maxFloorBox = w;
        }
        // 짝이든 홀이든 쌓이는 진행방향으로 몇번째의 박스를 target하는지
        int targetFloorBox = num%w;
        if(num%w == 0) {
            targetFloor -= 1;
            targetFloorBox = w;
        }

        // 어느 상자를 빼든 최소로 제거해야하는 개수
        answer = maxFloor - targetFloor;

        // 홀짝, 짝홀
        if(targetFloor%2 != maxFloor%2){
            int reverseMaxFloorBox = w - maxFloorBox;
            if(reverseMaxFloorBox < targetFloorBox){
                answer += 1;
            }
        }
        // 짝짝, 홀홀
        else{
            // 맨 윗 줄의 박스도 제거해야할 경우
            if(maxFloorBox >= targetFloorBox)
                answer += 1;
        }
        return answer;
    }
}