package ru.academits.zhurov.arrayList;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private static final int CAPACITY = 10;
    private static final int CAPACITY_MULTIPLIER = 2;
    private int ELEMENT_COUNTER = 0;
    private Object[] items = new Object[CAPACITY];
    private int SIZE;

    private class MyArrayListIterator implements Iterator<E> {
        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            //TODO бросить 2 исключения если вышел за границы или изменилась длина списка (видео Павла 1.17.00 про итератор)
            if (currentIndex > SIZE) {
                throw new NoSuchElementException("Больше нет элементов");
            }

            return currentIndex + 1 < SIZE;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            ++currentIndex;
            return (E) items[currentIndex];
        }

        public Iterator<E> iterator() {
            return new MyArrayListIterator();
        }
    }

    public ArrayList() {
        SIZE = 0;
    }

    public ArrayList(int capacity) {
        items = new Object[capacity];
        SIZE = 0;
    }

    public Object[] getItems() {
        return items;
    }

    public void setItems(E[] items) {
        this.items = items;
    }

    public int getSIZE() {
        return SIZE;
    }

    @Override
    public boolean add(Object element) {
        if (SIZE == items.length) {
            increaseCapacity(items);
        }

        items[SIZE] = element;
        SIZE++;

        return true;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > SIZE) {
            throw new IllegalArgumentException("Попытка обратиться к несуществующему индексу списка: " + index + " .Размер списка: " + SIZE);
        }

        if (SIZE == items.length) {
            increaseCapacity(items);
        }

        if (SIZE - 1 - index >= 0) {
            System.arraycopy(items, index, items, index + 1, SIZE - 1 - index);
        }

        SIZE++;
        items[index] = element;
    }

    //TODO дописать метод
    //Для реализации может потребоваться иттератор
    @Override
    public boolean addAll(Collection c) {
        if (c.size() == 0) {
            return false;
        }

        if (items.length < SIZE + c.size()) {
            Object[] addAll = Arrays.copyOf(items, SIZE + c.size());
            items = Arrays.copyOf(addAll, addAll.length);
        }

        for (int i = 0; i < c.size(); i++) {
            //  items[i] = c.
        }

        return true;
    }

    private void increaseCapacity(Object[] items) {
        Object[] increase = new Object[items.length];

        System.arraycopy(items, 0, increase, 0, items.length);

        this.items = new Object[items.length * CAPACITY_MULTIPLIER];

        System.arraycopy(increase, 0, this.items, 0, increase.length);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (int i = 0; i < SIZE; i++) {
            stringBuilder.append(items[i]);

            if (i != SIZE - 1) {
                stringBuilder.append(" ,");
            }
        }

        stringBuilder.append("}");

        return String.valueOf(stringBuilder);
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public boolean isEmpty() {
        return SIZE == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < SIZE; i++) {
            if (o.equals(items[i])) {
                return true;
            }
        }

        return false;
    }

    //TODO реализовать и проверить корректность
    @Override
    public Iterator iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] toArray = new Object[SIZE];
        System.arraycopy(items, 0, toArray, 0, SIZE);

        return toArray;
    }

    //TODO реализовать
    @Override
    public boolean remove(Object o) {
        return false;
    }

    //TODO реализовать
    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }
    //TODO реализовать

    @Override
    public void clear() {

    }

    //TODO реализовать
    @Override
    public E get(int index) {
        return (E) items[index];
    }

    //TODO реализовать
    @Override
    public Object set(int index, Object element) {
        return null;
    }
    //TODO реализовать

    @Override
    public E remove(int index) {
        if (index >= SIZE || index < 0) {
            throw new IndexOutOfBoundsException("Попытка обратиться к несуществующему индексу: " + index + " .Длина списка: " + SIZE);
        }

        Object removeElement = items[index];

        if (SIZE - 1 - index >= 0) {
            System.arraycopy(items, index + 1, items, index, SIZE - 1 - index);
        }

        SIZE--;
        return (E) removeElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < SIZE; i++) {
            if (o.equals(items[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = SIZE - 1; i >= 0; i--) {
            if (o.equals(items[i])) {
                return i;
            }
        }

        return -1;
    }

    //Не требуется реализовывать по условию задачи
    @Override
    public ListIterator listIterator() {
        return null;
    }

    //Не требуется реализовывать по условию задачи
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    //Не требуется реализовывать по условию задачи
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean isRetain = false;

        for (int i = 0; i < SIZE; i++) {
            if (!c.contains(items[i])) {
                isRetain = true;
                remove(i);
                i--;
            }
        }

        return isRetain;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean isRemove = false;

        for (int i = 0; i < SIZE; i++) {
            if (c.contains(items[i])) {
                isRemove = true;
                remove(i);
                i--;
            }
        }

        return isRemove;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c == null || c.getClass() != ArrayList.class) {
            return false;
        }

        for (int i = 0; i < c.size(); i++) {
            if (!contains(((ArrayList<?>) c).items[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return Arrays.copyOf(a, a.length);
    }

    public boolean ensureCapacity(int capacity) {
        return items.length >= capacity;
    }

    public void trimToSize() {
        Object[] trimItems = Arrays.copyOf(items, SIZE);
        items = Arrays.copyOf(trimItems, trimItems.length);
    }
}
