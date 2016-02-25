import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
 
 
public class Main {
	public static class Vertex
	{
		public int value;
		public int index;
		public int depth;
		public boolean visited;
		
		Vertex(int vIn, int indexIn, int dIn)
		{
			value = vIn;
			index = indexIn;
			depth = dIn;
			visited = false;
		}
		
	}
	
	public static class Bucket
	{
		boolean visited;
		public ArrayList<Vertex> sameValueVertices;
		public Bucket()
		{
			visited = false;
			sameValueVertices = new ArrayList<Vertex>();
		}
	}
	
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] values = in.readLine().toCharArray();
		Vertex[] vertexList = new Vertex[values.length];
		Bucket[] vertexBuckets = new Bucket[10];
		int length = values.length;
		
		for(int i=0; i<10; i++)
		{
			vertexBuckets[i] = new Bucket();
		}
		
		for(int i=0; i<values.length; i++) //create our initial vertex list
		{
			int value = Character.getNumericValue(values[i]);
			vertexList[i] = new Vertex(value, i, -1 );
			vertexBuckets[value].sameValueVertices.add(vertexList[i]);
		}
		
			
		//perform search through vertices to find shortest path
		Queue<Vertex> searchQ = new LinkedList<Vertex>();
		
		vertexList[0].depth = 0; //fix initial depth
		vertexList[0].visited = true;
		int depth = 0;
		searchQ.add(vertexList[0]);
		while(!searchQ.isEmpty())
		{
			Vertex currentV = searchQ.poll();
			
			if(currentV.index==length-1)
			{
				System.out.println(currentV.depth);
				break;
			}
			depth = currentV.depth +1;
			
			if(currentV.index>0 && !vertexList[currentV.index-1].visited) //add previous adjacent vertex
			{
				vertexList[currentV.index-1].visited = true;
				vertexList[currentV.index-1].depth = depth;
				searchQ.add(vertexList[currentV.index-1]);
			}
			
			if(currentV.index<length-1&& !vertexList[currentV.index+1].visited) //add next adjacent vertex
			{
				vertexList[currentV.index+1].visited = true;
				vertexList[currentV.index+1].depth = depth;
				searchQ.add(vertexList[currentV.index+1]);
			}
			
			if(!vertexBuckets[currentV.value].visited)
			{
				vertexBuckets[currentV.value].visited = true;
				for(Vertex VL : vertexBuckets[currentV.value].sameValueVertices)
				{
					if(!VL.visited)
					{
						VL.visited = true;
						VL.depth = depth;
						searchQ.add(VL);
					}
				}
			}
			
		}
		

	}
 
}
 