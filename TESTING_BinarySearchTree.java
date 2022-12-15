public class TESTING_BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.add(435, "Bill");
        bst.add(565, "Jill");
        bst.add(335, "Dill");
        bst.add(235, "Gill");
        bst.add(625, "Hill");
        System.out.println(bst.get(565));
        System.out.println(bst.get(625));

        bst.print();
        System.out.println(bst.min());
        System.out.println(bst.max());
    }
}

class BinarySearchTree <K extends Comparable<K>, V> {
    private class Node {
        public K key;
        public V value;
        public Node left = null;
        public Node right = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root = null;

    private int compare (K a, K b) {
        return a.compareTo(b);
    }

    public void add(K key, V value) {
        root = add_RECURSIVE(root, key, value);
    }

    public Node add_RECURSIVE(Node curr, K key, V value) {
        if (curr == null) {
            return new Node(key, value);
        }
        if (compare(key, curr.key) < 0) {
            curr.left = add_RECURSIVE(curr.left, key, value);
        }
        else if (compare(key, curr.key) > 0) {
            curr.right = add_RECURSIVE(curr.right, key, value);
        }
        return curr;
    }

    public V get(K key) {
        return get_RECURSIVE(root, key);
    }

    private V get_RECURSIVE(Node curr, K key) {
        if (curr == null) {
            return null;
        }
        if (compare(key, curr.key) == 0) {
            return curr.value;
        }
        if (compare(key, curr.key) < 0) {
            return get_RECURSIVE(curr.left, key);
        }
        else {
            return get_RECURSIVE(curr.right, key);
        }
    }

    public void traversePreOrder(Node root) {
        if (root != null) {
            System.out.println(" " + root.value);
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }

    public void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.println(" " + root.value);
            traverseInOrder(root.right);
        }
    }

    public void traversePostOrder(Node root) {
        if (root != null) {
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.println(" " + root.value);
        }
    }

    public void print() {
        System.out.println("PreOrder: ");
        traversePreOrder(root);
        System.out.println();
        System.out.println("InOrder: ");
        traverseInOrder(root);
        System.out.println();
        System.out.println("PostOrder: ");
        traversePostOrder(root);
        System.out.println();
    }

    public K min() { return min(root); }

    public K min(Node root) { return root.left == null ? root.key : min(root.left); }

    public K max() { return max(root); }

    public K max(Node root) { return root.right == null ? root.key : max(root.right); }

    public void delete(K key) {
        root = delete_RECURSIVE(root, key);
    }

    private Node delete_RECURSIVE(Node root, K key) {
        if (root == null) {
            return null;
        }

        if (compare(key, root.key) == 0) {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if (root.right == null) {
                return root.left;
            }
            else if (root.left == null) {
                return root.right;
            }
            else {
                Node max = maxNode(root.left);
                root.key = max.key;
                root.value = max.value;
                root.left = delete_RECURSIVE(root.left, max.key);
                return root;
            }
        }
        else {
            if (compare(key, root.key) < 0) {
                root.left = delete_RECURSIVE(root.left, key);
            }
            else {
                root.right = delete_RECURSIVE(root.right, key);
            }
            return root;
        }
    }

    private Node maxNode(Node root) {
        return root.right == null ? root: maxNode(root.right);
    }
}