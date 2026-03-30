class Solution {
    public int countComponents(int n, int[][] edges) {
         List<List<Integer>> adj = new ArrayList<>();
         boolean[] visit = new boolean[n];

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        } 

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(adj, visit, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(List<List<Integer>> adj, boolean[] visit, int node){
        visit[node] = true;
        for(int neighbor : adj.get(node)){
            if(!visit[neighbor]){
                dfs(adj, visit, neighbor);
            }
        }
    }
}
