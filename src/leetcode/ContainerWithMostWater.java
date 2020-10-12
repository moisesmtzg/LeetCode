package leetcode;

public class ContainerWithMostWater {

	public int maxArea(int [] height) {
		//si height no tiene valores o esta vacia el max area sea 0
		if(height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0, low = 0, max = height.length-1;
		
		while(low < max) {
			//tenemos que tomar la altura mas chica
			// Se puede usar tmb Integer.min en lugar del ?:
			int altura = (height[max] > height[low])? height[low] : height[max];
			
			//base * altura
			int area = (max - low) * altura;
			
			//comparamos cual area es mas grande, si la maxArea o la area que calculamos
			//si la area es mas grande, esta sera la nueva maxArea
			maxArea = Integer.max(maxArea, area);
			
			if(height[max] >= height[low]) {
				low++;
			}else {
				max--;
			}
		}
		return maxArea;
	}
}
