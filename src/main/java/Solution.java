
// // class Solution {
// // public TreeNode sortedArrayToBST(int[] nums) {
// // if (nums.length == 0) return null;
// // return constructTreeFromArray(nums, 0, nums.length - 1);
// // }

// // public TreeNode constructTreeFromArray(int[] nums, int left, int right) {
// // if (left > right) return null;
// // int midpoint = left + (right - left) / 2;
// // TreeNode node = new TreeNode(nums[midpoint]);
// // node.left = constructTreeFromArray(nums, left, midpoint - 1);
// // node.right = constructTreeFromArray(nums, midpoint + 1, right);

// // return node;

// // }

// class Solution {
// public boolean isSameTree(TreeNode p, TreeNode q) {
// // If we get to the end of the line:
// if (p == null && q == null)
// return true; // We made it to the end!

// // Always do the above check before the bottom check for the logic to work!!

// // If one of the sides is shorter than the other
// if (q == null || p == null)
// return false;

// // If the values do not align just return false boi!
// if (p.val != q.val)
// return false;

// return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
// }
// }

// /*
// * If you make it through the first three checks then this means that you have
// * the same value and node position on that current level of the tree. --> So,
// * now it is time to check if this is the case with all the rest - We have set
// a
// * tatytale ready to tell us what didn't work\\
// *
// * -- As soon as somthing is false it will let the parent or parent function
// * call in the call stack know that the next thing did not return true!! -->
// * Then the call above that will let its parent know that some deeper call did
// * not return ture and so on!!
// */

// class Solution {
// public ListNode removeNthFromEnd(ListNode head, int n) {
// ListNode dummy_head = new ListNode(0);
// dummy_head.next = head;

// ListNode fast = dummy_head;
// ListNode slow = dummy_head;

// for (int i = 1; i <= n + 1; i++) {
// fast = fast.next;
// }

// while (fast != null) {
// slow = slow.next;
// fast = fast.next;
// }

// slow.next = slow.next.next;

// return dummy_head.next;
// }
// }

// class Solution {
// public ListNode reverseList(ListNode head) {

// ListNode prev = null;

// while (head != null) {
// ListNode next = head.next; // 1 -> {2} ->3->4->5 || 2->{3}->4->5

// /* */
// head.next = prev; // head = 1 -> null || 2->1->null

// prev = head; // prev = 1 -> null || 2->1->null

// head = next; // 2->3->4->5 || 3->4->5
// }

// return prev;
// }
// }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
