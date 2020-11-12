 class Count extends Thread
{
  public void run()
  {
    for(int i=1;i<=100;i++)
    {
      System.out.println(i);
      try
      {
      Thread.sleep(1000);
        if(j%10==0)
                {
                	System.out.println("String printed after every ten number counting.");
                }
      }
      catch (Exception e)
      {
        System.out.println("Exception caught");
      }
    }
  }
}

public class Ques1 
{
  public static void main(String args[])
  {
    Count ob1=new Count();
    ob1.start();
    
  }
}