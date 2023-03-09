public class Solution {
    public static void main(String[] args){
        ListNode head = null;

        int[] arr = {3, 2, 1};

        head = createList(head, arr);

        printList(head);

        System.out.println();

        // head = reverseList1(head);
        // head = reverseList2(head);
        head = reverseList3(head);

        printList(head);
    }

    private static ListNode createList(ListNode head, int[] arr){
        if (head == null){
            head = new ListNode(arr[0]);
        }

        for(int i=1; i < arr.length; ++i){
            ListNode new_node = new ListNode(arr[i], null);

            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }

            temp.next = new_node;
        }

        return head;
    }

    private static void printList(ListNode head){
        if (head == null)
            return;

        System.out.print(head.val + " ");
        printList(head.next);
    }
    private static ListNode reverseList1(ListNode head){ // my first attempt O(N*logN)
        ListNode tempHead = head, tail;

        while (tempHead.next != null){
            tempHead = tempHead.next;
        }

        tail = tempHead;
        tempHead = head;

        while (tempHead != tail){
            int tempVal = tempHead.val;
            tempHead.val = tail.val;
            tail.val = tempVal;

            ListNode temp = tempHead;
            while (temp.next != tail){
                temp = temp.next;
            }

            tail = temp;
            tempHead = tempHead.next;
        }

        return head;
    }

    private static ListNode reverseList2(ListNode head){ // O(n)
        ListNode prevNode = null, tempHead = head;

        while(tempHead != null){
            ListNode tempNextHead = tempHead.next;
            tempHead.next = prevNode;
            prevNode = tempHead;
            tempHead = tempNextHead;
        }

        return prevNode;
    }

    private static ListNode reverseList3(ListNode head){ // recursive
        if (head == null)
            return head;

        if (head.next == null)
            return head;

        ListNode newHead = reverseList3(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
