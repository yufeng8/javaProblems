/**
 * Tester class for DecisionTree and BTNode classes.
 * 
 * 1. Reads lines from a text file into a DecisionTree (which is
 *    a subclass of ArrayList<BTNode>) 
 *    The text file name is read from the command line as args[0]
 *    and by convention has ".txt" extension.
 * 
 * 2. Connects the BTNodes in the DecisionTree based on the order
 *    in which they were created and then writes the DecisionTree
 *    object to a binary file, which by convention has a ".bin" 
 *    extension.
 */

import java.io.*;         // for file and keyboard readers
                          // and file writers

public class ReadTextFileCreateBinaryFile {
  
  // declare BufferedReader, DecisionTree, and
  // ObjectOutputStream objects as static fields
  // because they are used in a static method.
  static BufferedReader rd;
  static DecisionTree tree;
  static ObjectOutputStream out;
  
  public static void main (String[] args) throws IOException{    
    tree = createTree(args[0], args[1]);
    System.out.println("The nodes of the tree are:");
    System.out.println("----------------------------");
    tree.printAll(tree.get(0));
    System.out.println("\n\nThe height of the tree is "+tree.height());
  } 
  
  /**
   * Input parameters are Strings containing the name of the text-only 
   * input file and the binary output file.
   * Creates a DecisionTree out of lines read from the input file, connects
   * the internal BTNodes in the DecisionTree to their children (and 
   * children to parent nodes), and writes the DecisionTree to an output 
   * file. Returns a DecisionTree object that is printed in the main method.
   */
  public static DecisionTree createTree(String input, String output) 
     throws IOException {

    rd = new BufferedReader(new FileReader(input));
    out = new ObjectOutputStream(new FileOutputStream(output));
    
    tree = new DecisionTree();
    String line = "";
    
    // Create each BTNode in the position of the DecisionTree that
    // corresponds to the line's position in the input file
    
    while((line = rd.readLine()) != null){
      tree.add(new BTNode(line));
    }
    
    rd.close(); // last time using input file, so close it
    
    // Set child and parent pointers of BTNodes in DecisionTree.
    // Assumes each node has exactly 2 children (i.e., tree is full).
    
    int j = 0;  // start by connecting root of tree to left and right
                // children
    
    // 2*j+2 equals the size of the DecisionTree when j is 
    // the highest numbered internal node in the tree by level-
    // order numbering.
    while (2*j+2 < tree.size()) {
      // Set left child pointer and parent pointer of left child
      tree.get(j).setLeft(tree.get(2*j+1));  
      // Set right child pointer and parent pointer of right child
      tree.get(j).setRight(tree.get(2*j+2));
      // Go on to next internal node in the tree
      j++;
    }
    
    out.writeObject(tree);  // Writes DecisionTree to file in one line!
    out.close();            // Done with output file, so close it.
    
    return tree;
  }
  
}
