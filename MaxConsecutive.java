import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		ArrayList<Integer> zeroIndex = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==0){
                zeroIndex.add(i);
            }
        }
        if(zeroIndex.size()<=k)
            return arr.size();
        int pointer = 0;
        int result = 0;
        for(int i=0;i<zeroIndex.size()-k+1;i++){
            int index = i+k;//curr + zero we can change 
            if(index<zeroIndex.size()){
                result = Math.max(result,zeroIndex.get(i+k)-pointer);
                pointer = zeroIndex.get(i)+1;
            }
            else{
                result = Math.max(result,arr.size()-pointer);
            }
        }
        
        return result;
	}
}