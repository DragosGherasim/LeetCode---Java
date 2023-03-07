import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted(words, order) ? "true" : "false");
    }

    public static boolean isAlienSorted(String[] words, String order){ // O(n)
        Map<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < order.length(); ++i){
            hashMap.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length-1; ++i){
            for(int j = 0; j < words[i].length(); ++j){
                if (j == words[i+1].length()) {
                    return false;
                }
                else if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    if (hashMap.get(words[i].charAt(j)) > hashMap.get(words[i+1].charAt(j))){
                        return false;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return true;
    }
}
