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
			
			int N = Integer.parseInt(in.readLine());
			String[] line = in.readLine().split(" ");
			int[] values = new int[N+1];
			//int[] maxVal = new int[N+1];
			int[] parent = new int[N+1];
					
			for(int i=0; i< N; i++)
			{
				values[i+1]=Integer.parseInt(line[i]);
				parent[i+1] = i+1;
			}
			
			int Q = Integer.parseInt(in.readLine());
			
			for(int i=0; i<Q ; i++)
			{
				String lineIn = in.readLine();
				st = new StringTokenizer(lineIn, " ");
				int type = Integer.parseInt(st.nextToken());
				if(type==0)
				{
					int L = Integer.parseInt(st.nextToken());
					int R = Integer.parseInt(st.nextToken());

					//find max value of each group
					int pL = L;
					int pR = R;
					int tL = 0;
					int tR = 0;
					int maxL = 0;
					int maxR = 0;
					while(parent[pL]!=pL)
					{
						tL=parent[pL];
						parent[pL] = parent[tL];
						pL=tL;
					}
					parent[L] = pL;
					
					while(parent[pR]!=pR)
					{
						tR = parent[pR];
						parent[pR] = parent[tR];
						pR=tR;
					}
					parent[R] = pR;
					
					maxL = values[pL];
					maxR = values[pR];
					
					if(pL==pR)
					{
						sb.append("Invalid query!\n");
						continue;
					}
					
					//chef with max single value becomes parent to other items
					if(maxL>maxR)
					{
						parent[pR]=pL;
						values[pR]=values[pL];
					}
					else if(maxR>maxL)
					{
						parent[pL]=pR;
						values[pL]=values[pR];
					}
					
					
				}
				else
				{
					int C = Integer.parseInt(st.nextToken());
					while(parent[C]!=C)
					{
						C=parent[C];
					}
					//System.out.println(C);
					sb.append(C);
					sb.append("\n");
				}
			}
					
		}
		System.out.print(sb.toString());	
	}
	
	
}


