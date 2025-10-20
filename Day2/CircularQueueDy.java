import java.util.Scanner;

class CircularQueueDy {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueueDy(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        // Check if queue is full
        if (size == capacity) {
            System.out.println("Queue is full, resizing...");
            resize();
        }

        rear = (rear + 1) % capacity;
        queue[rear] = data;

        if (front == -1) front = 0;
        size++;
        System.out.println(data + " inserted.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newQueue = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }

        queue = newQueue;
        capacity = newCapacity;
        front = 0;
        rear = size - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueueDy cq = new CircularQueueDy(3);
        int choice, data;

        do {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    cq.enqueue(data);
                    break;
                case 2:
                    data = cq.dequeue();
                    if (data != -1)
                        System.out.println("Deleted: " + data);
                    break;
                case 3:
                    cq.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}
