public class linked{

    class Node { 
        int val; 
        Node next; 
        Node(int d) {
            val = d; next = null; 
        } 
    }
    public static int size=0;
    public static Node head = null;
    public static Node tail = null; 
    
    public static void main(String[] args){
        linked l1 = new linked();
        l1.insert(1);
        l1.insert(2);
        l1.insert(42);
        l1.insert(423);
        l1.insert(4206);
        System.out.println("Original List:");
        l1.display();
        l1.insertafter(9, 4206);
        l1.insertbefore(0, 423);
        l1.display();
    }


    public void insert(int val) {
        Node ne = new Node(val);
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
    public void insertafter(int val, int pos) {
        Node ptr = head;
        while (ptr.val!=pos){
            ptr = ptr.next;
        }
        if (ptr==head){
            System.out.println("Target Not Found");
            return;
        }
        Node newNode = new Node(val);
        newNode.next = ptr.next;
        ptr.next = newNode;
        System.out.println("After adding");
    }
    public void insertbefore(int val, int pos) {
        Node ptr = head;
        Node pptr = ptr;
        while (ptr.val!=pos){
            pptr = ptr;
            ptr = ptr.next;
        }
        if (ptr==head){
            System.out.println("Target Not Found");
            return;
        }
        Node newNode = new Node(val);
        newNode.next = pptr.next;
        pptr.next = newNode;
        System.out.println("Added " + val + " before " + pos);
    }
    public void display() {  
        Node curr = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }
        while(curr != null) {  
            System.out.print(curr.val + " ");  
            curr = curr.next;  
        }  
        System.out.println();  
    }  
}