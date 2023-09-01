package org.example.leet75.arraysString;

public class MergeWords {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int totalLength = word1.length() + word2.length();
        for(int i = 0; i < totalLength; i++) {
            if(i < word1.length()){
                sb.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }
}
