
    int dfs(List<Integer> list, boolean[] visited, int index, int N) {
        if (index == N) {
            return 1;
        }
        
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i - 1] || i % (index + 1) != 0 && (index + 1) % i != 0) {
                continue;
            }
            
            visited[i - 1] = true;
            list.add(i);
            sum += dfs(list, visited, index + 1, N);
            list.remove(list.size() - 1);
            visited[i - 1] = false;
        }
        return sum;
    }
}