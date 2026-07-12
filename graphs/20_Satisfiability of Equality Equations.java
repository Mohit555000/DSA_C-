//https://leetcode.com/problems/satisfiability-of-equality-equations/description/
//https://youtu.be/0Z8lt7U_kiE?si=fJ1K7RP4uiDfOlSA

class Solution {
    class DSU{
        int[] parent;
        int[] rank;

        public DSU(){
            parent=new int[26];
            rank=new int[26];

            //initially every node is it's own parent
            for(int i=0;i<26;i++){
                parent[i]=i;
                rank[i]=0;

            }
        }
        // find function with path compression
        public int find(int x){
            if(parent[x]==x){
                return x;
            }
            return parent[x]=find(parent[x]);
        }
        // union function with rank
        public void union(int a,int b){
            int xParent=find(a);
            int yparent=find(b);
            if(xParent==yparent){
                return;
            }
            if(rank[xParent]>rank[yparent]){
                parent[yparent]=xParent;
            } else if(rank[yparent]>rank[xParent]){
                parent[xParent]=yparent;
            }else{
                parent[xParent]=yparent;
                rank[yparent]++;
            }
        }
    }
    public boolean equationsPossible(String[] equations) {
        DSU dsu=new DSU();
        // case 1 for equality like a==b
        for(String s:equations){
            if(s.charAt(1)=='='){//if the equations is like this "a==b"
                dsu.union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }

        // case 2 for not equaltiy like a!=b
        for(String s:equations){
            if(s.charAt(1)=='!'){
                int xParent=dsu.find(s.charAt(0)-'a');
                int yParent=dsu.find(s.charAt(3)-'a');

                if(xParent==yParent){
                    return false;
                }
            }
        }
        return true;
    }
}
