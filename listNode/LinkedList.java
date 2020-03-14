//https://guides.codepath.org/compsci/Linked-Lists
//https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
//https://guides.codepath.org/compsci/Multiple-Pass
//https://guides.codepath.org/compsci/Dummy-Head

package listNode;

import java.util.Scanner;

public class LinkedList<T> {
    // instance variables
    private Node<T> head, tail;
    private int size;

    // constructor
    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    // utility methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // methods to change the list

    public void addHead(T d) {
        Node<T> n = new Node<T>(d, head);
        head = n;
        size++;
        if (tail == null)
            tail = head;
    }

    public void addTail(T d) {
        Node<T> n = new Node<T>(d, null);
        if (tail == null)
            head = tail = n;
        else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    public T removeHead() throws Exception {
        if (head == null)
            throw new Exception("Empty List");
        Node<T> n = head;
        head = head.getNext();
        if (head == null)
            tail = head;
        size--;
        return n.getData();
    }

    public void addAfter(Node<T> p, T d) {
        Node<T> n = new Node<T>(d, p.getNext());
        p.setNext(n);
        if (tail == p)
            tail = n;
        size++;
    }

    public void addBefore(Node<T> p, T d) {
        addAfter(p, p.getData());
        p.setData(d);
    }

    public T removeAfter(Node<T> p) throws Exception {
        Node<T> n = p.getNext();
        if (n == null) throw new Exception("At last node");
        p.setNext(n.getNext());
        size--;
        if (n == tail) p = tail;
        return n.getData();
    }

    public T remove(Node<T> p) throws Exception {
        T answer = p.getData();
        p.setData(removeAfter(p));
        return answer;
    }

    // LinkedList testing methods:

    public String toString() {
        String ans = "";
        Node<T> n = head;
        ans += "(H)-->";
        while (n != null) {
            ans += n.getData();
            ans += "-->";
            n = n.getNext();
        }
        return ans + "(T)";
    }

    public static void main(String args[]) {
        LinkedList<String> l = new LinkedList<String>();
        Node<String> position = null;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println(print(l, position) + "  :cmds are (add) H T A B (rem) h a p (position selection) 0 + (quit) Q: ");
            String cmd = s.next();
            if (cmd.charAt(0) == 'Q')
                break;
            else if (cmd.charAt(0) == '0') position = l.head;
            else if (cmd.charAt(0) == '+' && position != null) position = position.getNext();
            else if (cmd.charAt(0) == 'h' || cmd.charAt(0) == 'a' || cmd.charAt(0) == 'p')
                try {
                    if (cmd.charAt(0) == 'h') l.removeHead();
                    else if (position != null) {
                        try {
                            if (cmd.charAt(0) == 'a') l.removeAfter(position);
                            if (cmd.charAt(0) == 'p') l.remove(position);
                        } catch (Exception eek) {}
                    }
                } catch (Exception e) {
                    System.out
                            .println("Remove failed.  List was already empty!");
                }
            else {
                String entry = s.next();
                if (cmd.charAt(0) == 'H')
                    l.addHead(entry);
                if (cmd.charAt(0) == 'T')
                    l.addTail(entry);
                if (cmd.charAt(0) == 'A' && position != null)
                    l.addAfter(position, entry);
                if (cmd.charAt(0) == 'B' && position != null)
                    l.addBefore(position, entry);
            }
        }
        s.close();
    }

    private static <T> String print(LinkedList<T> l, Node<String> position) {
        String ans = "";
        Node<T> n = l.head;
        ans += "(H)-->";
        while (n != null) {
            if (n == position) ans +="(P)>";
            ans += n.getData();
            ans += "-->";
            n = n.getNext();
        }
        return ans + "(T)";
    }
}