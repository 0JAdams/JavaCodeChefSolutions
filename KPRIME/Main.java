
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	
	public static void main(String[] args)
	{
		int[] a = new int[0];
		int[] b = new int[0];
		int[] k = new int[0];
		
		int problemCount = 0;	
		int largestCount = 2;
		
		String[] line;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			problemCount = Integer.parseInt(in.readLine());
			
			a = new int[problemCount];
			b = new int[problemCount];
			k = new int[problemCount];
			
			for(int i=0; i< problemCount; i++)
			{
				line = in.readLine().split(" ");
				a[i] = Integer.parseInt(line[0]);
				b[i] = Integer.parseInt(line[1]);
				k[i] = Integer.parseInt(line[2]);
				if(b[i]>largestCount)
				{
					largestCount = b[i];
				}
			}
			
			in.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] numberArray = new int[largestCount+1];
		
		
		for(int i=2; i<numberArray.length; i++ ) 
		{
			if(numberArray[i]==0)
			{
				for(int j=i; j<numberArray.length; j+=i)
				{
					numberArray[j]++;
				}
			}
		} //end primacy generation
		
		int[][] kValueUpToI = new int[6][numberArray.length];
		for(int i = 1; i<6;i++)
		{
			for(int j=2; j<numberArray.length; j++)
			{
				if(numberArray[j]==i)
				{
					kValueUpToI[i][j] = kValueUpToI[i][j-1]+1;
				}
				else
				{
					kValueUpToI[i][j] = kValueUpToI[i][j-1];
				}
			}
		}
		
		for(int i = 0; i<problemCount; i++)
		{
			System.out.println((kValueUpToI[k[i]][b[i]]-kValueUpToI[k[i]][a[i]-1]));
			
		}
	}
	
}
