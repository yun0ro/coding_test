class Solution {
    // 초로 변환하는 함수
    private int toSec(String t){
        String[] arr = t.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    // "mm:ss"로 변환하는 함수
    private String toTime(int s){
        return String.format("%02d:%02d", s/60, s%60);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) { 
        int videoSec = toSec(video_len);
        int posSec = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);
        
        // 시작점이 오프닝 구간이면 즉시 점프
        if (opStart <= posSec && posSec <= opEnd) posSec = opEnd;

        // for-each
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                // max 활용해서 0과 계산된 값 중 큰 값으로 할당
                posSec = Math.max(0, posSec - 10);
            } else {
                // min 활용해서 비디오길이와 계산 값 중 작은 값으로 할당
                posSec = Math.min(videoSec, posSec + 10);
            }
            if (opStart <= posSec && posSec <= opEnd) posSec = opEnd;
        }
        return toTime(posSec);
    }
}