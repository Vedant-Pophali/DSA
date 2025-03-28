package String;

import java.util.ArrayList;
import java.util.Arrays;

public class KeyBoardRows {
    public static String[] findWords(String[] words) {
        ArrayList<String> ans=new ArrayList<>();
        String first = "qwertyuiop";
        String Secound ="asdfghjkl";
        String Third="zxcvbnm";
        for(String i : words){
            if(isinrow(i,first) || isinrow(i,Secound) || isinrow(i,Third))
                ans.add(i);
        }
        return ans.toArray(new String[0]);
    }
    private static boolean isinrow(String s,String row){
        for(char c:s.toCharArray()){
            if(row.indexOf(Character.toLowerCase(c))==-1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[][] testCases = {
                {"Hello", "Alaska", "Dad", "Peace"},
                {"row", "top", "moon", "pop"},
                {"qwe", "zxc", "asd", "mnb"},
                {"type", "trouble", "pink", "flow"},
                {"QWERTY", "zxcv", "mnbvcxz", "poiu"}
        };

        for (String[] testCase : testCases) {
            System.out.println("Input: " + Arrays.toString(testCase));
            System.out.println("Output: " + Arrays.toString(findWords(testCase)));
            System.out.println();
        }
    }
}
