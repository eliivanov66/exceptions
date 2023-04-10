public class ProgramLogic {
    
    public static int[] subArrays(int[] argArray1, int[] argArray2){
        int[] result = null;
        if ((argArray1.length == argArray2.length) && (argArray1 != null)) {
            result = new int[argArray1.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = argArray1[i] - argArray2[i];
            }
        }
        return result;
    }

    public static int[] divArrays(int[] argArray1, int[] argArray2){
        int[] result = null;
        if ((argArray1.length == argArray2.length) && (argArray1 != null)) {
            result = new int[argArray1.length];
            for (int i = 0; i < result.length; i++) {
                if (argArray2[i] == 0) {
                    result = null;
                    return result;
                }
                result[i] = argArray1[i] / argArray2[i];
            }
        }
        return result;
    }
}
