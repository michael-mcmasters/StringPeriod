public class Main {

    // This is a problem from CoderByte called StringPeriods.
    public static void main(String[] args) {

        // Answer: ab
        System.out.println(stringPeriods("ababab"));

        // Answer: haw
        System.out.println(stringPeriods("hawhawhaw"));

        // Answer: -1
        System.out.println(stringPeriods("abaxaba"));

        // Answer: -1
        System.out.println(stringPeriods("temetemep"));

        // Answer: abcab
        System.out.println(stringPeriods("abcababcababcab"));
    }

    private static String stringPeriods(String sen) {
        // Run loop for half the length of sen, because a substring longer than that is not a pattern.
        for (int i = 1; i < sen.length() / 2; i++) {
            String subString = sen.substring(0, i);     // subString gets longer and longer every loop ("a", "ab", "abc", "abcd" etc...)
            if (isPattern(sen, subString))
                return subString;
        }

        // If the condition above never runs true, return "-1" because sen is not a pattern.
        return "-1";
    }

    private static boolean isPattern(String sen, String subString) {
        // Length of sen ("ababab") must be perfectly divisible by length of subString ("ab")... meaning the remainder must be 0.
        if (sen.length() % subString.length() != 0)
            return false;       // If remainder is not 0, return false.

        // Loop will compare "ab" to substring(2, 4) ... then substring(4, 6) ... etc
        for (int i = subString.length(); i < sen.length(); i += subString.length()) {
            String subStringToCompare = sen.substring(i, i + subString.length());
            if (!subString.equals(subStringToCompare)) {
                return false;   // If any two substrings do not match, return false
            }
        }

        // If all conditions above passed, it is a pattern.
        return true;
    }
}
