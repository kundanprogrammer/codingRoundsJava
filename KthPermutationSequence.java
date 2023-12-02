import java.util.ArrayList;

public class Solution {
    public static String kthPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i=1;i<n;i++){
            fact *= i;
            list.add(i);
        }
        list.add(n);
        k = k-1;
        StringBuilder sb = new StringBuilder();
        while(true){
            Integer x = list.get(k/fact);
            sb.append(list.get(k/fact));
            list.remove(x);
            if(list.size()==0){
                break;
            }
            k = k%fact;
            fact = fact/list.size();
        }
        return sb.toString();
    }
}