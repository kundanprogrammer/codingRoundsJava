import java.util.*;
public class Solution {

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
        for(int ar : arr){
            int count = map.getOrDefault(ar,0);
            map.put(ar,count+1);
        }
        int[] result = new int[k];
        NumberCount[] numberCount = new NumberCount[map.size()];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            numberCount[index] = new NumberCount(entry.getValue(),entry.getKey());
            index++;
        }
        
        Arrays.sort(numberCount,(NumberCount a,NumberCount b)->(-a.count+b.count));
        
        for(int i=0;i<k;i++){
            result[i] = numberCount[i].number;
        }
        
        return result;
	}
    public static class NumberCount{
        int count;
        int number;
        public NumberCount(int count,int number){
            this.count = count;
            this.number = number;
        }
    }
}



