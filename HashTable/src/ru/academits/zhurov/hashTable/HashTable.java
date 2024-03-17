package ru.academits.zhurov.hashTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HashTable<T> implements Collection<T> {
    private Object[] hashTable = new HashTable[20];
    private ArrayList<T> objectsList = new ArrayList<>();

    public HashTable (){
    }

    /*
    Нет, нужно создать массив списков.
    lists = new КлассСписка[размер];
    Здесь придется указать тип без generic'а, т.к. Java не позволит использовать generic.
    Но само поле должно быть объявлено как массив generic списков.
    Этот код отработает, но будет warning.
    Этот warning исправить нельзя, его нужно будет заглушить.
    */

    public Object[] getHashTable() {
        return hashTable;
    }

    public void setHashTable(Object[] hashTable) {
        this.hashTable = hashTable;
    }

    public ArrayList<T> getObjectsList() {
        return objectsList;
    }

    public void setObjectsList(ArrayList<T> objectsList) {
        this.objectsList = objectsList;
    }

    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
