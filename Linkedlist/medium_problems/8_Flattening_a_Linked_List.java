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
