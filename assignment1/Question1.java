// Simple Java program to count occurrences 
// of pat in txt. 
import java.util.Arrays; 
class Question1 { 
	
	static int countFreq(String pat, String txt) {		 
		int M = pat.length();		 
		int N = txt.length();		 
		int res = 0; 
      char tempArray[] = pat.toCharArray(); 
      Arrays.sort(tempArray);
      String s1= new String(tempArray);

	
		for (int i = 0; i <= N - M; i++) { 
		    String s2=txt.substring(i,i+M);
            tempArray = s2.toCharArray(); 
           Arrays.sort(tempArray);
           String s3= new String(tempArray);
 
            if(s1.equals(s3))
              res++;
			 			 
		}		 
		return res;		 
	} 

	/* Driver program to test above function */
	static public void main(String[] args) { 
		String txt = args[0];		 
		String pat = args[1];	 
		System.out.println(countFreq(pat, txt));		 
	} 
} 

// This code is contributed by 29AjayKumar 

