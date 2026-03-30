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
        for(int node = 0; node < n; node++){
            if(!visit[node]){
                dfs(node, visit, adj);
                count++;
            }
        }
        return count;
    }
    public void dfs(int i, boolean[] visit, List<List<Integer>> adj){
        visit[i] = true;
        for(int neighbor : adj.get(i)){
            if(!visit[neighbor]){
                dfs(neighbor, visit, adj);
            }
        }
    }
}
