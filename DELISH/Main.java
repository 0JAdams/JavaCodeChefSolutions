import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Jonathan
// cpt_fwiffo
// 2/13/2015

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tests = 0; tests < T; tests++)
		{
			int N = Integer.parseInt(in.readLine());
			String[] line = new String[N];
			line = in.readLine().split(" ");
			long[] nums = new long[N];
			for(int n=0; n< N ; n++)
			{
				nums[n] = Integer.parseInt(line[n]);
			}
			
			long answer = findMax(nums, N);
			System.out.println(answer);
		}

	}
	
	public static long findMax(long[] nums, int N)
	{
		long[] maxFromLeft = new long[N];
		long[] minFromLeft = new long[N];
		long[] maxFromRight = new long[N];
		long[] minFromRight = new long[N];
		
		
		maxFromLeft[0] = nums[0];
		minFromLeft[0] = nums[0];
		maxFromRight[N-1] = nums[N-1];
		minFromRight[N-1] = nums[N-1];
		
		for(int i=1, j=N-2; i< N; i++, j--) //precompute series of max and mins from left
		{
			
			maxFromLeft[i] = Math.max(maxFromLeft[i-1] + nums[i], nums[i]);
			minFromLeft[i] = Math.min(minFromLeft[i-1] + nums[i], nums[i]);
			
			maxFromRight[j] = Math.max(maxFromRight[j+1] + nums[j], nums[j]);
			minFromRight[j] = Math.min(minFromRight[j+1] + nums[j], nums[j]);
			
		}
		
		return findMaxDelta(minFromLeft, maxFromLeft, minFromRight, maxFromRight); //use arrays to find max delta
	}
	
	
	public static long findMaxDelta(long[] minFromLeft, long[] maxFromLeft, long[] minFromRight, long[] maxFromRight)
	{
		long largestDelta = 0;
		long testCase =0;
		for(int i=0; i< minFromLeft.length-1; i++)
		{
			testCase = Math.max(Math.abs(minFromLeft[i] - maxFromRight[i+1]), Math.abs(minFromRight[i+1] - maxFromLeft[i]));
			if(largestDelta<testCase)
			{
				largestDelta = testCase;
			}
		}
		
		return largestDelta;
	}
}
