/*
// Definition for a Node.
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

class Solution {// using dfs time O(V+E) space O(V)
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);

    }

    private Node dfs(Node node, Map<Node, Node> map) {
        // If the node is already cloned, return the clone
        if (map.containsKey(node)) {
            return map.get(node);
        }
        //step 1 : clone the node and put it in map
        Node clone=new Node(node.val);
        map.put(node,clone);
        // step 2 : Recursively clone all the neighbors nodes
        for(Node neighbor : node.neighbors){
            clone.neighbors.add(dfs(neighbor, map)); // Add cloned neighbors to the current clone

        }
        return clone;
    }
}