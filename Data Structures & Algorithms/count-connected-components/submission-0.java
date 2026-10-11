class Solution {
    public int countComponents(int n, int[][] edges) {
        // 1. Initialize the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 2. Build the undirected graph
        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            adjacencyList.get(nodeA).add(nodeB);
            adjacencyList.get(nodeB).add(nodeA); // Because the graph is undirected
        }

        // 3. Track visited nodes and count components
        boolean[] visited = new boolean[n];
        int componentCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // A new unvisited node means we found a new connected component
                componentCount++;
                // Perform DFS to mark all connected nodes as visited
                dfs(i, adjacencyList, visited);
            }
        }

        return componentCount;
    }

    private void dfs(int currentNode, List<List<Integer>> adjacencyList, boolean[] visited) {
        // Mark the current node as visited
        visited[currentNode] = true;

        // Recursively visit all unvisited neighbors
        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacencyList, visited);
            }
        }
    }
}
