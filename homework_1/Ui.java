import java.util.Scanner;
public class Ui {
    
    public static int[] userInput(String argMsg, String argSeparator){
        Scanner scanner = new Scanner(System.in);
        boolean validData = false;
        int[] result = null;
        while (!validData){
            userOutput(argMsg + ": ");
            String[] temp = scanner.nextLine().split(argSeparator);
    
            result = new int[temp.length];
            for (int index = 0; index < result.length; index++) {
                try {
                    result[index] = Integer.valueOf(temp[index]);
                    validData = true;
                } catch (Exception e) {
                    userOutput("Некорректный ввод массива");
                    validData = false;
                }
                
            }
        }

        return result;

    }

    public static void userOutput(String argMsg){
        System.out.println(argMsg);
    }
}
