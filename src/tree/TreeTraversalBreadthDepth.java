package tree;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;


public class TreeTraversalBreadthDepth {

    public static void main(String args[]) {

        final Node nodeA = buildTree();

        //Do breadth first search

        System.out.println("***  Breadth First search *** ");

        Queue queue = new LinkedList() {{
            offer(nodeA);
        }};

        breadthFirstSearch(queue);

        //Do depth first search

        System.out.println("***  Depth First search *** ");

        Stack stack = new Stack() {{
            push(nodeA);
        }};

        depthFirstSearch(stack);
    }

    //recursively traverse the tree with
    //a stack of nodes (LIFO)
    public static void depthFirstSearch(Stack stack) {

        if (stack.isEmpty()) return;

        Node node = (Node) stack.pop();

        System.out.println("popping node: " + node);

        if (node.right != null) stack.push(node.right);

        if (node.left != null) stack.push(node.left);

        depthFirstSearch(stack);
    }

    //Recursively traverse the tree with
    //a queue of nodes (FIFO)
    public static void breadthFirstSearch(Queue queue) {

        if (queue.isEmpty()) return;

        Node node = (Node) queue.poll();

        System.out.println("polling node: " + node);

        if (node.right != null) queue.offer(node.right);

        if (node.left != null) queue.offer(node.left);

        breadthFirstSearch(queue);
    }

    static Node buildTree() {
        //nodeA needs to be final to be accessed by
        //the anonymous inner classes below

        final Node nodeA = new Node("A");

        Node nodeB = new Node("B");

        Node nodeC = new Node("C");

        Node nodeD = new Node("D");

        Node nodeE = new Node("E");

        Node nodeF = new Node("F");

        Node nodeG = new Node("G");

        //build the tree

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
