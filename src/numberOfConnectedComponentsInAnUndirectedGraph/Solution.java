package numberOfConnectedComponentsInAnUndirectedGraph;

import java.util.*;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<Integer>());
        }
        
        for(int[] p: edges){
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited.contains(i)) continue;
            dfs(map, visited, i);
            count++;
        }
        return count;
    }
    
    public void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int node){
        visited.add(node);
        for(int i: map.get(node)){
            if(visited.contains(i)) continue;
            dfs(map, visited, i);
        }
    }
}