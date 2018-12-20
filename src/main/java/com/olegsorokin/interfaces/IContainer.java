package main.java.com.olegsorokin.interfaces;

public interface IContainer<T> {
    int indexOf(T object);
    T get(int index);
    int size();
}
