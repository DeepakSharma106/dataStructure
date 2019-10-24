package graph;

import java.util.Scanner;

public class Graph_Adjacency_Matrix {

	//vertices and adjacency matrix
	public int vertices;
	public int[][] matrix;
	
	public Graph_Adjacency_Matrix(int vertices) {
		this.vertices = vertices;
		//square matrix
		this.matrix = new int[vertices+1][vertices+1];
	}
	
	public void addEdge(int to, int from, int edge) {
		
		try {
			matrix[to][from] = edge;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Vertices does not exists.");
		}
	}
	
	public int getEdge(int to, int from) {
		try {
			return matrix[to][from];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("vertices does not exist");
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Graph_Adjacency_Matrix graph;
		
		int vertices, edges, count =1, to=0, from=0;
		try {
			System.out.println("enter no of edges");
			edges = scan.nextInt();
			
			System.out.println("enter no of vertices");
			vertices = scan.nextInt();
			
			graph = new Graph_Adjacency_Matrix(vertices);
	
			System.out.println("enter the edge to and from values:");
			
			while(count <= edges) {
				to = scan.nextInt();
				from = scan.nextInt();
				
				//this is basically creating the matrix value from to and from values
				graph.addEdge(to, from, 1);
				
				count++;
			}
			
			//print the adjacency matrix for the given graph is :
			System.out.println("Adjacency matrix is :::  ");
			System.out.print("  ");
			
			for(int i=1; i<=vertices; i++) {
				System.out.print(i+" ");
			}
			System.out.println();
			
			for(int i=1; i<=vertices; i++) {
				System.out.print(i+" ");
				for(int j=1; j<=vertices; j++) {
					System.out.print(graph.getEdge(i, j)+" ");
				}
				System.out.println();
			}
			
			
		} catch(Exception E) {
			System.out.println("something went wrong");
		}
		
       scan.close();
	}

}
