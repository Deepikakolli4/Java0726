public class RepeatingString {
    public static void main(String[] args) {
        String input = "hihihi";
        String repatingString = repeatingStrings("hihihi"); //return "🌼".
        System.out.println(repatingString);
        String repeatingStrings = repeatingStrings("🌼🌼🌼"); //return "🌼".
        System.out.println(repatingString);
        repatingString = repeatingStrings("🌼🌻" + "🌼🌻" + "🌼🌻"); //return "🌼🌻".
        System.out.println(repatingString);
        repatingString = repeatingStrings("CiaoCiao"); //return "Ciao".
        System.out.println(repatingString);
        repatingString = repeatingStrings("Captain CiaoCiaoCaptain CiaoCiao"); //return "CaptainCiaoCiao".
        System.out.println(repatingString);
        repatingString = repeatingStrings("🌕🌔🌓🌑"); //return null.
        System.out.println(repatingString);
        repatingString = repeatingStrings("CaptainCiaoCiaoCaptain"); //return null.
        System.out.println(repatingString);
        repatingString = repeatingStrings("🌼"); //return null.
        System.out.println(repatingString);
        repatingString = repeatingStrings(""); //return null.
        System.out.println(repatingString);
        repatingString = repeatingStrings(null); //return null.
        System.out.println(repatingString);
    }

    public static String repeatingStrings(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        // CiaoCiao
        String longestSubstring = "";
        for (int start = 0; start < input.length(); start++) {
            String substring = "";
            for (int i = start; i < input.length(); i++) {
                substring += input.charAt(i);
                if (isRepeating(input, substring, i + 1)) {
                    if (substring.length() > longestSubstring.length()) {
                        longestSubstring = substring;
                    }
                } else {
                    break;
                }
            }
        }

        return longestSubstring;
    }

    private static boolean isRepeating(String input, String substring, int fromIndex) {
        // ref = C
        // CiaoCiao
        int count = 0;
        for (int i = fromIndex; i <= input.length() - substring.length(); i++) {
            if (!input.startsWith(substring, i)) {
                count++;
                return false;
            }
        }
        return true;
    }
}