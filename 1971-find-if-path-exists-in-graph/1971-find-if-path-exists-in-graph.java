// 177ms
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 인접 리스트 그래프 구성
        List<List<Integer>> graph = new ArrayList<>();
        // node별 인접 리스트 공간
        for(int i = 0; i< n; i++){
            graph.add(new ArrayList<>());
        }
        // node별 인접 node를 추가해줌
        for(int[] edge :edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // DFS, 방문했는지 안 했는지 여부를 판단하는 array
        boolean[] visited = new boolean[n];
        return dfs(source, destination, graph, visited);
    }

    // 깊게 들어가면서 destination node를 찾는다.
    private boolean dfs(int source, int destination, List<List<Integer>> graph, boolean[] visited){
        // 도착했으면 true 반환
        if(source == destination) return true;
        // 현재 node 방문 처리 (중복 방문 방지)
        visited[source] = true;

        // 현재 node의 인접 node들 확인
        for(int neighbor : graph.get(source)){
            // 아직 방문하지 않은 node에 대해서 dfs 탐색
            if(!visited[neighbor]){
                if(dfs(neighbor, destination, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}

// 14ms answer
// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         UnionFind uf= new UnionFind(n);
//         for(int[] edge:edges){
//             uf.union(edge[0],edge[1]);
//         }
//         return uf.find(source)==uf.find(destination);
//     }
// }
// class UnionFind{
//     int[] parent;
//     UnionFind(int n){
//         parent=new int[n];
//         for(int i=0;i<n;i++){
//             parent[i]=i;
//         }
//     }

//     public int find(int x){
//          if(parent[x]!=x){
//             parent[x]=find(parent[x]);
//          }
//          return parent[x];
//     }
//     public void union(int x,int y){
//         int px=find(x);
//         int py=find(y);
//         if(px!=py){
//             parent[px]=py;
//         }

//     }
// }