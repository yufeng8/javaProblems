public Node buildTree(Queue<String> queue) {
    // queue: 1 2 5 7 ) 3 ) ) ) )
    if (queue.isEmpty()) return null;
    String cur = queue.poll(); // 1
    Node node = new Node(Integer.valueOf(cur), new ArrayList<Node>());
    while (queue.size() > 0 && !queue.peek().equals(")")) {
        // queue: 2 5 7 ) 3 ) ) ) )
        node.children.add(Node(2, {5, {7, 3}}));
    }
    if (queue.size() > 0) {
        queue.poll();
    }
    return node;
}



public Node buildTree(Queue<String> queue) {
    // queue: 3 ) ) ) )
    if (queue.isEmpty()) return null;
    String cur = queue.poll();
    Node node = new Node(Integer.valueOf(cur), new ArrayList<Node>());
    // queue: ) ) ) )
    while (queue.size() > 0 && !queue.peek().equals(")")) {
        node.children.add(buildTree(queue));
    }
    if (queue.size() > 0) {
        queue.poll();
    }
    // queue: ) ) )
    return node; // 3
}
