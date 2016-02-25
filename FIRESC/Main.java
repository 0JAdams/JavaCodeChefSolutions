import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


//Jonathan
//cpt_fwiffo
// 3-2-15
public class Main {
	static class bucket
	{
		public int groupID;
		public int count;
		public bucket(int group)
		{
			groupID = group;
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tests = 0; tests < T ; tests++)
		{
			String[] line = in.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			
			//int[] values = new int[N+1];
			int[] parent = new int[N+1];
			int[] rank = new int[N+1];
			
			for(int i=1; i<N+1 ; i++)
			{
				//values[i] = i;
				parent[i] = i;
			}
			
			int L = 0;
			int R = 0;
			for(int m = 0; m<M ; m++) //perform unions to group people
			{
				line = in.readLine().split(" ");
				L = Integer.parseInt(line[0]);
				R = Integer.parseInt(line[1]);
				while(parent[L]!=L)
				{
					L=parent[L];
				}
				while(parent[R]!=R)
				{
					R=parent[R];
				}
				
				if(R!=L) //this means they are not already part of the same group
				{
					if(rank[L]==rank[R]) //bump rank if they are the same
					{
						rank[L]++;
					}
					
					if(rank[L]>rank[R]) //perform union based on rank
					{
						parent[R] = L;
					}
					else
					{
						parent[L] = R;
					}
				}
				
				
			}
			

			boolean flat = false;
			while(!flat) //flatten all trees to have the same parent node for grouping
			{
				flat = true;
				for(int i=1; i<N+1; i++)
				{
					if(parent[i]!=parent[parent[i]])
					{
						flat = false;
						parent[i] = parent[parent[i]];
					}
				}
			}
			
			Map<Integer, Integer> buckets = new TreeMap<Integer, Integer>();
			
			for(int i=1; i<=N; i++)
			{
				if(!buckets.containsKey(parent[i]))
				{
					buckets.put(parent[i], 1);
				}
				else
				{
					buckets.put(parent[i], buckets.get(parent[i]).intValue() +1 );
				}
			}
			
			
			
			//find number of groups and number of people in each group.
			//System.out.println(buckets.size());
			StringBuilder sb = new StringBuilder();
			sb.append(buckets.size());
			sb.append(' ');
			long P = 1000000007;
			long output = 0;
			
			for(Map.Entry<Integer, Integer> item : buckets.entrySet())
			{
				if(output==0)
				{
					output = item.getValue();
				}
				else
				{
					output = (output * item.getValue()) % P;
				}
			}
			
			sb.append(output);
			System.out.println(sb.toString());
			
		}
	}
}


