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
    "list" {
        return new Symbol(sym.LIST, yyline, yycolumn, yytext());
    }
    "push" {
        return new Symbol(sym.PUSH, yyline, yycolumn, yytext());
    }
    "get" {
        return new Symbol(sym.GET, yyline, yycolumn, yytext());
    }
    "set" {
        return new Symbol(sym.SET, yyline, yycolumn, yytext());
    }
    "remove" {
        return new Symbol(sym.REMOVE, yyline, yycolumn, yytext());
    }
    "pop" {
        return new Symbol(sym.POP, yyline, yycolumn, yytext());
    }
    "int" {
        return new Symbol(sym.INT_RW, yyline, yycolumn, yytext());
    }
    "double" {
        return new Symbol(sym.DOUBLE_RW, yyline, yycolumn, yytext());
    }
    "bool" {
        return new Symbol(sym.BOOL_RW, yyline, yycolumn, yytext());
    }
    "char" {
        return new Symbol(sym.CHAR_RW, yyline, yycolumn, yytext());
    }
    "string" {
        return new Symbol(sym.STRING_RW, yyline, yycolumn, yytext());
    }
    "const" {
        return new Symbol(sym.CONST, yyline, yycolumn, yytext());
    }
    "let" {
        return new Symbol(sym.LET, yyline, yycolumn, yytext());
    }
    "cast" {
        return new Symbol(sym.CAST, yyline, yycolumn, yytext());
    }
    "as" {
        return new Symbol(sym.AS, yyline, yycolumn, yytext());
    }
    "if" {
        return new Symbol(sym.IF, yyline, yycolumn, yytext());
    }
    "else" {
        return new Symbol(sym.ELSE, yyline, yycolumn, yytext());
    }
    "match" {
        return new Symbol(sym.MATCH, yyline, yycolumn, yytext());
    }
    "default" {
        return new Symbol(sym.DEFAULT, yyline, yycolumn, yytext());
    }
    "while" {
        return new Symbol(sym.WHILE, yyline, yycolumn, yytext());
    }
    "for" {
        return new Symbol(sym.FOR, yyline, yycolumn, yytext());
    }
    "do" {
        return new Symbol(sym.DO, yyline, yycolumn, yytext());
    }
    "break" {
        return new Symbol(sym.BREAK, yyline, yycolumn, yytext());
    }
    "continue" {
        return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());
    }
    "console" {
        return new Symbol(sym.CONSOLE, yyline, yycolumn, yytext());
    }
    "log" {
        return new Symbol(sym.LOG, yyline, yycolumn, yytext());
    }

    "//".* {
        // return new Symbol(sym.SINGLE_LINE_COMMENT, yyline, yycolumn, yytext()); 
    }
    "/*"([^*]|(\*+[^*/]))*\*+"/" {
        // return new Symbol(sym.BLOCK_COMMENT, yyline, yycolumn, yytext());
    }
    {digit}+ { 
        return new Symbol(sym.WHOLE, yyline, yycolumn, yytext()); 
    }
    {digit}+(\.{digit}+)? { 
        return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext()); 
    }
    "true"|"false" { 
        return new Symbol(sym.BOOLEAN, yyline, yycolumn, yytext()); 
    }
    "'"([^'\\]|\\[nt\"\\\\'])"'" { 
    String chr = yytext();
    chr = chr.substring(1, chr.length() - 1);
    switch (chr) {
        case "\\n": chr = "\n"; break;
        case "\\t": chr = "\t"; break;
        case "\\\"": chr = "\""; break;
        case "\\\\": chr = "\\"; break;
        case "\\'": chr = "'"; break;
    }
    return new Symbol(sym.CHAR, yyline, yycolumn, chr);
}
    "\""([^\"\\]|\\[nt\"\\\\'])*"\"" { 
        String str = yytext();
        str = str.substring(1, str.length() -1);
        str = str.replace("\\n", "\n")
             .replace("\\t", "\t")
             .replace("\\\"", "\"")
             .replace("\\\\", "\\")
             .replace("\\'", "\'");
        return new Symbol(sym.STRING, yyline, yycolumn, str); 
    }

    "\." {
        return new Symbol(sym.DOT, yyline, yycolumn, yytext());
    }

    {ws} {/* Ignore */}

    // Relational Operators
    "==" {
        return new Symbol(sym.EQUALS_TO, yyline, yycolumn, yytext());
    }
    "!=" {
        return new Symbol(sym.NOT_EQUAL, yyline, yycolumn, yytext());
    }
    "<" {
        return new Symbol(sym.LESS_THAN, yyline, yycolumn, yytext());
    }
    "<=" {
        return new Symbol(sym.LESS_EQUAL_THAN, yyline, yycolumn, yytext());
    }
    ">" {
        return new Symbol(sym.GREATER_THAN, yyline, yycolumn, yytext());
    }
    ">=" {
        return new Symbol(sym.GREATER_EQUAL_THAN, yyline, yycolumn, yytext());
    }

    // Logic Operators
    "||" {
        return new Symbol(sym.OR, yyline, yycolumn, yytext());
    }
    "&&" {
        return new Symbol(sym.AND, yyline, yycolumn, yytext());
    }
    "!" {
        return new Symbol(sym.NOT, yyline, yycolumn, yytext());
    }

    "(" {
        return new Symbol(sym.PAR_START, yyline, yycolumn, yytext());
    }
    ")" {
        return new Symbol(sym.PAR_END, yyline, yycolumn, yytext());
    }
    "{" {
        return new Symbol(sym.BRA_START, yyline, yycolumn, yytext());
    }
    "}" {
        return new Symbol(sym.BRA_END, yyline, yycolumn, yytext());
    }
    "[" {
        return new Symbol(sym.SBRA_START, yyline, yycolumn, yytext());
    }
    "]" {
        return new Symbol(sym.SBRA_END, yyline, yycolumn, yytext());
    }
    "\," {
        return new Symbol(sym.COMMA, yyline, yycolumn, yytext());
    }

    // Arithmetic operators
    "+" {  
        return new Symbol(sym.PLUS, yyline, yycolumn, yytext()); }
    "-" {  
        return new Symbol(sym.MINUS, yyline, yycolumn, yytext()); }
    "*" {  
        return new Symbol(sym.MULTIPLICATION, yyline, yycolumn, yytext()); }
    "/" {  
        return new Symbol(sym.DIVISION, yyline, yycolumn, yytext()); }
    "^" {  
        return new Symbol(sym.POWER, yyline, yycolumn, yytext()); }
    "$" {  
        return new Symbol(sym.ROOT, yyline, yycolumn, yytext()); }
    "%" {  
        return new Symbol(sym.MODULO, yyline, yycolumn, yytext()); }
    "=" {  
        return new Symbol(sym.EQUALS, yyline, yycolumn, yytext()); }


    ";" { 
        return new Symbol(sym.END, yyline, yycolumn, yytext()); }
    ":" { 
        return new Symbol(sym.COLON, yyline, yycolumn, yytext()); }

    {letter}+({digit}|{letter})* {
        return new Symbol(sym.ID, yyline, yycolumn, yytext()); 
    }

    [^] {
        // return new Symbol(sym.ERROR, yyline, yycolumn, yytext());
        lexicalErrors.add(new CompError(ErrorType.LEXICAL, "The char " + yytext() + " does not belong to the language", yyline, yycolumn));
    }

}