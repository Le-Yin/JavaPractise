package algo;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 **/

public class LeetCode709 {
    public static void main(String[] args) {
        String s = "azAZ";
        System.out.println(new LeetCode709().toLowerCase(s));
    }
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        str.chars().forEachOrdered(i -> sb.append(charLowerCase(i)));
        return sb.toString();
    }

    private char charLowerCase(int i) {
        if(i >= 65 && i <= 90)
            return (char)(i+32);
        return (char)i;
    }
}
