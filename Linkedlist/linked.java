public class linked{
    class Node { 
        int data; 
        Node next; 
        Node(int d) {data = d; next = null; } 
    }
    public int size=0;
    public Node head = null;
    public Node tail = null; 
    
    public static void main(String[] args){
        linked mi = new linked();
        mi.addn(1);
        mi.addn(2);
        mi.addn(3);
        mi.addn(4);
        mi.addn(42);
        mi.addn(423);
        mi.addn(4206);
        mi.addn(9);
        System.out.println("Original List:");
        mi.display();
        mi.insertafter(4206, 9);
        mi.insertbefore(9, 6);
    }


    public void addn(int data) {
        Node ne = new Node(data);
        if (head == null){
            head = ne;
            tail = ne;
        }
        else {
            tail.next = ne;
            tail = ne;
        }
        size++;
    }
    public void insertafter(int data, int target) {
        Node ptr = head;
        while (ptr.data!=target){
            ptr = ptr.next;
        }
        if (ptr==head){
            System.out.println("Target Not Found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = ptr.next;
        ptr.next = newNode;
        System.out.println("Added " + data + " after " + target);
        display();
    }
    public void insertbefore(int data, int target) {
        Node ptr = head;
        Node pptr = ptr;
        while (ptr.data!=target){
            pptr = ptr;
            ptr = ptr.next;
        }
        if (ptr==head){
            System.out.println("Target Not Found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = pptr.next;
        pptr.next = newNode;
        System.out.println("Added " + data + " before " + target);
        display();
    }
    public void display() {  
        Node curr = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }
        while(curr != null) {  
            System.out.print(curr.data + " ");  
            curr = curr.next;  
        }  
        System.out.println();  
    }  
}