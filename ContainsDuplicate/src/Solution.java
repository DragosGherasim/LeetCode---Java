import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4};

        System.out.println(containsDuplicate(nums) ? "true" : "false");
    }

    private static boolean containsDuplicate(int[] nums){ // O(n)
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; ++i){
            if (hashMap.get(nums[i]) != null){
                return true;
            }

            hashMap.put(nums[i], i);
        }

        return false;
    }
}
