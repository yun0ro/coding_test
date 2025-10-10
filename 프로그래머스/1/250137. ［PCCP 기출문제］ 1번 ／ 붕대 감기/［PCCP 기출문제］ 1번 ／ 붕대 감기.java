class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        // 회복총시간, 초당 회복량, 회복총시간 연속 달성 시 추가 회복량
        // 회복최대량
        // 공격하는 시간(1초간 공격한다고 생각), 데미지
        
        // 최대 회복량으로 시작
        answer = health;
        int sec = 0;
        int successTime = 0;
        int attackNum = 0;
        
        while(true){
            if(attackNum >= attacks.length){
                break;
            }
            if(attacks[attackNum][0] == sec){
                answer -= attacks[attackNum++][1];
                // 체력이 0이하가 될 경우 게임 끝
                if(answer <= 0){
                    answer = -1;
                    break;
                }
                // 연속 성공 실패 및 0으로 초기화
                successTime = 0;
            }
            else{
                answer += bandage[1];
                successTime++;
                if(successTime == bandage[0]){
                    answer += bandage[2];
                    successTime = 0;
                }
                if(answer > health){
                    answer = health;
                    successTime = 0;
                }
            }
            sec++;
        }
        return answer;
    }
}