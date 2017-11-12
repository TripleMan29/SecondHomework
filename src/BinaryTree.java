import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

// Attention: comparable supported but comparator is not
@SuppressWarnings("WeakerAccess")
public class BinaryTree<T extends Comparable<T>> extends AbstractSet<T> implements SortedSet<T> {

    private static class Node<T> {
        final T value;

        Node<T> left = null;

        Node<T> right = null;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> root = null;

    private int size = 0;

    @Override
    public boolean add(T t) {
        Node<T> closest = find(t);
        int comparison = closest == null ? -1 : t.compareTo(closest.value);
        if (comparison == 0) {
            return false;
        }
        Node<T> newNode = new Node<>(t);
        if (closest == null) {
            root = newNode;
        } else if (comparison < 0) {
            assert closest.left == null;
            closest.left = newNode;
        } else {
            assert closest.right == null;
            closest.right = newNode;
        }
        size++;
        return true;
    }

    boolean checkInvariant() {
        return root == null || checkInvariant(root);
    }

    private boolean checkInvariant(Node<T> node) {
        Node<T> left = node.left;
        if (left != null && (left.value.compareTo(node.value) >= 0 || !checkInvariant(left))) return false;
        Node<T> right = node.right;
        return right == null || right.value.compareTo(node.value) > 0 && checkInvariant(right);
    }

  /*  private Node<T> findForRemove(T value) {
        if (root == null) return null;
        return findForRemove(root, value);
    }

    private Node<T> findForRemove(Node<T> start, T value) {
        int comparison = value.compareTo(start.value);
        if (comparison == 0) {
            return start;
        }
        else if (comparison < 0) {
            if (start.left == null) return start;
            return findForRemove(start.left, value);
        }
        else {
            if (start.right == null) return start;
            return find(start.right, value);
        }
    }*/

    @Override
    public boolean remove(Object o) {
        T value = (T) o;
        if (contains(o)) {
            if (root.value.compareTo(value) == 0) {
                if (root.left == null && root.right == null) root = null;
                else if (root.left != null && root.right == null) root = root.left;
                else if (root.left == null && root.right != null) root = root.right;
                else removeNode(value, root, root);
            } else removeNode(value, root, root);
            size--;
            return true;
        }
        return false;
    }

    public void removeNode(T value, Node<T> n, Node<T> parent) {
        int comparison = n.value.compareTo(value);
        if (comparison != 0) {
            if (comparison > 0) removeNode(value, n.left, n);
            else removeNode(value, n.right, n);
        } else {
            if (n.left == null && n.right == null) {
                if (n == parent.right) parent.right = null;
                else parent.left = null;
            } else if (n.left != null && n.right == null) {
                if (n == parent.right) parent.right = n.left;
                else parent.left = n.left;
            } else if (n.left == null) {
                if (n == parent.right) parent.right = n.right;
                else parent.left = n.right;
            } else {
                if (n.right.left == null) {
                    if (n == root) root = n.right;
                    else if (n == parent.right) parent.right = n.right;
                    else parent.left = n.right;
                    n.right.left = n.left;
                    n.right = n.right.right;
                } else {
                    Node<T> m = n.right;
                    while (m.left != null) m = m.left;
                    if (parent == n) m.left = n.left;
                    else m.left = n.left;

                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bb = new BinaryTree();
        int b = 1;
        bb.add(250);
        bb.add(329);
        bb.add(90);
        bb.add(252);
        bb.add(100);
        bb.add(85);
        bb.add(73);
        bb.add(200);
        bb.add(101);
        bb.add(1);
        bb.add(62);
        bb.remove(b);
        System.out.println(bb.contains(b));
    }

    @Override
    public boolean contains(Object o) {
        @SuppressWarnings("unchecked")
        T t = (T) o;
        Node<T> closest = find(t);
        return closest != null && t.compareTo(closest.value) == 0;
    }

    private Node<T> find(T value) {
        if (root == null) return null;
        return find(root, value);
    }

    private Node<T> find(Node<T> start, T value) {
        int comparison = value.compareTo(start.value);
        if (comparison == 0) {
            return start;
        } else if (comparison < 0) {
            if (start.left == null) return start;
            return find(start.left, value);
        } else {
            if (start.right == null) return start;
            return find(start.right, value);
        }
    }

    public class BinaryTreeIterator implements Iterator<T> {
        private Node<T> current = null;
        private int count = 0;
        private int poof = size;

        private BinaryTreeIterator() {
        }

        private void findNext() {
            if (root != null) iter(root);
        }

        private void iter(Node<T> n) {
            if (n.left != null) iter(n.left);
            if (n.right != null) iter(n.right);
            count++;
            if (count == poof) {
                poof--;
                count = 0;
                current = n;
            }

        }

        @Override
        public boolean hasNext() {
            return poof > 0;
        }

        @Override
        public T next() {
            findNext();
            if (current == null) throw new NoSuchElementException();
            return current.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator();
    }

    @Override
    public int size() {
        return size;
    }


    @Nullable
    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @NotNull
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public SortedSet<T> headSet(T toElement) {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T first() {
        if (root == null) throw new NoSuchElementException();
        Node<T> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    @Override
    public T last() {
        if (root == null) throw new NoSuchElementException();
        Node<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
}