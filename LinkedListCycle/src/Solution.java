import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
    }

    public static boolean hasCycleOn(ListNode head){ // O(n) space because it allocates more memory while iterating, O(n) time complexity
        int pos = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        while (head != null){
            if (hashMap.get(head.val) != null) {
                return true;
            }

            hashMap.put(head.val, pos++);
            head = head.next;
        }

        return false;
    }

    public static boolean hasCycleO1(ListNode head){ // O(1) space because the pointers use a fixed amount of memory and O(n) time complexity
        if (head == null){
            return false;
        }

        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null){
            if (fast.next == null){
                return false;
            }
            if (fast == slow){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

}
