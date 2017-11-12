import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    @Test
    public void next() {
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        tree1.add(10);
        tree1.add(5);
        tree1.add(12);
        tree1.add(18);
        tree1.add(4);
        tree1.add(9);
        tree1.add(29);
        tree1.remove(12);
        assertFalse(tree1.contains(12));
        assertEquals(6, tree1.size());


        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.add(50);
        tree2.add(30);
        tree2.add(150);
        tree2.add(1);
        tree2.add(100);
        tree2.add(250);
        tree2.add(63);
        tree2.add(223);
        tree2.add(366);
        tree2.remove(150);
        assertFalse(tree2.contains(150));
        assertEquals(8, tree2.size());


        BinaryTree<Integer> tree3 = new BinaryTree<>();
        tree3.add(250);
        tree3.add(100);
        tree3.add(352);
        tree3.add(90);
        tree3.add(101);
        tree3.add(110);
        tree3.add(150);
        tree3.add(300);
        tree3.add(400);
        tree3.add(304);
        tree3.remove(250);
        assertFalse(tree3.contains(250));
        assertEquals(9, tree3.size());
    }
}