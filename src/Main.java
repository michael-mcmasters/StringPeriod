public class Main {

    // This is a problem from CoderByte called StringPeriods.
    public static void main(String[] args) {

        // ab
        System.out.println(stringPeriods("ababab"));

        // -1
        System.out.println(stringPeriods("abaxbab"));

        // -1
        System.out.println(stringPeriods("abaxbaba"));

    }

    private static String stringPeriods(String sen) {
        String subString = sen.substring(0, 2);
        String result = checkForMatchingSubstrings(sen, subString);
        return result;
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
