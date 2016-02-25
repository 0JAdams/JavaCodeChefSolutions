import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	//functions for a fenwick tree:
		static void update(long[] fTree, int i, int x){
			while(i<fTree.length){
				fTree[i]+=x;
				i|=i+1;
			}
		}
		
		static long query(long[] fTree, int i){
			long sum=0;
			while(i>=0){
				sum+=fTree[i];
				i &= i+1;
				i--;
			}
			return sum;
		}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder out = new StringBuilder();
		String[] line = in.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int C = Integer.parseInt(line[2]);
		long[] fTree = new long[N];
		StringTokenizer tokenizer;
		//set initial value of each item
		update(fTree, 0, C);
		
		//perform list of tasks
		for(int m=0; m<M; m++)
		{
			tokenizer = new StringTokenizer(in.readLine());
			char H = tokenizer.nextToken().toCharArray()[0];
			if(H=='Q') //perform query
			{
				int P = Integer.parseInt(tokenizer.nextToken())-1;
				long Q = query(fTree, P);
				out.append(Q);
				out.append("\n");
			}
			else //if(H=='S') //perform update from U to V
			{
				int U = Integer.parseInt(tokenizer.nextToken())-1;
				int V = Integer.parseInt(tokenizer.nextToken())-1;
				int K = Integer.parseInt(tokenizer.nextToken());
				update(fTree, U, K);
				if(V+1<N)
					update(fTree, V+1, -K);
			}
		}
		
		System.out.println(out.toString());
	}

}
