/*
/*
Assignment no: 4
Implement Pass II of Macroprocessor
Class: TE-A

*/


import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class macro
{
	public static void main(String args[])throws IOException
	{
		int MDTC=1;
		int MNTC=1;
		int index=1;
		int macroindex=0;
		String arg[]=new String[10];
		String mname[]=new String[10];
		String MNT[][]=new String[10][10];
		String MDT[][]=new String[10][10];
		String output =new Scanner(new File("macro.txt")).useDelimiter("\\Z").next();
		String result[]=output.split("\n");
		String result1[]=output.split("[,\\s\\?]");
		for(int k=0;k<result1.length;k++)
		{
			if(result1[k].equals("MACRO")||result1[k].equals("macro"))
			{
				mname[macroindex]=result1[k+2];
				macroindex++;
			}
		}
		System.out.println("\nMACRO NAME TABLE\n—————————————–");
		System.out.println("VALUE OF MDTC\tMNTC\tNAME");
		for(int k=0;k<macroindex;k++)
		{
			System.out.println("\t"+MDTC+"\t"+MNTC+"\t"+mname[k]);
			MNTC=MNTC+1;
		}
		System.out.println("\n\n MACRO DEF TABLE\n—————————————–");
		System.out.println("INDEX\tCARD");
		for(int i=1;i<result.length;i++)
		{
			System.out.println(MDTC+"\t"+result[i]);
			MDTC=MDTC+1;
		}
		System.out.print("\n\nARGUMENT LIST ARRAY\n——————————–");
		for(int k=3;k<result1.length;k++)
		{
			if(result1[k].equals(mname[0]))
			{
				arg[0]=result1[k+1];
				arg[1]=result1[k+2];
				arg[2]=result1[k+3];
			}
		}
		System.out.println("\nINDEX\t ARGUMENTS");
		System.out.println("\n"+ index+ "\t" +arg[0]+"\n"+(index+1)+"\t"+arg[1]+"\n"+(index+2)+"\t"+arg[2]+"\n");
		System.out.print("\n\nOUTPUT PROGRAM AFTER CALL\n——————————–");
		for(int k=6;k<result1.length;k++)
		{
			for(int i=3;i<6;i++)
			{
				if(result1[k].equals(result1[i]))
				{
					result1[k]=arg[i-3];
				}
			}
		}
		for(int k=6;k<result1.length;k++)
		{
			if(result1[k].equals("MEND"))
			{
				System.out.print("END");
				break;
			}
			if(result1[k].equals(""))
			System.out.println();
			else
			System.out.print(result1[k]+" ");
		}
	}
}
