import java.io.*;
import java.util.Scanner;
import java.io.IOError;

public class AnimalGame {
  public static void printHead() {
    System.out.println("        Welcome to the Animal Guessing Game!");
    System.out.println("Please think of an animal.");
    System.out.println("I will ask some yes/no questions to try to figure out what you are.");
    System.out.println("Please enter a file name containing a decision tree.");
  }
  
  public static String readLine() {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    // scan.close();
    return s;
  }

  public static boolean promptYN() {
    for (;;) {
      String s = readLine();
      
      if (s.equals("N")) {
        return false;
      } else if (s.equals("Y")) {
        return true;
      } else {
        System.err.println("Invalid answer");
      }
    }
  }

  public static void playRound(DecisionTree tree) {
    BTNode node = tree.getRoot();
    while (!node.isLeaf()) {
      System.out.println(node.getElement());
      if (promptYN()) {
        node = node.getLeft();        
      } else {
        node = node.getRight();
      }
    }

    System.out.println("My guess is " + node.getElement() + ". Am I right?");
    if (!promptYN()) {
      System.out.println("I give up. What are you?");
      String animal = readLine();
      System.out.println("Please type a yes/no question that will distinguish the " + animal +  " from the " + node.getElement() + ".");
      String question = readLine();
      BTNode newNode = new BTNode(question);
      if (node.getParent().getLeft() == node) {
        node.getParent().setLeft(newNode);
      } else {
        node.getParent().setRight(newNode);
      }
      System.out.println("Is the answer yes for " + animal);
      boolean guess = promptYN();
      BTNode animalNode = new BTNode(animal);
      if (guess) {
        newNode.setLeft(animalNode);
        newNode.setRight(node);
      } else {
        newNode.setLeft(node);
        newNode.setRight(animalNode);
      }
    } else {
      System.out.println("Hahha, I win!");
    }
  }

  public static void main(String[] args) throws ClassNotFoundException, IOException {
    DecisionTree tree = createTree(args[0]);
    printHead();
    do {
      playRound(tree);
      System.out.println("Shall we play again?");
    } while (promptYN());
  }

  public static DecisionTree createTree(String input) throws ClassNotFoundException, IOException {
    // instantiate ObjectInputStream
    ObjectInputStream rd = new ObjectInputStream(new FileInputStream(input));
    // Read from the input stream and cast to actual object type
    DecisionTree tree = (DecisionTree) rd.readObject();
    // Close the input stream
    rd.close();
    return tree;

  }

}
