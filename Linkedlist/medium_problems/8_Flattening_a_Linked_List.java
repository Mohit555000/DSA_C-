//https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
//https://www.youtube.com/watch?v=ykelywHJWLg&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=25

1) Brute Force Approach
/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node convert(ArrayList<Integer> list){
        Node head=new Node(list.get(0));
        Node temp=head;
        for(int i=1;i<list.size();i++){
            Node newNode=new Node(list.get(i));
            temp.bottom=newNode;
            temp=temp.bottom;
        }
        return head;
    }
    public Node flatten(Node root) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        Node temp=root;
        while(temp!=null){
            Node temp2=temp;
            while(temp2!=null){
                list.add(temp2.data);
                temp2=temp2.bottom;
            }
            temp=temp.next;
        }
        Collections.sort(list);
        temp=convert(list);
        return temp;
    }
}

In brute force approach we are sorting and using an extra space.
In Optimized approach we can remove sorting (from the child nodes) since it is already sorted and we won't avoid the use of external array.

Optimized Approach
    /*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node merge(Node a,Node b){
        Node dummy=new Node(0);
        Node temp=dummy;
        
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.bottom=a;
                temp=a;
                a=a.bottom;
            }
            else{
                temp.bottom=b;
                temp=b;
                b=b.bottom;
            }
            if(a!=null){
                temp.bottom=a;
            }
            else{
                temp.bottom=b;
            }
            
        }
        return dummy.bottom;
    }
    public Node flatten(Node root) {
        // code here
        if(root==null || root.next==null){
            return root;
        }
        
        root.next=flatten(root.next);
        
        root=merge(root,root.next);
        return root;
    }
}
