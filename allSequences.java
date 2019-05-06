import java.util.*;
import java.lang.*;
public class allSequences {
    public List<List<Integer>> findSequences(int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> doubleSequence = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            dfs(doubleSequence, result, i, k);
        }
        return result;
    }

    // dfs(start = 1, k = 4, doubleSequence = [])
    //   dfs(start = 2, k = 4, doubleSequence = [1])

    public void dfs(List<Integer> doubleSequence, List<List<Integer>> result, int start, int k) {
        if (start > k)
            return;

        doubleSequence.add(start);
        result.add(new ArrayList<>(doubleSequence));
        dfs(doubleSequence, result, start*2, k);
        if (start > 1)
            dfs(doubleSequence, result, start + 1, k);
        doubleSequence.remove(doubleSequence.size() -1);
    }
    public static void main(String[] args) {
        System.out.println(new allSequences().findSequences(4));
    }
}



