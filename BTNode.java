import java.util.*;

public class BTNode implements java.io.Serializable {
    private String element;
    private BTNode parent;
    private BTNode left, right;

    public BTNode(String value) {
        this.element = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public BTNode getLeft() {
        return this.left;
    }

    public BTNode getRight() {
        return this.right;
    }

    public BTNode getParent() {
        return this.parent;
    }

    public void setLeft(BTNode newLeft) {
        if (this.left != null) {
            this.left.parent = null;
        }
        
        this.left = newLeft;
        newLeft.parent = this;
    }

    public void setRight(BTNode newRight) {
        if (this.right != null) {
            this.right.parent = null;
        } 
        this.right = newRight;
        newRight.parent = this;

    }

    public void setParent(BTNode newParent) {
        this.parent = newParent;
        newParent.left = this.left;
        newParent.right = this.right;
    }

    public int size() {
        if (this.left == null) {
            return this.right != null ? 1: 0;
        }

        if (this.right == null) {
            return this.left != null ? 1: 0;
        }
        return 2;
    }

    public int height() {
        int height1 = 1;
        int height2 = 1;
        while (this.left != null) {
            height1++;
            this.left = this.left.left;
        }
        while (this.right != null) {
            height2++;
            this.right = this.right.right;
        }
        return Math.max(height1, height2);
    }

    public boolean isEmpty() {
        return this == null;
    }

    public boolean isLeaf() {
        if (this.left == null && this.right == null) {
            return true;
        }
        return false;
    }

    public boolean isLeftChild() {
        return this.parent.left != null ? true: false;
    }

    public boolean isRightChild() {
        return this.parent.right != null ? true: false;
    }

    public String getElement() {
        return this.element != null ? this.element: null;
    }

    public void setElement(String value) {
        this.element = value;
    }
}
