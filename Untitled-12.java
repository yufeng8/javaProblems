public Node buildTree(Queue<String> queue) {
    // queue: 5 7 ) 3 ) ) ) )
    if (queue.isEmpty()) return null;
    String cur = queue.poll();
    Node node = new Node(Integer.valueOf(cur), new ArrayList<Node>());
    while (queue.size() > 0 && !queue.peek().equals(")")) {
        // queue: 7 ) 3 ) ) ) )
        node.children.add(Node(7));
        // queue: 3 ) ) ) )
        node.children.add(Node(3));
        // queue: ) ) )
    }
    if (queue.size() > 0) {
        queue.poll();
    }
    // queue: ) )
    return node; // 5 (7 3)
}
