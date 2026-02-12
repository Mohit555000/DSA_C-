class MergeSort{
    public void divide(int[] arr, int size, int start, int end){
        
        int mid=start+(end-start)/2;
        int leftArraySize=mid-start+1;
        int rightArraySize=end-mid;
        int[] leftArray=new int[leftArraySize];
        int[] rightArray=new int[rightArray];

        

        

    }
    public static void main(String[] args){
        int[] arr={10,20,50,80,100,90};

        int size=arr.length;
        int start=0;
        int end=size-1;
        divide(arr,size,start,end);
    }
}