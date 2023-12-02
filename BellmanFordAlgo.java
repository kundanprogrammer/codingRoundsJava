import java.util.*;
public class Solution {
    static int bellmonFord(int vertices, int n, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        
        int[] result = new int[vertices+1];
        Arrays.fill(result,1000000000);
        result[src] = 0;
        
        for(int i=1;i<=vertices-1;i++){
            for(ArrayList<Integer> x : edges){
                if(x.get(2) + result[x.get(0)] < result[x.get(1)]){
                    result[x.get(1)] = x.get(2) + result[x.get(0)];
                }
            }
        }
        for(ArrayList<Integer> x : edges){
            if(x.get(2) + result[x.get(0)] < result[x.get(1)]){
                result[x.get(1)] = 1000000000;
            }
        }

        return result[dest]>100000?1000000000:result[dest];
    }
    
}
class Node{
    int from;
    int to;
    int weight;
    Node(int _from,int _to,int _weight){
        from = _from;
        to = _to;
        weight = _weight;
    }
}