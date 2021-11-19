
public class LoopList {
	
	static Node head;
	
	static class Node {
		  
        int data;
        Node next;
  
        Node(int d) {
            data = d;
            next = null;}
    }
	
	static int sum = 0;
	static void counter() {
		sum = sum + 1;
	}
	
	static Boolean FindLoop(Node node)
	    {
	        Node front = node, end = node;
	        while (front != null && end != null && end.next != null) {
	            front = front.next;
	            end = end.next.next;
	            System.out.print(front.data);
	            System.out.print(" ");
	            System.out.print(end.data);
	            System.out.println("");
	            counter();
	            // If slow and fast meet at same point then loop is present
	            if (front == end) {
	                return true;
	            }
	        }
	        return false;
	    }
	
	static void MeasureLoop(Node node) {
		int loop = 1;
		 Node front = node, end = node;
	        while (front != null && end != null && end.next != null) {
	            front = front.next; end = end.next.next;
	            if (front == end) { end = null; }
	        }
	        Node temp = front;
            while (temp.next != front) { temp = temp.next; loop += 1;}
            System.out.println(loop);
	}
	
	static void MeasureChain(Node node) {
		int chain = 0;
		 Node front = node, end = node;
	        while (front != null && end != null && end.next != null) {
	            front = front.next;
	            end = end.next.next;
	            if (front == end) { front = null; }
	        }
	        front = node;
            while (front != end) {
            	front = front.next;
            	end = end.next;
            	chain += 1;
            }
            System.out.println(chain);
	}
	
	static void printList(Node L)
    {
        Node n = L;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println("");
    }

	public static void main(String[] args) {
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
  
        // Creating a loop for testing
        //head.next.next.next.next.next = head.next;
        head.next.next.next.next.next = head.next.next;
        //head.next.next.next.next.next = head.next.next.next;
        //printList(head);
        //System.out.println(FindLoop(head));
        //System.out.println(sum);
        MeasureChain(head);
        MeasureLoop(head);
	}

}
