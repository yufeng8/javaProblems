class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    int count;
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.count = 1;
    }
}


public int numberSmaller(TreeNode root, int target) {
    if (root == null) return 0;

    if (target <= root.val) {
        int left = numberSmaller(root.left, target);
        return left;
    } else {
        int right = numberSmaller(root.right, target);
        return root.left.count + 1 + right;
    }
}

public void insert(TreeNode root, TreeNode node) {
    if (node.val <= root.val) {
        if (root.left == null) {
            root.left = node;
        } else {
            insert(root.left, node);
        }
    } else {
        if (root.right == null) {
            root.right = node;
        } else {
            insert(root.right, node);
        }
    }
    root.count++;
}

