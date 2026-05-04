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
class SourceDestinationNode {
    Node source, destination;
    public SourceDestinationNode(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }
}
class Solution {
    
    Node root;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap();
        root = new Node(node.val);
        Queue<SourceDestinationNode> queue = new LinkedList<>();
        queue.add(new SourceDestinationNode(node, root));
        map.put(node.val, root);
        //System.out.println("coMING HERE");
        Set<Integer> visited = new HashSet();
        visited.add(node.val);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                SourceDestinationNode sd = queue.poll();
                Node destination = sd.destination, source = sd.source;
                for (Node neighbor : source.neighbors) {
                    if (neighbor == null) {
                        continue;
                    }
                    map.putIfAbsent(neighbor.val, new Node(neighbor.val));
                    Node destinationNeighbor = map.get(neighbor.val);
                    destination.neighbors.add(destinationNeighbor);
                    if (!visited.contains(neighbor.val)) {
                        queue.add(new SourceDestinationNode(neighbor, destinationNeighbor));
                        visited.add(neighbor.val);
                    }
                }
            }
        }
        return root;
    }
}