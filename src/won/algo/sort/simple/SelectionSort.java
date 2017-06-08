package won.algo.sort.simple;

public class SelectionSort {
	public static void TEST(int[] data){
		long s = System.currentTimeMillis();
		SelectionSort.sort(data);
		long e = System.currentTimeMillis();
		double elapsed = (e-s)/1000.0;
		System.out.println("SelectionSort: "+ elapsed);
	}
	public static void sort(int[] data){
//		int arr[] = {10,9,1,2,3,3};
		int size = data.length;
		int minInd = 0;
		int temp = 0;
		for(int i = 0; i < size-1; i++){
			minInd = i;
			for(int j = i+1; j < size; j++){
				if(data[minInd]>data[j]){
					minInd = j;
				}
			}
			temp = data[minInd];
			data[minInd] = data[i];
			data[i] = temp;
		}
//		System.out.println(data[0]);
	}
}
