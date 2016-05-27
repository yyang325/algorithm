package nestedListWeightSum;

import java.util.List;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return help(nestedList, 1);
    }
    
    public int help(List<NestedInteger> nestedList, int level){
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++){
            if(nestedList.get(i).isInteger()){
                sum += (nestedList.get(i).getInteger()*level);
            }else{
                sum += help(nestedList.get(i).getList(), level+1);
            }
        }
        return sum;
    }
}