package dsa.encoder;

import java.util.*;

public class encoder {

    private final char DELIMITATION = '#';

    public String encodeMessage(List<String> listOfStrings) {
        StringBuilder sb = new StringBuilder();
        for (var word : listOfStrings) {
            sb.append(word.length());
            sb.append(DELIMITATION);
            sb.append(word);
        }
        return sb.toString();
    }

    public List<String> decodeMessage(String cryptographicString) {

        char[] letters = cryptographicString.toCharArray();
        List<String> decodedStrings = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            StringBuilder decode = new StringBuilder();
            while (letters[i] != DELIMITATION) {
                decode.append(letters[i]);
                i++;
            }
            i++;
            int wordLength = Integer.valueOf(decode.toString());
            int endLength = i + wordLength;
            StringBuilder buildWord = new StringBuilder();

            while (i < endLength) {
                buildWord.append(letters[i]);
                i++;
            }
            i--;

            decodedStrings.add(buildWord.toString());
        }

        return decodedStrings;
    }

    public static void main(String[] args) {
        encoder whatsApp = new encoder();
        String internetTransfer = whatsApp.encodeMessage(new ArrayList<>(List.of("Arsenal", "Liverpool")));
        List<String> receivedMessage = whatsApp.decodeMessage(internetTransfer);
        for (String word : receivedMessage) {
            System.out.print(word + " ");
        }

    }
}
