package Graph.ListRepresentation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private int V; // no. of vertices in Graph
	private int E; // no. of edges in Graph
	private LinkedList<Integer>[] adj;

	public Graph(int nodes) {
		this.V = nodes;
		this.E = 0;
		this.adj = new LinkedList[nodes];
		for (int i = 0; i < nodes; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		this.adj[u].add(v);
		this.adj[v].add(u);
		E++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges " + "\n");
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			for (int w : adj[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void bfs(int s) {
		boolean[] visited = new boolean[V];

		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);

		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");

			for (int v : adj[u]) {
				if (!visited[v]) {
					visited[v] = true;
					q.offer(v);
				}
			}
		}
	}

	public void dfs(int s) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		stack.push(s);

		while (!stack.isEmpty()) {
			int u = stack.pop();
			if (!visited[u]) {
				visited[u] = true;
				System.out.print(u + " ");

				for (int v : adj[u]) {
					if (!visited[v]) {
						stack.push(v);
					}
				}
			}
		}

	}

	public void iteratativeDfs() {
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				iteratativeDfs(v, visited);
			}
		}
	}

	public void iteratativeDfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int w : adj[v]) {
			if (!visited[w]) {
				iteratativeDfs(w, visited);
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);
		System.out.print("BFS: ");
		g.bfs(0);
		System.out.println();
		System.out.print("DFS: ");
		g.dfs(0);
		System.out.println();
		System.out.print("IDFS: ");
		g.iteratativeDfs();
		System.out.println();
		System.out.println(g);

	}


}
