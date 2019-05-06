import java.util.*;

class TreeNode {
    public String name;
    public TreeNode[] children;

    TreeNode(String name, TreeNode[] children) {
        this.name = name;
        this.children = children;
    }
}

public class TreePrinter {
    public String printTree(TreeNode node) {
        //Map<TreeNode, Integer> depth = new HashMap<TreeNode, Integer>();
        //TreeNode pre = null;
        //depth.put(null, -1);
        StringBuilder sb = new StringBuilder();
        printTree(node, 0, sb);
        return sb.toString();
    }

    public void printTree(TreeNode node, int depth, StringBuilder sb) {
        for (int i = 0; i < depth * 2; i++) {
            sb.append(" ");
        }
        sb.append("<" + node.name + ">"); 
        sb.append("\n");

        for (TreeNode child: node.children) {
            printTree(child, depth + 1, sb);
        }

        for (int i = 0; i < depth * 2; i++) {
            sb.append(" ");
        }
        sb.append("</" + node.name + ">"); 
        sb.append("\n");
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode("foo", new TreeNode[] {
            new TreeNode("bar", new TreeNode[] {}),
            new TreeNode("another", new TreeNode[] {
                new TreeNode("child1", new TreeNode[] {}),
                new TreeNode("child2", new TreeNode[] {}),
                new TreeNode("child3", new TreeNode[] {})
            }),
            new TreeNode("baz", new TreeNode[] {})
        });

        System.out.println(new TreePrinter().printTree(tree));
    }
}
