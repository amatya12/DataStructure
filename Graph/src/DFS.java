import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class DFS {
	int vertex;
	static int[][] adjancencyMatrix;
	boolean[] visited;

	DFS(int vertex) {
		this.vertex = vertex;
		adjancencyMatrix = new int[vertex][vertex];
		visited = new boolean[vertex];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

	}

	public void clearVisited() {
		visited = new boolean[vertex];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}

	public void addEdge(int source, int destination) {
		adjancencyMatrix[source][destination] = 1;
		adjancencyMatrix[destination][source]=1;
	}

	public void PrintGraph() {
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

	}

	public ArrayList<Integer> FindAdjacent(int index) {
		ArrayList<Integer> adjacent = new ArrayList<Integer>();
		for (int i = 0; i < adjancencyMatrix.length; i++) {
			if (adjancencyMatrix[index][i] == 1)
				adjacent.add(i);
		}
		return adjacent;
	}

	public void DepthFirstTraversal(int s) {
		Stack<Integer> st = new Stack<>();
		int j;
		st.push(s);
		visited[s] = true;
		while (!st.isEmpty()) {
			int element = st.pop();
			System.out.println(element);
			ArrayList<Integer> neighbours = FindAdjacent(element);
			for (int i = 0; i < neighbours.size(); i++) {
				int k = neighbours.get(i);
				if (visited[k] == false) {
					st.push(k);
					visited[k] = true;
				}
			}

		}

	}

	public void BreadthFirstTraversal(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		clearVisited();
		queue.add(s);
		visited[s] = true;
		while (!queue.isEmpty()) {
			int element = queue.poll();
			System.out.println(element);
			ArrayList<Integer> adjacent = FindAdjacent(element);
			for (int i = 0; i < adjacent.size(); i++) {
				int k = adjacent.get(i);
				if (visited[k] == false) {
					queue.add(k);
					visited[k] = true;
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
		ds.addEdge(0, 2);
		ds.addEdge(1, 4);
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
