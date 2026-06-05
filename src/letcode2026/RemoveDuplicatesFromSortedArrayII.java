package letcode2026;

public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums){
        return 0;
    }

    public static void main(String[] args){
    }
}

/*
    [1, 1, 1, 2, 2, 3]
           i
           d
   1a iniciamos i y d en 2
   0   1  2  3  4  5
   [1, 1, 1, 2, 2, 3]
          i
          d
    nums[d] != nums[i-2] => 1 != 1 no, avanzamos d

    2a
       0   1  2  3  4  5
       [1, 1, 1, 2, 2, 3]
              i
                 d
    nums[d] != nums[i-2] => 2 != 1 si, cambiamos valor de nums[i] por nums[d] y movemos apuntadores

        0   1  2  3  4  5
        [1, 1, 2, 2, 2, 3]
                  i
                     d
    3a  nums[d] != nums[i-2] => 2 != 1 si, cambiamos valor de nums[i] por nums[d] y movemos apuntadores (no se ve pq cambiamos 2 con 2)

        0   1  2  3  4  5
        [1, 1, 2, 2, 2, 3]
                     i
                        d

    4a  nums[d] != nums[i-2] => 3 != 2 si, cambiamos valor de nums[i] por nums[d] y movemos apuntadores
        0   1  2  3  4  5
        [1, 1, 2, 2, 3, 3]
                        i
                        d
    5a d ya es igual al tama~no, regresamos i
 */