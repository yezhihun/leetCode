package leetCode;

public class RemoveDuplicates {

	/**
	 * Remove Duplicates from Sorted Array
	* @Author tianye
	* @Description: 
	* @return void
	* @throws
	 */
	public static void main(String[] args) {
		int[] ary = {1,1,2,2,4,4,4,4,4,5,6};
		System.out.println(removeDuplicates2(ary));
	}
	
	private static int removeDuplicates(int A[]) {
		int n = A.length;
        if (n == 0) return 0;
 
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (A[index] != A[i])
                A[++index] = A[i];
        }
        return index + 1;
    }
	
	private static int removeDuplicates2(int ary[]){
		if(ary.length==0)
			return 0;
		int count = 1;
		for(int i=1;i<ary.length;i++){
			if(ary[i-1] != ary[i]){
				count ++;
			}
		}
		
		return count;
	}

}
