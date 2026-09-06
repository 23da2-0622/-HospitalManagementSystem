public class BST {
    public Patient root;

    // Insert
    public void insert(Patient p) {
        root = insertRec(root, p);
    }
    private Patient insertRec(Patient root, Patient p) {
        if (root == null) return p;
        if (p.patientId < root.patientId)
            root.left = insertRec(root.left, p);
        else if (p.patientId > root.patientId)
            root.right = insertRec(root.right, p);
        return root;
    }

    // Search
    public Patient search(int id) {
        return searchRec(root, id);
    }
    private Patient searchRec(Patient root, int id) {
        if (root == null || root.patientId == id) return root;
        if (id < root.patientId) 
            return searchRec(root.left, id);
        return searchRec(root.right, id);
    }

    // Delete
    public void delete(int id) {
        root = deleteRec(root, id);
    }
    private Patient deleteRec(Patient root, int id) {
        if (root == null) return root;
        if (id < root.patientId) 
            root.left = deleteRec(root.left, id);
        else if (id > root.patientId) 
            root.right = deleteRec(root.right, id);
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // Node with two children: Get inorder successor (smallest in right subtree)
            Patient min = root.right;
            while (min.left != null) 
                min = min.left;
            
            // Copy data of inorder successor to this node
            root.patientId = min.patientId;
            root.name = min.name;
            root.age = min.age;
            root.contact = min.contact;
            root.medicalCondition = min.medicalCondition;
            
            // Delete the inorder successor
            root.right = deleteRec(root.right, min.patientId);
        }
        return root;
    }

    // In-order Traversal
    public void inorder() {
        inorderRec(root);
    }
    private void inorderRec(Patient root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root);
            inorderRec(root.right);
        }
    }
}