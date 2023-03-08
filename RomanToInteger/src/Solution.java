import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String num = input.nextLine();

        System.out.println(romanToInt(num));
    }

    public static int romanToInt(String s){
        Map<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int num = 0, value;

        for (int i=s.length()-1; i > -1; --i){
            value = hashMap.get(s.charAt(i));

            if (value * 4 < num){ // numerals jump in value by increments of at least 5x (only IV, XL, CM are available)
                num -= value;
            }
            else{
                num += value;
            }
        }

        return num;
    }
}
