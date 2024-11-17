//At curr idx abs(leftSum[curr]-rightSum[curr])<=1 then all element of array converted in zero
// b/c at particural idx for the dir. left or right it reduce 1 so both side has equal or one more sum

class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int leftSum[] = new int[n];
        leftSum[0] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        int rightSum[] = new int[n];
        rightSum[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (leftSum[i] == rightSum[i])
                    cnt += 2;
                else if (Math.abs(leftSum[i] - rightSum[i]) == 1)
                    cnt += 1;
            }
        }
        return cnt;
    }
}