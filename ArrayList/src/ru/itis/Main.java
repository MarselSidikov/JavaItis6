package ru.itis;

public class Main {

    public static void main(String[] args) {
	    ArrayList list = new ArrayList();
	    list.add(6);
	    list.add(7);
	    list.add(-8);

        System.out.println(list.getElementByIndex(2));
        System.out.println(list.getElementByIndex(1));
        System.out.println(list.getElementByIndex(0));
        System.out.println(list.getElementByIndex(3));
    }
}
