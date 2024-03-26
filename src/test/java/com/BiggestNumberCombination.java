package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BiggestNumberCombination {

    public static void main(String args[]) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        String str = "143dja321kk5vas";
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
                int value = Character.getNumericValue(c);
                num.add(value);

            }
        }


        System.out.println(num);
        Set<Integer> hs = new HashSet<Integer>();
        hs.addAll(num);
        num.clear();
        num.addAll(hs);

        Collections.reverse(num);
        System.out.println(num);
        System.out.println(num.get(num.size() - 1));

        String listString = "";

        for (Integer s : num) {
            listString += s;
        }

        System.out.println(listString);


        int max=0;
        String input = "143dja321kk5vas";
        ArrayList<Integer> nums = new ArrayList<>();
        String[] elements = input.split("[^0-9]+");
        for (String element : elements) {
            //skip empty elements, see note
            if (element.isEmpty()) {
                continue;
            }
            nums.add(Integer.parseInt(element));


        }
        System.out.println(nums);
        Integer maxv = Collections.max(nums);
        System.out.println(maxv);

    }
}
