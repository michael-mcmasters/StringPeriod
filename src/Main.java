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
            String result = checkForMatchingSubstrings(sen, subString);
            if (result != "-1")
                return result;
        }

        return "-1";
    }

    private static String checkForMatchingSubstrings(String sen, String subString) {
        if (sen.length() % subString.length() == 0) {
            boolean patternDetected = true;
            for (int i = 0; i < sen.length(); i += subString.length()) {
                if (sen.substring(i, i + subString.length()).equals(subString)) {
                    continue;
                }
                patternDetected = false;
                break;
            }

            if (patternDetected == true) {
                return subString;
            }
        }
        return "-1";
    }
}
