import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        //loop for para capturar os valores de acordo com cada classe
        for(int i=1; i<=n; i++) {
            System.out.println("Product #"+i+" data: ");
            System.out.println("Common, used or imported (c/u/i)? ");
            char a = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (a == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
            else if (a == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY):");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));
            }
            else {
                list.add(new Product(name, price));
            }

        }

        System.out.println("PRICE TAGS: ");
        for(Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();

    }
}