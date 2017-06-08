package won.algo.sort.simple;

public class InsertionSort {
	public static void TEST(int[] data){
		long s = System.currentTimeMillis();
		InsertionSort.sort(data);
		long e = System.currentTimeMillis();
		double elapsed = (e-s)/1000.0;
		System.out.println("InsertionSort: "+ elapsed);
	}
	public static void sort(int[] data){
		//int[] arr = {10,9,1,2,3,3};
		for(int i = 1; i < data.length; i++){
			int target = data[i];
			int indexToCompare = i-1;
			while(indexToCompare >= 0 && data[indexToCompare]>target){
				data[indexToCompare+1] = data[indexToCompare];
				indexToCompare--;
			}
			data[indexToCompare + 1] = target;
		}
		//System.out.println(arr[0]);
	}
}
