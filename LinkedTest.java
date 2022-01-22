public class LinkedTest {
    public static void main(String[] args) {
        Method<String> stringLinked = new MyLinkedList<String>();
        stringLinked.add("abc");
        stringLinked.add("BC");
        stringLinked.add("123");

        System.out.println(stringLinked.size()); // 3
        System.out.println();

        System.out.println(stringLinked.getElement(0)); // abc
        System.out.println();

        stringLinked.remove(1); // 123
        System.out.println(stringLinked.getElement(1));
        System.out.println();

        stringLinked.clear();
        System.out.println(stringLinked.size()); // 0
    }
}
