// 다시 풀어볼만한 문제 
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        // TreeMap은 자동정렬해주는 Map
        Map<Character, Integer> close1 = new TreeMap<>();
        Map<Character, Integer> close2 = new TreeMap<>();
 
        for(char word : word1.toCharArray()){
            close1.put(word, close1.getOrDefault(word, 0) + 1);
        }
        for(char word : word2.toCharArray()){
            close2.put(word, close2.getOrDefault(word, 0) + 1);
        }

        // 문자 집합이 같은지 확인
        if(!close1.keySet().equals(close2.keySet())){
            return false;
        }

        // 문자 개수가 같은지 확인
        List<Integer> num1 = new ArrayList<>(close1.values());
        List<Integer> num2 = new ArrayList<>(close2.values());

        // Collections는 List, Set, Map에 사용 
        Collections.sort(num1);
        Collections.sort(num2);
        return num1.equals(num2);
    }
}

// 훨씬 빠른 코드
// class Solution {
//     public boolean closeStrings(String word1, String word2) {
      
//         if (word1.length() != word2.length()) return false;

//         int[] freq1 = new int[26];
//         int[] freq2 = new int[26];

//         for (char c : word1.toCharArray()) freq1[c - 'a']++;
//         for (char c : word2.toCharArray()) freq2[c - 'a']++;
//         for (int i = 0; i < 26; i++) {
//              if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
//                  return false;
//              }
//          }

//          // Arrays는 배열에 사용 
//          Arrays.sort(freq1);
//          Arrays.sort(freq2);

//          return Arrays.equals(freq1, freq2);
//      }
// }