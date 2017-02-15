package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 *
 * Description: 
 *
 * @author tianye
 * @version V1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2017年2月15日上午11:34:45    tianye       V1.0        
 * </pre>
 */
public class CountMoney {

	/**
	 * 
	* @Author tianye
	* @Description: 有一个有序数组，从数组中任取一值，获得他共有几种组合（通过数组中数据相加获得，不包含本身） 
	* @return void
	* @throws
	 */
	public static void main(String[] args) {
		int ary[] = {1,2,5,10,20,50,100};
		for(int i=0;i<ary.length;i++){
			System.out.println(ary[i] +":"+ countSum(ary, ary[i]));
		}
	}
    
    private static int countSum(int[] ary, int count){
    	Map<Integer,List<Integer>> result = countMap(ary);
    	return count(result, count);
    }
    
    private static int count(Map<Integer,List<Integer>> resultMap, int count){
    	if(!resultMap.containsKey(count)){
    		return 0;
    	}
    	List<Integer> result = resultMap.get(count);
    	int sum = 1;
    	for(int i=0;i<result.size();i++){
    		int me = result.get(i);
    		if(resultMap.containsKey(me)){
    			sum += count(resultMap, me);
    		}
    	}
    	return sum;
    }
    
    private static Map<Integer,List<Integer>> countMap(int[] ary){
    	Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
		for(int i=1;i<ary.length;i++){
			/**
			 * 需要计算的和
			 */
			int sum = ary[i];
			int sub = sum;
			/**
			 * 遍历在他之前的数据
			 */
			w:for(int x=i-1;x>=0;x--){
				List<Integer> list = new ArrayList<Integer>();
				for(int j=x;j>=0;){
					int me = ary[j];
					if(sub==me){
						if(result.containsKey(sum)){
							list = result.get(sum);
						}
						list.add(me);
						result.put(sum, list);
						break w;
					}else if(sub>me){
						list.add(me);
						sub = sub-me;
					}else if(sub<me){
						j-=1;
					}
				}
			}
		}
		return result;
    }
}
