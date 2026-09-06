public class Patient {
    public int patientId;
    public String name, contact, medicalCondition;
    public int age;
    
    // BST සඳහා Left/Right Pointers
    public Patient left, right;
    
    // Patient ගේ Visit History (Linked List)
    public VisitLinkedList visitHistory;

    public Patient(int patientId, String name, int age, String contact, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Condition: " + medicalCondition;
    }
}