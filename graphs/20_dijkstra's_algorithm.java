//https://www.youtube.com/watch?v=xQ3vjWwFRuI&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=24
//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
class Solution {

    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        Map<Integer, List<Pair>> adj = buildGraph(edges);

        return findShortestDistance(V, adj, src);
    }

    // Build Adjacency List
    private Map<Integer, List<Pair>> buildGraph(int[][] edges) {

        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // Undirected Graph
        }

        return adj;
    }

    // Dijkstra's Algorithm
    private int[] findShortestDistance(int V, Map<Integer, List<Pair>> adj, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int currDist = current.weight;

            if (currDist > dist[node]) {
                continue;
            }

            for (Pair neighbour : adj.getOrDefault(node, new ArrayList<>())) {

                int nextNode = neighbour.node;
                int edgeWeight = neighbour.weight;

                if (currDist + edgeWeight < dist[nextNode]) {

                    dist[nextNode] = currDist + edgeWeight;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }
}
