import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
 
public class Main {
 
	static int[][] permArray;
	static int[][] permPairs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		
		for(int tests=0; tests<T; tests++)
		{
			String[] line = in.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
 
			permArray = new int[N][3];
			permPairs = new int[M][2];
			line = in.readLine().split(" ");
			
			for(int i=0; i<line.length; i++)
			{
				permArray[i][0] = Integer.parseInt(line[i]); //put permutation numbers
				permArray[i][1] = i;						 //save original index
				permArray[i][2] = -(i+1);					 //give a unique id for each item for permutation groups
			}
			
			for(int i=0; i < M; i++)
			{
				line = in.readLine().split(" ");
				permPairs[i][0] = Integer.parseInt(line[0]); //left most index
				permPairs[i][1] = Integer.parseInt(line[1]); //right most index
			}
			
			Comparator<int[]> compareZero = new Comparator<int[]>()
					{
 
						@Override
						public int compare(int[] a, int[] b) {
 
							return a[0] - b[0];
						}
					
					};
 
			Arrays.sort(permPairs, compareZero);
			
			//sort(0, M-1, permPairs);
			
			
			int[][] groupedPairs = groupPairs(permPairs, M);
			
			int count = 0;
			for(int i=0; i<groupedPairs.length; i++)
			{
				count++;
				for(int j = groupedPairs[i][0]-1; j<groupedPairs[i][1]; j++)
				{
					if(j>=0 && j<N)
					{
						permArray[j][2] = count;						
					}
				}
			}
			
			
			Arrays.sort(permArray, compareZero);
			//sort(0, N-1, permArray);
			
			boolean possible = true;
			for(int i=0; i < N; i++)
			{
				if(!(permArray[i][2]==permArray[permArray[i][1]][2]))
				{
					possible = false;
					break;
				}
			}
			
			System.out.println((possible)?"Possible":"Impossible");
			
		}
		
		in.close();
 
	}
	
	private static int[][] groupPairs(int[][] array, int length)
	{
		int j = 0;
		int[][] groupedPairsTemp = new int[length][2];
		groupedPairsTemp[0][0] = array[0][0];
		groupedPairsTemp[0][1] = array[0][1];
		for(int i=1; i < length ; i++)
		{
			if(array[i][0]==array[i][1])//ignore pointless ranges
			{
				
			}
			else if(array[i][0]<=groupedPairsTemp[j][1]) //still within range
			{
				groupedPairsTemp[j][1] = Math.max(array[i][1], groupedPairsTemp[j][1]); 
			}
			else //need to create a new range;
			{
				j++;
				groupedPairsTemp[j][0] = array[i][0];
				groupedPairsTemp[j][1] = array[i][1];
			}
		}
		
		int[][] groupedPairs = new int[j+1][2];
		for(int i=0; i<j+1; i++)
		{
			groupedPairs[i][0] = groupedPairsTemp[i][0];
			groupedPairs[i][1] = groupedPairsTemp[i][1];
		}
		
		return groupedPairs;
	}
	
 
 
}