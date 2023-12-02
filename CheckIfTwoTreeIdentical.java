/*******************************************************

    Following is the BinaryTreeNode class structure:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        
        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

*******************************************************/

public class Solution {
    
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if(root1==null && root2==null)
            return true;
        
        else if (root1==null || root2==null || !root1.data.equals(root2.data))
            return false;
        
        boolean left = identicalTrees(root1.left,root2.left);
        boolean right = identicalTrees(root1.right,root2.right);
        
        return left && right;
    }

}