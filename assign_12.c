/*
Assignment no: 12
Unix system call
Class: TE-A
*/

#include<stdio.h>
#incude<stdlib.h>
#include<unistd.h>
//#include<sys/type.h>

void parent()
{
printf("\n\tThis is parent task");
	printf("\n\tChild dies...hence parent executing");
}
void main()
{
	pid_t pid,pid1;
	int status;

	printf("\n\tParent executing");
	pid=fork();
	
	if(pid==0)
	{
	        printf("\n\tChild Created");
	        printf("%d ",pid);
	        sleep(10);
	        printf("\n\tChild after sleep");
	        execlp("/bin/ps","ps",NULL);
	        exit(0);
	} 
	else
	{
	        printf("\n\tParent again executing");
	        printf("%d ",pid);
	        pid1=wait(&status);
	        printf("\n%d ",pid1);
	        parent();
	        printf("\n\tParent after child exit");
	        printf("\n\tParent terminating");
	        exit(0);
	}
}
