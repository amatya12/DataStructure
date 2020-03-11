
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Queue;

class Vertex {
	public Vertex(int source, int destination) {
		this.x = source;
		this.y = destination;
	}
	int x;
	int y;
	
}

public class DFS {
	int vertex;
	//static int[][] adjancencyMatrix;
	Map<Integer, ArrayList<Integer>> adjancencyMatrix;
	boolean[] visited;
	Map<Integer, Boolean> isVisited;

	DFS(int vertex) {
		this.vertex = vertex;
		//adjancencyMatrix = new int[vertex][vertex];
		adjancencyMatrix = new HashMap<Integer,ArrayList<Integer>>();
		/*visited = new boolean[vertex];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}*/
		isVisited = new HashMap<Integer, Boolean>();
		

	}

	/*public void clearVisited() {
		visited = new boolean[vertex];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}*/
	
	public void clearVisited() {
		
	}

	public void addEdge(int source, int destination) {
		/*adjancencyMatrix[source][destination] = 1;
		adjancencyMatrix[destination][source] = 1;*/
		if(adjancencyMatrix.get(source) == null) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(destination);
		
		adjancencyMatrix.put(source, a);
		
		}
		else {
		List<Integer>value  = adjancencyMatrix.get(source);
		value.add(destination);
		}
		if(adjancencyMatrix.get(destination)==null) {
			ArrayList<Integer> b = new ArrayList<>();
			b.add(source);
			adjancencyMatrix.put(destination,b);
		}
		
		else 
		{
			List<Integer>value  = adjancencyMatrix.get(destination);
			value.add(source);
		}
		
	}

	/*public void PrintGraph() {
		System.out.println("Adjancency Matrix");
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				System.out.print(adjancencyMatrix[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < vertex; i++) {
			System.out.print("vertex " + i + " is connected to: ");
			for (int j = 0; j < vertex; j++) {
				if (adjancencyMatrix[i][j] == 1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
		
	}*/

	public ArrayList<Integer> FindAdjacent(int index) {
		/*ArrayList<Integer> adjacent = new ArrayList<Integer>();
		for (int i = 0; i < adjancencyMatrix.length; i++) {
			if (adjancencyMatrix[index][i] == 1)
				adjacent.add(i);
		}*/
		
		 ArrayList<Integer> adjacent = adjancencyMatrix.get(index);
		
		
		return adjacent;
	}

	public void DepthFirstTraversal(int s) {
		Stack<Integer> st = new Stack<>();
		int j;
		st.push(s);
		//visited[s] = true;
		isVisited.put(s, true);
		while (!st.isEmpty()) {
			int element = st.pop();
			System.out.println(element);
			ArrayList<Integer> neighbours = FindAdjacent(element);
			if(neighbours!=null) {
				for (int i = 0; i < neighbours.size(); i++) {
					int k = neighbours.get(i);
					if (isVisited.get(k) == null) {
						isVisited.put(k, true); 
						st.push(k);
						if(isVisited.get(k) == false) {
						st.push(k);
						isVisited.replace(k, true);
						}
					}
				}
			}

		}

	}

	public void BreadthFirstTraversal(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		clearVisited();
		queue.add(s);
		//visited[s] = true;
		isVisited.put(s, true);
		while (!queue.isEmpty()) {
			int element = queue.poll();
			System.out.println(element);
			ArrayList<Integer> neighbours = FindAdjacent(element);
			if(neighbours != null) {
				for (int i = 0; i < neighbours.size(); i++) {
					int k = neighbours.get(i);
					if(isVisited.get(k) == null) {
						isVisited.put(k, true);
						queue.add(k);
					}
					if(isVisited.get(k) == false) {
						queue.add(k);
						isVisited.replace(k, true);
					}
					/*if (visited[k] == false) {
						queue.add(k);
						visited[k] = true;
					}*/
				}
			}

		}

	}
	public int[][] MatrixMultiplication(int[][] adjacencyMatrix) {
		int [][] resultantMatrix = new int[adjacencyMatrix.length][adjacencyMatrix.length];
		for(int i = 0; i < adjacencyMatrix.length;i++)  {
			for(int j = 0; j<adjacencyMatrix.length;j++) {
				for(int k = 0 ; k<adjacencyMatrix.length;k++) {
					//resultantMatrix[i][j]+=adjacencyMatrix[i][k]*adjacencyMatrix[k][j];
					resultantMatrix[i][j] = ((resultantMatrix[i][j]!=0) || ((adjacencyMatrix[i][k]!=0)&& (adjacencyMatrix[k][j]!=0)))?1:0;
					
				}
			}
		}
		return resultantMatrix;
		
	}
	
	
	public void PrintResultantMatrix(int[][] array) {
		for(int i = 0 ; i < array.length; i ++) {
			for(int j = 0;j < array.length;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		DFS ds = new DFS(9);
		ds.addEdge(0, 1);
			
			
		ds.addEdge(0, 8);
		ds.addEdge(1, 8);
		ds.addEdge(1, 6);
		ds.addEdge(4, 6);
		ds.addEdge(3, 6);
		ds.addEdge(2, 6);
		ds.addEdge(5, 6);
		ds.addEdge(2, 5);
		
		//ds.DepthFirstTraversal(1);
		
		
		ds.BreadthFirstTraversal(1);
		System.out.println();
	
		
		/*int[][]adjancencyMatrix = {{1,1,0,1},
								  {0,1,1,0},
								  {0,0,1,1},
								  {0,0,0,1}};

	ds.MatrixMultiplication(adjancencyMatrix);
		ds.PrintResultantMatrix(ds.MatrixMultiplication(adjancencyMatrix));*/
	}

}
/*1
8
6
5
4
3
2
0*/
