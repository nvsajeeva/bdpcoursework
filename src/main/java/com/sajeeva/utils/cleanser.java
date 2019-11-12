package com.sajeeva.utils;
import java.util.HashMap;
import java.util.Map;

public class cleanser {



    public static Map<String, String> CSVToMap(String csv) {
        Map<String, String> map = new HashMap<>();
        try {


            String numdays = csv.split(",")[15];
            String key = "availability";
            map.put(key, numdays);


        } catch (StringIndexOutOfBoundsException e) {
            System.err.println(csv);
        }

        return map;
    }

}
