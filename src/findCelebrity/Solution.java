package findCelebrity;

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class Solution extends Relation {
	public int findCelebrity(int n) {
	  int suspect = 0;
	  for(int i = 0; i < n; i++){
	      if(i == suspect) continue;
	      if(knows(suspect, i)){
	          suspect = i;
	      }
	  }
	  for(int i = 0; i < n; i++){
	      if(i == suspect) continue;
	      if(knows(suspect, i) || !knows(i, suspect)) return -1;
	  }
	  return suspect;
	}
}