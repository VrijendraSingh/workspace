
public class TestClass {

	/**
	 * @param args
	 */
	static int count = 0;
	public static void main(String[] args) 
	{
		
		System.out.println(gcdIt(2,1));
		//System.out.println(count);
	}
	
	
	
	public static long gcdDP(int a, int b)
	{
		int N = 0;
		if (a > b) {
			N = a+1;
		} else {
			N = b+1;
		}
		int stepCount = 0;
		long[][] mat= new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = i; j<N;j++) {
				mat[i][j] = mat[j][i]=gcdREC(i,j);
				stepCount++;
			}
		}
		System.out.println(stepCount);

		return mat[a][b];
	}
	
	
	public static long gcdREC(long a, long b)
	{
		if (b == 0) {
			return a;
		} else {
			return gcdREC(b,a%b);
		}
	}
	
	
	public static long gcdIt(long a, long b)
	{
		
		while (b > 0) {
			long c  = a%b;
			 a = b;
			 b = c;
					
		}
		
		return a;
	}
		
		

}
