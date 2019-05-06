/**
 * Tester class for reading DecisionTree from binary file.
 * 
 * 1. Reads DecisionTree object from a binary input file, 
 *    which by convention has a ".bin" extension.
 * 
 * 2. Prints the tree in order the nodes occur in the DecisionTree,
 *    which is a subclass of ArrayList<BTNode>. Skips all null
 *    positions in tree.
 */

import java.io.*;

public class ReadPrintBinaryDecisionTreeFile {
   
   // declare ObjectInputStream and DecisionTree as 
   // static fields because they are used in 2 static methods
   static ObjectInputStream rd;
   static DecisionTree tree;
   
   public static void main (String[] args) 
      throws ClassNotFoundException, IOException{
      
      tree = createTree(args[0]);
      System.out.println("The nodes of the tree are:");
      System.out.println("----------------------------");
      tree.printAll(tree.get(0));
      System.out.println("\nThe size of the tree is "+tree.size());
      System.out.println("The height of the tree is "+tree.height());
   } 
   
   public static DecisionTree createTree(String input) 
      throws ClassNotFoundException, IOException{
      // instantiate ObjectInputStream 
      rd = new ObjectInputStream(new FileInputStream(input));
      // Read from the input stream and cast to actual object type
      tree = (DecisionTree)rd.readObject();     
      // Close the input stream
      rd.close();
      return tree;
      
   }
}
