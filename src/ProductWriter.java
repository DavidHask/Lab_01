import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {

        boolean doneInput = false;

        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;

        String rec = "";

        ArrayList<Product> products = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        SafeInputObj sio = new SafeInputObj(in);
        Product productObj = new Product(ID, name, description, cost);

        // create a loop to input the person's data

        do {

            ID = sio.getNonZeroLenString("Enter the ID [000001] ");
            name = sio.getNonZeroLenString("Enter the name of the product ");
            description = sio.getNonZeroLenString("Enter the description of the product ");
            cost = sio.getRangedDouble("Enter the price of the product  ", 10, 10000);

            products.add(new Product(ID, name, description, cost));

            for (Product x : products) {
                System.out.println(x);
            }

            System.out.println(productObj.toCSV());

            doneInput = sio.getYNConfirm("Are you done ");

        } while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\products.csv");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product product : products)
            {
                writer.write(product.toCSV());  // stupid syntax for write rec
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
