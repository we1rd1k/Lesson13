package part1.lesson13.task01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class DocumentConverter {

    String name;
    float  quantity;
    float price;
    float amount;
    float all;

    private static Logger logger = LoggerFactory.getLogger(DocumentConverter.class);

    public DocumentConverter() {
    }

    public void readFromFile() {
        logger.info("Указываем с консоли путь к файлу");
        System.out.print("Введите путь к файлу: ");

        try(BufferedReader reader = new BufferedReader(new FileReader(new Scanner(System.in).nextLine()))) {
            logger.info("Считываем построчно данные из файла");
            System.out.println("=====================================================");
            while (true){
                logger.debug("Считываем данные для переменной \"name\"");
                name = reader.readLine();
                logger.debug("Данные для переменной \"name\" - {}", name);
                quantity = Float.parseFloat(reader.readLine());
                logger.debug("Данные для переменной \"quantity\" - {}", quantity);
                price = Float.parseFloat(reader.readLine());
                logger.debug("Данные для переменной \"price\" - {}", price);
                amount= quantity*price;
                all = all + amount;
                System.out.format("%-20s %-7.2f X %-5.2f =%-1.2f \n", name, price, quantity, amount);
            }
        }catch (IOException e) {
            logger.error("Ошибка Ввода");
            e.printStackTrace();
        } catch (NullPointerException exception){
            logger.warn("Закончились данные");
            System.out.println("=====================================================");
            System.out.printf("%-30s Итого: %.2f\n", "", all);
        }
    }
}
