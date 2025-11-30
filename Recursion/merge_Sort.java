/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class merge_Sort
{
    public static void merge(int[] arr, int start,int end){
        int mid=start+(end-start)/2;
        int leftArraySize=mid-start+1;
        int rightArraySize=end-mid;
        //create left and right array
        int[] leftArray=new int[leftArraySize];
        int[] rightArray=new int[rightArraySize];
        
        //copy values from original array to left array
        int k=start;
        //k->starting idex of left array values in the original array
        for(int i=0;i<leftArraySize;i++){
            leftArray[i]=arr[k];
            k++;
        }
        //copy values to right array
        k=mid+1;
        for(int i=0;i<rightArraySize;i++){
                rightArray[i]=arr[k];
                k++;
        }
        
        //actual merge logic here
        //left array is already sorted
        //right array is already sorted
        
        // leftArrayIndex -> created this to traverse in the left array
        int leftArrayIndex=0;
        // rightArrayIndex -> created this to traverse in the right array
        int rightArrayIndex=0;
        // mainArrayIndex -> created this to traverse in the main array
        int mainArrayIndex=start;
        
        while(leftArrayIndex<leftArraySize && rightArrayIndex<rightArraySize){
            if(leftArray[leftArrayIndex]<rightArray[rightArrayIndex]){
                arr[mainArrayIndex]=leftArray[leftArrayIndex];
                mainArrayIndex++;
                leftArrayIndex++;
            }
            else{
                arr[mainArrayIndex]=rightArray[rightArrayIndex];
                mainArrayIndex++;
                rightArrayIndex++;
            }
        }
        
        //2 more cases
        // case 1 left array is exhausted and elements are still pending in the right array
        while(rightArrayIndex<rightArraySize){
            arr[mainArrayIndex]=rightArray[rightArrayIndex];
            mainArrayIndex++;
            rightArrayIndex++;
        }
        // case 2 right array is exhausted and elements are still pending in the left array
        while(leftArrayIndex<leftArraySize){
            arr[mainArrayIndex]=leftArray[leftArrayIndex];
            mainArrayIndex++;
            leftArrayIndex++;
        }
        
    }
        
    public static void mergeSort(int[] arr, int start,int end){
        //base condition
        if(start>=end){
            return;
        }
        //break
        int mid=start+(end-start)/2;
        //recursive call for leftarray
        mergeSort(arr,start,mid);
        //recurive call for righrarray
        mergeSort(arr,mid+1,end);
        //merge two sorted Array
        merge(arr,start,end);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] arr={2,1,6,9,4,5};
		int size=6;
		int start=0;
		int end=size-1;
		
		System.out.println("-------------Before Sorting-------------");
		for(int i=0;i<arr.length;i++){
		    System.out.print(arr[i]+" ");
		}
		mergeSort(arr,start,end);
		System.out.println();
		System.out.println("-------------After Sorting-------------");
		for(int i=0;i<arr.length;i++){
		    System.out.print(arr[i]+" ");
		}
	}
}