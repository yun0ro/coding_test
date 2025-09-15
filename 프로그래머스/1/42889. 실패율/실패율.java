class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // temp[stage 번호] = 머물러있는 사용자 수
        // temp[N] = 모든 스테이지를 완료한 사용자의 수
        int[] temp = new int[N+1];
        int stage_length = stages.length;
        double[] fails = new double[N];
        
        for(int i = 0; i < stage_length; i++){
            temp[stages[i] - 1] += 1;
        }
        for(int i = 0; i < N; i++){
            if(temp[i] == 0) continue;
            fails[i] = (double)temp[i] / stage_length;
            stage_length -= temp[i];
        }
        for(int i = 0; i < N; i++){
            answer[i] = i+1;
        }
        mergesort(fails, answer, 0, N-1);
        return answer;
    }
    
    private void mergesort(double[] fails, int[] answer, int left, int right){
        if(left >= right) return;
        
        int mid = left + (right - left)/2;
        mergesort(fails, answer, left, mid);
        mergesort(fails, answer, mid + 1, right);
        
        merge(fails, answer, left, mid, right);
    }
    
    private void merge(double[] fails, int[] answer, int left, int mid, int right){
        int idx = 0;
        double[] temp = new double[right - left + 1];
        int[] temp_ans = new int[right - left + 1];
        
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (fails[l] >= fails[r]) {
                temp[idx] = fails[l];
                temp_ans[idx] = answer[l];
                l++;
            } else {
                temp[idx] = fails[r];
                temp_ans[idx] = answer[r];
                r++;
            }
            idx++;
        }

        //왼쪽 리스트에 값이 남아 있는 경우
        while (l <= mid) { 
            temp[idx] = fails[l];
            temp_ans[idx] = answer[l];
            idx++;
            l++;
        }
        //오른쪽 리스트에 값이 남아 있는 경우
        while (r <= right) { 
            temp[idx] = fails[r];
            temp_ans[idx] = answer[r];
            idx++;
            r++;
        }

        for (int i = left; i <= right; i++) {
            fails[i] = temp[i - left];
            answer[i] = temp_ans[i - left];
        }
    }
}