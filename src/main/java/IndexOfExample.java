public class IndexOfExample {
    public static void main(String[] args) {
        String str = "klm.hij!\n";
        String output = decaesar(caesar(str, 3), 3);
        System.out.println(output);
    }


    public static boolean completeRepeat1() {
        //        String string = "abcabcabcabc";
        String string = "abcpqrabcabc";
        String substring = "abc";

        int count = 0;

        int index = 0;
        int substringlength = substring.length();
        while (true) {
            index = string.indexOf(substring, index);
            if (index == -1) {
                break;
            }

            index += substringlength;
            count++;
        }

        return count * substringlength == string.length();
    }

    public static boolean completeRepeat2() {
        //        String string = "abcabcabcabc";
        String string = "abcpqrabcabc";
        String substring = "abc";

        int count = 0;
        int substringlength = substring.length();
        for (int index = 0; index < string.length(); index++) {
            index = string.indexOf(substring, index, index + substringlength);
            if (index == -1) {
                return false;
            }

            index += substringlength;
            count++;
        }

        return true;
    }

    public static String caesar(String string, int rotation) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
                char orignalLetter = string.charAt(i);
                int orignalValue = string.charAt(i) - 'a';
                int finalValue = (orignalValue + rotation) % 26;
                char finalLetter = (char) (finalValue + 'a');
                stringBuilder.append(finalLetter);
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String decaesar(String string, int rotation) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
                stringBuilder.append((char) (((string.charAt(i) - 'a') - rotation) % 26 + 'a'));
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}

// 1. You find the count and then count * substring.length() === string.length(); indexOf(substring, index);
// 2. You find the count and then