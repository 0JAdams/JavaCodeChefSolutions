import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception
	{

		int num = 0;
		int n = 0;
		int k = 0;
		int count = 0;
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String[] line = in.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			k = Integer.parseInt(line[1]);
			
			for(int i=0; i<n;i++)
			{
				num = Integer.parseInt(in.readLine());
				if(num%k==0)
				{
					count++;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
}
