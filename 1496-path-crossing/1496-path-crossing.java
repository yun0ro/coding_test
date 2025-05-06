class Solution {
    public boolean isPathCrossing(String path) {
        // Set 자료구조로 방문한 위치가 겹치는 지 체크
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;

        // 시작 위치 추가
        visited.add("0, 0");

        for(char visit : path.toCharArray()){
            switch(visit){
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }            
            String locate = x + ", " + y;
            if(!visited.add(locate))
                return true;
        }
        return false;
    }
}