import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Problem
	{
		public int c = 0;
		public int p = 0;
		public int t = 0;		
		public int value = 0;
		public Problem(int C, int P, int T)
		{
			c = C;
			p = P;
			t = T;
			value = C*P;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		
		for(int tests = 0; tests<T; tests++)
		{
			String[] line = in.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int W = Integer.parseInt(line[1]);
			
			Problem[] problems = new Problem[N];
			
			for(int i = 0; i<N; i++)
			{			
				line = in.readLine().split(" ");
				problems[i] = new Problem(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));			
			}
			
			int[][] values = new int[N+1][W+1];
			
			for(int j=0; j<W; j++)
			{
				values[0][j] = 0;
			}
			
			for(int i= 1; i<N+1; i++)
			{
				for(int j=0; j<=W; j++)
				{
					if(problems[i-1].t<=j)
					{
						values[i][j] = Math.max(values[i-1][j], values[i-1][j-problems[i-1].t]+problems[i-1].value);
					}
					else
					{
						values[i][j] = values[i-1][j];
					}
				}
			}
			
			
			System.out.println(values[N][W]);
		}
	}
}
