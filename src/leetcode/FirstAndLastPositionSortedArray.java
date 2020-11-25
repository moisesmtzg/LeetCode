package leetcode;

public class FirstAndLastPositionSortedArray {

	public int[] searchRange(int[] nums, int target) {
		int start = 0, end = nums.length-1;

		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] == target && nums[start] == nums[end]) {
				return new int[] {start, end};
			}else if(nums[mid] == target && nums[start] < target) {
				start++;
			}else if(nums[mid] == target && nums[end] > target) {
				end--;
			}else if(nums[mid] < target){
				start = mid +1;
			}else {
				end = mid -1;
			}
		}
		return new int[]{-1,-1};
	}
}
