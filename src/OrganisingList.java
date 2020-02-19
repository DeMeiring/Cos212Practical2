/**
 * Name:
 * Student Number:
 */

abstract class OrganisingList {

    public ListNode root = null;

    public OrganisingList() {

    }
    
    /**
     * Calculate the data field of all nodes in the list using the recursive functions.
     */
    public void calculateData() {
        if (root != null) {
            dataRec(root);
        }
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////

    
    //Recursive functions

    /**
     * Calculate the sum of keys recursively, starting with the given node until the end of the list
     * @return The sum of keys from the current node to the last node in the list
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int sumRec(ListNode node) {

        //Your code goes here
        if(node.next==null){
            return node.key;
        }else{
            return sumRec(node.next)+node.key;
        }

    } //TODO:imp sumRec

    /**
     * Calculate and set the data for the given node.
     * @return The calculated data for the given node
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int dataRec(ListNode node) {

        //Your code goes here
        if(node.next==null){
            node.data= node.key;
            return node.key;
        }else{
            node.data = (node.key* sumRec(node))-dataRec(node.next);
            return (node.key* sumRec(node))-dataRec(node.next);
        }

    } //TODO:imp dataRec


    //Organising List functions

    /**
     * Retrieve the node with the specified key, move the node as required and recalculate all data fields.
     * @return The node with its data value before it has been moved, otherwise 'null' if the key does not exist.
     * Implement only in specific subclass!
     */
    public abstract ListNode searchNode(Integer key);

    /**
     * Check if a key is contained in the list
     * @return true if the key is in the list, otherwise false
     */
    public boolean contains(Integer key) {
        ListNode curr;
        //Your code goes here
        if(root==null){ //if the list is empty
            return false;
        }else if(root.key==key){
            return true;
        }else{
            curr=root;
            while(curr.next!=null && curr.key!=key){
                curr=curr.next;
            }
            if(curr.key==key){
                return true;
            }
        }
        return false;
    }


    /**
     * Insert a new key into the linked list.
     * New nodes should be inserted at the back.
     * calculateData() should be called after insertion.
     * Duplicate keys should not be added.
     */
    public void insert(Integer key) {

        //Your code goes here
        ListNode curr;
        ListNode newNode = new ListNode(key);
        if(root==null){ //make newNode the root when the list does not yet exist and or is empty
            root = newNode;
            calculateData();
        }else if(contains(key)){   //if key is already present then do nothing
            return;
        }else{
            curr=root;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
            calculateData();
        }
    }
	
    /**
     * Delete the node with the given key.
     * calculateData() should be called after deletion.
     * If the key does not exist, do nothing.
     */
    public void delete(Integer key) {

        //Your code goes here
        if(root==null){ //if list is empty
            return;
        }else if(!contains(key)){     //key is not in list
            return;
        }else if(root.key==key){ //root is being deleted
            root=root.next;
            calculateData();
        }else{  //key is present and list does exist
            ListNode prev,curr;
            prev=curr=root;

            while(curr.next !=null && curr.key!=key){   //loop through list till you find the desired node
                prev=curr;
                curr=curr.next;
            }
            prev.next = curr.next;  //uncouple curr node from list
            curr = null;
           calculateData();
        }
    }


    //Helper functions

    


}