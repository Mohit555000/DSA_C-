//print all the subsequences of the string using exclude and include pattern
public class PrintAllTheSubsequences
{
    public void printSubsequence(String str,String out, int index ){
        //base condition
        if(index>=str.length()){
            System.out.println(out);
            return;
        }
        //exlude the current character
        printSubsequence(str,out,index+1);
        //include the current character
        char ch=str.charAt(index);
        out=out+ch;
        printSubsequence(str,out,index+1);

        
        
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		PrintAllTheSubsequences obj = new PrintAllTheSubsequences();
		obj.printSubsequence("abc","",0);
	}
	
}