/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;

public class Solution 
{
    static int currIndex = 0;
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        currIndex = 0;
        HashMap<Integer,Integer> inOrderMap = new HashMap<>();
        populateHashMap(inOrderMap,inorder);
        return buildTree(inOrderMap,preorder,0,inorder.size()-1);
    }
    public static void populateHashMap(HashMap<Integer,Integer> inOrderMap,ArrayList<Integer> inorder){
        for(int i=0;i<inorder.size();i++){
            inOrderMap.put(inorder.get(i),i);
        }
    }
    public static TreeNode<Integer> buildTree(HashMap<Integer,Integer> inOrderMap,ArrayList<Integer> preorder,int start,int end){
        if(currIndex>preorder.size()-1)
            return null;
        if(start>end){
            return null;
        }
        int element = preorder.get(currIndex++);
        TreeNode<Integer> node = new TreeNode<Integer>(element);
        
        if(start==end){
            return node;
        }
        
        int mid = inOrderMap.get(element);
        node.left = buildTree(inOrderMap,preorder,start,mid-1);
        node.right = buildTree(inOrderMap,preorder,mid+1,end);
        return node;
    }
    
}



















