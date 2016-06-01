package twoSum3;

import java.util.*;

public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number)){
	        int v = map.get(number);
	        map.put(number, v+1);
	    }else{
	        map.put(number, 1);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int i = 0; i < list.size(); i++){
	        int n1 = list.get(i);
	        int n2 = value-n1;
	        if((n1 == n2 && map.get(n2) > 1) || (n1 != n2 && map.containsKey(n2))) return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);