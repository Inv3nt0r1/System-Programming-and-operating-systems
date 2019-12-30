/*
ASSIGNMENT NO: 9
Write a program using YACC specifications to implement syntax analysis phase of compiler
to validate type and syntax of variable declaration in Java.
CLASS: TE-A
*/

%{
#include<stdio.h>
int flag=0;
%}

%token DATATYPE EQUAL SEMIC ID NUM


%%
S:S1|S2
;

S1:DATATYPE ID SEMIC
{
	printf("\n Correct syntax");
	flag=1;
}
;

S2: DATATYPE ID EQUAL NUM SEMIC
{
	printf("\n Correct syntax");
	flag=1;
}
;

%%

int main()
{
	yyparse();
}

yyerror()
{
	if(flag==0)
	printf("Error in Syntax");
}
yywrap()
{
	return 1;
}

//OUTPUT
/*./a.out
int a ;
  
 Correct syntax
^Z
[6]+  Stopped                 ./a.out
unix@unix-HP-280-G1-MT:~$ lex jcheck.l
unix@unix-HP-280-G1-MT:~$ yacc -d jcheck.y
unix@unix-HP-280-G1-MT:~$ cc lex.yy.c y.tab.c -ll -ly
y.tab.c: In function ‘yyparse’:
y.tab.c:1123:16: warning: implicit declaration of function ‘yylex’ [-Wimplicit-function-declaration]
       yychar = yylex ();
                ^
y.tab.c:1270:7: warning: implicit declaration of function ‘yyerror’ [-Wimplicit-function-declaration]
       yyerror (YY_("syntax error"));
       ^
jcheck.y: At top level:
jcheck.y:32:1: warning: return type defaults to ‘int’ [-Wimplicit-int]
 yyerror()
 ^
jcheck.y:37:1: warning: return type defaults to ‘int’ [-Wimplicit-int]
 yywrap()
 ^
unix@unix-HP-280-G1-MT:~$ ./a.out
int a = 1 ;
    
 Correct syntax
*/


