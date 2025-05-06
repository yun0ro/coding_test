class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();

        // 출발 도시를 set에 저장해놓는다.
        for(List<String> path : paths){
            cities.add(path.get(0));
        }

        // 도착 도시를 비교해가며, set안에 존재하지 않을 경우 해당 도시 이름 반환
        for(List<String> path : paths){
            if(cities.add(path.get(1)))
                return path.get(1);
        }
        return "Wrong Destination Input";
    }
}