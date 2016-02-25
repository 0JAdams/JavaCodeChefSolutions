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
		int[][] earnings;
		int N = 0;
		for(int tests = 0; tests< T; tests++)
		{
			earnings = new int[49][49]; //max of 48 hours, so start and end times will range from 0 to 48 (49 values);
			N = Integer.parseInt(in.readLine());
			int s =0;
			int e =0;
			int v =0;
			String[] line;
			for(int i=0; i<N; i++)
			{
				line = in.readLine().split(" ");
				s= Integer.parseInt(line[0]);
				e= Integer.parseInt(line[1]);
				v= Integer.parseInt(line[2]);
				earnings[s][e] = Math.max(earnings[s][e], v); //must do max in case there are multiple entries with the same start and end times
			}
			int[] maxValue = new int[49];
			for(int end=1; end<49; end++) //go through all end periods, and find the best combination that ends at that time based on it and things that end at the same time or earlier
			{
				for(int start=0; start<end; start++)
				{
					maxValue[end] = Math.max(maxValue[start] + earnings[start][end], maxValue[end]);
				}
			}
			System.out.println(maxValue[48]);
		}
		
		
	}

}
