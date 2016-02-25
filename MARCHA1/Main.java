import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Jonathan
//cpt_fwiffo
//2/4/2015
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tests=0; tests<T; tests++)
		{
			String[] line = in.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			int[] bNotes = new int[N+1]; 
			for(int n=1; n<=N; n++)
			{
				bNotes[n] = Integer.parseInt(in.readLine());
			}
			
			boolean[][] possible = new boolean[N+1][M+1];
			possible[0][0] = true;		
			for(int n=1; n<=N; n++)
			{
				for(int m=0; m<=M; m++)
				{
					possible[n][m] = possible[n][m] || possible[n-1][m];
					possible[n][m] = possible[n][m] || (bNotes[n]==m);
					possible[n][m] = possible[n][m] || ((bNotes[n]<=m)?possible[n-1][m-bNotes[n]]:false);
					
				}
			}
			if(possible[N][M])
			{
				System.out.println("Yes");				
			}
			else
			{
				System.out.println("No");
			}
		
		}

	}

}
