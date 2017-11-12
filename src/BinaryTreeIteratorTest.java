import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BinaryTreeIteratorTest {
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

        Iterator<Integer> iterator1 = tree1.iterator();
        assertEquals(4,(int) iterator1.next());
        assertEquals(5,(int) iterator1.next());
        assertEquals(9,(int) iterator1.next());
        assertEquals(10,(int) iterator1.next());
        assertEquals(12,(int) iterator1.next());
        assertEquals(18,(int) iterator1.next());
        assertEquals(29,(int) iterator1.next());


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

        Iterator<Integer> iterator2 = tree2.iterator();
        assertEquals(1,(int) iterator2.next());
        assertEquals(30,(int) iterator2.next());
        assertEquals(50,(int) iterator2.next());
        assertEquals(63,(int) iterator2.next());
        assertEquals(100,(int) iterator2.next());
        assertEquals(150,(int) iterator2.next());
        assertEquals(223,(int) iterator2.next());
        assertEquals(250,(int) iterator2.next());
        assertEquals(366,(int) iterator2.next());


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

        Iterator<Integer> iterator3 = tree3.iterator();
        assertEquals(90,(int) iterator3.next());
        assertEquals(100,(int) iterator3.next());
        assertEquals(101,(int) iterator3.next());
        assertEquals(110,(int) iterator3.next());
        assertEquals(150,(int) iterator3.next());
        assertEquals(250,(int) iterator3.next());
        assertEquals(300,(int) iterator3.next());
        assertEquals(304,(int) iterator3.next());
        assertEquals(352,(int) iterator3.next());
        assertEquals(400,(int) iterator3.next());
    }

}