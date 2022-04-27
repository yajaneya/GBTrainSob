/*
Реализация LinkedList
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

import java.util.*;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>{

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    // добавление элемента в конец
    @Override
    public boolean add(E e) {
        if (size == 0) {
            first = new Node<>(e, null, null);
            size++;
            return true;
        }
        if (size == 1) {
            last = new Node<>(e, null, first);
            first.next = last;
            size++;
            return true;
        }
        Node<E> temp = new Node<>(e, null, last);
        last.next = temp;
        last = temp;
        size++;
        return true;
    }

    // добавление элемента по индексу
    @Override
    public void add(int index, E element) {
        checkIndex(index);
        Node <E> prevNode = seachNode(index-1);
        Node <E> nextNode = seachNode(index);
        Node <E> node = new Node<>(element, nextNode, prevNode);
        prevNode.next = node;
        nextNode.prev = node;
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return seachNode(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        seachNode(index).item = element;
        return element;
    }


    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> removed = seachNode(index);
        Node<E> prev = seachNode(index - 1);
        Node<E> next = seachNode(index + 1);
        prev.next = next;
        next.prev = prev;
        size--;
        return removed.item;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndex(index);
        E[] arr = (E[]) c.toArray();
        for (int i = 0; i < arr.length; i++) {
            add(i + index, arr[i]);
        }
        return true;
    }

    @Override
    public void clear() {
        if (first.next == null) {
            first = null;
            size = 0;
            return;
        }
        Node<E> node = first;
        while (node.next != null) {
            Node<E> next = node.next;
            node.prev = null;
            node.next = null;
            node = next;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    private Node<E> seachNode(int index) {
        checkIndex(index);
        Node<E> findNode = first;
        for (int i = 0 ; i < index; i++)
            findNode = findNode.next;
        return findNode;
    }

    private void checkIndex (int index) {
        if (index < 0 || index > size -1) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
