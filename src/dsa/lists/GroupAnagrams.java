package dsa.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAns(String[] strs) {
        Map<String, List<String>> sortedToList = new HashMap<>();

        for (var word : strs) {

            String sortedWordString = sortThisWord(word);
            sortedToList.putIfAbsent(sortedWordString, new ArrayList());
            sortedToList.get(sortedWordString).add(word);

        }
        System.out.println(convertList(sortedToList));

        return convertList(sortedToList);

    }

    private String sortThisWord(String string) {
        char[] myCharacters = string.toCharArray();
        Arrays.sort(myCharacters);
        return new String(myCharacters);
    }

    private List<List<String>> convertList(Map<String, List<String>> toBeConverted) {
        List<List<String>> resultantList = new ArrayList<>();

        for (List<String> anagramStrings : toBeConverted.values()) {
            resultantList.add(anagramStrings);
        }
        return resultantList;
    }

    public static void main(String[] args) {
        GroupAnagrams twentyOne = new GroupAnagrams();
        String[] strs = { "cat", "tac", "man", "nam", "elf", "elfie" };

        twentyOne.groupAns(strs);
    }
}
