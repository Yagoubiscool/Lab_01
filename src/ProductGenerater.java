import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerater {

    public static void main(String[] args) {

        Scanner pipe = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        boolean done = false;

        while (!done) {

            String name =
                    SafeInput.getNonZeroLenString(pipe, "Enter product name");

            String description =
                    SafeInput.getNonZeroLenString(pipe, "Enter product description");

            String ID =
                    SafeInput.getNonZeroLenString(pipe, "Enter product ID");

            double cost =
                    SafeInput.getRangedDouble(pipe,
                            "Enter product cost",
                            0,
                            10000);

            Product product =
                    new Product(name, description, ID, cost);

            products.add(product);

            done = !SafeInput.getYNConfirm(pipe,
                    "Do you want to enter another product?");
        }

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("ProductData.csv"));

            for (Product product : products) {
                writer.write(product.toCSV());
                writer.newLine();
            }

            writer.close();

            System.out.println("Product data saved to ProductData.csv");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}