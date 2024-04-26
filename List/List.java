package List;

import java.util.Arrays;

public class List<T> {
    Object[] array;
    int size = 0;

    public List(int capacity) {
        array = new Object[capacity];
    }

    public List() {
        array = new Object[10];
    }

    public int getCapacity() {
        return array.length;
    }

    public int size() {
        return size;
    }

    public void add(T data) {
        if (getCapacity() > size) {
            array[size++] = data;
        } else {
            int newCapacity = getCapacity() * 2;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size(); i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            array[size++] = data;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public void print() {
        if (size == 0){
            System.out.println("[]");
        }
        else {
            System.out.print("[");
            for (int i = 0; i < getCapacity(); i++) {
                if (array[i] == null) {
                    break;
                } else if (getCapacity() == i + 1 && array[i] != null) {
                    System.out.print(array[i] + "]");
                } else if (array[i + 1] == null && array[i] != null) {
                    System.out.print(array[i] + "]");
                } else if (array[i] != null) {
                    System.out.print(array[i] + ", ");
                }
            }System.out.println();
        }
    }

    public Object get(int index) {
        if (index > size) {
            return null;
        }
        return array[index];
    }

    public void remove(int index) {
        if (index < size) {
            while (index < getCapacity() - 1) {
                array[index] = array[++index];
            }
        }size--;
    }

    public void set(int index, T data) {
        if (index < getCapacity()) {
            array[index] = data;
        } else {
            System.out.println("Geçersiz index değeri girildi!!");
            ;
        }
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(T data) {
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }
    public void clear(){
        Object[] newArray = new Object[getCapacity()];
        array = newArray;
        size = 0;
    }
    public boolean contains(T data){
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }
    public List<T> subList(int start, int finish){
        int subCapacity = finish-start+1;
        List<T> arr = new List<T>(subCapacity);
        for (int i = 0; i<subCapacity; i++){
            arr.add((T) array[start++]);
        }
        return arr;

    }
}
