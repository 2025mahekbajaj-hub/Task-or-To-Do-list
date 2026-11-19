import java.util.Scanner;

class Node {
    int id;
    String task;
    String priority;
    boolean completed;
    Node next;

    Node(int id, String task, String priority) {
        this.id = id;
        this.task = task;
        this.priority = priority;
        this.completed = false;
        this.next = null;
    }
}

class TaskList {
    Node head = null;
    int count = 1;

    // Add Task
    void addTask(String task, String priority) {
        Node newNode = new Node(count++, task, priority);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Task Added Successfully!");
    }

    // Display Tasks
    void display() {
        if (head == null) {
            System.out.println("No Tasks Available!");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.println("\nTask ID: " + temp.id);
            System.out.println("Task: " + temp.task);
            System.out.println("Priority: " + temp.priority);
            System.out.println("Status: " +
                    (temp.completed ? "Completed" : "Pending"));

            temp = temp.next;
        }
    }

    // Search Task
    void search(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Task Found: " + temp.task);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found!");
    }

    // Mark Task Completed
    void complete(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.completed = true;
                System.out.println("Task Completed!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found!");
    }

    // Delete Task
    void delete(int id) {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Task Deleted!");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.id == id) {
                temp.next = temp.next.next;
                System.out.println("Task Deleted!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found!");
    }
}

public class TaskTrackerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskList list = new TaskList();

        int choice;

        do {
            System.out.println("\n===== TASK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Complete Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Task: ");
                    String task = sc.nextLine();

                    System.out.print("Enter Priority: ");
                    String priority = sc.nextLine();

                    list.addTask(task, priority);
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.print("Enter Task ID: ");
                    int searchId = sc.nextInt();

                    list.search(searchId);
                    break;

                case 4:
                    System.out.print("Enter Task ID: ");
                    int completeId = sc.nextInt();

                    list.complete(completeId);
                    break;

                case 5:
                    System.out.print("Enter Task ID: ");
                    int deleteId = sc.nextInt();

                    list.delete(deleteId);
                    break;

                case 6:
                    System.out.println("Thank You! Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
