/**
 * Name:
 * Student Number:
 */

public class TransposeOrganisingList extends OrganisingList {

    ////// Implement the function below this line //////

/**
     * Retrieve the node with the specified key and swap the
     * accessed node with its predecessor, then recalculate all data fields.
     * @return The node with its data value before it has been moved,
     * otherwise 'null' if the key does not exist.*/


    @Override
    public ListNode searchNode(Integer key) {

	//Your code goes here
        if(root==null){
            return null;
        }else if(root.key==key){
            ListNode retNode = root;
            return  retNode;
        }else if(!contains(key)) {
            return null;
        }else if(root.next.key==key){
            ListNode curr,retNode;
            retNode=curr = root.next;
            root.next=curr.next;
            root = curr;
            return retNode;
        }else{
            ListNode  pred,prev,curr,retNode;
            pred=prev=curr=root;

            while(curr.next!=null && curr.key!=key){
                pred=prev;
                prev=curr;
                curr=curr.next;
            }
            retNode = curr;
            pred.next=curr;
            prev.next = curr.next;
            curr.next=prev;
            return retNode;
        }

    }


}
