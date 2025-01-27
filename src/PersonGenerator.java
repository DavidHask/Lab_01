import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {

        boolean doneInput = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        String rec = "";

        ArrayList<Person> people = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        SafeInputObj sio = new SafeInputObj(in);
        Person personObj = new Person(ID, firstName, lastName, title, YOB);

        // create a loop to input the person's data

        do {

            /* ID = SafeInput.getNonZeroLenString(in, "Enter your ID [000001] ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name ");
            title = SafeInput.getNonZeroLenString(in, "Enter your title ");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth ", 1000, 9999);
            */

            ID = sio.getNonZeroLenString("Enter your ID [000001] ");
            //personObj.setID(ID);
            firstName = sio.getNonZeroLenString("Enter your first name ");
            //personObj.setFirstName(firstName);
            lastName = sio.getNonZeroLenString("Enter your last name ");
            //personObj.setLastName(lastName);
            title = sio.getNonZeroLenString("Enter your title ");
            //personObj.setTitle(title);
            YOB = sio.getRangedInt("Enter your year of birth ", 1000, 9999);
            //personObj.setYOB(YOB);

            people.add(new Person(ID, firstName, lastName, title, YOB));

            //rec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            //System.out.println(rec);

            //people.add(rec);

            for (Person x : people) {
                System.out.println(x);
            }

            System.out.println(personObj.toCSV());

            doneInput = sio.getYNConfirm("Are you done ");

        } while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.csv");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person person : people)
            {
                writer.write(person.toCSV());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
