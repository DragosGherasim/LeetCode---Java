public class Solution {
    public static void main(String[] args){
        int[] nums1 = {2, 4, 5, 0, 0};
        int[] nums2 = {1, 3};

        merge(nums1, 3, nums2, 2);

        for (int i = 0; i < 5; ++i){
            System.out.print(nums1[i] + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;

        while (n > 0 && m > 0){
            if (nums1[m-1] > nums2[n-1]){
                nums1[last] = nums1[m-1];
                m = m-1;
            }
            else{
                nums1[last] = nums2[n-1];
                n = n-1;
            }

            last = last-1;
        }

        while (n > 0){
            nums1[last] = nums2[n-1];
            last = last-1;
            n = n-1;
        }
    }
}
