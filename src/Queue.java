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

    /**
     * FIFO queue used by the exhaustive search
     */
    public Queue() {
        this.head = this.tail = null;
    }

    /**
     * Adds a value to the end of the queue 
     * @param value value to be added to the end of the queue
     */
    public void enqueue(E value) {
        if (tail != null) {
            tail.next = new ListNode<E>(value, null);
            tail = tail.next;
        } else {
            tail = new ListNode<E>(value, null);
            head = tail;
        }
    }

    /**
     * removes the first item in the queue and returns this value
     * @return The first item in the queue 
     */
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


