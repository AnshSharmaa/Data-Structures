// Java program to delete a node from doubly linked list 

class halfcll { 

	static LinkList head, head1, head2; 

	static class LinkList { 

		int data; 
		LinkList next, prev; 

		LinkList(int d) { 
			data = d; 
			next = prev = null; 
		} 
	} 

	void half() { 
		LinkList ptr1 = head; 
		LinkList ptr2 = head; 

		if (head == null) { 
			return; 
		} 
		while (ptr2.next != head 
				&& ptr2.next.next != head) { 
			ptr2 = ptr2.next.next; 
			ptr1 = ptr1.next; 
		} 

		if (ptr2.next.next == head) { 
			ptr2 = ptr2.next; 
		} 
		head1 = head; 
		if (head.next != head) { 
			head2 = ptr1.next; 
		} 
		ptr2.next = ptr1.next; 
		ptr1.next = head; 
	} 

	void print(LinkList node) { 
		LinkList temp = node; 
		if (node != null) { 
			do { 
				System.out.print(temp.data + " "); 
				temp = temp.next; 
			} while (temp != node); 
		} 
	} 

	public static void main(String[] args) { 
		halfcll list = new halfcll(); 

		//Created linked list will be 12->56->2->11 
		list.head = new LinkList(12); 
		list.head.next = new LinkList(56); 
		list.head.next.next = new LinkList(2); 
		list.head.next.next.next = new LinkList(11); 
		list.head.next.next.next.next = list.head; 

		System.out.println("Original Circular Linked list "); 
		list.print(head); 

		// Split the list 
		list.half(); 
		System.out.println(""); 
		System.out.println("First Circular List "); 
		list.print(head1); 
		System.out.println(""); 
		System.out.println("Second Circular List "); 
		list.print(head2); 
		
	} 
} 
