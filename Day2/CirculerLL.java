class CirculerLL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private Node tail = null;

    // a) Insert at nth position
    public void insertAt(int data, int position) {
        Node newNode = new Node(data);
        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
            return;
        }

        if (position == 0) {
            newNode.next = tail.next;
            tail.next = newNode;
            return;
        }

        Node current = tail.next;
        for (int i = 0; i < position - 1 && current != tail; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        if (current == tail) tail = newNode;
    }

    // b) Delete by value
    public void deleteByValue(int value) {
        if (tail == null) return;

        Node current = tail.next;
        Node prev = tail;

        do {
            if (current.data == value) {
                if (current == tail && current == tail.next) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
    }

    // c) Modify node
    public void modifyNode(int oldValue, int newValue) {
        if (tail == null) return;

        Node current = tail.next;
        do {
            if (current.data == oldValue) {
                current.data = newValue;
                return;
            }
            current = current.next;
        } while (current != tail.next);
    }

    // d) Display
    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }

    
    public static void main(String[] args) {
        CirculerLL cll = new CirculerLL();

        cll.insertAt(10, 0);
        cll.insertAt(20, 1);
        cll.insertAt(30, 2);
        cll.insertAt(5, 0);
        System.out.print("After insertion: ");
        cll.display();

        cll.modifyNode(20, 25);
        System.out.print("After modification: ");
        cll.display();

        cll.deleteByValue(10);
        System.out.print("After deletion: ");
        cll.display();
    }
}
