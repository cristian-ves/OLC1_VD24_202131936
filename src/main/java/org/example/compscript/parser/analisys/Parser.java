
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package org.example.compscript.parser.analisys;

import java_cup.runtime.*;
import java.util.LinkedList;
import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.*;
import org.example.compscript.parser.symbol.Symbol;
import org.example.compscript.parser.instructions.Print;
import org.example.compscript.parser.expresions.Native;
import org.example.compscript.parser.expresions.operators.relational.*;
import org.example.compscript.parser.expresions.operators.arithmetic.*;
import org.example.compscript.parser.expresions.operators.logic.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\035\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\004\000\002\005\010" +
    "\000\002\006\004\000\002\006\005\000\002\006\005\000" +
    "\002\006\005\000\002\006\005\000\002\006\005\000\002" +
    "\006\005\000\002\006\005\000\002\006\005\000\002\006" +
    "\005\000\002\006\005\000\002\006\005\000\002\006\005" +
    "\000\002\006\005\000\002\006\005\000\002\006\005\000" +
    "\002\006\004\000\002\006\003\000\002\006\003\000\002" +
    "\006\003\000\002\006\003\000\002\006\003\000\002\006" +
    "\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\004\037\010\001\002\000\004\036\072\001" +
    "\002\000\004\002\071\001\002\000\006\002\ufffe\037\ufffe" +
    "\001\002\000\006\002\000\037\010\001\002\000\004\040" +
    "\011\001\002\000\004\041\012\001\002\000\004\042\013" +
    "\001\002\000\022\031\017\032\020\033\021\034\015\035" +
    "\024\042\016\045\014\065\022\001\002\000\022\031\017" +
    "\032\020\033\021\034\015\035\024\042\016\045\014\065" +
    "\022\001\002\000\042\043\uffe7\044\uffe7\045\uffe7\050\uffe7" +
    "\051\uffe7\052\uffe7\053\uffe7\054\uffe7\055\uffe7\056\uffe7\057" +
    "\uffe7\060\uffe7\061\uffe7\062\uffe7\063\uffe7\064\uffe7\001\002" +
    "\000\022\031\017\032\020\033\021\034\015\035\024\042" +
    "\016\045\014\065\022\001\002\000\042\043\uffea\044\uffea" +
    "\045\uffea\050\uffea\051\uffea\052\uffea\053\uffea\054\uffea\055" +
    "\uffea\056\uffea\057\uffea\060\uffea\061\uffea\062\uffea\063\uffea" +
    "\064\uffea\001\002\000\042\043\uffe9\044\uffe9\045\uffe9\050" +
    "\uffe9\051\uffe9\052\uffe9\053\uffe9\054\uffe9\055\uffe9\056\uffe9" +
    "\057\uffe9\060\uffe9\061\uffe9\062\uffe9\063\uffe9\064\uffe9\001" +
    "\002\000\042\043\uffe8\044\uffe8\045\uffe8\050\uffe8\051\uffe8" +
    "\052\uffe8\053\uffe8\054\uffe8\055\uffe8\056\uffe8\057\uffe8\060" +
    "\uffe8\061\uffe8\062\uffe8\063\uffe8\064\uffe8\001\002\000\022" +
    "\031\017\032\020\033\021\034\015\035\024\042\016\045" +
    "\014\065\022\001\002\000\042\043\027\044\032\045\026" +
    "\050\043\051\036\052\037\053\033\054\035\055\044\056" +
    "\034\057\031\060\040\061\030\062\042\063\041\064\025" +
    "\001\002\000\042\043\uffe6\044\uffe6\045\uffe6\050\uffe6\051" +
    "\uffe6\052\uffe6\053\uffe6\054\uffe6\055\uffe6\056\uffe6\057\uffe6" +
    "\060\uffe6\061\uffe6\062\uffe6\063\uffe6\064\uffe6\001\002\000" +
    "\022\031\017\032\020\033\021\034\015\035\024\042\016" +
    "\045\014\065\022\001\002\000\022\031\017\032\020\033" +
    "\021\034\015\035\024\042\016\045\014\065\022\001\002" +
    "\000\004\036\ufffc\001\002\000\022\031\017\032\020\033" +
    "\021\034\015\035\024\042\016\045\014\065\022\001\002" +
    "\000\022\031\017\032\020\033\021\034\015\035\024\042" +
    "\016\045\014\065\022\001\002\000\022\031\017\032\020" +
    "\033\021\034\015\035\024\042\016\045\014\065\022\001" +
    "\002\000\022\031\017\032\020\033\021\034\015\035\024" +
    "\042\016\045\014\065\022\001\002\000\022\031\017\032" +
    "\020\033\021\034\015\035\024\042\016\045\014\065\022" +
    "\001\002\000\022\031\017\032\020\033\021\034\015\035" +
    "\024\042\016\045\014\065\022\001\002\000\022\031\017" +
    "\032\020\033\021\034\015\035\024\042\016\045\014\065" +
    "\022\001\002\000\022\031\017\032\020\033\021\034\015" +
    "\035\024\042\016\045\014\065\022\001\002\000\022\031" +
    "\017\032\020\033\021\034\015\035\024\042\016\045\014" +
    "\065\022\001\002\000\022\031\017\032\020\033\021\034" +
    "\015\035\024\042\016\045\014\065\022\001\002\000\022" +
    "\031\017\032\020\033\021\034\015\035\024\042\016\045" +
    "\014\065\022\001\002\000\022\031\017\032\020\033\021" +
    "\034\015\035\024\042\016\045\014\065\022\001\002\000" +
    "\022\031\017\032\020\033\021\034\015\035\024\042\016" +
    "\045\014\065\022\001\002\000\042\043\ufff3\044\032\045" +
    "\026\050\043\051\036\052\037\053\033\054\035\055\ufff3" +
    "\056\ufff3\057\ufff3\060\ufff3\061\ufff3\062\ufff3\063\ufff3\064" +
    "\ufff3\001\002\000\042\043\ufff8\044\ufff8\045\ufff8\050\ufff8" +
    "\051\ufff8\052\037\053\033\054\ufff8\055\ufff8\056\ufff8\057" +
    "\ufff8\060\ufff8\061\ufff8\062\ufff8\063\ufff8\064\ufff8\001\002" +
    "\000\042\043\uffee\044\032\045\026\050\043\051\036\052" +
    "\037\053\033\054\035\055\uffee\056\uffee\057\uffee\060\uffee" +
    "\061\uffee\062\uffee\063\uffee\064\uffee\001\002\000\042\043" +
    "\uffec\044\032\045\026\050\043\051\036\052\037\053\033" +
    "\054\035\055\044\056\034\057\031\060\040\061\030\062" +
    "\042\063\uffec\064\025\001\002\000\042\043\ufff0\044\032" +
    "\045\026\050\043\051\036\052\037\053\033\054\035\055" +
    "\ufff0\056\ufff0\057\ufff0\060\ufff0\061\ufff0\062\ufff0\063\ufff0" +
    "\064\ufff0\001\002\000\036\043\ufff6\044\ufff6\045\ufff6\050" +
    "\ufff6\051\ufff6\054\ufff6\055\ufff6\056\ufff6\057\ufff6\060\ufff6" +
    "\061\ufff6\062\ufff6\063\ufff6\064\ufff6\001\002\000\042\043" +
    "\ufff7\044\ufff7\045\ufff7\050\ufff7\051\ufff7\052\037\053\033" +
    "\054\ufff7\055\ufff7\056\ufff7\057\ufff7\060\ufff7\061\ufff7\062" +
    "\ufff7\063\ufff7\064\ufff7\001\002\000\042\043\ufff4\044\ufff4" +
    "\045\ufff4\050\ufff4\051\ufff4\052\037\053\033\054\ufff4\055" +
    "\ufff4\056\ufff4\057\ufff4\060\ufff4\061\ufff4\062\ufff4\063\ufff4" +
    "\064\ufff4\001\002\000\042\043\ufff2\044\032\045\026\050" +
    "\043\051\036\052\037\053\033\054\035\055\ufff2\056\ufff2" +
    "\057\ufff2\060\ufff2\061\ufff2\062\ufff2\063\ufff2\064\ufff2\001" +
    "\002\000\036\043\ufff5\044\ufff5\045\ufff5\050\ufff5\051\ufff5" +
    "\054\ufff5\055\ufff5\056\ufff5\057\ufff5\060\ufff5\061\ufff5\062" +
    "\ufff5\063\ufff5\064\ufff5\001\002\000\042\043\ufffa\044\ufffa" +
    "\045\ufffa\050\043\051\036\052\037\053\033\054\035\055" +
    "\ufffa\056\ufffa\057\ufffa\060\ufffa\061\ufffa\062\ufffa\063\ufffa" +
    "\064\ufffa\001\002\000\042\043\ufff1\044\032\045\026\050" +
    "\043\051\036\052\037\053\033\054\035\055\ufff1\056\ufff1" +
    "\057\ufff1\060\ufff1\061\ufff1\062\ufff1\063\ufff1\064\ufff1\001" +
    "\002\000\042\043\uffef\044\032\045\026\050\043\051\036" +
    "\052\037\053\033\054\035\055\uffef\056\uffef\057\uffef\060" +
    "\uffef\061\uffef\062\uffef\063\uffef\064\uffef\001\002\000\042" +
    "\043\ufff9\044\ufff9\045\ufff9\050\043\051\036\052\037\053" +
    "\033\054\035\055\ufff9\056\ufff9\057\ufff9\060\ufff9\061\ufff9" +
    "\062\ufff9\063\ufff9\064\ufff9\001\002\000\042\043\uffed\044" +
    "\032\045\026\050\043\051\036\052\037\053\033\054\035" +
    "\055\044\056\034\057\031\060\040\061\030\062\042\063" +
    "\uffed\064\uffed\001\002\000\042\043\uffeb\044\032\045\026" +
    "\050\043\051\036\052\037\053\033\054\035\055\044\056" +
    "\034\057\031\060\040\061\030\062\042\063\uffeb\064\uffeb" +
    "\001\002\000\042\043\066\044\032\045\026\050\043\051" +
    "\036\052\037\053\033\054\035\055\044\056\034\057\031" +
    "\060\040\061\030\062\042\063\041\064\025\001\002\000" +
    "\042\043\uffe5\044\uffe5\045\uffe5\050\uffe5\051\uffe5\052\uffe5" +
    "\053\uffe5\054\uffe5\055\uffe5\056\uffe5\057\uffe5\060\uffe5\061" +
    "\uffe5\062\uffe5\063\uffe5\064\uffe5\001\002\000\042\043\ufffb" +
    "\044\ufffb\045\ufffb\050\ufffb\051\ufffb\052\ufffb\053\ufffb\054" +
    "\ufffb\055\ufffb\056\ufffb\057\ufffb\060\ufffb\061\ufffb\062\ufffb" +
    "\063\ufffb\064\ufffb\001\002\000\006\002\uffff\037\uffff\001" +
    "\002\000\004\002\001\001\002\000\006\002\ufffd\037\ufffd" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\012\002\004\003\006\004\005\005\003\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\004\067\005\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\022\001\001" +
    "\000\004\006\066\001\001\000\002\001\001\000\004\006" +
    "\064\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\006\063\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\006\062\001\001\000\004\006\061" +
    "\001\001\000\002\001\001\000\004\006\060\001\001\000" +
    "\004\006\057\001\001\000\004\006\056\001\001\000\004" +
    "\006\055\001\001\000\004\006\054\001\001\000\004\006" +
    "\053\001\001\000\004\006\052\001\001\000\004\006\051" +
    "\001\001\000\004\006\050\001\001\000\004\006\047\001" +
    "\001\000\004\006\046\001\001\000\004\006\045\001\001" +
    "\000\004\006\044\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    Lexer lex;
    Parser(Lexer lex){this.lex = lex;}

    public void syntax_error(Symbol s){}

    public void unrecovered_syntax_error (Symbol s){}



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {



  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= S EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		LinkedList<Instruction> start_val = (LinkedList<Instruction>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // S ::= INSTRUCTIONS 
            {
              LinkedList<Instruction> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		LinkedList<Instruction> a = (LinkedList<Instruction>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = a; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("S",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCTIONS ::= INSTRUCTIONS INSTRUCTION 
            {
              LinkedList<Instruction> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		LinkedList<Instruction> a = (LinkedList<Instruction>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = a; RESULT.add(b); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCTIONS",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCTIONS ::= INSTRUCTION 
            {
              LinkedList<Instruction> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new LinkedList<Instruction>(); RESULT.add(a); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCTIONS",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCTION ::= PRINT END 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = a; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("INSTRUCTION",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // PRINT ::= CONSOLE DOT LOG PAR_START EXPRESSION PAR_END 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new Print(a, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("PRINT",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // EXPRESSION ::= MINUS EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new UnitaryNegation(a, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXPRESSION ::= EXPRESSION PLUS EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Addition(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPRESSION ::= EXPRESSION MINUS EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Substraction(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPRESSION ::= EXPRESSION MULTIPLICATION EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Multiplication(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPRESSION ::= EXPRESSION DIVISION EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Division(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPRESSION ::= EXPRESSION POWER EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Power(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPRESSION ::= EXPRESSION ROOT EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Root(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPRESSION ::= EXPRESSION MODULO EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Modulo(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPRESSION ::= EXPRESSION EQUALS_TO EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new EqualsTo(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPRESSION ::= EXPRESSION NOT_EQUAL EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NotEqualsTo(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXPRESSION ::= EXPRESSION LESS_THAN EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new LessThan(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXPRESSION ::= EXPRESSION GREATER_THAN EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new GreaterThan(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXPRESSION ::= EXPRESSION LESS_EQUAL_THAN EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new LessEqualsThan(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXPRESSION ::= EXPRESSION GREATER_EQUAL_THAN EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new GreaterEqualsThan(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXPRESSION ::= EXPRESSION AND EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new And(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXPRESSION ::= EXPRESSION OR EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction b = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Or(a, b, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // EXPRESSION ::= NOT EXPRESSION 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Not(a, aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // EXPRESSION ::= WHOLE 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Native(Integer.parseInt(a),new Type(dataType.WHOLE), aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // EXPRESSION ::= STRING 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Native(a, new Type(dataType.STRING), aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // EXPRESSION ::= DOUBLE 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Native(new Double(a),new Type(dataType.DOUBLE), aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // EXPRESSION ::= BOOLEAN 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Native(Boolean.parseBoolean(a), new Type(dataType.BOOLEAN), aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // EXPRESSION ::= CHAR 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Native(a.charAt(0), new Type(dataType.CHAR), aleft, aright); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // EXPRESSION ::= PAR_START EXPRESSION PAR_END 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = a; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("EXPRESSION",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
