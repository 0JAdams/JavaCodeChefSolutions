import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Jonathan
// cpt_fwiffo
// 2/10/15
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tests = 0; tests < T; tests++)
		{
			int N = Integer.parseInt(in.readLine());
			int[][] pairs = new int[N][2];
			
			String[] line = null;
			for(int n = 0; n < N; n++)
			{
				line = in.readLine().split(" ");
				pairs[n][0] = Integer.parseInt(line[0]);
				pairs[n][1] = Integer.parseInt(line[1]);
			}
			
			int left = pairs[0][0];
			int right = pairs[0][1];
			
			
			StringBuilder sb = new StringBuilder();
			int count =0;
			for(int i = 1; i < N; i++)
			{
				int targetLeft = pairs[i][0];
				int targetRight = pairs[i][1];
				
				while(left < targetLeft)
				{
					if(left == right-1)
					{
						right++;
						sb.append("R+");
						count++;
					}
					
					left++;
					sb.append("L+");
					count++;
				}
				
				while(left > targetLeft)
				{
					left--;
					sb.append("L-");
					count++;
				}
				
				while(right < targetRight)
				{
					right++;
					sb.append("R+");
					count++;
				}
				
				while(right > targetRight)
				{
					right--;
					sb.append("R-");
					count++;
				}
			}
			System.out.println(count);
			System.out.println(sb.toString());
			
		}

	}

}
