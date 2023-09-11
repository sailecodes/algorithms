package bst;

/**
 * Description: An implementation of a binary search tree that does not allow duplicates.
 * */
public class MyBST {
    /**
     * Inner class representing a node in the tree
     * */
    public class MyNode {
        private final int element;
        private MyNode parent;
        private MyNode left;
        private MyNode right;

        public MyNode(int element) {
            this.element = element;
        }
    }

    /** Instance variables */
    private MyNode root;
    private int size;

    public MyBST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Inserts the element into the tree
     *
     * @param element The element to insert
     * @return true if the element was inserted, false otherwise
     * */
    public boolean insert(int element) {
        if (contains(element)) { return false; }

        this.size++;

        if (root == null) {
            this.root = new MyNode(element);
            return true;
        } else {
            return insertHelper(element, this.root);
        }
    }

    private boolean insertHelper(int element, MyNode currNode) {
        if (element < currNode.element) {
            if (currNode.left == null) {
                MyNode newNode = new MyNode(element);
                currNode.left = newNode;
                newNode.parent = currNode;

                return true;
            }

            return insertHelper(element, currNode.left);
        } else if (element > currNode.element) {
            if (currNode.right == null) {
                MyNode newNode = new MyNode(element);
                currNode.right = newNode;
                newNode.parent = currNode;

                return true;
            }

            return insertHelper(element, currNode.right);
        }

        return false;
    }

    public boolean contains(int element) { return false; }


}
