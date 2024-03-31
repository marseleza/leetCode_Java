class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {0, 0};

        for(int i = 0, j = 0; ; j++) {
            if(j == nums.length) {
                j = i;
                i += 1;
            }

            if(nums[i] + nums[j] == target && i != j) {
                res[0] = i;
                res[1] = j;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Solution test = new Solution();

        int[] res = test.twoSum(nums, target);

        System.out.printf("%d %d", res[0], res[1]);
    }
}
