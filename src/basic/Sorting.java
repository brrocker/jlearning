package basic;

import java.util.Arrays;

public class Sorting {
	public void selectSort(int[] arr){
		int length = arr.length;
		for(int i=0;i<length;i++) {
			int min=i;
			for(int j=i+1;j<length;j++){
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			
			//Put min element to the left
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
		Ut.pt(Arrays.toString(arr));
	}
	
	public void quickSort(int[] arr) {
		int right = arr.length;
		doQuickSort(arr, 0, arr.length-1);
		Ut.pt("----result----"+Arrays.toString(arr));
	}
	
	private void doQuickSort(int[] arr, int left, int right) {
		if(left >= right) {
			//Sort all done
			return;
		}
		
		int key = arr[right];
		int low = left;
		int high = right - 1;
		
		while(true) {
			while(arr[low] < key) {
				low++;
			}
			
			while(arr[high] > key && high > left) {
				high--;
			}
			
			
			if(low < high){
				//Switch Position
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			} else {
				//Shift back 1 position
				if(high<low)high++;
				
				//Sort Complete, put key in the right position
				arr[right] = arr[high];
				arr[high] = key;
				break;
			}
		}
		Ut.pt("key:"+key+",low:"+low+",high:"+high+",left:"+left+",right"+right);
		Ut.pt(Arrays.toString(arr));
		
		doQuickSort(arr, left, high-1);
		doQuickSort(arr, high+1, right);
			
	}
	
	public int[] getIntArray(int count) {
		int[] arr = new int[count];
		for(int i=0;i<count;i++){
			arr[i] = (int)(Math.random()*100);
		}
		
		Ut.pt(Arrays.toString(arr));
		return arr;
	}
}
