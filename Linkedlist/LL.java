public class LL{
        Node next;
        int data;
        Node head;
        Node tail;
        int size; //how long is the linkedlist or how many nodes are present in the linkedlist.
        LL(){
            this.size=0;
        }
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        
       
    }
    //insert at the the start of the linkedlist
        public void insertFirst(int data){
            Node node=new Node(data);
            node.next=head;
            head=node;
            if(tail==null){
                tail=head;
            }
            size=size+1;
        }
        //display the entire linkedlist
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ---> ");

                temp=temp.next;
            }
            System.out.println("END");
        }
        //insert at last position of linkedlist
        public void inserLast(int data){
            if(tail==null){
                insertFirst(data);
                return;
            }
            Node node=new Node(data);
            tail.next=node;
            tail=node;
            size=size+1;
        }
        //insert at a particular index of linkelist
        public void insert(int data,int index){
            if(index==0){
                insertFirst(data);
                return;
            }
            if(index==size){
                inserLast(data);
            }
            Node temp=head;
            for(int i=1;i<index;i++){
                temp=temp.next;
            }
            Node node=new Node(data,temp.next);
            temp.next=node;
            size=size+1; 
        }
        //delete the first node of the linkedlist
        public int deleteFirst(){
            int value=head.data;
            head=head.next;
            if(head==null){
                tail=null;
            }
            size=size-1;
            return value;
        }
        //get a particuar node of the linkedlist
        public Node get(int index){
            Node node=head;
            for(int i=1;i<index;i++){
                node=node.next;
            }
            return node;
        }
        //delete the last element
        public int deleteLast(){
            if(size<=1){
                return deleteFirst();
            }
            Node secondlast=get(size-2);
            int value=tail.data;
            tail=secondlast;
            secondlast.next=null;
            return value;
        }
        //delete a particular index
        public int delete(int index){
            if(index==0){
                return deleteFirst();  
            }
            if(index==size){
                return deleteLast();
            }
            Node previousNode=get(index-1);
            int value=previousNode.next.data;
            previousNode.next=previousNode.next.next;
            return value;
        }
        //find a particular node
        public Node find(int value){
            Node node=head;
            while(node!=null){
                if(node.data==value){
                    return node;
                }
                node=node.next;
            }
            return null;
        }

}