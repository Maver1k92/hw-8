public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("HomeSiren");
        strings.add("StreetSiren");
        strings.add("DoorProtect");
        strings.add("MotionProtect");
        strings.remove(1);
        strings.clear();


        System.out.println(strings.get(0));
        System.out.println(strings.size());


    }

}
