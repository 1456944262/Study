/**
 * Copyright(C),2015‐2020,北京清能互联科技有限公司
 * Author:yangjin
 * Date:2020/11/2419:08
 * History:
 * <author> <time> <version> <desc>
 */
package 快速选择排序;

/**
 * Description: <br>
 *
 * @author yangjin
 * @create 2020/11/24
 * @since 1.0.0
 */
public class Sort {

    public  static int findKthLarges(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,k);
    }

    public static int quickSelect(int nums[], int low, int high,int k) {
        int pivot = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
               swap(nums,pivot++,j);
            }
        }
        swap(nums,pivot,high);
        int count = high-pivot+1;
        if(count == k){return nums[pivot];}
        if(count>k){return quickSelect(nums,pivot+1,high,k);}
        return quickSelect(nums,low,pivot-1,k-count);
    }


    public static void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }


    public static void main(String[] args) {
        int [] nums = {1,4,7,10,8,3,6};
        int kthLarges = findKthLarges(nums, 1);
        System.out.println(kthLarges);
    }

}