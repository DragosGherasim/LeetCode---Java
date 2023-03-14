import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement3(nums));
    }

    public static int majorityElement1(int[] nums){ // first approach O(nlogn) time and O(1) space complexity
        Arrays.sort(nums);
        int count = 1;

        for(int i = 1; i < nums.length; ++i){
            if (nums[i-1] == nums[i]){
                count++;
            }
            else{
                count = 1;
            }

            if (count > nums.length/2){
                return nums[i];
            }
        }

        return 0;
    }

    public static int majorityElement2(int[] nums){ // O(n) time and O(n) space complexity
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count;

        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                count = hashMap.get(num) + 1;

                if (count > nums.length / 2) {
                    return num;
                } else {
                    hashMap.put(num, count);
                }
            } else {
                hashMap.put(num, 1);
            }
        }

        return 0;
    }

    public static int majorityElement3(int[] nums){ // O(n) time and O(1) space complexity
        int rez = nums[0], count = 1;

        for (int i = 1; i < nums.length; ++i){
            if (rez == nums[i]){
                ++count;
            }
            else{
                --count;
            }

            if (count < 0){
                rez = nums[i];
                count = 1;
            }
        }

        return rez;
    }
}
