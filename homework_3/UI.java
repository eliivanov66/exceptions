import java.util.Scanner;

public class UI {
    
    public static String in(String argMsg){
        String retValue;
        out(argMsg);
        try (Scanner scanner = new Scanner(System.in)) {
            retValue = scanner.nextLine();
        }
        return retValue;
    }

    public static void out(String argMsg){
        System.out.println(argMsg);
    }
}
