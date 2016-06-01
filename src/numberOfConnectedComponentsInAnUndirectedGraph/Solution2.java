package numberOfConnectedComponentsInAnUndirectedGraph;

public class Solution2 {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for(int i = 0;i < n; i++){
            root[i] = i;
        }
        
        for(int[] pair: edges){
            if(root[pair[0]] != root[pair[1]]){
                join(root, pair[0], pair[1]);
            }
        }
        
        int count = 0;
        for(int i = 0; i < root.length; i++){
            if(root[i] == i) count++;
        }
        return count;
    }
    
    public void join(int[] root, int n1, int n2){
    	int root1 = root[n1];
        for(int i = 0; i < root.length; i++){
            if(root[i] == root1){
                root[i] = root[n2];
            }
        }
    }
    
    public static void main(String[] a){
    	Solution2 f = new Solution2();
    	int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
    	System.out.println(f.countComponents(5
    			, edges));
    }
}