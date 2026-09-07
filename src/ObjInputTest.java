public class ObjInputTest {

    public static void main(String[] args) {

        SafeInputObj input = new SafeInputObj();

        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("Name: " + name);

        int age = input.getInt("Enter your age");
        System.out.println("Age: " + age);

        int number = input.getRangedInt("Enter a number", 1, 10);
        System.out.println("Number: " + number);

        double price = input.getDouble("Enter a price");
        System.out.println("Price: " + price);

        double rating = input.getRangedDouble("Enter a rating", 1, 5);
        System.out.println("Rating: " + rating);

        boolean answer = input.getYNConfirm("Do you like Java?");
        System.out.println("Answer: " + answer);

        String zipCode = input.getRegExString(
                "Enter a 5 digit ZIP code",
                "\\d{5}"
        );
        System.out.println("ZIP Code: " + zipCode);
    }
}