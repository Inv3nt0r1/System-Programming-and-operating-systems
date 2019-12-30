/*
Assignment no: 7
Lexical analysis to count words, lines, spaces, special symbols, characters, digit, decimals
Class: TE-A
*/


%{ 
    #include<stdio.h>
    int word_cnt = 0, line_cnt = 0, space_cnt = 0, specialsymbol_cnt = 0, character_cnt = 0, digit_cnt  = 0, decimal_cnt = 0;
    FILE *fp;

%}

word [a-zA-Z]+
digit [0-9]+
decimal [0-9]*\.[0-9]+
line [\n]+
space [\t|' ']+
special ['$' | '#' | '!' | '@' | '%' | '^' | '*' | '(' | ')' | '\-' | '/']+

%%
{word} {word_cnt++ ;character_cnt+=yyleng;}    
{digit} {digit_cnt++; character_cnt += yyleng;}
{decimal} {decimal_cnt++; character_cnt += yyleng;}
{line} {line_cnt++; character_cnt += yyleng;}
{space} {space_cnt++; character_cnt += yyleng;}
{special} {specialsymbol_cnt++; character_cnt += yyleng;}
%%

int main(int argc, char *argv[])
{
    fp = fopen(argv[1], "r");
    yyin = fp;
    yylex();
    
    printf("\nWord Count: %d", word_cnt);
    printf("\nCharacter Count: %d", character_cnt);
    printf("\nDigit Count: %d", digit_cnt);
    printf("\nDecimal Count: %d", decimal_cnt);
    printf("\nLine Count: %d", line_cnt);
    printf("\nSpace Count: %d", space_cnt);
    printf("\nSpecial Symbols Count: %d", specialsymbol_cnt);
    
    return 0;
}




