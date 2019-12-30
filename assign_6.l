/* 
Assignment No: 6
Write a program using Lex specifications to implement lexical analysis phase of compiler to
generate tokens of subset of ‘Java’ program
Class: TE-A
*/

%{
	#include<stdio.h>
	FILE *fp;
%}


Package "import".*;
classdef "class ".*|Scanner
inbuiltfun "System.out.println(".*");"
mainfunction "public static void main".*
Assignment [a-zA-Z]+"=".*;
Datatype "int"|"float"|"double"
object .*"=new".*

%%

{Package} {printf("Package is %s",yytext);}
{classdef} {printf("Class is %s",yytext);}
{inbuiltfun} {printf("Inbuilt Function is %s",yytext);}
{mainfunction} {printf("Main Function is %s",yytext);}
{Datatype} {printf("Data Type is %s",yytext);}
{Assignment} {printf("Assignment Statement is %s",yytext);}
{object} {printf("%s is object",yytext);}
%%


int main(int argc,char *argv[])
{
	fp=fopen(argv[1],"r");
	yyin=fp;
	yylex();
	return 0;
}


/*

Java Input File:

import java.util.Scanner;

class Addition
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a,b,sum;
		System.out.println("Enter two no's:-");
		
		a=sc.nextInt();
		b=sc.nextInt();

		sum=a+b;

		System.out.println("Sum="+sum);
	}
}

OUTPUT:-
unix@unix-HP-280-G1-MT:~/Desktop/tea65/system$ lex javafilelex.l
unix@unix-HP-280-G1-MT:~/Desktop/tea65/system$ gcc lex.yy.c -ll
unix@unix-HP-280-G1-MT:~/Desktop/tea65/system$ ./a.out Addition.java
Package is import java.util.Scanner;

Class is class Addition
{
	Main Function is public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in); is object
		Data Type is int a,b,sum;
		Inbuilt Function is System.out.println("Enter two no's:-");
		
		Assignment Statement is a=sc.nextInt();
		Assignment Statement is b=sc.nextInt();

		Assignment Statement is sum=a+b;

		Inbuilt Function is System.out.println("Sum="+sum);
	}
}
*/


