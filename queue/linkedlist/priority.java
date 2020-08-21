public class PriorityQueue {
    static class pnode {
        int priority;
        int data;
        pnode next = null;
    }

    public static void main(String[] args){
        pnode obj = newNode(60, 1);
        obj = insert(obj, 7, 10);
        obj = insert(obj, 10, 10);
        obj = insert(obj, 5, 10);
        obj = insert(obj, 5, 10);
        obj = insert(obj, 3, 1);
        obj = insert(obj, 1, 666);
        obj = insert(obj, 3, 10);
        obj = insert(obj, 2, 69);
        obj = insert(obj, 5, 420);
        traverse(obj);
    }

    static pnode newNode(int p, int d){
        pnode obj = new pnode();
        obj.priority = p;
        obj.data = d;
        obj.next = null;
        return obj;
    }

    static pnode insert(pnode head, int p, int d)  {  
        pnode start = (head);  
        pnode temp = newNode(p, d);  
    
        if ((head).priority > p) {
            temp.next = head;  
            (head) = temp;
        }  
        else {
            while (start.next != null &&  start.next.priority < p) {  
                start = start.next;  
            }
            temp.next = start.next;
            start.next = temp;  
        }
        return head; 
    }
    static void traverse(pnode head) {
        pnode ptr = head;
        while (ptr.next!=null){
            System.out.println(ptr.priority+" "+ptr.data);
            ptr = ptr.next;
        }
    }

}