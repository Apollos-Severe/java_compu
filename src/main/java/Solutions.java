// public class Solutions {

// /************* Array Chapter Easy ************/

// // 1.
// public void rotate(int[] nums, int k) {
// k = k % nums.length;

// // Reverse the whole thing frist
// reverse(nums, 0, nums.length - 1);

// reverse(nums, 0, k - 1);
// reverse(nums, k, nums.length - 1);
// }

// public void reverse(int[] nums, int start, int end) {
// while (start < end) {
// int temp = nums[start];

// nums[start] = nums[end];
// nums[end] = temp;

// start++;
// end--;
// }
// }

// }
