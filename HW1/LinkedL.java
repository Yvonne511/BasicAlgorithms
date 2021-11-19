
public class LinkedL {
	
	static class Node {
        int data;
        Node next;
    };
    
    static void printList(Node L)
    {
        Node n = L;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println("");
    }
    
    static Node push(Node head_ref,int new_data)
    {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }
    
    public static void append(Node head, int new_data)
    {
        Node new_node = new Node();
        new_node.data = new_data; new_node.next = null;
        if (head == null)
        {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return;
    }
    
    static int sum = 0;
    static Node twopasssum(Node l) {
    	Node prev = null;
        Node current = l;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        l = prev;
   
        Node temp = null;
        while (l != null) {
        	printList(temp);
        	sum += l.data;
        	l = l.next;
            append(temp, sum);
        }
    	
    	l = temp;
    	return l;
    }
    
    static void succedsum(Node l) {
    	if (l == null) return;
    	else {
    		succedsum(l.next);
    		sum += l.data;
    		l.data = sum;
    	}
    }

    static void previoussum(Node l) {
    	if (l == null) return;
    	else {
    		sum += l.data;
    		l.data = sum;
    	}
    	previoussum(l.next);
    }
    
	public static void main(String[] args) {
		Node L = null;
		L = push(L, 7);
		L = push(L, 6);
		L = push(L, 5);
		L = push(L, 4);
		L = push(L, 3);
		Node l = L;
		printList(L);
		//succedsum(l);
//		previoussum(l);
//		printList(l);
		printList(twopasssum(l));
	}

}
