package demo.myfirst.example.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
* Simple example class to show amount of hashCode collisions in Strings.
*
* TODO: Make the number of characters and the character set to be more
* configurable
*
* @author Michael Stummvoll
*/
public class HashCodeCollision {
  public static void main(String[] args) {
    Map<Integer, List<String>> hashMap = new HashMap<>();

    String str = "abcdefghijklmnopqrstuvwxyz";
    str += str.toUpperCase();
    for (char c1 : str.toCharArray()) {
      for (char c2 : str.toCharArray()) {
        // for (char c3 : str.toCharArray()) {
        String s = c1 + "" + c2; // + "" + c3;
        int code = s.hashCode();
        if (!hashMap.containsKey(code)) {
          hashMap.put(code, new ArrayList<String>());
        }

      hashMap.get(code).add(s);
      // }
    }
  }

  int collisions = 0;
  int max = 0;
  List<String> maxList = null;
  for (Entry<Integer, List<String>> e : hashMap.entrySet()) {
    List<String> l = e.getValue();
    if (l.size() > max) {
      max = l.size();
      maxList = l;
    }

    if (l.size() > 1) {
      System.out.println("Collision: " + l);
      ++collisions;
    }
  }

  System.out.println("collisions found: " + collisions);
  System.out.println("biggest collision: " + maxList);
  }
}