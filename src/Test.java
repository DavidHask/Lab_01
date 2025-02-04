import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        /*
        Person test = new Person("000001", "hello", "yes", "mr.", 1999);

        System.out.println(test.toJSON());
        System.out.println(test.toXML());

         */

        Scanner in = new Scanner(System.in);

        SafeInputObj sio = new SafeInputObj(in);

        System.out.println(sio.getNonZeroLenString("What is your name? "));
        System.out.println(sio.getInt("Enter an integer "));
        System.out.println(sio.getDouble("Enter a double "));
        System.out.println(sio.getRangedInt("Enter a ranged integer ", 1, 100));
        System.out.println(sio.getRangedDouble("Enter a ranged double ", 1, 100));
        System.out.println(sio.getYNConfirm("Is this working? "));
        System.out.println(sio.getRegExString("Enter a reg ex pattern", "%-2.2f"));

    }
}
