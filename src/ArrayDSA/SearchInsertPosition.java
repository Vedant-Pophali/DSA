package ArrayDSA;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int size = nums.length;
        if (size == 1 && target > nums[0]) {
            index = 1;
        } else if (size == 1 && target < nums[0]) {
            index = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
            } else if (target < nums[0]) {
                index = 0;
            } else if (target > nums[size - 1]) {
                index = size;
            } else if (nums[i] < target && target < nums[i + 1]) {
                index = i + 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = obj.searchInsert(nums, target);
        System.out.println("Insert position: " + result);
    }

}