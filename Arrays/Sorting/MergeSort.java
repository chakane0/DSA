package Arrays.Sorting;
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3, 7, 5, 1, 10, 0, 7, 4, 2, 8, 6, 9 };
        mergeSort(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int [] nums) {
        if(nums.length <= 1) return;

        int midPoint = nums.length /2;

        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[nums.length - midPoint];

        int i = 0; // left array
        int j = 0; // right array

        for(; i < nums.length; i++) {
            if( i < midPoint) {
                leftArray[i] = nums[i];
            } else {
                rightArray[j] = nums[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, nums);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, L = 0, R = 0;

        while(L < leftSize && R < rightSize) {
            if(leftArray[L] < rightArray[R]) {
                array[i] = leftArray[L];
                i++;
                L++;
            } else {
                array[i] = rightArray[R];
                i++;
                R++;
            }
        }

        while(L < leftSize) {
            array[i] = leftArray[L];
            i++;
            L++;
        }

        while(R < rightSize) {
            array[i] = rightArray[R];
            i++;
            R++;
        }
    }
}
