package mergeInterval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start, end;
	Interval(){
		start = 0;
		end = 0;
	}
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start == o2.start) return o1.end - o2.end;
				return o1.start - o2.start;
			}
        });
        
        for(int i = 0; i < intervals.size(); i++){
        	if(i < intervals.size()-1){
        		if(intervals.get(i).end >= intervals.get(i+1).start && intervals.get(i).end < intervals.get(i+1).end){
        			intervals.get(i).end = intervals.get(i+1).end;
        			intervals.remove(i+1);
        			i--;
        		}else if(intervals.get(i).end >= intervals.get(i+1).end){
        			intervals.remove(i+1);
        			i--;
        		}
        	}
        }
        
        return intervals;
    }
}
