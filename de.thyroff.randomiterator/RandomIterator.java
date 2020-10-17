import java.util.*;

public class RandomIterator<E> implements Iterator<E> {

    List<E> list;

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
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        if (!this.hasNext())
            throw new NoSuchElementException();

        Random r = new Random();
        int ranInt = r.nextInt(list.size());

        return list.remove(ranInt);
    }
}
