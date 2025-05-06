class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 중복을 허용하지 않는 set 자료구조 활용
        Set<Integer> setNum = new HashSet<>();
        for (int num : nums) {
            // if문 진입 = 중복 값 존재
            if (!setNum.add(num)) {
                return true;
            }
        }
        return false;
    }
}