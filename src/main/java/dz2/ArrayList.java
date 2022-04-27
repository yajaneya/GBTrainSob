/*
Реализация ArrayList
---------------------
Реализованные методы:
boolean add(E e) - добавление элемента в конец списка - возвращает всегда true;
void add(int index, E element) - добавление элемента на место, заданное индексом;
E get(int index) - получение элемента с заданным индексом - возвращает найденный элемент;
E set(int index, E element) - изменение элемента с заданным индексом - возвращает измененный элемент;
E remove(int index) - удаление элемента с заданным индексом - возвращает удаленный элемент;
boolean addAll(int index, Collection<? extends E> c) - добавление коллекции на место, начиная с заданного индекса - возвращает всегда true;
void clear() - очистка списка;
int size() - возвращает размер списка;
 */

package dz2;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayList<E> extends AbstractList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;

    private int size;
    private E [] items;

    public ArrayList() {
        capacity = DEFAULT_CAPACITY;
        items = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList(int initCapacity) {
        if (initCapacity == 0) {
            capacity = DEFAULT_CAPACITY;
            items = (E[]) new Object[capacity];
            size = 0;
        } else if (initCapacity > 0) {
            capacity = initCapacity;
            items = (E[]) new Object[capacity];
            size = 0;
        } else {
            throw new IllegalArgumentException ("Некорректный размер: " + initCapacity);
        }
    }

    @Override
    public boolean add(E e) {
        items[size++] = e;
        if (isFull())
            resizeCapacity();
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkOutIndex(index);
        if (index == size) {
            add(element);
        } else {
            items[index] = element;
        }
    }

    @Override
    public E get(int index) {
        checkOutIndex(index);
        return items[index];
    }

    @Override
    public E set(int index, E element) {
        checkOutIndex(index);
        return items[index] = element;
    }

    @Override
    public E remove(int index) {
        checkOutIndex(index);
        E returnElement = items[index];
        for (int i = index; i < size-1; i++) {
            items [i] = items[i+1];
        }
        return returnElement;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkOutIndex(index);
        E[] arr = (E[]) c.toArray();
        while (size + arr.length > capacity) {
            resizeCapacity();
        }
        E [] temp = Arrays.copyOfRange(items, index, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            items[index + i] = arr[i];
        }
        for (int i = 0; i < temp.length; i++) {
            items[index+arr.length + i] = temp[i];
        }
        size = size + arr.length;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isFull () {
        return size == capacity;
    }

    private void resizeCapacity () {
        E [] temp = items;
        items = Arrays.copyOf(temp, capacity * 2);
    }

    private void checkOutIndex (int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("индекс -> " + index + " отрицателен, однако! Непорядочек!");
        }
        if (index > size) {
            throw new IndexOutOfBoundsException("индекс -> " + index + ", а размер -> " + size + ", однако!");
        }
    }
}
