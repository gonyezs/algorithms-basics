package traverse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalBreadthDepth {

    public static void main(String args[]) {

        Node tree = buildTree();

        // Breadth first search

        System.out.println("***  Breadth First search *** ");

        Queue queue = new LinkedList() {{
            offer(tree);
        }};

        breadthFirstSearch(queue);

        // Depth first search

        System.out.println("***  Depth First search *** ");

        Stack stack = new Stack() {{
            push(tree);
        }};

        depthFirstSearch(stack);
    }

    /**
     * Recursively traverse the tree with a stack of nodes (LIFO)
     *
     * @param stack
     */
    public static void depthFirstSearch(Stack stack) {

        if (stack.isEmpty()) return;

        Node node = (Node) stack.pop();

        System.out.println("Popping node: " + node);

        if (node.right != null) stack.push(node.right);

        if (node.left != null) stack.push(node.left);

        depthFirstSearch(stack);
    }

    /**
     * Recursively traverse the tree with a queue of nodes (LIFO)
     *
     * @param queue
     */
    public static void breadthFirstSearch(Queue queue) {

        if (queue.isEmpty()) return;

        Node node = (Node) queue.poll();

        System.out.println("Polling node: " + node);

        if (node.right != null) queue.offer(node.right);

        if (node.left != null) queue.offer(node.left);

        breadthFirstSearch(queue);
    }

    static Node buildTree() {

        final Node nodeA = new Node("A");

        Node nodeB = new Node("B");

        Node nodeC = new Node("C");

        Node nodeD = new Node("D");

        Node nodeE = new Node("E");

        Node nodeF = new Node("F");

        Node nodeG = new Node("G");

        nodeD.left = nodeE;

        nodeB.left = nodeC;

        nodeB.right = nodeD;

        nodeF.right = nodeG;

        nodeA.left = nodeB;

        nodeA.right = nodeF;

        return nodeA;
    }
}

class Node {

    Node right;

    Node left;

    String value;

    Node(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}