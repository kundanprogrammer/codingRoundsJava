import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
        if(head==null)
            return null;
		LinkedListNode<Integer> root = head;
        while(root!=null){
            LinkedListNode<Integer> nxt = root.next;
            root.next = new LinkedListNode(root.data);
            root = root.next;
            root.next = nxt;
            root = root.next;
        }
        root = head;
        while(root!=null){
            if(root.random!=null){
                root.next.random = root.random.next;
            }
            root = root.next.next;
        }
        LinkedListNode<Integer> dummy = new LinkedListNode(0);
        LinkedListNode<Integer> cp = dummy;
        root = head;
        LinkedListNode<Integer> pointer = null;
        while(root!=null){
            pointer = root.next.next;
            cp.next = root.next;
            root.next = pointer;
            cp = cp.next;
            root = root.next;
        }
        
        return dummy.next;
	}
}