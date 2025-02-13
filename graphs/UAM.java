// This is the implementation for undirected adjacency matrix 
// This is the implementation for undirected graph


class GraphMatrix{

    int[][] adjMatrix;
    int vertices; // vertex
    int edges = 0; // edges

    GraphMatrix(int v){
        adjMatrix = new int[v][v]; // creates a V x V matrix
        vertices = v;
    }

    void addEdge(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        edges++;

        // Add edges between u and v
    }


    void printGraph(){

        StringBuilder sb = new StringBuilder();
        sb.append("Vetices: " + vertices + " Edges: " + edges);
        sb.append("\n");


        for(int i = 0; i < vertices; i++ ){

            sb.append(i + ": " ); // prints vertex

                     for(int j: adjMatrix[i]) {
                sb.append(j + " "); // prints vertex that has edges
            }
            sb.append("\n");
        }
    
        System.out.println(sb.toString()); // prints adjacency matrix

    }

}

public class UAM {

    public static void main(String[] args) {
        
        GraphMatrix g = new GraphMatrix(4);
        g.addEdge(0, 1); // adds edge b/w 0 and 1
        g.addEdge(0, 2); // edge b/w 0 and 2
        g.addEdge(0, 3); // edge b/w 0 and 3
        g.addEdge(1, 3); // edge b/w 1 and 3
        g.addEdge(2, 3); // edge b/w 2 and 3
        g.printGraph();
    }
    
}
