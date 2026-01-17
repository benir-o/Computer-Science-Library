package dsa.encoder;

import java.util.*;

public class Codec {
    final char DELIMITER = '#';

    public String encode(List<String> strings) {

        StringBuilder sb = new StringBuilder();

        for (String str : strings) {
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String string) {

        List<String> decodedStrings = new ArrayList<>();

        char[] charArray = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            while (charArray[i] != DELIMITER) {
                sb.append(charArray[i++]);
            }
            i++;

            int numOfChars = Integer.valueOf(sb.toString());
            int end = i + numOfChars;

            StringBuilder wordConstructor = new StringBuilder();
            while (i < end) {
                wordConstructor.append(charArray[i++]);
            }
            i--;
            decodedStrings.add(wordConstructor.toString());

        }

        return decodedStrings;

    }

    public static void main(String[] args) {
        Codec message = new Codec();
        String senderMessage = message.encode(new ArrayList<>(List.of("Bruno", "Aldrine", "Jacob")));
        var receiver = message.decode(senderMessage);
        for (var item : receiver) {
            System.out.print(item + " ");
        }
    }
}
