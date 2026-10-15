/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Map<Node, Node> res = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val); // Keeps the actual value intact beacuse
        // default value of node will '0'
        res.put(node, clone);
        q.offer(node);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            // retrive and remove the queue from fist item
            // when first time only firt node valaible
            for (Node n : currentNode.neighbors) {
                // check in resp Map contains key or not
                if (!res.containsKey(n)) {
                    res.put(n, new Node(n.val));
                    q.offer(n);
                }
                // Add neighbor to the current node clone.
                res.get(currentNode).neighbors.add(res.get(n));
            }
        }

        return res.get(node);
    }
}