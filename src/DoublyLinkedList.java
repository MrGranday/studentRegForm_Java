public class DoublyLinkedList {
    private Node head;
    private Node tail;

   

    public class Node {
        private Student student;
        private Node previous;
        private Node next;

        public Node(Student student) {
            this.student = student;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // Doubly Linked List operations

    public void addFirst(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
    }

    public void addLast(Student student) {
        Node newNode = new Node(student);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void addAtPosition(Student student, int position) {
        if (position <= 0) {
            addFirst(student);
        } else if (position >= getSize()) {
            addLast(student);
        } else {
            Node newNode = new Node(student);
            Node current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            current.getNext().setPrevious(newNode);
            current.setNext(newNode);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            } else {
                head.setPrevious(null);
            }
        }
    }

    public void removeLast() {
        if (tail != null) {
            tail = tail.getPrevious();
            if (tail == null) {
                head = null;
            } else {
                tail.setNext(null);
            }
        }
    }

    public void removeAtPosition(int position) {
        if (position <= 0) {
            removeFirst();
        } else if (position >= getSize() - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            current.getNext().getNext().setPrevious(current);
            current.setNext(current.getNext().getNext());
        }
    }

    public int getSize() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
