import java.util.Scanner;

public class Main {
    static BST bst = new BST();
    static EmergencyQueue queue = new EmergencyQueue();
    static TreatmentStack stack = new TreatmentStack();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== HOSPITAL EMERGENCY MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient (Insert BST)");
            System.out.println("2. Search Patient (BST)");
            System.out.println("3. Delete Patient (BST)");
            System.out.println("4. Display All Patients (In-order)");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Process Next Patient (Dequeue)");
            System.out.println("7. Show Waiting Queue");
            System.out.println("8. Complete Treatment (Push to Stack)");
            System.out.println("9. Undo Last Treatment (Pop)");
            System.out.println("10. Show Treatment History");
            System.out.println("11. Add Visit to Patient History (Linked List)");
            System.out.println("12. Show Patient Visit History (Linked List)");
            System.out.println("13. Remove a Visit from History");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Medical Condition: ");
                    String condition = sc.nextLine();
                    bst.insert(new Patient(id, name, age, contact, condition));
                    System.out.println("Patient registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int sid = sc.nextInt();
                    Patient p = bst.search(sid);
                    if (p != null) 
                        System.out.println("Found: " + p);
                    else 
                        System.out.println("Patient not found.");
                    break;

                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int did = sc.nextInt();
                    bst.delete(did);
                    System.out.println("Patient deleted (if existed).");
                    break;

                case 4:
                    System.out.println("--- All Patients (Sorted by ID) ---");
                    bst.inorder();
                    break;

                case 5:
                    System.out.print("Enter Patient ID to add to queue: ");
                    int qid = sc.nextInt();
                    Patient qp = bst.search(qid);
                    if (qp != null) 
                        queue.enqueue(qp);
                    else 
                        System.out.println("Patient not found in system.");
                    break;

                case 6:
                    Patient dq = queue.dequeue();
                    if (dq != null) 
                        System.out.println("Now treating: " + dq.name);
                    break;

                case 7:
                    queue.display();
                    break;

                case 8:
                    System.out.print("Enter Patient ID to complete treatment: ");
                    int tid = sc.nextInt();
                    Patient tp = bst.search(tid);
                    if (tp != null) 
                        stack.push(tp);
                    else 
                        System.out.println("Patient not found.");
                    break;

                case 9:
                    Patient pop = stack.pop();
                    if (pop != null) 
                        System.out.println("Successfully undid treatment.");
                    break;

                case 10:
                    stack.display();
                    break;

                case 11:
                    System.out.print("Enter Patient ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    Patient hp = bst.search(pid);
                    if (hp != null) {
                        System.out.print("Enter Visit ID: ");
                        String vid = sc.nextLine();
                        System.out.print("Enter Visit Date (e.g., 2026-09-06): ");
                        String date = sc.nextLine();
                        System.out.print("Enter Doctor Name: ");
                        String doc = sc.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diag = sc.nextLine();
                        System.out.print("Enter Treatment Given: ");
                        String treat = sc.nextLine();
                        hp.visitHistory.addVisit(new Visit(vid, date, doc, diag, treat));
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 12:
                    System.out.print("Enter Patient ID: ");
                    int hpid = sc.nextInt();
                    Patient hp2 = bst.search(hpid);
                    if (hp2 != null) {
                        System.out.println("--- Visit History for " + hp2.name + " ---");
                        hp2.visitHistory.display();
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 13:
                    System.out.print("Enter Patient ID: ");
                    int rpid = sc.nextInt();
                    sc.nextLine();
                    Patient rp = bst.search(rpid);
                    if (rp != null) {
                        System.out.print("Enter Visit ID to remove: ");
                        String rvid = sc.nextLine();
                        rp.visitHistory.removeVisit(rvid);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}