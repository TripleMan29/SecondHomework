import java.util.Iterator;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeIteratorTest {
    private List<Integer> list;
    private List<Integer> list1;
    private BinaryTree<Integer> binaryTree;
    private Iterator<Integer> binaryTreeIterator;

    BinaryTreeIteratorTest() {
        binaryTree = new BinaryTree<>();
        list = Arrays.asList(50, 30, 150, 250, 100, 223, 63, 1, 366);
        list1 = new ArrayList<>();
        binaryTree.addAll(list);
        list.sort(Integer::compareTo);
        binaryTreeIterator = binaryTree.iterator();

    }

    @Test
    void hasNext() {
        assertFalse(new BinaryTree<Integer>().iterator().hasNext());
        assertTrue(binaryTreeIterator.hasNext());
    }

    @Test
    void next() {
        for (Integer a : list) assertEquals(a, binaryTreeIterator.next());
        list1.addAll(binaryTree);
        assertEquals(list, list1);
    }

}