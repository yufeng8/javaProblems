import java.util.*;
class Node {
    public String type;
    public List<Node> children;
    public Node(String type) {
        this.type = type;
        children = new ArrayList<>();
    }
    public Node(String type, List<Node> children) {
        this.type = type;
        this.children = children;
    }
}

public class parseString {
    public String parseStringToTree(String input) {
        Queue<String> queue = new LinkedList<>();
        for (String str: input.split(" ")) {
            if (str.length() > 0) {
                queue.add(str);
            }
        }
        Node node = buildTree(queue);
        StringBuilder sb = new StringBuilder();
        printTree(node, 0, sb);
        return sb.toString();
    }

    public Node buildTree(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        String cur = queue.poll();
        Node node;
        if ("([{".contains(cur)) {
            StringBuilder sb = new StringBuilder();
            sb.append(cur);
            node = new Node(sb.toString(), new ArrayList<Node>());   
        } else return null;
        
        while (queue.size() > 0 && "([{".contains(queue.peek())) {
            node.children.add(buildTree(queue));
        }

        if (queue.size() > 0 && ")]}".contains(queue.peek())) {
            node.type += queue.poll();
        }

        return node;
    }

    public void printTree(Node node, int depth, StringBuilder sb) {
        for (int i = 0; i < depth * 2; i++) {
            sb.append(" ");
        }
        sb.append(node.type); 
        sb.append("\n");

        for (Node child: node.children) {
            printTree(child, depth + 1, sb);
        }

        // for (int i = 0; i < depth * 2; i++) {
        //     sb.append(" ");
        // }
        // sb.append("</" + node.name + ">"); 
        // sb.append("\n");
    }

    public static void main(String[] args) {
        String input = "( [ ] { } [ ] { ( [ ] ) } )";
        System.out.println(new parseString().parseStringToTree(input));
    }
}