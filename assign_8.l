/*
Assignment no: 8
Parser generator for simple and compound sentences
Class: TE-A
*/


%{
	#include "y.tab.h"
	extern int yylval;
%}

%%
"for" {return (FOR);}
"(" {return (OPBR);}
")" {return (CLBR);}
"{" {return (OPCBR);}
"}" {return (CLCBR);}
";" {return (SEMI);}
"=" {return (EQU);}
"<"|">"|"<="|">=" {return (REOP);}
"++" {return (INC);}
"--" {return (DEC);}
[a-z|A-Z] {yylval=yytext[0]; return ID;}
[0-9]	{yylval=atof(yytext); return NUM;}

%%


/*
output -
unix@unix-HP-280-G1-MT:~$ lex forloop.l
unix@unix-HP-280-G1-MT:~$ yacc -d forloop.y
unix@unix-HP-280-G1-MT:~$ cc lex.yy.c y.tab.c -ll -ly
y.tab.c: In function ‘yyparse’:
y.tab.c:1146:16: warning: implicit declaration of function ‘yylex’ [-Wimplicit-function-declaration]
       yychar = yylex ();
                ^
y.tab.c:1281:7: warning: implicit declaration of function ‘yyerror’ [-Wimplicit-function-declaration]
       yyerror (YY_("syntax error"));
       ^
unix@unix-HP-280-G1-MT:~$ ./a.out 
for(i=0;i<8;i++){}

Accepted..
^C
unix@unix-HP-280-G1-MT:~$ 




*/
