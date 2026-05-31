//https://www.naukri.com/code360/problems/convert-bst-to-min-heap_920498?leftPanelTabValue=SUBMISSION
//https://www.youtube.com/watch?v=_9F2VgZcvdw&t=2923s


import java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/

public class Solution {
	static int index=0;
	public static void inorder(BinaryTreeNode root,ArrayList<Integer> list){
		if(root==null){
			return;
		}
		inorder(root.left,list);
		list.add(root.data);
		inorder(root.right,list);
	}
	public static BinaryTreeNode preorder(BinaryTreeNode root,ArrayList<Integer> list){
		if(root==null || index>=list.size()){
			return root;
		}
		root.data=list.get(index);
		index++;
		preorder(root.left,list);
		preorder(root.right,list);
		return root;
	}
	public static BinaryTreeNode convertBST(BinaryTreeNode root) {
		// Write your code here.
		ArrayList<Integer> list=new ArrayList<>();
		inorder(root,list);
		index=0;
		return preorder(root,list);
	}
}


