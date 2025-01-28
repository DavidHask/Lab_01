public class Test {

    public static void main(String[] args) {
        Person test = new Person("000001", "hello", "yes", "mr.", 1999);

        System.out.println(test.toJSON());
        System.out.println(test.toXML());
    }
}
