package org.dsa.trees;

import org.dsa.util.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BurnBinaryTreeTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("1,5,3,null,4,10,6,9,2", 3, 4),
                Arguments.of("1,2,3,null,4,null,5", 2, 3),
                Arguments.of("1", 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void amountOfTimeReturnsCorrectTime(String treeStructure, int start, int expectedTime) {
        TreeNode root = buildTree(treeStructure);
        BurnBinaryTree burnBinaryTree = new BurnBinaryTree();
        assertEquals(expectedTime, burnBinaryTree.amountOfTime(root, start));
    }

    private TreeNode buildTree(String treeStructure) {
        if (treeStructure == null || treeStructure.isEmpty()) {
            return null;
        }

        String[] nodes = treeStructure.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nodes.length) {
            TreeNode current = queue.poll();
            if (!nodes[i].equals("null")) {
                assert current != null;
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("null")) {
                assert current != null;
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}