package leetcode;

import java.util.Arrays;

public class Sum3Closest {

	public int threeSumClosest(int[] nums, int target) {
		int closest = 100000;
		int diff;
		int pointer1, pointer2;
		
		//sorteamos el nums
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length-1; i++) {
			//apuntadores i al inicio, p1 i+1 y p2 tomara el ulitmo valor de nums
			pointer1 = i+1;
			pointer2 = nums.length-1;
			
			while(pointer1 < pointer2) {
				int sum = nums[i] + nums[pointer1] + nums[pointer2];
				diff = target - sum;
				if(sum == target || diff == 0) {
					return sum;
				}
				if(Math.abs(diff) < Math.abs(target - closest)) {
					closest = sum;
				}
				if(sum < target) {
					pointer1++;
				}else {
					pointer2--;
				}
			}
		}
		return closest;
	}
}
