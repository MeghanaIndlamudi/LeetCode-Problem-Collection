/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode deven = new ListNode(-1);
        ListNode dodd = new ListNode(-1);
        ListNode even = deven;
        ListNode odd = dodd;
        int c=0;
        while(temp!=null) {
            if(c%2==0) {
                ListNode newnode = new ListNode(temp.val);
                even.next = newnode;
                even = even.next;
            }
            else{
                ListNode newnode = new ListNode(temp.val);
                odd.next = newnode;
                odd = odd.next;
            }
            if(temp!=null) {
                temp=temp.next;
                c++;
            }
        }
        even.next = dodd.next;
        return deven.next;
    }
}