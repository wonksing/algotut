package won.algo.sort.efficient;

public class MergeSort {
	public static void TEST(int[] data){
		int size = 100;
		if(data==null){
			data = new int[size];
			for(int i = 0; i < data.length; i++){
				data[i] = (int)(Math.random()*size);
			}
		}
//		for(int i = 0; i < data.length; i++){
//			System.out.print(data[i] + " ");
//		}
//		System.out.println("");
		//MergeSort.merge(data, 0, data.length/2, data.length-1);
		long s = System.currentTimeMillis();
		MergeSort.sort(data, 0, data.length-1);
		long e = System.currentTimeMillis();
		if(data.length<=1000){
			for(int i = 0; i < data.length; i++){
				System.out.print(data[i] + " ");
			}
			System.out.println("");
		}
		double elapsed = (e-s)/1000.0;
		System.out.println("MergeSort: "+ elapsed);
	}

	public static void sort(int[] data, int left, int right){
		if(right-left < 1) {
			return;
		}
		int mid = 0;
		if(left < right){
			mid = (left+right)/2;
		}
		MergeSort.sort(data, left, mid);
		MergeSort.sort(data, mid+1, right);
		MergeSort.merge(data, left, mid, right);
	}

	public static void merge(int[] data, int left, int mid, int right){
		
		int tempLeft = left;
		int tempRight = mid+1;
		int cnt = right-left+1;

		int result[] = new int[cnt];
		int ri = 0;
		for(int i = left; i <= right; i++){
			if(tempLeft <= mid && (tempRight>right || data[tempLeft] <= data[tempRight])){
				result[ri++] = data[tempLeft++];
			}else{
				result[ri++] = data[tempRight++];
			}
		}
		
		System.arraycopy(result, 0, data, left, cnt);
	}
	
	public static void sort_v1(int[] data, int left, int right){
		if(right-left < 1) {
			return;
		}
		int mid = 0;
		if(left < right){
			mid = (left+right)/2;
		}
		MergeSort.sort_v1(data, left, mid);
		MergeSort.sort_v1(data, mid+1, right);
		MergeSort.merge_v1(data, left, mid, right);
	}
	public static void merge_v1(int[] data, int left, int mid, int right){
		
		int result[] = new int[data.length];
		int ri = 0;
		

		int tempLeft = left;
		int tempRight = mid+1;
		int cnt = right-left+1;
//		int cnt = data.length;
		int attempt = 0;
		while(attempt < cnt){
			if(tempRight<=right && tempLeft <= mid){
				if(data[tempLeft] <= data[tempRight]){
					result[ri++] = data[tempLeft++];
				}else{
					result[ri++] = data[tempRight++];
				}
			}else if(tempRight>right && tempLeft<=mid){
				result[ri++] = data[tempLeft++];
			}else if(tempRight<=right && tempLeft>mid){
				result[ri++] = data[tempRight++];
			}else{
				break;
			}
			attempt++;
		}
		
		System.arraycopy(result, 0, data, left, cnt);
	}
}
