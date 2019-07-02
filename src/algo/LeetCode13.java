package algo;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {

/*    private final static Map<String, Integer> romanMapping = new HashMap();
    static {
        romanMapping.put("I", 1);
        romanMapping.put("IV", 4);
        romanMapping.put("V", 5);
        romanMapping.put("IX", 9);
        romanMapping.put("X", 10);
        romanMapping.put("XL", 40);
        romanMapping.put("L", 50);
        romanMapping.put("XC", 90);
        romanMapping.put("C", 100);
        romanMapping.put("CD", 400);
        romanMapping.put("D", 500);
        romanMapping.put("CM", 900);
        romanMapping.put("M", 1000);
    }*/

    public static void main(String[] args) {
        System.out.println(new LeetCode13().romanToInt("D"));
    }

/*    public int romanToInt(String s) {
        final char[] chars = s.toCharArray();
        if(chars.length == 1)
            return romanMapping.get(""+chars[0]);
        int i= 0, result=0;
        while(i < chars.length) {
            if(i+1 < chars.length && romanMapping.containsKey(""+chars[i]+chars[i+1])) {
                result += romanMapping.get(""+chars[i]+chars[i+1]);
                i+=2;
            }
            else if(romanMapping.containsKey(""+chars[i])) {
                result += romanMapping.get(""+chars[i]);
                i+=1;
            }
        }
        return result;
    }*/

    public int romanToInt(String s) {
        final char[] chars = s.toCharArray();
        if(chars.length == 1)
            return romanToDec(""+chars[0]);
        int i= 0, result=0;
        while(i < chars.length) {
            if(i+1 < chars.length && romanToDec(""+chars[i]+chars[i+1]) != 0) {
                result += romanToDec(""+chars[i]+chars[i+1]);
                i+=2;
            } else{
                result += romanToDec(""+chars[i]);
                i+=1;
            }
        }
        return result;
    }

    private int romanToDec(String roman) {
        switch (roman) {
            case "I": return 1;
            case "IV": return 4;
            case "V": return 5;
            case "IX": return 9;
            case "X": return 10;
            case "XL": return 40;
            case "L": return 50;
            case "XC": return 90;
            case "C": return 100;
            case "CD": return 400;
            case "D": return 500;
            case "CM": return 900;
            case "M": return 1000;
            default: return 0;
        }
    }
}
