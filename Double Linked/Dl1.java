public class Dl1{
	static class Node{
	    int data;
    	Node next;
    	Node prev;
	    public Node (int data){
	    this.data=data;
	    }
	}

	public static Node insertAtPos(Node head,int pos,int data){
		if(head==null) return null;
		if(pos==1) return insbeg(head,data);
		Node p=head;
		Node q=new Node(data);
		q.prev=null;
		q.next=null;
		int i=0;
		pos--;
		while(p!=null&&i++!=pos) p=p.next;
		if(p==null) return insend(head,data);
		p.prev.next=q;
		q.prev=p.prev;
		q.next=p;
		p.prev=q;
		return head;
	}

    public static Node insend(Node head,int data){
	    Node n=new Node(data);
	    n.prev=null;
	    n.next=null;
	    if(head==null){
            return n;
        }//
	    Node p=head;
	    while(p.next!=null) p=p.next;
	    p.next=n;
	    n.prev=p;
	    return head;
	}
	
	public static Node insbeg(Node head,int data){
	    Node n=new Node(data);
	    n.prev=null;
	    n.next=null;
    	if(head==null) {
           return n;
        }
	    Node p=head;
	    n.next=p;
	    p.prev=n;
    	return n;
	}
	public static  void print(Node head){
	    Node p=head;
	    while(p!=null){
	    System.out.print(p.data+" ");
	    p=p.next;
		}
		System.out.println();
	}

	public static Node deleteAtEnd(Node head)
	{
		if(head==null) return null;
		Node p=head;
		while(p.next!=null) p=p.next;
		p.prev.next=null;
		return head;
	}

	public static Node delAtPos(Node head,int pos)
	{
		if(pos==1) return deleteAtBeg(head);
		int c=0;
		Node p=head;
		pos--;
		while(p!=null&&c++!=pos) p=p.next;
		if(p==null) return deleteAtEnd(head);
		Node t=p.next;
		p.prev.next=t;
		t=null;
		return head;
	}

	public static Node deleteAtBeg(Node head)
	{
		if(head==null) return null;
		Node t=head;
		head=head.next;
		head.prev=null;
		return head;

	}
	


	public static void main(String[] args){
        Node head=null;
	    head=insbeg(head,7);
        head=insbeg(head,7);
        head=insbeg(head,9);
        head=insbeg(head,8);
		head=insbeg(head,7);
		head=insend(head, 2);
		head=insend(head, 0);//okay sir
		print(head);
		
		System.out.println();
		System.out.println("Del at beg");  
		
		head=deleteAtBeg(head);
		print(head);   
		
		System.out.println();
		System.out.println("Del at Pos 3");
		
		head=delAtPos(head, 3);
		print(head);  

		System.out.println();
		System.out.println("Del at end");

		head=deleteAtEnd(head);
		print(head);
	}
	
	

}
