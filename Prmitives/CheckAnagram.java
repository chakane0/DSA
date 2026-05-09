package Prmitives;

public class CheckAnagram {
    public boolean areAnagrams(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] charCounts = new int[26]; // Assuming only lowercase letters

        for(int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for(int count : charCounts) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }


}
