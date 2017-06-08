package won.algo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import getTemp.RssReadTemp;
import won.algo.sort.efficient.HeapSort;
import won.algo.sort.efficient.MergeSort;
import won.algo.sort.simple.InsertionSort;
import won.algo.sort.simple.SelectionSort;



public class AlgoMain {
	
	// 알고리듬 문제 1
	public static int getLastComp(BigDecimal a, BigDecimal b, int noOfComp){
		if(a.intValue()==1 || b.intValue()==0){
			return 1;
		}
		if(a.intValue()==0){
			return 0;
		}
		int firstDigitMap[][] = {{10,10,10,10}
								, {1,1,1,1}
								, {2,4,8,6}
								, {3,9,7,1}
								, {4,6,4,6}
								, {5,5,5,5}
								, {6,6,6,6}
								, {7,9,3,1}
								, {8,4,2,6}
								, {9,1,9,1}};
		//BigDecimal tmp = b.divide(new BigDecimal(4));
		int mapX = a.intValue()%10;
		int mapY = b.intValue()%4;
	 	if(mapY == 0){
	 		mapY = 3;
	 	}else{
	 		mapY--;
	 	}
	 	//System.out.println(firstDigitMap[mapX][mapY]);
	 	return firstDigitMap[mapX][mapY];
	}
	
	public static void main(String[] args) {

		for(int tries = 0; tries < 100; tries++){
			int size = 100000;
			int[] data = new int[size];
			int[] baseData = new int[size];
			for(int i = 0; i < size; i++){
				data[i] = (int)(Math.random()*size);
				baseData[i] = data[i];
			}
			System.arraycopy(baseData, 0, data, 0, size);
			InsertionSort.TEST(data);
			
			System.arraycopy(baseData, 0, data, 0, size);
			SelectionSort.TEST(data);
			
			System.arraycopy(baseData, 0, data, 0, size);
			MergeSort.TEST(data);
			
			System.arraycopy(baseData, 0, data, 0, size);
			HeapSort.TEST(data);
		}
		

		// TODO Auto-generated method stub
		
//		String[][] temp = new RssReadTemp().getTemp();
//		for(int i = 0; i<temp[0].length; i++){
//			
//		}
		
		//jsonTest();
		
//		int a = 9;
//		for(int i = 0; i < 100; i++){
//			System.out.println(String.valueOf(a)+"^"+String.valueOf(i)+"="+getLastComp(new BigDecimal(String.valueOf(a)), new BigDecimal(String.valueOf(i)), 10));
//		}
		
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("0"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("1"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("2"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("3"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("4"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("5"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("6"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("7"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("8"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("9"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("10"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("11"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("12"), 10));
//		System.out.println(getLastComp(new BigDecimal("2"), new BigDecimal("13"), 10));
		System.exit(0);
//		
//		BigDecimal a = new BigDecimal("11.0");
//		BigDecimal b = new BigDecimal("1000000.0");
//		BigDecimal t = a;
//				
//		MathContext mc = new MathContext(4);
//		/*try{
//			BigDecimal t = a.pow(10000, mc);
//			System.out.println(t);
//		}catch(Exception e){
//			e.printStackTrace();
//		}*/
//
//		System.out.println(t.toBigIntegerExact());
//		for(int i = 0; i < 12; i++){
//			t = t.multiply(a);
//			System.out.println(t.toBigIntegerExact());
//		}
//		//System.out.println(t.toBigIntegerExact());
	}

}
