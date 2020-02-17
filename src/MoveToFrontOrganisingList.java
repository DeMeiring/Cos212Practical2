import java.util.List;

/**
 * Name:
 * Student Number:
 */

public class MoveToFrontOrganisingList extends OrganisingList {

    ////// Implement the function below this line //////

/**
     * Retrieve the node with the specified key and move the accessed node
     * to the front, then recalculate all data fields.
     * @return The node with its data value before it has been moved to the front,
     * otherwise 'null' if the key does not exist.
     */

    @Override
    public ListNode searchNode(Integer key) {

        //Your code goes here
        if(root==null){ //if list is empty return null
            return null;
        }else if(!contains(key)){ //list is not empty but does not contain desired key
            return null;
        }else if(root.key==key){
            ListNode retNode = root;
            return retNode;
        }else{  //list is not empty and key is in list
            ListNode prev,curr,retNode;
            prev=curr=root;
            while(curr.next!=null && curr.key!=key){
                prev=curr;
                curr=curr.next;
            }
            retNode=curr;
            prev.next = curr.next;
            curr.next = root;
            root=curr;
            calculateData();
            return retNode;
        }

    }


}
