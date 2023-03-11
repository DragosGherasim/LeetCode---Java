public class Solution {
    public static void main(String[] args){

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode mergeList = new ListNode(1, null);
        ListNode listHead = mergeList;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                mergeList.next = list1;
                list1 = list1.next;
            }
            else{
                mergeList.next = list2;
                list2 = list2.next;
            }

            mergeList = mergeList.next;
        }

        if (mergeList.next == list1 && list1 == null){
            mergeList.next = list2;
        }
        else{
            mergeList.next = list1;
        }

        return listHead.next;
    }
}
