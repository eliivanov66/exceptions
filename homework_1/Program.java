public class Program {
    public static void main(String[] args) {
        int[] array1 = Ui.userInput("Введите первый массив целозначных чисел, разделённых через ПРОБЕЛ", " ");
        int[] array2 = Ui.userInput("Введите второй массив целозначных чисел, разделённых через ПРОБЕЛ", " ");

        if ((array1.length == array2.length) && (array1 != null)) {
            int[] arrSub = ProgramLogic.subArrays(array1, array2);
            int[] arrDiv = ProgramLogic.divArrays(array1, array2);

            if (arrSub != null) {
                StringBuilder result1 = new StringBuilder();
                result1.append("Массив разности элементов равен: [");
                for (int i : arrSub) {
                    result1.append(i);
                    result1.append(" ");
                }
                result1.append("]");
                Ui.userOutput(result1.toString());
            }
            if (arrDiv != null) {
                StringBuilder result2 = new StringBuilder();
                result2.append("Массив частного элементов равен: [");
                for (int i : arrDiv) {
                    result2.append(i);
                    result2.append(" ");
                }
                result2.append("]");
                Ui.userOutput(result2.toString());
            }
        } else {
            Ui.userOutput("!!! Вы ввели массивы разной длины");
        }
    }
}
