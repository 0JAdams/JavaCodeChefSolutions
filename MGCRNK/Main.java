import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tests = 0; tests < T; tests++)
		{
			
			int N = Integer.parseInt(in.readLine());
			int[][] board = new int[N][N];
			String[] line = null;
			for( int n=0; n< N; n++)
			{
				line = in.readLine().split(" ");
				for(int m = 0; m < N; m++)
				{
					board[n][m] = Integer.parseInt(line[m]);
				}
			}
			
			int[][] DPboard = new int[N][N];
			
			
			for(int i = 0; i < N; i++)
			{
				for(int j=0; j < N; j++)
				{
					if(j==0 && i==0)
					{
						DPboard[i][j] = board[i][j];
					}
					else if(i==0) //at top of board, must choose left option
					{
						DPboard[i][j] = DPboard[i][j-1] + board[i][j];
					}
					else if(j==0) //against the left of board, must choose up
					{
						DPboard[i][j] = DPboard[i-1][j] + board[i][j];
					}
					else
					{
						DPboard[i][j] = Math.max(DPboard[i-1][j], DPboard[i][j-1]) + board[i][j];
					}
				}
			}
			double total = (double)DPboard[N-1][N-1] / (double) (2*N-3);
			
			if(total<0)
			{
				System.out.println("Bad Judges");
			}
			else
			{
				System.out.println(total);
			}
			
		}
		
	}

}
