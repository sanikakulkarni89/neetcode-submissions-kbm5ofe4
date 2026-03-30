class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    HashSet<Integer> visiting = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1)){
            return false;
        }

        return visiting.size() == n;
    }
    public boolean dfs(int node, int parent){
        if(visiting.contains(node)){
            return false;
        }

        visiting.add(node);
        for(int neighbor : adj.get(node)){
            if(neighbor == parent){
                continue;
            }
            if(!dfs(neighbor, node)){
                return false;
            }
        }
        return true;        
    }
}
