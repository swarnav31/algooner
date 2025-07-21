package org.dsa.trees;

import org.dsa.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode 2385. Amount of Time for Binary Tree to Be Infected/Burned (Medium)
 */
public class BurnBinaryTree {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, TreeNode> pMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        pMap.put(root.val, null);
        q.add(root);
        TreeNode sNode = null;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                assert node != null;
                if (node.val == start) {
                    sNode = node;
                }
                if (node.left != null) {
                    pMap.put(node.left.val, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    pMap.put(node.right.val, node);
                    q.add(node.right);
                }
            }
        }

        Set<Integer> vis = new HashSet<>();
        assert sNode != null;
        vis.add(sNode.val);
        int time = -1;
        q.add(sNode);
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null && !vis.contains(node.left.val)) {
                    q.add(node.left);
                    vis.add(node.left.val);
                }
                if (node.right != null && !vis.contains(node.right.val)) {
                    q.add(node.right);
                    vis.add(node.right.val);
                }
                TreeNode parent = pMap.get(node.val);
                if (parent != null && !vis.contains(parent.val)) {
                    q.add(parent);
                    vis.add(parent.val);
                }
            }
        }
        return time;
    }
}
