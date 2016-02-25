import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Jonathan
//cpt_fwiffo
// 3-2-15
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tests = 0; tests < T ; tests++)
		{
			int N = Integer.parseInt(in.readLine());
			String[] line = in.readLine().split(" ");
			int[] P = new int[N];
			for(int n=0; n<N ; n++)
			{
				P[n] = Integer.parseInt(line[n]);
			}
			
			Arrays.sort(P);
			long cost = 0;
			for(int i=1; i<N; i++)
			{
				cost+= ((long)P[0]) * P[i];
			}
			System.out.println(cost);
		}
	}
}
