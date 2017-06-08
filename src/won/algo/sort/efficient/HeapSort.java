package won.algo.sort.efficient;

/**
 * Much more efficient version of selection sort.
 * It uses data structure, HEAP(a special type of binary tree)
 * Time complexity of O(n log n) - worst case
 * @author wonk
 * 
 *
 */
public class HeapSort {
	public static void TEST(int[] data){
//		int[] data = {6,5,3,1,8,7,2,4};
		int size = 100;
		if(data==null){
			data = new int[size];
			for(int i = 0; i < size; i++){
				data[i] = (int)(Math.random()*size);
			}
		}

		long s = System.currentTimeMillis();
		HeapSort.sort(data);
		long e = System.currentTimeMillis();
		if(data.length<=1000){
			for(int i = 0; i < data.length; i++){
				System.out.print(data[i] + " ");
			}
			System.out.println("");
		}
		double elapsed = (e-s)/1000.0;
		System.out.println("HeapSort: "+ elapsed);
	}
	public static void sort(int[] data){
		//HeapSort.repairHeap(data, 0, data.length-1);
		HeapSort.buildHeap(data);
		int end = data.length-1;
		while(end>0){
			HeapSort.swap(data, 0, end);
			end--;
			HeapSort.repairHeapDown(data, 0, end);
		}
	}
	private static void buildHeap(int[] data){
		int[] heap = new int[data.length];
		for(int i = 0; i < data.length; i++){
			heap[i] = data[i];
			repairHeapUp(heap, 0, i);
		}
		System.arraycopy(heap, 0, data, 0, data.length);
	}
	private static void repairHeapUp(int[] data, int start, int end){
		int parentNode = 0;
		int parentInd = 0;
		
		int tmpStart = start;
		int tmpEnd = end;
		while(tmpStart<tmpEnd){
			parentInd = (tmpEnd-1)/2;
			parentNode = data[parentInd];
			if(parentNode<data[tmpEnd]){
				data[parentInd] = data[tmpEnd];
				data[tmpEnd] = parentNode;
			}else{
				break;
			}
			tmpEnd = parentInd;
		}
	}
	private static void repairHeapDown(int[] data, int start, int end){
		int parentNode = 0;
		int leftChildNode = 0;
		int leftChildInd = 0;
		int rightChildNode = 0;
		int rightChildInd = 0;
		int tmpStart = start;

		leftChildInd = 2*tmpStart+1;
		rightChildInd = 2*tmpStart+2;
		if(end==0){
			parentNode = data[tmpStart];
			leftChildNode = data[leftChildInd];
			if(leftChildNode<parentNode){
				HeapSort.swap(data, tmpStart, leftChildInd);
			}
			return;
		}
		
		while(tmpStart<=end && leftChildInd <= end && rightChildInd <= end){
			parentNode = data[tmpStart];
			leftChildNode = data[leftChildInd];
			rightChildNode = data[rightChildInd];
			if(leftChildNode>parentNode || rightChildNode>parentNode){
				if(leftChildNode>=rightChildNode){
					data[tmpStart] = data[2*tmpStart+1];
					data[2*tmpStart+1] = parentNode;
					tmpStart = 2*tmpStart+1;
				}else if(leftChildNode<rightChildNode){
					data[tmpStart] = data[2*tmpStart+2];
					data[2*tmpStart+2] = parentNode;
					tmpStart = 2*tmpStart+2;
				}
			}else{
				break;
			}
			leftChildInd = 2*tmpStart+1;
			rightChildInd = 2*tmpStart+2;
		}
	}
	private static void swap(int[] data, int start, int end){
		int tmp = data[start];
		data[start] = data[end];
		data[end] = tmp;
	}
}
