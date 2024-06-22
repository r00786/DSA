package com.example.programs.dsa.graph;
import java.util.Objects;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class GraphExample {
    public static void main(String[] args){
        Graph graph= new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        System.out.println(graph.toString());

        System.out.println(graph.depthFirstTraversal("Bob"));
        System.out.println(graph.breadthFirstTraversal("Bob"));

        GraphWithMatrix gWm= new GraphWithMatrix(6);
        gWm.addEdge(0, 1);
        gWm.addEdge(0, 2);
        gWm.addEdge(1, 3);
        gWm.addEdge(1, 4);
        gWm.addEdge(2, 4);
        gWm.addEdge(3, 5);
        gWm.addEdge(4, 5);
        gWm.printGraph();
        System.out.println("");
        gWm.depthFirstTraversal(0).forEach(ele->System.out.print(ele+"--->"));
        System.out.println("");
        gWm.breadFirstTraversal(0).forEach(ele->System.out.print(ele+"--->"));

    }
}

class Graph{
    private Map<Vertex,List<Vertex>> adjVertices;

    Graph(){
        adjVertices= new HashMap();
    }
    public void addVertex(String label){
        Vertex v1 = new Vertex(label);
        adjVertices.putIfAbsent(v1,new ArrayList());
    }
    public void removeVertex(String label){
        Vertex v1 = new Vertex(label);
        adjVertices.values().stream().forEach(e->e.remove(v1));
        adjVertices.remove(v1);
    }
    public void addEdge(String label1,String label2){
        Vertex v1= new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }
    public void removeEdge(String label1,String label2){
        Vertex v1= new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).remove(v2);
        adjVertices.get(v2).remove(v1);
    }

    public List<Vertex> getAdjVertices(String label){
        return adjVertices.get(new Vertex(label));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(adjVertices.size()==0){
            return "empty";
        }
        for (Vertex vertex : adjVertices.keySet()) {
            sb.append(vertex.getLabel());
            sb.append(" -> ");
            sb.append(adjVertices.get(vertex));
            sb.append("\n");
        }
        return sb.toString();
    }
    public Set<String> depthFirstTraversal(String rootLabel){
        Set<String> visited = new LinkedHashSet();
        Stack<String> stack = new Stack();
        stack.push(rootLabel);
        while(!stack.isEmpty()){
            String currentVertex= stack.pop();
            if(!visited.contains(currentVertex)){
                visited.add(currentVertex);
                for(Vertex vertex:this.getAdjVertices(currentVertex)){
                    stack.push(vertex.getLabel());
                }

            }


        }
return visited;

    }

    Set<String> breadthFirstTraversal(String root){
        Set<String> visited= new LinkedHashSet();
        Queue<String> queue = new LinkedList();
        queue.add(root);
        visited.add(root);
        while(!queue.isEmpty()){
            String currentVertex= queue.poll();
            for(Vertex vertex:getAdjVertices(currentVertex)){
                if(!visited.contains(vertex.getLabel())){
                    visited.add(vertex.getLabel());
                    queue.add(vertex.getLabel());

                }
            }
        }
        return visited;
    }
}

class GraphWithMatrix{
    int numVertices;
    int[][] adjacencyMatrix;
    GraphWithMatrix(int numVertices){
        this.numVertices=numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public Set<Integer> depthFirstTraversal(int root){
        Set<Integer> visited = new LinkedHashSet();
        Stack<Integer> stack= new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            int currentVertex= stack.pop();
            visited.add(currentVertex);
            for(int i= numVertices-1;i>=0;i--){
                if(adjacencyMatrix[currentVertex][i]==1&&!visited.contains(i)){
                    stack.push(i);
                }
            }

        }
        return visited;
    }

    public Set<Integer> breadFirstTraversal(int root){
        Set<Integer> visited = new LinkedHashSet();
        Queue<Integer> queue = new LinkedList();
        visited.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for(int i=0;i<numVertices;i++){
                if(adjacencyMatrix[vertex][i]==1&&!visited.contains(i)){
                    queue.add(i);
                    visited.add(i);
                }
            }
        }
        return visited;

    }

    public void addEdge(int source,int destination){
        this.adjacencyMatrix[source][destination]=1;
        this.adjacencyMatrix[destination][source]=1;
    }

    public void printGraph(){
        System.out.print("  ");
        for(int i=0;i<numVertices;i++){
            System.out.print(i+" ");
        }
        System.out.println("");
        for(int i=0;i<numVertices;i++){
            System.out.print(i+" ");
            for(int j=0;j<numVertices;j++){
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}


class Vertex{
    private String label;
    public Vertex(String label){
        this.label=label;
    }

    @Override
    public boolean equals(Object vertex){
        Vertex v2=(Vertex)vertex;
        return v2.getLabel().equals(this.label);
    }
    @Override
    public int hashCode(){
        return Objects.hash(label);
    }
    public String getLabel(){
        return this.label;
    }
    @Override
    public String toString(){
        return label;
    }


}
