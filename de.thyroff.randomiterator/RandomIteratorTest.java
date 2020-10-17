import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RandomIteratorTest {

    @org.junit.jupiter.api.Test
    void hasNext() {
        RandomIterator<Integer> it = new RandomIterator<>(Collections.singletonList(1));

        assertTrue (it.hasNext());

        it = new RandomIterator<>(new LinkedList<>());

        assertFalse(it.hasNext());

        RandomIterator<Integer> finalIt = it;
        assertThrows(NoSuchElementException.class, finalIt::next);
    }

    @org.junit.jupiter.api.Test
    void next() {
        RandomIterator<Integer> it = new RandomIterator<>(Arrays.asList(1, 2, 3, 4, 5));

        it.forEachRemaining(System.out::println);
    }
}