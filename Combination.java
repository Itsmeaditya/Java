import java.io.*; 
import java.util.*;

class Combination {    
    static String flag = "No";
    static void getCombinationSum(int arr[], int data[], int start, 
                                int end, int index, int r,int targetSum) 
    { 
        if (index == r) 
        { 
        	int sum = 0;
            for (int j=0; j<r; j++)
            {
            	sum = sum+ data[j];
            }
            if( sum == targetSum)
            {
            	flag = "Yes";
            	return;
            }
            return; 
        } 
  
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            getCombinationSum(arr, data, i+1, end, index+1, r,targetSum); 
        } 
    } 
   
    static void printCombination(int arr[], int n, int r,int targetSum) 
    { 
        int data[]=new int[r]; 
        getCombinationSum(arr, data, 0, n-1, 0, r,targetSum); 
    } 
  
    public static void main (String[] args) { 
        int arr[] = {5,3,2};
        int n = arr.length; 
        int targetSum =7;
        for(int i=0;i<arr.length;i++)
        {
        	printCombination(arr, n, i+1,targetSum);
        }
        if( flag == "Yes")
    		System.out.println("Yes");
    	else
    		System.out.println("No");
        
    } 
}
