public class Main {

    // This is a problem from CoderByte called StringPeriods.
    public static void main(String[] args) {

        String result = stringPeriods("ababab");

        System.out.println(result);
    }

    private static String stringPeriods(String sen) {
        String result = "";

        String subString = sen.substring(0, 2);
        if (sen.length() % subString.length() == 0) {
            int amountToMultiply = sen.length() / subString.length();
            for (int i = 0; i < amountToMultiply; i++) {
                result += subString;
            }
            return result;
        }

        return "-1";
    }
}
