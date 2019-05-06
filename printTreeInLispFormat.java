import java.util.*;
class Node {
    public int value;
    public List<Node> children;
    public Node(int value) {
        this.value = value;
        children = new ArrayList<>();
    }
    public Node(int value, List<Node> children) {
        this.value = value;
        this.children = children;
    }
}

public class printTreeInLispFormat {
    public String printTree(Node node) {
        StringBuilder sb = new StringBuilder();
        buildTree(node, sb);
        return sb.toString();
    }

    public void buildTree(Node node, StringBuilder sb) {
        if (node == null) return;
        if (node.children.size() != 0) {
            if (node.value % 2 != 0) {
                sb.append("(");
                sb.append(node.value);
                sb.append(" ");
            } else {
                sb.append("[");
                sb.append(node.value);
                sb.append(" ");
            }
            
        }
        
        for (Node child: node.children) {
            buildTree(child, sb);
        }
        if (node.children.size() == 0) {
            if (node.value % 2 != 0) {
                sb.append(node.value);
                sb.append(")");
                sb.append(" ");
            } else {
                sb.append(node.value);
                sb.append("]");
                sb.append(" ");
            }
            
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.children.add(b);
        a.children.add(c);
        Node d = new Node(4);
        Node e = new Node(5);
        b.children.add(d);
        b.children.add(e);
        Node f = new Node(6);
        d.children.add(f);
        System.out.println(new printTreeInLispFormat().printTree(a));
    }
}