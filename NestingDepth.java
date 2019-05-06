import java.util.*;

public class NestingDepth {
    public int nestDepth(String input) {
        Queue<String> queue = new LinkedList<>();
        for (char val: input.toCharArray()) {
            if (val != ' ')
                queue.offer(Character.toString(val));
        }
        return getDepth(queue);
    }

    public int getDepth(Queue<String> queue) {
        int max = 0;
        String cur = queue.poll();
        if (!cur.equals("(")) {
            System.out.println("error");
        }
        while (queue.size() > 0 && queue.peek().equals("(")) {
            max = Math.max(max, getDepth(queue));
        }

        if (queue.size() > 0 && queue.peek().equals(")")) {
            queue.poll();
        }
        return max + 1; 
    }

    public static void main(String[] args) {
        String input = "(() (()()))";
        System.out.println(new NestingDepth().nestDepth(input));
    }
}