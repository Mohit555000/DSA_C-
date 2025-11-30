

public class Permutation_Of_Strings_1 {

    public static void printPermutation(char[] arr, int index){
        if(index == arr.length){
            System.out.println(String.valueOf(arr));
            return;
        }

        for(int j = index; j < arr.length; j++){
            // swap
            char temp = arr[index];
            arr[index] = arr[j];
            arr[j] = temp;

            // recursion
            printPermutation(arr, index + 1);

            // backtrack
            temp = arr[index];
            arr[index] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        char[] arr = s.toCharArray();  // convert String → char[]

        printPermutation(arr, 0);
    }
}
