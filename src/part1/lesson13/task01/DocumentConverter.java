package part1.lesson13.task01;

import java.io.*;
import java.util.Scanner;

public class DocumentConverter {

    String name;
    float  quantity;
    float price;
    float amount;
    float all;

    public DocumentConverter() {
    }

    public void readFromFile() {
        System.out.print("Введите путь к файлу: ");
        try(BufferedReader reader = new BufferedReader(new FileReader(new Scanner(System.in).nextLine()))) {
            System.out.println("=====================================================");
            while (true){
                name = reader.readLine();
                quantity = Float.parseFloat(reader.readLine());
                price = Float.parseFloat(reader.readLine());
                amount= quantity*price;
                all = all + amount;
                System.out.printf("%s %f X %f =%f \n", name, quantity, price, amount);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException exception){
            System.out.println("=====================================================");
            System.out.printf("Итого: %f", all);
        }
    }
}
