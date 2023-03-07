public class Queue <E>{
    private ListNode <E> head;
    private ListNode <E> tail;

    private static class ListNode <E> {
        private final E value;
        private ListNode <E> next;

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public Queue() {
        this.head = this.tail = null;
    }

    public void enqueue(E value) {
        if (tail != null) {
            tail.next = new ListNode<E>(value, null);
            tail = tail.next;
        } else {
            tail = new ListNode<E>(value, null);
            head = tail;
        }
    }

    public E dequeue() {
        if(head == null){
            return null;
        }

        E currentHead = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return currentHead;
    }

    public boolean isEmpty() {
        return head == null;
    }
}


