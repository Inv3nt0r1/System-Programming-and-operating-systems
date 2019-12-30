/*
Assignment no: 14
Page replacement algorithm
Class: TE-A
*/

import java.io.*;

public class Lru {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i,j,k, curr_page, page_counter, page_fault;
		i = j = k = page_fault = 0;
		boolean flag;
		
		System.out.println("Enter number of Frames: ");
		int numberOfFrames = Integer.parseInt(br.readLine());
		
		int frame[] = new int[numberOfFrames];
		int tempA[] = new int[numberOfFrames];
		int tempB[] = new int[numberOfFrames];
		
		for(i=0; i<numberOfFrames; i++){
			frame[i]=tempA[i]=tempB[i] = -1;			//initialised to -1
		}
		
		System.out.println("Enter number of pages: ");
		int total_pages = Integer.parseInt(br.readLine());
		int pages[] = new int[total_pages];
		
		System.out.println("Enter the pages: ");
		for(i=0; i<total_pages; i++){
			pages[i] = Integer.parseInt(br.readLine());
		}
		System.out.println("--------------------");
		int limit = 0;
		
		do{
			
			page_counter = 0;
			
			for(page_counter=0; page_counter < total_pages; page_counter++){
				curr_page = pages[page_counter];
				flag = true;
				
				for(j=0; j < numberOfFrames; j++){			//checks if the curr page is already present
					if(curr_page == frame[j]){
						flag = false;
						break;
					}
					
				}
				
				for(j=0; j < numberOfFrames && flag; j++){
					if(frame[j] == tempA[numberOfFrames - 1]){
						k = j;								//finding appropriate location to replace
						break;						
					}					
				}
				
				if (flag){
					frame[k] = curr_page;
					
					for(j=0; j<numberOfFrames; j++)
						System.out.print(frame[j] + "  ");
					page_fault++;
					System.out.println();
				}
				else{
					
					for(j=0; j<numberOfFrames; j++)
						System.out.print(frame[j] + "  ");
					System.out.println();
					
				}
				
				int x = 1;
				tempB[0] = curr_page;
				for(j=0; j<tempA.length; j++){
					if(curr_page!=tempA[j] && x<numberOfFrames){
						tempB[x] = tempA[j];
						x++;
					}
				}
				
				for(j=0; j<numberOfFrames; j++){
					tempA[j] = tempB[j];
				}
				limit++;
				
			}			
			
		}while(limit!=total_pages);
		System.out.println("Page fault:"+page_fault);		

	}

}
