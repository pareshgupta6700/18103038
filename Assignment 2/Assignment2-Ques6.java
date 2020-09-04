

import java.io.Console;  

public class Ques6  {
public static void main(String[] args) {
Console c=System.console();    
System.out.println("Enter the Number: ");    
int n=Integer.parseInt(c.readLine());    

int evenNum; // define even number as integer
int oddNum; // define odd number as integer
int halfNum; // define Hailstone step1 if number is even as integer
int tripleOne; // define Hailstone step1 if number is odd as integer 3n+1
int count = 0; // define steps it takes to get to 1 as count and initialize at 0

if (n == 1) {
System.out.println("Please enter a number larger than 1.");
}

while (n != 1) { // run if/else statement until n is not equal to 1

if ((n % 2) == 0) {
evenNum = n;
halfNum = (evenNum / 2);
System.out.println(evenNum + " is even, so I take half: " + halfNum);
n = halfNum;

} else {
oddNum = n;
tripleOne = ((3 * n) + 1);
System.out.println(oddNum + " is odd, so I make 3n+1: " + tripleOne);
n = tripleOne;

}
count++; //increment counter 1 for every while loop
}

System.out.println("I've reached the number 1, I'm stopping.");
System.out.println("The process took " + count + " steps to reach 1.");
}
}
