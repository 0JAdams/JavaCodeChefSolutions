import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	
	static int step;
	static class Vertex
	{
		ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
		int a;
		int b;
		boolean visited;
		boolean AP;
		void DFS(Vertex P)
		{
			visited = true;
			a = step++; 
			b = a;
			int children = 0;
			for(Vertex V : neighbors)
			{
				if(!V.visited)
				{
					children++;
					V.DFS(this);
					if(P==null && children > 1 || P!=null && V.b >= a) //condition to determine if something is an articulation point
					{
						AP = true;
					}
					if(V.b < b) //this will be true when a node has a child node that is able to visit a lower node
					{
						b = V.b;
					}
				
				} 
				else if (V != P)
				{
					if(V.a < b) //this will be true when a node with a lower value is able to be visited by this node
					{
						b = V.a;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int t=0; t<T; t++)
		{
			
			String[] values = in.readLine().split(" ");
			int N = Integer.parseInt(values[0]);
			int M = Integer.parseInt(values[1]);
			int K = Integer.parseInt(values[2]);
			
			Vertex[] vertexList = new Vertex[N];
			for(int n=0; n<N; n++)
			{
				vertexList[n] = new Vertex();
			}
			
			//read and mark edges on vertices
			for(int m=0; m<M; m++)
			{
				values = in.readLine().split(" ");
				int L = Integer.parseInt(values[0]);
				int R = Integer.parseInt(values[1]);
				vertexList[L].neighbors.add(vertexList[R]);
				vertexList[R].neighbors.add(vertexList[L]);
			}
			
			
			
			//find and mark Articulation points
			step = 0;
			for( int i=0; i<N; i++) 
			{
				if(!vertexList[i].visited)
				{
					vertexList[i].DFS(null);
				}
			}
			
			//find and count the number of articulation points
			int count = 0; 
			for(int i = 0; i<N ; i++)
			{
				if(vertexList[i].AP)
				{
					count++;
				}
			}
			out.append(count*K + "\n");
		}
		
		System.out.println(out);
	}

}
