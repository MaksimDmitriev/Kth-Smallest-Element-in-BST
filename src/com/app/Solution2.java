package com.app;

public class Solution2 {

    public int kthSmallest(TreeNode root, int k) {
        ResultWrapper resultWrapper = new ResultWrapper();
        kthSmallest(root, k, resultWrapper);
        return resultWrapper.val;
    }

    public void kthSmallest(TreeNode root, int k, ResultWrapper resultWrapper) {
        if (root == null) {
            return;
        }
        kthSmallest(root.left, k, resultWrapper);
        if (k == resultWrapper.index) {
            resultWrapper.val = root.val;
            resultWrapper.index = -1;
            return;
        } else if (resultWrapper.index == -1) {
            return;
        }
        resultWrapper.index++;
        kthSmallest(root.right, k, resultWrapper);
    }

    private static class ResultWrapper {
        int val;
        int index = 1;
    }
}
