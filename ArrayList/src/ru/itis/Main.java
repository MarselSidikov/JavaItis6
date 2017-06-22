package ru.itis;

public class Main {

    public static void main(String[] args) {
	    ArrayList list = new ArrayList();
	    list.add(6);
	    list.add(7);
	    list.add(8);

	    ArrayList list1 = new ArrayList();
	    list1.add(1);
	    list1.add(5);
	    list1.add(7);
        list1.add(10,1);

        ArrayList mergedList = ArrayList.merge(list, list1);
        System.out.println(list.getElementByIndex(2));
        System.out.println(list.getElementByIndex(1));
        System.out.println(list.getElementByIndex(0));
        System.out.println(list.getElementByIndex(3));

    }
}
