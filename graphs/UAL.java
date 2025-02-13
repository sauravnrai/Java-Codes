import java.util.LinkedList;
import java.util.HashMap;


class GraphList{

   HashMap<Integer, LinkedList<Integer>> adjList; // declaration for the list
   int vertices;
   int edges = 0;

   GraphList(int v){
    vertices = v;
    adjList = new HashMap<>(); // creates the HashMap
   }

// Adds the vertex to the key part of the hashmap
   void addVertex(int v){
    adjList.putIfAbsent(v, new LinkedList<>()); // creates an entry for vertex if the vertex is not present
   }


  void addEdge(int u, int v){

 addVertex(u); // creates an entry for vertex u
 addVertex(v); // creates an entry for vertex u

  adjList.get(u).add(v); // adds entry of v in u i.e value part to key u
  adjList.get(v).add(u); // adds entry of u in v i.e value part to key v
  // Edge bi-directional is added

  edges++;
  }

  void printGraph(){
    StringBuilder sb = new StringBuilder();
    sb.append("Edges: " + edges + " Vertices: " + vertices);
    sb.append("\n");

     // Very important loop to understand 
    for(HashMap.Entry<Integer, LinkedList<Integer>> entry: adjList.entrySet()){
        // Gives all the entry of keys in the hashmap as a set

        sb.append(entry.getKey() + " -> "); // adds the vertex or index or key in iteration

        // Since a entry or key is available, we can access its value or values
        // We get the list of values using get value for a key in adjList 
        for(Integer vertex: entry.getValue() ){
            sb.append(vertex + " "); // adds the neighbors of that vertex
        }
       
        sb.append("\n");
    }

   System.out.println( sb.toString());
  }

}

public class UAL {
    public static void main(String[] args) {

        GraphList g = new GraphList(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.printGraph();
        
    }
    
}
