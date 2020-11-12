public class Main {

    // This is a problem from CoderByte called StringPeriods.
    public static void main(String[] args) {

        // Answer: ab
        System.out.println(stringPeriods("ababab"));

        // Answer: haw
        System.out.println(stringPeriods("hawhawhaw"));

        // Answer: -1
        System.out.println(stringPeriods("abaxbab"));

        // Answer: -1
        System.out.println(stringPeriods("temetemep"));

        // Answer: abcab
        System.out.println(stringPeriods("abcababcababcab"));
    }

    private static String stringPeriods(String sen) {
        // Run loop for half the length of sen, because a substring longer than that is not a pattern.
        for (int i = 1; i < sen.length() / 2; i++) {
            String subString = sen.substring(0, i);     // subString gets longer and longer every loop ("a", "ab", "abc", "abcd" etc...)
            if (checkForMatchingSubstring(sen, subString))
                return subString;
        }

        return "-1";
    }

    private static boolean checkForMatchingSubstring(String sen, String subString) {
        // If sen is "ababab" and subString is "ab" ...
        // length of "ab" must go into length of "ababab" perfectly for it to be a pattern.
        // ( (6 letters) / (2 letters) equals 3 with a remainder of 0).
        // If remainder is 0, it is perfectly divisible and we continue ("ab" goes into "ababab" 3 times)
        // If not, it is not a pattern and we return false.
        if (sen.length() % subString.length() != 0)
            return false;

        // Loop will compare "ab" to substring(0, 2) ... then substring(2, 4) ... then substring(4, 6) ... etc
        for (int i = subString.length(); i < sen.length(); i += subString.length()) {
            String subStringToCompare = sen.substring(i, i + subString.length());
            if (!subString.equals(subStringToCompare)) {
                return false;       // If any two substrings do not match, return false
            }
        }

        // If all conditions above passed, it is a pattern.
        return true;
    }
}
