// Declarations
package org.example.compscript.parser;

import java_cup.runtime.*;

%%

%class Lexer
%unicode
%line
%column
%public
%cup
%ignorecase

%init{
    yyline = 1;
    yychar = 1;
%init}

// Regular definitions
delim = [ \r\t\f\n]
ws = {delim}+
// letter = [A-Za-z\_]
digit = [0-9]

%%
<YYINITIAL> {

    "//".* {
        System.out.println("Recognized SINGLE_LINE_COMMENT " + yytext());
        return new Symbol(sym.SINGLE_LINE_COMMENT, yyline, yycolumn, yytext()); 
    }
    "/*"([^*]|(\*+[^*/]))*\*+"/" {
        System.out.println("Recognized BLOCK_COMMENT: " + yytext());
        return new Symbol(sym.BLOCK_COMMENT, yyline, yycolumn, yytext());
    }
    {digit}+ { 
        System.out.println("Recognized WHOLE " + yytext());
        return new Symbol(sym.WHOLE, yyline, yycolumn, yytext()); 
    }
    {digit}+(\.{digit}+)? { 
        System.out.println("Recognized DOUBLE " + yytext());
        return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext()); 
    }
    "true"|"false" { 
        System.out.println("Recognized BOOLEAN " + yytext());
        return new Symbol(sym.BOOLEAN, yyline, yycolumn, yytext()); 
    }
    "'"([^'\\]|\\[nt\"\\\\'])"'" { 
        System.out.println("Recognized CHAR " + yytext());
        return new Symbol(sym.CHAR, yyline, yycolumn, yytext()); 
    }
    "\""([^\"\\]|\\[nt\"\\\\'])*"\"" { 
        System.out.println("Recognized STRING " + yytext());
        return new Symbol(sym.STRING, yyline, yycolumn, yytext()); 
    }

    {ws} {/* Ignore */}

    // Arithmetic operators
    "+" {  
        System.out.println("Recognized ADDITION " + yytext());
        return new Symbol(sym.ADDITION, yyline, yycolumn, yytext()); }
    "-" {  
        System.out.println("Recognized SUBSTRACTION " + yytext());
        return new Symbol(sym.SUBSTRACTION, yyline, yycolumn, yytext()); }
    "*" {  
        System.out.println("Recognized MULTIPLICATION " + yytext());
        return new Symbol(sym.MULTIPLICATION, yyline, yycolumn, yytext()); }
    "/" {  
        System.out.println("Recognized DIVISION " + yytext());
        return new Symbol(sym.DIVISION, yyline, yycolumn, yytext()); }
    "^" {  
        System.out.println("Recognized POWER " + yytext());
        return new Symbol(sym.POWER, yyline, yycolumn, yytext()); }
    "$" {  
        System.out.println("Recognized ROOT " + yytext());
        return new Symbol(sym.ROOT, yyline, yycolumn, yytext()); }
    "%" {  
        System.out.println("Recognized MODULO " + yytext());
        return new Symbol(sym.MODULO, yyline, yycolumn, yytext()); }

    ";" { 
        System.out.println("Recognized END " + yytext());
        return new Symbol(sym.END, yyline, yycolumn, yytext()); }

    [^] {
        System.err.println("Unrecognized character: " + yytext());
        return new Symbol(sym.ERROR, yyline, yycolumn, yytext());
    }

}