package letcode2026;

public class RemoveElement {
    public static int removeElement(int[] nums, int val){
        int size = nums.length;
        if (size == 0) return 0;
        int p1 = 0;
        int p2 = size-1;

        while(p1 <= p2){
            if(nums[p1] != val){
                p1++;
            }else if(nums[p2] == val){
                p2--;
            }else if(nums[p1] == val && nums[p2] != val){
                int aux = nums[p2];
                nums[p1] = aux;
                nums[p2] = val;
                p1++;
                p2--;
            }
        }
        return p1;
    }

    public static void main(String[] args){
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
    }
}
