package leetCode;

public class TwoSum {

	public static void main(String[] args) {
		int[] ary = {1,5,6,7,11};
		twoSum(ary, 13);
	}
	
	private static int[] twoSum(int[] nums, int target) {
		int[] result = {0,0};
		int max = nums.length-1;
        for(int i=0;i<max;){
        	if(nums[i]+nums[max]>target){
        		max--;
        	}else if(nums[i]+nums[max]<target){
        		i++;
        	}else{
        		result[0]=nums[i];
        		result[1]=nums[max];
        		break;
        	}
        }
        return result;
    }
}
