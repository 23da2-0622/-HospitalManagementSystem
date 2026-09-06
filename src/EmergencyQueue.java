import java.util.LinkedList;

public class EmergencyQueue {
    private LinkedList<Patient> queue = new LinkedList<>();

    public void enqueue(Patient p) {
        queue.addLast(p);
        System.out.println(p.name + " added to emergency queue.");
    }

    public Patient dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Patient p = queue.removeFirst();
        System.out.println(p.name + " is now being processed.");
        return p;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        if (queue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }
        System.out.println("--- Waiting Patients (FIFO - First In First Out) ---");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}