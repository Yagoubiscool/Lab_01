import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductReader {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("ProductData.csv"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(",");

                String name = fields[0];
                String description = fields[1];
                String ID = fields[2];
                double cost = Double.parseDouble(fields[3]);

                Product product =
                        new Product(name, description, ID, cost);

                products.add(product);
            }

            reader.close();

            System.out.println("Product data read from ProductData.csv");
            System.out.println();

            for (Product product : products) {
                System.out.println(product);
            }

        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }
}