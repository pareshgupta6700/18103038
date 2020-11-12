import java.util.*;
import java.lang.*;
import java.util.Scanner;
public class ques1{
	public static void main(String[] args) {
		int n; 
		Scanner in = new Scanner(System.in); 
		n = in.nextInt();
		in.nextLine(); 
		String[] crops = new String[n]; 
		for (int i=0;i<n;i++)
		{ 
			crops[i]=in.nextLine().trim();
		}
		System.out.print(replant(crops));
	}
	public static int replant(String[] crops)
	{
		int num = crops.length;
        String cropsReverse[] = new String[num];
        for(int i = 0;i<num;++i) {
            StringBuilder temp = new StringBuilder(crops[i]);
            cropsReverse[i] =  temp.reverse().toString();
        }
        int res1 = replantUtil(crops);
        int res2 = replantUtil(cropsReverse);
        return (res1>res2)?res2:res1;   
	}
	public static int replantUtil(String[] crops) {
        int rows = crops.length;
        int cols = crops[0].length();
        int dp[][] = new int[rows][cols];
        for(int i = 0;i<rows;++i){
            for(int j=0;j<cols;++j)
                dp[i][j]=0;
        }
        for(int i= 1;i<rows;++i) {
            dp[i][0] = dp[i-1][0];
            if(crops[i].charAt(0)==crops[i-1].charAt(0)&&crops[i].charAt(0)!='$') {
                dp[i][0]++;
                String crop = crops[i];
                crop = '$'+crop.substring(1);			//we need to change our crop
                crops[i] = crop;
            }
        }
        for(int j = 1;j<cols;++j) {
            dp[0][j] = dp[0][j-1];
            if(crops[0].charAt(j)==crops[0].charAt(j-1)&&crops[0].charAt(j)!='$') {
                dp[0][j]++;
                String crop = crops[0];
                crop = crop.substring(0,j)+'$'+crop.substring(j+1); 		//we need to change our crop
                crops[0] = crop;
            }
        }
        for(int i = 1;i<rows;++i) {
            for(int j = 1;j<cols;++j) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
                if((crops[i].charAt(j)==crops[i].charAt(j-1))||(crops[i].charAt(j)==crops[i-1].charAt(j))){
                    dp[i][j]++;    
                    String crop = crops[i];
                    crop = crop.substring(0,j)+'$'+crop.substring(j+1);		//agin we need to change to our crop	
                    crops[i] = crop;
                }
            }
        }
/*         for(int i=0;i<rows;i++)
         {
         	for(int j=0;j<cols;j++)
         	{
         		System.out.print(dp[i][j]);
         	}
      		System.out.println();
        }*/
        return dp[rows-1][cols-1];
    }
}