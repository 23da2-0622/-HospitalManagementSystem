class VisitNode {
    Visit data;
    VisitNode next;
    VisitNode(Visit d) { 
        data = d; 
        next = null; 
    }
}

public class VisitLinkedList {
    private VisitNode head;

    // Add visit
    public void addVisit(Visit v) {
        VisitNode newNode = new VisitNode(v);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode temp = head;
            while (temp.next != null) 
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Visit added successfully.");
    }

    // Remove visit
    public void removeVisit(String visitId) {
        if (head == null) {
            System.out.println("No history available.");
            return;
        }
        if (head.data.visitId.equals(visitId)) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }
        VisitNode curr = head, prev = null;
        while (curr != null && !curr.data.visitId.equals(visitId)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
            System.out.println("Visit removed successfully.");
        } else {
            System.out.println("Visit ID not found.");
        }
    }

    // Search visit
    public void searchVisit(String visitId) {
        VisitNode temp = head;
        while (temp != null) {
            if (temp.data.visitId.equals(visitId)) {
                System.out.println("Found: " + temp.data);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Visit ID not found.");
    }

    // Display history
    public void display() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        VisitNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}