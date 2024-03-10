package ru.academits.zhurov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public ListItem<T> getHead() {
        return head;
    }

    public void setHead(ListItem<T> head) {
        this.head = head;
    }

    public T getData(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Индекс отсчитывается от 0. Введенный индекс: " + index + ". Длина списка: " + count);
        }

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        return currentItem.getData();
    }

    public T setData(int index, T data) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Индекс отсчитывается от 0. Введенный индекс: " + index + ". Длина списка: " + count);
        }

        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        T previousData = currentItem.getData();
        currentItem.setData(data);

        return previousData;
    }

    public void add(int index, T data) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Попытка обращения к несуществующему индексу. Введенный индекс: " + index + ". Длина списка: " + count);
        }

        if (index == 0) {
            add(data);
            return;
        }

        ListItem<T> currentItem = head;

        if (index == count) {
            SinglyLinkedList<T> oneItem = new SinglyLinkedList<>();
            oneItem.add(data);

            for (int i = 0; i < count - 1; i++) {
                currentItem = currentItem.getNext();
            }

            currentItem.setNext(oneItem.head);

            count++;
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            currentItem = currentItem.getNext();
        }

        ListItem<T> newItem = new ListItem<>(data, currentItem.getNext());
        currentItem.setNext(newItem);

        count++;
    }

    public void unwrap() {
        ListItem<T> previousItem = null;
        ListItem<T> currentItem = head;

        for (int i = 0; i < count; i++) {
            ListItem<T> nextItem = currentItem.getNext();

            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();

        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            copy.add(currentItem.getData());
        }

        copy.unwrap();
        return copy;
    }

    public T remove(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("попытка обращения к несуществующему индексу. Введенный индекс: " + index + ". Длина списка: " + count);
        }

        ListItem<T> currentItem = head;
        T previousData = currentItem.getData();

        if (count == 1) {
            count = 0;
            head = null;

            return previousData;
        }

        if (index == 0) {
            currentItem = currentItem.getNext();
            head = currentItem;
            count--;

            return previousData;
        }

        if (index == count - 1) {
            for (int i = 0; i < count; i++) {
                if (i < count - 1) {
                    currentItem = currentItem.getNext();
                }
            }

            previousData = currentItem.getData();
            currentItem.setNext(null);

            count--;
            return previousData;
        }

        ListItem<T> m = head;

        for (int i = 0; i < index + 1; i++) {
            currentItem = currentItem.getNext();

            if (i < index - 1) {
                m = m.getNext();
            }
        }

        previousData = m.getNext().getData();
        m.setNext(currentItem);

        count--;
        return previousData;
    }

    public boolean removeFirstOccurrence(T data) {
        ListItem<T> currentItem = head;

        for (int i = 0; currentItem != null; currentItem = currentItem.getNext(), i++) {
            if (currentItem.getData().equals(data)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    public int getSize() {
        return count;
    }

    public T getHeadData() {
        return head.getData();
    }

    public void add(T value) {
        head = new ListItem<>(value, head);
        count++;
    }

    public T removeFirstElement() {
        if (count == 0) {
            throw new IndexOutOfBoundsException("Попытка обращения к несуществующему индексу. Длина списка = 0");
        }

        T firstElementData = head.getData();

        remove(0);
        return firstElementData;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('{');

        for (int i = 0; i < count; i++) {
            stringBuilder.append(getData(i));

            if (i != count - 1) {
                stringBuilder.append(" ,");
            }
        }

        stringBuilder.append('}');
        return String.valueOf(stringBuilder);
    }
}
