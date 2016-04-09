package twoSum;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTwoSum {

	@Test
	public void test() {
		int[] nums = {3,2,4};
		int target = 6;
		Solution f = new Solution();
		int[] res = f.twoSum(nums, target);
		System.out.println(res[0] + " " +res[1]);
		assertSame(1, res[0]);
		assertSame(2, res[1]);
	}

}
