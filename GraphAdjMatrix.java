package graph;

/**
 *  Sample graph (directed) representation using Adjacency Matrix
 *  addEdge(int v, int w)
 *  isConnected(int v, int w)
 */
import java.util.Arrays;

public class GraphAdjMatrix {
	
	private int vertices;
	private int edges;
	private boolean[][] adjMatrix;
	
	public GraphAdjMatrix(int V) {
		this.vertices = V;
		this.edges = 0;
		this.adjMatrix = new boolean[V][V];
	}
	
	public void addEdge(int v, int w) {
		if(v < 0 || v >= vertices || w < 0 || w >= vertices)
			throw new IllegalArgumentException("invalid vartices");
		
		adjMatrix[v][w] = true;
		adjMatrix[w][v] = true;
		edges++;
	}
	
	public boolean contains(int v, int w) {
		if(v < 0 || v >= vertices || w < 0 || w >= vertices)
			throw new IllegalArgumentException("invalid vartices");
		
		return adjMatrix[v][w];
	}
	
	public void print() {
		for(boolean[]  vertex : adjMatrix) {
			System.out.println(Arrays.toString(vertex));
		}
	}
	
	public int getVertices() {
		return vertices;
	}

	public int getEdges() {
		return edges;
	}

	public static void main(String[] args) {
		int V = 5;
		GraphAdjMatrix graph = new GraphAdjMatrix(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.print();
	}
}
