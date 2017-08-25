/**
 * Created by hwangfantasy on 2017/8/25.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * 解题思路:
 * 我们要找到两个数组合并起来第k大的元素的话，
 * 我们可以先试想一种最特殊的情况，便于理解，
 * 就是A，B的前面各自占有的K/2全都是一样的，
 * 那么结果不就是(A[K/2]+B[K/2])/2吗?要是A[K/2] < B[K/2] ,
 * 画一个图理解马上就可以发现，两个数组合并之后，
 * 真正的第k大的元素应该在B[K/2]的左侧或者A[K/2]的右侧，
 * 我们可以吧A[K/2]左侧的元素(假设舍去了i个元素)舍去，
 * 因为全都是比k要小的元素。
 * 然后我们继续寻找剩下的数组中第(K-i)大的元素。
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        if ((m + n) % 2 == 0) {
            //偶数，找到第k/2个数和k/2+1个数的平均数
            double a = findKth(nums1, nums2, k / 2);
            double b = findKth(nums1, nums2, k / 2 + 1);
            System.out.println(a);
            System.out.println(b);
            return (findKth(nums1, nums2, k / 2) + findKth(nums1, nums2, k / 2 + 1)) / 2.0;
        } else
            //奇数，找到第k/2+1个数
            return findKth(nums1, nums2, k / 2 + 1);
    }

    public double findKth(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length)
            //保证入参中nums1是更少的数组
            return findKth(nums2, nums1, k);
        if (nums1.length == 0)
            //如果更小的数组为空,第K个数就是num2中的
            return nums2[k - 1];
        if (k == 1)
            //第一个数就是两个数组中最小的那一个
            return Math.min(nums1[0], nums2[0]);

        int i = Math.min(nums1.length, k / 2);
        int j = Math.min(nums2.length, k / 2);
        //如果一个数组的k/2 个值（此处的K/2为相对而言，因为如果一个数组长度不够，只能判断它的最大值）
        // 大余另一个数组的K/2个值，即可排除较小的一方的前k/2个值了
        if (nums1[i - 1] > nums2[j - 1]) {
            nums2 = copyArray(nums2, j);
            return findKth(nums1, nums2, k - j);
        } else {
            nums1 = copyArray(nums1, i);
            return findKth(nums1, nums2, k - i);
        }
    }

    /**
     * 把数组nums中的下标为start到最后的取出作为新的数组
     *
     * @param nums
     * @param start
     * @return
     */
    public int[] copyArray(int[] nums, int start) {
        int[] result = new int[nums.length - start];
        for (int i = start; i < nums.length; i++) {
            result[i - start] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
    }
}
