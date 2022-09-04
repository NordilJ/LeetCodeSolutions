import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode node1 = new ListNode(5);
        node1 = new ListNode(4, node1);
        node1 = new ListNode(3, node1);
        node1 = new ListNode(2, node1);
        node1 = new ListNode(1, node1);
        ListNode node2 = new ListNode(3);
        node2 = new ListNode(2, node2);
        node2 = new ListNode(1, node2);

        Solution solution = new Solution();
        solution.mergeTwoLists(node1, node2);
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = null;

        List<Integer> values = new ArrayList<>();

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                values.add(list2.val);
                list2 = list2.next;
            } else if (list2 == null || list2.val > list1.val) {
                values.add(list1.val);
                list1 = list1.next;
            } else {
                values.add(list2.val);
                list2 = list2.next;
            }
        }

        for (int i = values.size() - 1; i >= 0; i--) {
            result = new ListNode(values.get(i), result);
        }

        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
