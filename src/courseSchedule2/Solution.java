package courseSchedule2;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer> list = new ArrayList<Integer>();
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int[] p: prerequisites){
            inDegree[p[0]]++;
        }
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0) queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int temp = queue.remove();
            list.add(temp);
            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == temp){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
        int[] res = new int[numCourses];
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] != 0) return new int[0];
        }
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    public static void main(String[] a){
    	Solution f = new Solution();
    	int[][] prerequisites = {{0,1},{1,0}};
    	int[] res = f.findOrder(2, prerequisites);
    	for(int i : res){
    		System.out.print(i + "\t");
    	}
    }
}