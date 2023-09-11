package bst;

/**
 * Description: An implementation of a binary search tree that does not allow duplicates.
 * */
public class MyBST {
    /**
     * Inner class representing a node in the tree
     * */
    public class MyNode {
        private int element;
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

    /** Constructors */
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
        this.size++;

        if (this.root == null) {
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

    /**
     * Deletes the element from the tree
     *
     * Note(s):
     *  - There are a few cases to consider:
     *      1. element is a leaf node
     *          i. Simply remove the element node
     *      2. element has one child
     *          i. Swap the values of the child and element nodes
     *      3. element has two children
     *          i. Swap the values of the minimum node in the right subtree and the element node
     *
     * @param element The element to delete
     * @return true if the element was deleted, otherwise false
     * */
    public boolean delete(int element) {
        if (this.root == null) { return false; }

        this.size--;

        return deleteHelper(element, this.root);
    }

    private boolean deleteHelper(int element, MyNode currNode) {
        if (element < currNode.element) {
            if (currNode.left == null) { return false; }

            return deleteHelper(element, currNode.left);
        } else if (element > currNode.element) {
            if (currNode.right == null) { return false; }

            return deleteHelper(element, currNode.right);
        } else {
            if (currNode.left == null && currNode.right == null) { // CASE 1
                if (currNode.parent == null) {
                    this.root = null;
                } else {
                    if (element < currNode.parent.element) { currNode.parent.left = null; }
                    else { currNode.parent.right = null; }
                }
            } else if (currNode.right == null) { // CASE 2a
                currNode.element = currNode.left.element;
                currNode.left = null;
            } else if (currNode.left == null) { // CASE 2b
                currNode.element = currNode.right.element;
                currNode.right = null;
            } else { // CASE 3
                MyNode tempNode = currNode.right;

                while (tempNode.left != null) { tempNode = tempNode.left; }

                currNode.element = tempNode.element;

                return deleteHelper(tempNode.element, tempNode);
            }

            return true;
        }
    }

    /**
     * Checks if the element is in the tree
     *
     * @param element The element to check
     * @return true if the element is in the tree, otherwise false
     * */
    public boolean contains(int element) {
        if (this.root == null) { return false; }

        return containsHelper(element, this.root);
    }

    private boolean containsHelper(int element, MyNode currNode) {
        if (element < currNode.element) {
            return containsHelper(element, currNode.left);
        } else if (element > currNode.element) {
            return containsHelper(element, currNode.right);
        } else {
            return true;
        }
    }

    /** Traversal algorithms */

    public String preorderTraversal() {
        StringBuilder ret = new StringBuilder();
        preorderTraversalHelper(this.root, ret);

        return (this.size == 0) ? ret.substring(0, ret.length()) :
                ret.substring(0, ret.length() - 1);
    }

    private void preorderTraversalHelper(MyNode currNode, StringBuilder ret) {
        if (currNode == null) { return; }

        ret.append(currNode.element).append(" ");
        preorderTraversalHelper(currNode.left, ret);
        preorderTraversalHelper(currNode.right, ret);
    }

    public String inorderTraversal() {
        StringBuilder ret = new StringBuilder();
        inorderTraversalHelper(this.root, ret);

        return (this.size == 0) ? ret.substring(0, ret.length()) :
                ret.substring(0, ret.length() - 1);
    }

    private void inorderTraversalHelper(MyNode currNode, StringBuilder ret) {
        if (currNode == null) { return; }

        inorderTraversalHelper(currNode.left, ret);
        ret.append(currNode.element).append(" ");
        inorderTraversalHelper(currNode.right, ret);
    }

    public String postorderTraversal() {
        StringBuilder ret = new StringBuilder();
        postorderTraversalHelper(this.root, ret);

        return (this.size == 0) ? ret.substring(0, ret.length()) :
                ret.substring(0, ret.length() - 1);
    }

    private void postorderTraversalHelper(MyNode currNode, StringBuilder ret) {
        if (currNode == null) { return; }

        postorderTraversalHelper(currNode.left, ret);
        postorderTraversalHelper(currNode.right, ret);
        ret.append(currNode.element).append(" ");
    }
}
