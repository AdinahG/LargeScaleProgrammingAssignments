package org.howard.edu.lsp.finalexam;

import java.util.HashMap;

public class MapUtilities {
public static int CommonKeyValuePairs {
	 HashMap<String, String> map1,
     HashMap<String, String> map2
) throws NullMapException {
 int count = 0;

 if(map1.isEmpty() || map2.isEmpty()) {
     throw new NullMapException("One or both maps are null!");
 }

 for (Map.Entry<String, String> keyValue : map1.entrySet()) {
     if (map2.containsKey(keyValue.getKey())) {
         count++;
     }
     if(map2.containsValue(keyValue.getValue())) {
         count++;
     }
 }
 return count;
}
}
