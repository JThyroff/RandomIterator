import java.util.*;

public class RandomIterator<E> implements Iterator<E> {

    private final List<E> list;
    private final Random r = new Random();

    public RandomIterator(List<E> list) {
        this.list = new ArrayList<>(list);
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return list.listIterator().hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public E next() {
        return list.remove(r.nextInt(list.size()));
    }
}
