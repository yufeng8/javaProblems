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
public class countOddNum {
    
    public int countOdd(Node node) {
        
        return helper(node);
    }

    public int helper(Node node) {
        if (node == null) return 0;
        int count = 0;
        if (node.value%2 != 0) {
            count++;
        } 
        for (Node child: node.children) {
            count += helper(child);
        }
        return count;
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
        System.out.println(new countOddNum().countOdd(a));       
    }
}