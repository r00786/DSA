package com.example.programs.dsa.unionfind;

public class UnionFindExample {
        public static void main(String[] args) {
            UnionFind uf = new UnionFind(10);

            // Perform some union operations
            uf.union(1, 2);
            uf.union(3, 4);
            uf.union(2, 4);
            uf.union(5, 6);
            uf.union(7, 8);
            uf.union(6, 8);

            for (int i = 0; i < uf.parent.length; i++) {
                System.out.print(uf.parent[i] + " ");
            }
            System.out.println("");

            for (int i = 0; i < uf.rank.length; i++) {
                System.out.print(uf.rank[i] + " ");
            }
            System.out.println("");

            // Perform some find operations
            System.out.println("Find(1): " + uf.find(1)); // Should print the root of the set containing 1
            System.out.println("Find(3): " + uf.find(3)); // Should print the root of the set containing 3
            System.out.println("Find(5): " + uf.find(5)); // Should print the root of the set containing 5
            System.out.println("Find(7): " + uf.find(7)); // Should print the root of the set containing 7

            // Check if two elements are in the same set
            System.out.println("1 and 3 connected: " + (uf.find(1) == uf.find(3))); // Should be true
            System.out.println("5 and 7 connected: " + (uf.find(5) == uf.find(7))); // Should be true
            System.out.println("1 and 5 connected: " + (uf.find(1) == uf.find(5))); // Should be false
        }

}

class UnionFind{
    int[] parent;
    int [] rank;

    UnionFind(int n){
        this.parent = new int[n];
        this.rank= new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
   public  int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x,int y){
        int rootX= find(x);
        int rootY= find(y);

        if(rank[rootX]>rank[rootY]){
            parent[rootY]=rootX;
        }else if(rank[rootY]>rank[rootX]){
            parent[rootX]=rootY;
        }else{
            parent[rootY]=rootX;
            rank[rootX]++;
        }
    }


}
