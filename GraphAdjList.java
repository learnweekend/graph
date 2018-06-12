package graph;

/**
 * Sample graph representation using Adjacency List
 *  addEdge(int v, int w)
 *  getNeighbors(int v)
 */
import java.util.LinkedList;
import java.util.List;

public class GraphAdjList {

	private int vertices;
	private int edges;
	private LinkedList<Integer>[] adjList;

	public GraphAdjList(int v) {
		this.vertices = v;
		this.edges = 0;
		this.adjList = new LinkedList[vertices];

		for (int i = 0; i < vertices; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dst) {
		if (src < 0 || src >= vertices || dst < 0 || dst >= vertices)
			throw new IllegalArgumentException("invalid source or destination vertices");

		adjList[src].addFirst(dst);
		adjList[dst].addFirst(src); // since its undirected
		edges++;
	}

	public List<Integer> getNeighbors(int v) {
		if (v < 0 || v >= vertices)
			throw new IllegalArgumentException("invalid vertex");

		return adjList[v];
	}

	public void print() {
		for (int v = 0; v < vertices; v++) 
			System.out.println(v + "--" + adjList[v]);
	}

	public int getVertices() {
		return vertices;
	}

	public int getEdges() {
		return edges;
	}

	public static void main(String[] args) {
		int V = 5;
		GraphAdjList graph = new GraphAdjList(V);
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
