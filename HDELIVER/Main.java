import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//Jonathan
//cpt_fwiffo
// 3-2-15
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		 StringTokenizer st;
		 StringBuilder sb = new StringBuilder();
		for(int tests = 0; tests < T ; tests++)
		{
			String line = in.readLine();
			st = new StringTokenizer(line, " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] group = new int[N];
			int[] rank = new int[N];
			
			for(int i=1; i<N; i++)
			{
				group[i] = i;
			}
			
			int L = 0;
			int R = 0;
			for(int m=0; m< M; m++) //set groups to match fast routes
			{
				line = in.readLine();
				st = new StringTokenizer(line, " ");
				L = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				int pL = L;
				int pR = R;
				int tL = 0;
				int tR = 0;
				
				while(group[pL]!=pL)
				{
					tL=group[pL];
					group[pL] = group[tL];
					pL=tL;
				}
				group[L] = pL;
				
				while(group[pR]!=pR)
				{
					tR = group[pR];
					group[pR] = group[tR];
					pR=tR;
				}
				group[R] = pR;
				
				if(pR!=pL) //this means they are not already part of the same group
				{
					if(rank[pL]==rank[pR]) //bump rank if they are the same
					{
						rank[pL]++;
					}
					
					if(rank[pL]>rank[pR]) //perform union based on rank
					{
						group[pR] = pL;
					}
					else
					{
						group[pL] = pR;
					}
				}
			}
			
			int Q = Integer.parseInt(in.readLine());
			for(int q=0; q<Q; q++)
			{
				line = in.readLine();
				st = new StringTokenizer(line, " ");
				L = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				
				while(group[L]!=L)
				{
					L=group[L];
				}
				while(group[R]!=R)
				{
					R=group[R];
				}
				
				if(group[L]==group[R])
				{
					sb.append("YO\n");
				}
				else
				{
					sb.append("NO\n");
				}
			}
					
		}
		System.out.print(sb.toString());	
	}
	
	
}


