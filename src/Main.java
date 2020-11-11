public class Main {

    // This is a problem from CoderByte called StringPeriods.
    public static void main(String[] args) {

        // ab
        System.out.println(stringPeriods("ababab"));

        // haw
        System.out.println(stringPeriods("hawhawhaw"));

        // -1
        System.out.println(stringPeriods("abaxbab"));

        // -1
        System.out.println(stringPeriods("abaxbaba"));

    }

    private static String stringPeriods(String sen) {
        for (int i = 1; i < sen.length() / 2; i++) {
            String subString = sen.substring(0, i);
            boolean foundPattern = checkForMatchingSubstrings(sen, subString);
            if (foundPattern)
                return subString;
        }

        return "-1";
    }

    private static boolean checkForMatchingSubstrings(String sen, String subString) {
        if (sen.length() % subString.length() != 0)
            return false;

        for (int i = 0; i < sen.length(); i += subString.length()) {
            String subStringToCompare = sen.substring(i, i + subString.length());
            if (!subString.equals(subStringToCompare)) {
                return false;
            }
        }

        // If subString passed conditions above, it is a pattern.
        return true;
    }
}
