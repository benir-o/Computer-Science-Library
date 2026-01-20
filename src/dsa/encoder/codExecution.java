package dsa.encoder;

import java.util.*;

public class codExecution {
    public final char DELIMITER = '#';

    public String encoder(List<String> myStringList) {

        StringBuilder buildEncoder = new StringBuilder();

        for (String str : myStringList) {
            buildEncoder.append(str.length());
            buildEncoder.append(DELIMITER);
            buildEncoder.append(str);
        }
        return buildEncoder.toString();
    }

    public List<String> decoder(String messageString) {

        List<String> decodedList = new ArrayList<>();
        char[] characterList = messageString.toCharArray();

        for (int i = 0; i < characterList.length; i++) {
            StringBuilder buildDecoder = new StringBuilder();

            while (characterList[i] != DELIMITER) {
                buildDecoder.append(characterList[i++]);
            }
            i++;
            int numberOfCharacters = Integer.valueOf(buildDecoder.toString());
            int end = i + numberOfCharacters;
            StringBuilder toList = new StringBuilder();
            while (i < end) {
                toList.append(characterList[i++]);
            }
            i--;
            decodedList.add(toList.toString());

        }

        return decodedList;
    }

    public static void main(String[] args) {
        codExecution whatsApp = new codExecution();
        List<String> messages = new ArrayList<>();
        messages.add("Hello");
        messages.add("Benir");
        String securedMessage = whatsApp.encoder(messages);
        List<String> receiver = whatsApp.decoder(securedMessage);

        for (String str : receiver) {
            {
                System.out.print(str + " ");
            }
        }

    }

}
