class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;
    int count;

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return count;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Kosong");
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        count--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Kosong");
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue Kosong");
            return;
        }
        Node current = front;
        System.out.print("FRONT -> ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("<- REAR");
    }

    public void clear() {
        front = null;
        rear = null;
        count = 0;
    }

    public boolean contains(int value) {
        Node current = front;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

public class MainQueue {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Queue Awal ");
        q.display();

        System.out.println("Dequeue: " + q.dequeue() + "size: " + q.size());
        System.out.println("Setelah dequeue");
        q.display();
        q.enqueue(50);
        System.out.println("Setelah enqueue");
        q.display();
        System.out.println("Peek: " + q.peek());
        System.out.println("Jumlah data: " + q.size());

        System.out.println("---Pengujian jurnal Terbimbing 3 ---");
        System.out.println("Angka 60 : "+ q.contains(60));
        System.out.println("Angka 10 : " + q.contains(10));
        q.clear();
        q.display();
        
    }
}
