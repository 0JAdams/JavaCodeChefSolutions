import java.util.*;

public class Main {
	static int[] FrogPos;
	static int[] FrogInd;
	public static void main(String[] args)
	{
		
		int N = 0;
		int K = 0;		
		int P = 0;
		Scanner sIn = new Scanner(System.in);
		
		N = sIn.nextInt();
		K = sIn.nextInt();
		P = sIn.nextInt();
		
		FrogPos = new int[N];
		FrogInd = new int[N];
		
		for(int i=0; i<N; i++)
		{
			FrogPos[i] = sIn.nextInt();
			FrogInd[i] = i;
		}
		sort(0, FrogPos.length-1);
		
		int[][] pairs = new int[2][P];
		
		for(int i=0; i<P; i++)
		{
			pairs[0][i] = sIn.nextInt();
			pairs[1][i] = sIn.nextInt();
		}
		
		int[] gaps = new int[FrogPos.length];		
		
	
		
		gaps[FrogInd[0]] = FrogPos[0]+K;
		
		for(int i=1; i<gaps.length;i++)
		{
			if(FrogPos[i] - FrogPos[i-1] <= K)
			{
				gaps[FrogInd[i]] = gaps[FrogInd[i-1]];
			}
			else
			{
				gaps[FrogInd[i]] = FrogPos[i]+K;
			}
		}
		
		
		for(int i=0; i<P;i++)
		{
			System.out.println(gaps[pairs[0][i]-1]==gaps[pairs[1][i]-1]? "Yes" : "No");
		}
		
		sIn.close();
		 
	}
	
	static void sort(int lo, int hi)
	{
		if (hi<=lo) return;
		int j = hi+1;
		int i = lo;
		int v = FrogPos[lo];
		
		while(true)
		{
			while(FrogPos[++i]<v) if(i==hi) break;
			while(v< FrogPos[--j]) if(j==lo) break;
			if (i>=j) break;
			exchange(i, j);
		}
		exchange(lo, j);
		sort(lo, j-1);
		sort(j+1, hi);
	}
	
	static void exchange(int i, int j)
	{
		int hold = FrogPos[i];
		FrogPos[i] = FrogPos[j];
		FrogPos[j] = hold;
		
		hold = FrogInd[i];
		FrogInd[i] = FrogInd[j];
		FrogInd[j] = hold;
	}
	
	
}
