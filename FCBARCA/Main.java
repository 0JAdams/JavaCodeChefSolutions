import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tests = 0; tests < T; tests++)
		{
			String[] line = in.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);
			long[] dpPossibilities = new long[N+1];
			long M = 1000000007;
			dpPossibilities[0] = 1;
			dpPossibilities[1] = 0;
			
			for(int i= 2; i < N+1 ; i++)
			{
				dpPossibilities[i] = ((((K)*(dpPossibilities[i-2]) % M) + ((K-1) * (dpPossibilities[i-1])) % M) % M);
			}
			System.out.println(dpPossibilities[N]);
		}
		
	}

}
