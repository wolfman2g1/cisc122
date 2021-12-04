
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.InputMismatchException;

import java.util.Scanner;

/**
 * The LinkedList1 class implements a Linked list.
 */

class LinkedList1 {
    /**
     * The Node class stores a list element
     * and a reference to the next node.
     */

    private class Node {
        String value;
        Node next;

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         * @param n   The reference to the successor node.
         */

        Node(String val, Node n) {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */

        Node(String val) {
            // Call the other (sister) constructor.
            this(val, null);
        }
    }

    private Node first;  // list head
    private Node last;   // last element in list

    /**
     * Constructor.
     */

    public LinkedList1() {
        first = null;
        last = null;
    }

    /**
     * The isEmpty method checks to see
     * if the list is empty.
     *
     * @return true if list is empty,
     * false otherwise.
     */

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * The size method returns the length of the list.
     *
     * @return The number of elements in the list.
     */

    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
            // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * The add method adds an element to
     * the end of the list.
     *
     * @param e The value to add to the
     *          end of the list.
     */

    public void add(String e) {
        if (isEmpty()) {
            first = new Node(e);
            last = first;
        } else {
            // Add to end of existing list
            last.next = new Node(e);
            last = last.next;
        }
    }

    /**
     * The add method adds an element at a position.
     *
     * @param e     The element to add to the list.
     * @param index The position at which to add
     *              the element.
     * @throws IndexOutOfBoundsException When
     *                                   index is out of bounds.
     */

    public void add(int index, String e) {
        if (index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Index is at least 0
        if (index == 0) {
            // New element goes at beginning
            first = new Node(e, first);
            if (last == null)
                last = first;
            return;
        }

        // Set a reference pred to point to the node that
        // will be the predecessor of the new node
        Node pred = first;
        for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;
        }

        // Splice in a node containing the new element
        pred.next = new Node(e, pred.next);

        // Is there a new last element ?
        if (pred.next.next == null)
            last = pred.next;
    }

    /**
     * The toString method computes the string
     * representation of the list.
     *
     * @return The string form of the list.
     */

    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        // Use p to walk down the linked list
        Node p = first;
        while (p != null) {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }

    /**
     * The remove method removes the element at an index.
     *
     * @param index The index of the element to remove.
     * @return The element removed.
     * @throws IndexOutOfBoundsException When index is
     *                                   out of bounds.
     */

    public String remove(int index) {
        if (index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        String element;  // The element to return
        if (index == 0) {
            // Removal of first item in the list
            element = first.value;
            first = first.next;
            if (first == null)
                last = null;
        } else {
            // To remove an element other than the first,
            // find the predecessor of the element to
            // be removed.
            Node pred = first;

            // Move pred forward index - 1 times
            for (int k = 1; k <= index - 1; k++)
                pred = pred.next;

            // Store the value to return
            element = pred.next.value;

            // Route link around the node to be removed
            pred.next = pred.next.next;

            // Check if pred is now last
            if (pred.next == null)
                last = pred;
        }
        return element;
    }

    /**
     * The remove method removes an element.
     *
     * @param element The element to remove.
     * @return true if the remove succeeded,
     * false otherwise.
     */

    public boolean remove(String element) {
        if (isEmpty())
            return false;

        if (element.equals(first.value)) {
            // Removal of first item in the list
            first = first.next;
            if (first == null)
                last = null;
            return true;
        }

        // Find the predecessor of the element to remove
        Node pred = first;
        while (pred.next != null &&
                !pred.next.value.equals(element)) {
            pred = pred.next;
        }

        // pred.next == null OR pred.next.value is element
        if (pred.next == null)
            return false;

        // pred.next.value  is element
        pred.next = pred.next.next;

        // Check if pred is now last
        if (pred.next == null)
            last = pred;

        return true;
    }

    // check if the list is empty. if not use the sort method to sort in ascending order
    /*public String sort(Node node) {
        if (isEmpty()) {
            return null;
        } else {
            Node current = first, index = null;
            int temp;
            if(first == null){
                return null;
            }
            else {
                while(current != null){
                    index = current.next;
                    while (index != null){
                        if(current.value > index.value)
                    }
                }
            }

        }


    }*/

    // check if list is empty if it's not reverse the order
    public String reverse(Node node) {
        if (isEmpty()) {
            return null;

        } else {
            Node back = null;
            Node current = node;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = back;
                back = current;
                current = next;
            }
            node = back;
            return node.toString();
        }
    }

    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1(); // new linked list

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter path to file\n");
            if (input.hasNext()) {
                String file = input.nextLine();
                Scanner sc = new Scanner(new BufferedReader(new FileReader(file))); // open file

                while (sc.hasNext()) {
                    String name = sc.next();
                    list.add(name); // add all lines to the list
                }
            } else {
                throw new IOException("You didn't provide a file path");
            }


        } catch (IOException e) {
            System.out.println("File not Found!");
            System.exit(0);
        }
        // menu
        try {
            Scanner menu = new Scanner(System.in);
            System.out.println("Select and option");
            System.out.println(
                    "1) Print \n" + "2) Remove \n" + "3) Sort\n" + "4) Reverse Sort\n"
            );
            int choice = menu.nextInt();
            switch (choice) {
                case 1:

                    System.out.println(list);
                    break;
                case 2:
                    System.out.println("Please enter a name to remove");
                    Scanner remove = new Scanner(System.in);
                    list.remove(remove.next());
                    System.out.println("Complete \n" + list);
                    break;
                //case 3:
                //    list.sort( list );
                //    break;
                case 4:
                    list.reverse( list.last);
                    System.out.println("Complete \n" + list);
                    break;
                default:
                    System.out.println("Invalid Selection");


            }
        } catch (InputMismatchException e) {
            System.out.println("You didn't enter a number " + e.getMessage());
        }
    }
}