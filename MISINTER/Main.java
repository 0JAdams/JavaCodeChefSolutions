import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
	static long MD = 1000000007;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int problemCount = Integer.parseInt(in.readLine());
		int[] problems = new int[problemCount];
		for(int i=0; i<problemCount; i++)
		{
			problems[i] = Integer.parseInt(in.readLine());
		}
		
		in.close();
		
		
		
		int groupCount = 0;
		long solution = 0;
		for(int i=0; i<problems.length; i++)
		{
			groupCount = findGroups(problems[i]);
			solution = getPermutations(26, groupCount);
			System.out.println(solution);
		}
	}
	
	static long getPermutations(int num, int power)
	{
		long solution = 1;
		for(int i=0; i< power; i++)
		{
			solution = solution * 26 % MD;
		}
		return solution;
	}
	
	static int findGroups(int charCount)
	{
		int numberOfGroups=0;
		int[] positions = new int[charCount];
		int result = 0;
		int j=0;
		for(int i=0; i<charCount; i++)
		{
			if(positions[i]==0)
			{
				positions[i] = 1;
				j = i+1;
				while(result!=i+1)
				{	
					if( j % 2 == 0)
					{
						result = (j)/2;
					}
					else
					{
						result = charCount/2 + (j+1)/2;
					}
					positions[result-1] = 1;
					j=result;
				}
				numberOfGroups++;
			}
		}
		
		
		return numberOfGroups;
	}
}
