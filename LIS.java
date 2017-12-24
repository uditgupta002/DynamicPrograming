import java.util.*;
import java.lang.*;
import java.io.*;

class LIS {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int testCases = Integer.parseInt(br.readLine());
	    for(int t = 0;t<testCases;t++){
	        int length = Integer.parseInt(br.readLine());
	        String tempArr[] = br.readLine().split(" ");
	        int arr[] = new int[length];
	        for(int i=0;i<length;i++)
	            arr[i] = Integer.parseInt(tempArr[i]);
	            
	        if(length == 0)
	            System.out.println(0);
	        else
	            System.out.println(findLis(arr));
	        
	    }
	    
	}
	
	
	public static int findLis(int[] arr){
	    
	    int testArr[] = new int[arr.length];
	    int max = 1;
	    Arrays.fill(testArr,1);
	    for(int i=0;i<arr.length;i++){
	        for(int j=0;j<=i;j++){
	            if(arr[j] < arr[i] && testArr[j]+1 > testArr[i]){
	                testArr[i] = testArr[j]+1;
	                if(testArr[i] > max)
	                    max = testArr[i];
	            }
	        }
	    }
	    return max;
	}
}
