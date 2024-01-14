import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        /*-------- CLIENT IMPLEMENTATION --------*/
        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();

        Client client = new Client(name, email, sdf.parse(birthDate));

        /*-------- ORDER IMPLEMENTATION --------*/
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.nextLine();
        OrderStatus valueStatus = OrderStatus.valueOf(status);

        System.out.print("How many items to this order? ");
        int quantity = sc.nextInt();

        Order order = new Order(null, valueStatus, client);

        for (int i = 1; i <= quantity; i++) {
            sc.nextLine();
            System.out.format("Enter %d item data:\n", i);
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();

            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();

            Product product = new Product(nameProduct, priceProduct);

            System.out.print("Quantity: ");
            int quantityProduct = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantityProduct, product.getPrice(), product);

            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}