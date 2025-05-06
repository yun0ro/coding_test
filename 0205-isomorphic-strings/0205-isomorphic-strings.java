class Solution {
    // 동형 = Isomorphic 이란 한 문자가 다른 한 문자하고만 매핑되어야하는 것
    public boolean isIsomorphic(String s, String t) {
        // 길이가 다를 때
        if(s.length() != t.length()) return false;

        // Map으로 관리
        Map<Character, Character> isomorphic = new HashMap<>();
        // 이미 매핑되어있는 문자 관리
        Set<Character> mapped = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            // ss가 이미 매핑이 되어있을 경우
            if(isomorphic.containsKey(ss)){
                // 다른 문자로 매핑되어있는 경우
                if(isomorphic.get(ss) != tt) return false;
            }
            // 새로 매핑하는 경우
            else {
                // tt가 이미 매핑이 되어있을 경우
                if(mapped.contains(tt)) return false;
                isomorphic.put(ss, tt);
                mapped.add(tt);
            }
        }
        return true;
    }
}