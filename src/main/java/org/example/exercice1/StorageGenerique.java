package org.example.exercice1;

import java.util.ArrayList;
import java.util.List;

class StorageGenerique<T> {
    private List<T> elements;

    public StorageGenerique() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T o) {
        elements.add(o);
    }

    public T getElement(int index) {
        return elements.get(index);
    }

    public void removeElement(int index) {
        elements.remove(index);
    }

    public int getSize() {
        return elements.size();
    }
}

 class App {
    public static void main(String[] args) {
        StorageGenerique<Integer> storageIntegers = new StorageGenerique<>();
        storageIntegers.addElement(1);
        storageIntegers.addElement(2);
        storageIntegers.addElement(3);

        System.out.println("Element à l'index 1: " + storageIntegers.getElement(1));

        storageIntegers.removeElement(0);

        System.out.println("Taille de la liste: " + storageIntegers.getSize());

        StorageGenerique<String> storageStrings = new StorageGenerique<>();
        storageStrings.addElement("Bonjour");
        storageStrings.addElement("Hello");
        storageStrings.addElement("Hola");

        System.out.println("Element à l'index 2: " + storageStrings.getElement(2));

        System.out.println("Taille de la liste: " + storageStrings.getSize());
    }
}
