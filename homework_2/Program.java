package exceptions.homework_2;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Program {
    // 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и 
    //    возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
    //    вместо этого, необходимо повторно запросить у пользователя ввод данных.
    public static float task1(String msg){
        float retValue = 0.0f;
        Scanner scanner = new Scanner(System.in);
        boolean badValue = true;
        while (badValue) {
            try {
                System.out.println(msg + ": ");
                String tempValue = scanner.nextLine();
                retValue = Float.valueOf(tempValue);
                badValue = false;
            } catch (Exception e) {
                System.out.println("!!! некорректный ввод");
                badValue = true;
            }
        }
        //scanner.close();
        return retValue;
    }

    // 2. Если необходимо, исправьте данный код 
    //    (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    public static void task2(){
        try {
            int d = 0;
            
            int[] intArray = new int[9];
            
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = new Random().nextInt();
            }

            double catchedRes1 = intArray[8] / d;
            
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Catching exception: " + e.toString());
         }
         
    }

    // 3. Дан следующий код, исправьте его там, где требуется 
    //    (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
    public static void task3(){
        String exMessage = null;
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[abc.length - 1] = 9;
            
        } catch (NullPointerException ex) {
            exMessage = "Указатель не может указывать на null! ";
            System.out.println();
        } catch (IndexOutOfBoundsException ex) {
            exMessage = "Массив выходит за пределы своего размера!";
        } catch (Exception ex) {
            exMessage = "Что-то пошло не так";
        } finally{
            if (exMessage != null) {
                System.out.println(exMessage);
            }
        }
    }
    public static void printSum(Integer a, Integer b) throws NullPointerException{
        System.out.println(a.toString() + b.toString());
    }

    // 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
    //    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    static public String task4() throws NullPointerException, NoSuchElementException {
        Scanner scanner = new Scanner(System.in);
        String retValue = scanner.nextLine();
  
        if (retValue.length() == 0) {
            //scanner.close();
            throw new NullPointerException();
        }
        //scanner.close();
        return "retValue";
    }


    public static void main(String[] args) {
        float value1 = task1("Введите число с плавающей запятой: ");
        System.out.println("Вы ввели " + value1);
        task2();
        task3();
        boolean badValue4 = true;
        while (badValue4) {
            try {
                System.out.println("Введите произвольную строку: ");
                String value4 = task4();
                badValue4 = false;
            } catch (NullPointerException | NoSuchElementException e) {
                System.out.println("Ввод пустых строк запрещён");
            } 
        }

    }
}
