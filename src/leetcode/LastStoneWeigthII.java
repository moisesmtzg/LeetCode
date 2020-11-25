package leetcode;

import java.util.Arrays;

public class LastStoneWeigthII {

	public int lastStoneWeightII(int[] stones) {

		//si solo hay una piedra el resultado es la piedra
		if(stones.length == 1) {
			return stones[0];
		}

		Arrays.sort(stones);
		int apuntador1 = stones.length-1;
		int apuntador2 = apuntador1-1;

		while(apuntador2 >= 0 && apuntador1 >= 0) {
			if(stones[apuntador2] < stones[apuntador1]) {
				int res = stones[apuntador1] - stones[apuntador2];
				stones[apuntador1] = 0;
				stones[apuntador2] = res;
				apuntador1--;
				apuntador2--;
			}else if(stones[apuntador2] == stones[apuntador1]) {
				stones[apuntador1] = 0;
				stones[apuntador2] = 0;
				apuntador2--;
				apuntador1 = apuntador2-1;
				
			}else if(stones[apuntador2] > stones[apuntador1] && stones[apuntador1] != 0) {
				int aux = stones[apuntador2]; 
				stones[apuntador2] = stones[apuntador1];
				stones[apuntador1] = aux;
			}
		}
		return stones[0];
		
    }
}
