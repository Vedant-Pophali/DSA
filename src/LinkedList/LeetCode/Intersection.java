package LinkedList.LeetCode;

public class Intersection {
     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int m = findLength(headA);
            int n = findLength(headB);

            ListNode fp=headA,sp=headB;

            if(m<n){
                for(int i=0;i<n-m;i++){
                    sp=sp.next;
                }
            }
            else if(n<m){
                for(int i=0;i<m-n;i++)
                    fp=fp.next;
            }
            return findSameNode(fp,sp);
        }
        private int findLength(ListNode head){
            ListNode curr = head;
            int len=0;
            while(curr!=null){
                len++;
                curr=curr.next;
            }
            return len;
        }
        private ListNode findSameNode(ListNode fp,ListNode sp){
            while(fp!=null && sp!=null){
                if(fp==sp){
                    return fp;
                }
                else{
                    fp=fp.next;
                    sp=sp.next;
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        Intersection obj = new Intersection();
        Solution solution = new Solution();

        // Creating sample linked lists with intersection
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(9);
        headA.next.next.next = common;

        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);
        headB.next.next = common;

        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println("Intersection at node with value: " +
                (intersectionNode != null ? intersectionNode.val : "No Intersection"));
    }

}
