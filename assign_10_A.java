/*
Assignment no: 10
Process scheduling algorithms
Class: TE-A
*/

import java.util.Scanner;

class fcfs
{
    public static void main(String[] args)
    {
   
    int proc,i,x=0;
    int[] burst=new int[50];	
    int[] process=new int[50];
    int[] wait=new int[50];
    
    
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the number of processes:");
    proc = s.nextInt();
   
    
    System.out.println("Enter the  burst time for the processes : ");
    for(i=0;i<proc;i++)
    {
     burst[i]=s.nextInt();
    }
	
	 wait[0]=0;
	for( i=0;i<proc;i++)
	 {
         wait[i] = x+burst[i-1];
       	x=wait[i];        
      }
	
      for( i=0;i<proc;i++)
	 {
        	System.out.println("Process:" +i+ "\t\tburst:" +x+ "\t\twait:"+wait[i] );
	 
      }      
	
      int sum=0;
      for( i=0;i<proc;i++)
	 {
      int avg=sum/3;
	 System.out.println("avg time is "+avg);
	 
      }	
	}
}
   
 
