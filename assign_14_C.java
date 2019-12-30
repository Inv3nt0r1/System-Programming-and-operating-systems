/*
Assignment no: 14
Page replacement algorithm
Class: TE-A
*/

import java.io.*;
      class Fifo
        {
        public static void main(String args[])throws IOException
         {
          BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
         int f,page=0,ch,pgf=0,n,chn=0;
      boolean flag;
        int pages[]; 		//pgf-page fault
      
      	System.out.println("1.FIFO");
     int pt=0;
         	System.out.println("enter no. of frames: ");
     	 f=Integer.parseInt(obj.readLine());
      	int frame[]=new int[f];
      	for(int i=0;i<f;i++)
      		{
      		frame[i]=-1;
      		}
       	System.out.println("enter the no of pages ");
      	 n=Integer.parseInt(obj.readLine());
      	 pages=new int[n];
      	System.out.println("enter the page no ");
      	for(int j=0;j<n;j++)
     	pages[j]=Integer.parseInt(obj.readLine());
       	
       	int pg=0;
       	for(pg=0;pg<n;pg++)
            {
      	page=pages[pg];
       	flag=true;
      	for(int j=0;j<f;j++)
     	{
       	if(page==frame[j])
       	{
       	flag=false;
      	 break;
        }
       	}
       	if(flag)
        	{
        	frame[pt]=page;
        	pt++;
       	if(pt==f)
      	pt=0;
       	System.out.print("frame :");
      	for(int j=0;j<f;j++)
       	System.out.print(frame[j]+"   ");
    	System.out.println();
       	pgf++;
       	}
      	else
      	{
      	System.out.print("frame :");
       	for(int j=0;j<f;j++)
      	System.out.print(frame[j]+"  ");
    	System.out.println();
       	}
    	
       	}//for
       
        	System.out.println("Page fault:"+pgf);

}//main
}//class
