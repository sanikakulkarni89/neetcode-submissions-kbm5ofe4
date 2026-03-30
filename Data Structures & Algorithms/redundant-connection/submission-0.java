class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visit = new boolean[n + 1];

            if(dfs(edge[0], -1, adj, visit)){
                return edge;
            }
        }
        return new int[0];
    }
    public boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visit){
        if(visit[node]){
            return true;
        }

        visit[node] = true;
        for(int neighbor : adj.get(node)){
            if(neighbor == parent){
                continue;
            }
            if(dfs(neighbor, node, adj, visit)){
                return true;
            }
        }
        return false;
    }
}
