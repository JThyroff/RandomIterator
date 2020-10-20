import java.util.Iterator;
import java.util.List;

/**
 * Copyright 2020 Smail Smajlović
 * @param <E>
 */
public class FasterIterator<E> implements Iterator<E> {
    private final int dimension;
    private final Object[] unused;
    private int currentIndex = 0;

    public FasterIterator(List<E> pixels) {
        dimension = pixels.size();
        unused = pixels.toArray();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < dimension;
    }

    @Override
    public E next() {
        final var index = dimension - currentIndex - 1;
        final var random = (int) (Math.random() * index);
        final E result = (E) unused[random];

        // Swap last element and random index
        swap(unused, index, random);
        currentIndex += 1;

        return result;
    }

    private void swap(Object[] array, int i, int j) {
        final Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static boolean isArrayValid(final Object[][] array) {
        return !(array == null || array.length == 0 || array[0] == null || array[0].length == 0);
    }
}
