public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int targetIndex = getTargetIndex(head, n);

        var removedNode = removeNth(head, targetIndex);

        return getHeadNode(head, removedNode);
    }

    private ListNode getHeadNode(ListNode head, ListNode removedNode) {
        return removedNode != head ? head : head.next;
    }

    private int getTargetIndex(ListNode head, int n) {
        var size = 0;
        var currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }

        return size - n;
    }

    private ListNode removeNth(ListNode head, int n) {
        if (n == 0) return head;

        var preNode = head;
        for (int i = 1; i < n; i++) {
            preNode = preNode.next;
        }

        return removeByPrevNode(preNode);
    }

    private ListNode removeByPrevNode(ListNode prevNode) {
        var removeNode = prevNode.next;
        prevNode.next = removeNode != null ? removeNode.next : null;

        return removeNode;
    }
}
