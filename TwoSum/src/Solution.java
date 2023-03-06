import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] arr;

        //arr = TwoSumOn2(nums, target); // O(n^2)
        //arr = TwoSumNLogN(nums, target); // O(n*logn)
        arr = TwoSumN(nums, target);

        for(int i = 0; i < arr.length; ++i)
            System.out.printf("%d ", arr[i]);
    }

    public static int[] TwoSumOn2(int[] nums, int target){
        int[] indx = new int[2];
        boolean find = false;

        for(int i = 0; i < nums.length - 1; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                if (nums[i] + nums[j] == target){
                    indx[0] = i;
                    indx[1] = j;

                    find = true;
                }

                if (find == true){
                    break;
                }
            }
            if (find == true){
                break;
            }
        }

        return indx;
    }

    public static int[] TwoSumNLogN(int[] nums, int target){
        int[] indx = new int[2];
        boolean find = false;

        int[] tempNums = nums.clone();
        Arrays.sort(nums); // O(n*logn)

        for(int i = 0; i < nums.length - 1 && nums[i] <= target && find == false; ++i){ // O(n*logn)
            int newTarget = target - nums[i];

            int low = i+1, high = nums.length - 1;

            while(low <= high){ // O(logn)
                int mid = (low + high) / 2;

                if (nums[mid] == newTarget){
                    indx[0] =  nums[i];
                    indx[1] = nums[mid];
                    find = true;
                    break;
                }
                else if (nums[mid] < newTarget) {
                    low = mid + 1;
                }
                else{
                    high = mid;
                }
            }
        }

        int c = 0;
        for (int i = 0; i < tempNums.length; ++i){
            if (tempNums[i] == indx[0] || tempNums[i] == indx[1]){
                indx[c++] = i;
            }
        }
        return indx;
    }

    public static int[] TwoSumN(int[] nums, int target){
        Map<Integer, Integer> hashTable = new HashMap<>();

        for(int i = 0; i < nums.length && nums[i] <= target; ++i) { // O(n)
            int newTarget = target - nums[i];

            if (hashTable.containsKey(newTarget)) { // O(1)
                return new int[]{hashTable.get(newTarget), i};
            }

            hashTable.put(nums[i], i);
        }

        return null;
    }
}
