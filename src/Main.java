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

        // abcab
        System.out.println(stringPeriods("abcababcababcab"));
    }

    private static String stringPeriods(String sen) {
        // Run loop for half the length of sen, because a substring longer than that is not a pattern.
        for (int i = 1; i < sen.length() / 2; i++) {
            String subString = sen.substring(0, i);
            if (checkForMatchingSubstrings(sen, subString))
                return subString;
        }

        return "-1";
    }

    private static boolean checkForMatchingSubstrings(String sen, String subString) {
        // length of "ab" must go into length of "ababab" perfectly for it to be a pattern.
        // (6 / 2 equals 3 with a remainder of 0).
        // If remainder is 0, it is perfectly divisible and we continue. If not, it is not a pattern and we return false.
        if (sen.length() % subString.length() != 0)
            return false;

        // If subString is "ab" and sen is "ababab"
        // This will compare "ab" to substring(0, 2) ... substring(2, 4) ... substring(4, 6)
        for (int i = 0; i < sen.length(); i += subString.length()) {
            String subStringToCompare = sen.substring(i, i + subString.length());
            if (!subString.equals(subStringToCompare)) {
                return false;       // If two substrings do not match, return false
            }
        }

        // If all conditions above passed, it is a pattern.
        return true;
    }
}
