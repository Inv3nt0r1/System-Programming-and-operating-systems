/*
Assignment no: 3
Implement Pass I of Macroprocessor
Class: TE-A
*/

import java.util.*;
import java.io.*;

public class MacroPass1{
	
	String MDT[][] = new String[20][4];
	String MNT[][] = new String[20][2];
	String argumentList[] = new String[20];
	public String code[][] = new String[20][4];
	int MDTcount, MNTcount, argumentCount, codeSize;
	
	MacroPass1(){
		MDTcount = 0;
		MNTcount = 0;
		argumentCount = 0;
		codeSize = 0;
	}
	
	public void getData(){
		try{
			File file = new File("input1.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp1;
			int j,i = 0;
			
			while( (temp1 = br.readLine()) != null ){
				String temp2[] = temp1.split("\t");
		
				for( j=0; j<temp2.length; j++)
					code[i][j] = temp2[j];
				
				while(j<4){
					code[i][j] = "";
					j++;
				}
				i++;
			}
			codeSize = i;
			
		}catch(Exception e){ System.out.println(e); }
	}
	
	public void createTable(){
		int pos = 0;
		boolean flag = false;
		while(pos < codeSize){
			
			if(code[pos][1].contains("MACRO")){
				pos++;
				
				MNT[MNTcount][0] = code[pos][1];
				MNT[MNTcount++][1] = Integer.toString(MDTcount);
				
				String temp[] = code[pos][2].split(",");
				
				for(int i=0; i<temp.length; i++){
					if(temp[i].contains("=")){
						String temp2[] = temp[i].split("=");
						argumentList[argumentCount++] = temp2[0];
					}
					else
						argumentList[argumentCount++] = temp[i];
				}
				
				flag = true;
			}
			else if(flag){
				int temp;
				
				MDT[MDTcount][0] = code[pos][0];
				MDT[MDTcount][1] = code[pos][1];
				
				temp = linearSearch(code[pos][2]);
				if(temp != -1){
					MDT[MDTcount][2] = Integer.toString(temp);
				}else{
					MDT[MDTcount][2] = "";
				}
				
				temp = linearSearch(code[pos][3]);
				if(temp != -1){
					MDT[MDTcount][3] = Integer.toString(temp);
				}else{
					MDT[MDTcount][3] = "";
				}
				
				MDTcount++;
			
				if(code[pos][1].contains("MEND"))
					flag = false;
			}
			
			pos++;
		}	
		
	}
	
	public int linearSearch(String key){
		if(key == "")
			return -1;
		
		for(int i=0; i<argumentCount; i++){
			if(argumentList[i].contains(key))
				return i;
		}
		
		return -1;
	}
	
	public void putData(){
		int i,j;
		System.out.println("ArgumentList:");
		for(i=0; i<argumentCount; i++){
			System.out.println(argumentList[i]);
		}
		
		System.out.println("\n\nMNT:");
		for(i=0; i<MNTcount; i++){
			for(j=0; j<2; j++){
				System.out.print(MNT[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("\n\nMDT:");
		for(i=0; i<MDTcount; i++){
			for(j=0; j<4; j++){
				System.out.print(MDT[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		/*System.out.println("Code:");
		for(i=0; i<codeSize; i++){
			for(j=0; j<4; j++){
				System.out.print(code[i][j]+"\t");
			}
			System.out.print("\n");
		}*/
	}
	
	
	
	
	public static void main(String[] args){
		MacroPass1 obj = new MacroPass1();
		
		obj.getData();
		obj.createTable();
		obj.putData();
	}
}



/*OUTPUT:
ArgumentList:
&X
&Y
&REG1
&A
&B
&REG2


MNT:
INCR	0	
DECR	4	


MDT:
	MOVER	2	0	
	ADD	2	1	
	MOVEM	2	0	
	MEND			
	MOVER	5	3	
	SUB	5	4	
	MOVEM	5	3	
	MEND	*/
