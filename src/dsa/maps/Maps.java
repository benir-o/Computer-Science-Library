package dsa.maps;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        // A map is a set of key value pairs
        HashMap<String, Integer> empIDs = new HashMap<>();
        empIDs.put("John", 12);
        empIDs.put("Carl", 463);
        empIDs.put("Jerry", 849);

        System.out.println(empIDs);
        // To retrieve a value from the map
        System.out.println(empIDs.get("Carl"));
    }

}
