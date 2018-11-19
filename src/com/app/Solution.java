package com.app;

// https://leetcode.com/submissions/detail/190469342/
class Solution {

    public int kthSmallest(TreeNode root, int k) {
        NodeWithCount rootWithCount = createNodesWithCount(root);
        return kthSmallest(rootWithCount, k);
    }

    private Integer kthSmallest(NodeWithCount rootWithCount, int k) {
        if (rootWithCount.left != null) {
            if (k == rootWithCount.left.count + 1) {
                return rootWithCount.val;
            } else if (k < rootWithCount.left.count + 1) {
                return kthSmallest(rootWithCount.left, k);
            } else {
                return kthSmallest(rootWithCount.right, k - rootWithCount.left.count - 1);
            }
        } else if (rootWithCount.right != null) {
            if (k == 1) {
                return rootWithCount.val;
            } else {
                return kthSmallest(rootWithCount.right, k - 1);
            }
        } else {
            return (k == 1) ? rootWithCount.val : null;
        }
    }

    private NodeWithCount createNodesWithCount(TreeNode root) {
        if (root == null) {
            return null;
        }
        NodeWithCount nodeWithCount = new NodeWithCount(root.val);
        nodeWithCount.left = createNodesWithCount(root.left);
        nodeWithCount.right = createNodesWithCount(root.right);
        if (nodeWithCount.left != null) {
            nodeWithCount.count += nodeWithCount.left.count;
        }
        if (nodeWithCount.right != null) {
            nodeWithCount.count += nodeWithCount.right.count;
        }
        return nodeWithCount;
    }

    static class NodeWithCount {

        NodeWithCount left;
        NodeWithCount right;
        int val;
        int count = 1;

        NodeWithCount(int val) {
            this.val = val;
        }
    }
}