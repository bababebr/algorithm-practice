package org.example.leet75.arraysString;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        String[] splitString = s.trim().replaceAll("\\s+", " ").split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = splitString.length - 1; i >= 0 ; i--) {
            sb.append(splitString[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
