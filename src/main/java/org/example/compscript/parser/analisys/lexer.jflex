// Declarations
package org.example.compscript.parser.analisys;

import java_cup.runtime.*;
import java.util.LinkedList;
import org.example.compscript.parser.exceptions.*;

%%

%{
    public LinkedList<CompError> lexicalErrors = new LinkedList<>();
%}

%init{
    yyline = 1;
    yychar = 1;
    lexicalErrors = new LinkedList<>();
%init}

%class Lexer
%unicode
%line
%column
%public
%cup
%ignorecase

// Regular definitions
delim = [ \r\t\f\n]
ws = {delim}+
letter = [A-Za-z\_]
digit = [0-9]

%%
<YYINITIAL> {

    //Reserved words
    "int" {
        // System.out.println("Recognized INT_RW " + yytext());
        return new Symbol(sym.INT_RW, yyline, yycolumn, yytext());
    }
    "double" {
        // System.out.println("Recognized DOUBLE_RW " + yytext());
        return new Symbol(sym.DOUBLE_RW, yyline, yycolumn, yytext());
    }
    "bool" {
        // System.out.println("Recognized BOOL_RW " + yytext());
        return new Symbol(sym.BOOL_RW, yyline, yycolumn, yytext());
    }
    "char" {
        // System.out.println("Recognized CHAR_RW " + yytext());
        return new Symbol(sym.CHAR_RW, yyline, yycolumn, yytext());
    }
    "string" {
        // System.out.println("Recognized STRING_RW " + yytext());
        return new Symbol(sym.STRING_RW, yyline, yycolumn, yytext());
    }
    "const" {
        // System.out.println("Recognized CONST " + yytext());
        return new Symbol(sym.CONST, yyline, yycolumn, yytext());
    }
    "let" {
        // System.out.println("Recognized LET " + yytext());
        return new Symbol(sym.LET, yyline, yycolumn, yytext());
    }
    "cast" {
        // System.out.println("Recognized CAST " + yytext());
        return new Symbol(sym.CAST, yyline, yycolumn, yytext());
    }
    "as" {
        // System.out.println("Recognized AS " + yytext());
        return new Symbol(sym.AS, yyline, yycolumn, yytext());
    }
    "if" {
        // System.out.println("Recognized IF " + yytext());
        return new Symbol(sym.IF, yyline, yycolumn, yytext());
    }
    "else" {
        // System.out.println("Recognized ELSE " + yytext());
        return new Symbol(sym.ELSE, yyline, yycolumn, yytext());
    }
    "match" {
        // System.out.println("Recognized MATCH " + yytext());
        return new Symbol(sym.MATCH, yyline, yycolumn, yytext());
    }
    "default" {
        // System.out.println("Recognized DEFAULT " + yytext());
        return new Symbol(sym.DEFAULT, yyline, yycolumn, yytext());
    }
    "while" {
        // System.out.println("Recognized WHILE " + yytext());
        return new Symbol(sym.WHILE, yyline, yycolumn, yytext());
    }
    "for" {
        // System.out.println("Recognized FOR " + yytext());
        return new Symbol(sym.FOR, yyline, yycolumn, yytext());
    }
    "do" {
        // System.out.println("Recognized DO " + yytext());
        return new Symbol(sym.DO, yyline, yycolumn, yytext());
    }
    "break" {
        // System.out.println("Recognized BREAK " + yytext());
        return new Symbol(sym.BREAK, yyline, yycolumn, yytext());
    }
    "continue" {
        // System.out.println("Recognized CONTINUE " + yytext());
        return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());
    }
    "console" {
        // System.out.println("Recognized CONSOLE " + yytext());
        return new Symbol(sym.CONSOLE, yyline, yycolumn, yytext());
    }
    "log" {
        // System.out.println("Recognized LOG " + yytext());
        return new Symbol(sym.LOG, yyline, yycolumn, yytext());
    }

    "//".* {
        // // System.out.println("Recognized SINGLE_LINE_COMMENT " + yytext());
        // return new Symbol(sym.SINGLE_LINE_COMMENT, yyline, yycolumn, yytext()); 
    }
    "/*"([^*]|(\*+[^*/]))*\*+"/" {
        // // System.out.println("Recognized BLOCK_COMMENT: " + yytext());
        // return new Symbol(sym.BLOCK_COMMENT, yyline, yycolumn, yytext());
    }
    {digit}+ { 
        // System.out.println("Recognized WHOLE " + yytext());
        return new Symbol(sym.WHOLE, yyline, yycolumn, yytext()); 
    }
    {digit}+(\.{digit}+)? { 
        // System.out.println("Recognized DOUBLE " + yytext());
        return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext()); 
    }
    "true"|"false" { 
        // System.out.println("Recognized BOOLEAN " + yytext());
        return new Symbol(sym.BOOLEAN, yyline, yycolumn, yytext()); 
    }
    "'"([^'\\]|\\[nt\"\\\\'])"'" { 
        String chr = yytext();
        chr = chr.substring(1, chr.length() -1);
        return new Symbol(sym.CHAR, yyline, yycolumn, chr); 
    }
    "\""([^\"\\]|\\[nt\"\\\\'])*"\"" { 
        // System.out.println("Recognized STRING " + yytext());
        String str = yytext();
        str = str.substring(1, str.length() -1);
        return new Symbol(sym.STRING, yyline, yycolumn, str); 
    }

    "\." {
        // System.out.println("Recognized DOT " + yytext());
        return new Symbol(sym.DOT, yyline, yycolumn, yytext());
    }

    {ws} {/* Ignore */}

    // Relational Operators
    "==" {
        // System.out.println("Recognized EQUALS_TO " + yytext());
        return new Symbol(sym.EQUALS_TO, yyline, yycolumn, yytext());
    }
    "!=" {
        // System.out.println("Recognized NOT_EQUAL " + yytext());
        return new Symbol(sym.NOT_EQUAL, yyline, yycolumn, yytext());
    }
    "<" {
        // System.out.println("Recognized LESS_THAN " + yytext());
        return new Symbol(sym.LESS_THAN, yyline, yycolumn, yytext());
    }
    "<=" {
        // System.out.println("Recognized LESS_EQUAL_THAN " + yytext());
        return new Symbol(sym.LESS_EQUAL_THAN, yyline, yycolumn, yytext());
    }
    ">" {
        // System.out.println("Recognized GREATER_THAN " + yytext());
        return new Symbol(sym.GREATER_THAN, yyline, yycolumn, yytext());
    }
    ">=" {
        // System.out.println("Recognized GREATER_EQUAL_THAN " + yytext());
        return new Symbol(sym.GREATER_EQUAL_THAN, yyline, yycolumn, yytext());
    }

    // Logic Operators
    "||" {
        // System.out.println("Recognized OR " + yytext());
        return new Symbol(sym.OR, yyline, yycolumn, yytext());
    }
    "&&" {
        // System.out.println("Recognized AND " + yytext());
        return new Symbol(sym.AND, yyline, yycolumn, yytext());
    }
    "!" {
        // System.out.println("Recognized NOT " + yytext());
        return new Symbol(sym.NOT, yyline, yycolumn, yytext());
    }

    "(" {
        // System.out.println("Recognized PAR_START " + yytext());
        return new Symbol(sym.PAR_START, yyline, yycolumn, yytext());
    }
    ")" {
        // System.out.println("Recognized PAR_END " + yytext());
        return new Symbol(sym.PAR_END, yyline, yycolumn, yytext());
    }
    " {" {
        // System.out.println("Recognized BRA_START " + yytext());
        return new Symbol(sym.BRA_START, yyline, yycolumn, yytext());
    }
    "}" {
        // System.out.println("Recognized BRA_END " + yytext());
        return new Symbol(sym.BRA_END, yyline, yycolumn, yytext());
    }

    // Arithmetic operators
    "+" {  
        // System.out.println("Recognized PLUS " + yytext());
        return new Symbol(sym.PLUS, yyline, yycolumn, yytext()); }
    "-" {  
        // System.out.println("Recognized MINUS " + yytext());
        return new Symbol(sym.MINUS, yyline, yycolumn, yytext()); }
    "*" {  
        // System.out.println("Recognized MULTIPLICATION " + yytext());
        return new Symbol(sym.MULTIPLICATION, yyline, yycolumn, yytext()); }
    "/" {  
        // System.out.println("Recognized DIVISION " + yytext());
        return new Symbol(sym.DIVISION, yyline, yycolumn, yytext()); }
    "^" {  
        // System.out.println("Recognized POWER " + yytext());
        return new Symbol(sym.POWER, yyline, yycolumn, yytext()); }
    "$" {  
        // System.out.println("Recognized ROOT " + yytext());
        return new Symbol(sym.ROOT, yyline, yycolumn, yytext()); }
    "%" {  
        // System.out.println("Recognized MODULO " + yytext());
        return new Symbol(sym.MODULO, yyline, yycolumn, yytext()); }
    "=" {  
        // System.out.println("Recognized EQUALS " + yytext());
        return new Symbol(sym.EQUALS, yyline, yycolumn, yytext()); }


    ";" { 
        // System.out.println("Recognized END " + yytext());
        return new Symbol(sym.END, yyline, yycolumn, yytext()); }
    ":" { 
        // System.out.println("Recognized COLON " + yytext());
        return new Symbol(sym.COLON, yyline, yycolumn, yytext()); }

    {letter}+({digit}|{letter})* {
        // System.out.println("Recognized ID " + yytext());
        return new Symbol(sym.ID, yyline, yycolumn, yytext()); 
    }

    [^] {
        // System.err.println("Unrecognized character: " + yytext());
        // return new Symbol(sym.ERROR, yyline, yycolumn, yytext());
        lexicalErrors.add(new CompError(ErrorType.LEXICAL, "The char " + yytext() + " does not belong to the language", yyline, yycolumn));
    }

}