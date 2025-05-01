public class Tools {

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
    void insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    ListNode insertArray(ListNode head,int[] arr){
        ListNode newNode = head;
        for(int i=0;i<arr.length;i++){
            ListNode t = new ListNode(arr[i]);
            head.next = t;
            head = head.next;
        }
        return newNode;
    }
    void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}

