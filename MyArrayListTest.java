class MyArrayListTests {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList();
        list.add("MotionProtect");
        list.add("DoorProtect");
        list.add("HomeSiren");
        list.add("LeaksProtect");
        list.add("KeyPad");
        list.add("ReX");
        list.add("MotionCam");


        System.out.println("list = " + list );
        System.out.println("list.size() = " + list.size());
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println(list.remove(2));
        System.out.println(list.clear());
    }

}
