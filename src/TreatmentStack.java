import java.util.Stack;

public class TreatmentStack {
    private Stack<Patient> stack = new Stack<>();

    public void push(Patient p) {
        stack.push(p);
        System.out.println(p.name + "'s treatment completed and saved to history.");
    }

    public Patient pop() {
        if (stack.isEmpty()) {
            System.out.println("Treatment stack is empty!");
            return null;
        }
        Patient p = stack.pop();
        System.out.println("Undid treatment for: " + p.name);
        return p;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        if (stack.isEmpty()) {
            System.out.println("No treatment records yet.");
            return;
        }
        System.out.println("--- Treatment History (LIFO - Last In First Out / Recent First) ---");
        // Stack එකේ පහළ සිට ඉහළට (Recent එක පළවෙනි එක විදියට)
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }
}