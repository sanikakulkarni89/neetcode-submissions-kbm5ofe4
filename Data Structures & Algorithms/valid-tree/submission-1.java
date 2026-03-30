class Solution {
    private HashMap<Integer, List<Integer>> graph = new HashMap<>();
    private HashSet<Integer> visiting = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
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
        for(int neighbor : graph.get(node)){
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
