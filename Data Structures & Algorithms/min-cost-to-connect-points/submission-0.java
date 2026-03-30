class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int node = 0;
        int[] dist = new int[n];
        boolean[] visit = new boolean[n];
        Arrays.fill(dist, 10000000);
        int edges = 0;
        int res = 0;

        while(edges < n - 1){
            visit[node] = true;
            int nextNode = -1;
            for(int i = 0; i < n; i++){
                if(visit[i]) continue;
                int currDist = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(dist[i], currDist);
                if(nextNode == -1 || dist[i] < dist[nextNode]){
                    nextNode = i;
                }
            }
            res += dist[nextNode];
            node = nextNode;
            edges++;
        }
        return res;
    }
}
