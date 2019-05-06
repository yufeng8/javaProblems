import java.util.*;
public class DecisionTree extends ArrayList<BTNode> {
    public int height() {
       return getRoot().height();
    }

    public BTNode getRoot() {
        return this.get(0);
    }

    public void printAll(BTNode v) {
        if (v == null) {
           return;
        } 
          
        System.out.println(v.getElement());
        
        printAll(v.getLeft());
        printAll(v.getRight());  
    }
}