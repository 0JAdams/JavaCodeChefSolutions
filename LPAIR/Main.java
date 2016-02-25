import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
	static class Pair{
		public int m, f;
		public Pair(int M, int F)
		{
			m=M;
			f=F;
		}
	}
	
	//functions for a fenwick tree:
	static void update(int[] fTree, int i, int x){
		while(i<fTree.length){
			fTree[i]+=x;
			i|=i+1;
		}
	}
	
	static long query(int[] fTree, int i){
		long sum=0;
		while(i>=0){
			sum+=fTree[i];
			i &= i+1;
			i--;
		}
		return sum;
	}
	
	static class sortM implements Comparator<Pair>{ 
		public int compare(Pair a, Pair b)
		{
			if(a.m == b.m)
				return 0;
			if(a.m > b.m)
				return 1;
			else 
				return -1;
		}
	}
	
	static class sortF implements Comparator<Pair>{ 
		public int compare(Pair a, Pair b)
		{
			if(a.f == b.f)
				return 0;
			if(a.f > b.f)
				return 1;
			else 
				return -1;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long count =0;
		String[] line;
		Pair[] pairs = new Pair[N];
		Pair[] pairsCopy;
		int[] fTree = new int[N];
		
		for(int n=0; n<N; n++)
		{
			line = in.readLine().split(" ");
			int m = Integer.parseInt(line[0]);
			int f = Integer.parseInt(line[1]);
			pairs[n] = new Pair(m,f);
		}
		pairsCopy = Arrays.copyOf(pairs, N);
		
		Arrays.sort(pairs, new sortM());
		Arrays.sort(pairsCopy, new sortF());
		
		for(int n=0; n<N; n++)
		{
			pairsCopy[n].f = n;
		}
		
		for(int n=N-1; n>=0; n-- )
		{
			count+= query(fTree, pairs[n].f);
			update(fTree, pairs[n].f, 1);
		}
		
		System.out.println(count);
	}

}
