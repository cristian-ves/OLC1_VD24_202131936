// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: lexer.jflex

// Declarations
package org.example.compscript.parser.analisys;

import java_cup.runtime.*;


@SuppressWarnings("fallthrough")
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\1\u0400\266\u0200\10\u0500\u1020\u0200";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\2\2\22\0\1\4\1\5"+
    "\1\6\1\0\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\0\1\17\1\20\1\21\12\22\1\23"+
    "\1\24\1\25\1\26\1\27\2\0\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\2\41\1\47\1\50\1\51"+
    "\1\52\1\41\1\53\3\41\1\0\1\54\1\0\1\55"+
    "\1\41\1\0\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\56"+
    "\1\46\2\41\1\47\1\50\1\57\1\52\1\41\1\53"+
    "\3\41\1\60\1\61\1\62\7\0\1\3\252\0\2\63"+
    "\115\0\1\64\u01a8\0\2\3\u0100\0\1\65\325\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1536];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\1\1\4\1\5\2\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\14\23\1\24\1\1"+
    "\1\25\1\1\1\26\1\27\1\0\1\30\1\0\1\31"+
    "\2\0\1\32\1\33\1\0\1\34\1\0\1\35\1\36"+
    "\1\37\2\40\4\23\1\41\3\23\1\42\5\23\1\43"+
    "\1\42\1\44\1\0\1\45\2\23\1\0\3\23\1\0"+
    "\1\23\1\46\1\47\1\50\3\23\1\0\1\51\1\23"+
    "\2\52\2\23\1\0\1\23\2\53\1\0\1\23\1\54"+
    "\1\23\1\0\2\55\1\23\1\56\1\23\2\0\1\56"+
    "\1\23\1\54\1\57\2\60\2\23\2\0\1\23\1\61"+
    "\1\23\1\0\1\61\1\62\2\63";

  private static int [] zzUnpackAction() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\66\0\154\0\242\0\330\0\u010e\0\66\0\66"+
    "\0\u0144\0\u017a\0\66\0\66\0\66\0\u01b0\0\u01e6\0\66"+
    "\0\u021c\0\u0252\0\66\0\66\0\u0288\0\u02be\0\u02f4\0\u032a"+
    "\0\u0360\0\u0396\0\u03cc\0\u0402\0\u0438\0\u046e\0\u04a4\0\u04da"+
    "\0\u0510\0\u0546\0\u057c\0\66\0\u05b2\0\66\0\u05e8\0\66"+
    "\0\66\0\u010e\0\66\0\u061e\0\66\0\u0654\0\u068a\0\66"+
    "\0\66\0\u06c0\0\u06f6\0\u072c\0\66\0\66\0\66\0\u046e"+
    "\0\66\0\u0762\0\u0798\0\u07ce\0\u0804\0\u046e\0\u083a\0\u0870"+
    "\0\u08a6\0\u046e\0\u08dc\0\u0912\0\u0948\0\u097e\0\u09b4\0\66"+
    "\0\66\0\66\0\u09ea\0\u072c\0\u0a20\0\u0a56\0\u0a8c\0\u0ac2"+
    "\0\u0af8\0\u0b2e\0\u0b64\0\u0b9a\0\u046e\0\u046e\0\u046e\0\u0bd0"+
    "\0\u0c06\0\u0c3c\0\u0c72\0\66\0\u0ca8\0\u046e\0\66\0\u0cde"+
    "\0\u0d14\0\u0d4a\0\u0d80\0\u046e\0\66\0\u0db6\0\u0dec\0\u046e"+
    "\0\u0e22\0\u0e58\0\u046e\0\66\0\u0e8e\0\u046e\0\u0ec4\0\u0efa"+
    "\0\u0f30\0\66\0\u0f66\0\66\0\u046e\0\u046e\0\66\0\u0f9c"+
    "\0\u0fd2\0\u1008\0\u103e\0\u1074\0\u046e\0\u10aa\0\u10e0\0\66"+
    "\0\u046e\0\u046e\0\66";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\2\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\2\36\1\37\2\36"+
    "\1\40\1\41\4\36\1\42\1\36\1\43\1\2\1\44"+
    "\1\36\1\42\1\2\1\45\1\46\1\47\2\2\67\0"+
    "\2\3\1\0\1\3\62\0\2\3\1\0\1\3\53\0"+
    "\1\50\33\0\1\51\37\0\6\52\1\53\45\52\1\54"+
    "\11\52\11\0\1\55\54\0\12\56\1\0\41\56\1\57"+
    "\11\56\16\0\1\60\66\0\1\61\63\0\1\62\3\0"+
    "\1\63\64\0\1\64\1\0\1\22\71\0\1\65\65\0"+
    "\1\66\65\0\1\67\61\0\1\36\5\0\20\36\1\70"+
    "\3\36\2\0\2\36\4\0\1\71\23\0\1\36\5\0"+
    "\17\36\1\72\4\36\2\0\2\36\30\0\1\36\5\0"+
    "\1\73\15\36\1\74\5\36\2\0\2\36\30\0\1\36"+
    "\5\0\4\36\1\75\11\36\1\76\5\36\2\0\2\36"+
    "\30\0\1\36\5\0\13\36\1\77\10\36\2\0\2\36"+
    "\30\0\1\36\5\0\1\100\15\36\1\101\5\36\2\0"+
    "\2\36\30\0\1\36\5\0\24\36\2\0\2\36\30\0"+
    "\1\36\5\0\5\36\1\102\16\36\2\0\2\36\30\0"+
    "\1\36\5\0\4\36\1\103\11\36\1\104\5\36\2\0"+
    "\2\36\30\0\1\36\5\0\1\105\23\36\2\0\2\36"+
    "\30\0\1\36\5\0\17\36\1\106\4\36\2\0\2\36"+
    "\30\0\1\36\5\0\7\36\1\107\14\36\2\0\2\36"+
    "\67\0\1\110\41\0\1\111\36\0\1\52\3\0\1\52"+
    "\41\0\1\52\1\0\2\52\20\0\1\112\61\0\1\56"+
    "\3\0\1\56\41\0\1\56\1\0\2\56\6\0\15\62"+
    "\1\113\50\62\2\63\2\0\62\63\22\0\1\114\65\0"+
    "\1\36\5\0\4\36\1\115\17\36\2\0\2\36\30\0"+
    "\1\36\5\0\20\36\1\116\3\36\2\0\2\36\4\0"+
    "\1\117\23\0\1\36\5\0\15\36\1\120\6\36\2\0"+
    "\1\120\1\36\30\0\1\36\5\0\5\36\1\121\16\36"+
    "\2\0\2\36\30\0\1\36\5\0\20\36\1\122\3\36"+
    "\2\0\2\36\4\0\1\123\23\0\1\36\5\0\13\36"+
    "\1\124\10\36\2\0\2\36\30\0\1\36\5\0\17\36"+
    "\1\125\4\36\2\0\2\36\30\0\1\36\5\0\21\36"+
    "\1\126\2\36\2\0\1\36\1\126\30\0\1\36\5\0"+
    "\6\36\1\127\15\36\2\0\2\36\30\0\1\36\5\0"+
    "\21\36\1\130\2\36\2\0\1\36\1\130\30\0\1\36"+
    "\5\0\22\36\1\131\1\36\2\0\2\36\30\0\1\36"+
    "\5\0\10\36\1\132\13\36\2\0\2\36\3\0\1\133"+
    "\2\0\15\62\1\113\3\62\1\134\44\62\22\0\1\36"+
    "\5\0\1\135\23\36\2\0\2\36\30\0\1\36\5\0"+
    "\21\36\1\136\2\36\2\0\1\36\1\136\57\0\1\137"+
    "\5\0\1\137\30\0\1\36\5\0\20\36\1\140\1\141"+
    "\2\36\2\0\1\36\1\141\4\0\1\142\23\0\1\36"+
    "\5\0\1\143\23\36\2\0\2\36\30\0\1\36\5\0"+
    "\4\36\1\144\17\36\2\0\2\36\42\0\1\145\53\0"+
    "\1\36\5\0\20\36\1\131\3\36\2\0\2\36\4\0"+
    "\1\146\23\0\1\36\5\0\2\36\1\147\21\36\2\0"+
    "\2\36\30\0\1\36\5\0\4\36\1\150\17\36\2\0"+
    "\2\36\30\0\1\36\5\0\13\36\1\151\10\36\2\0"+
    "\2\36\51\0\1\152\44\0\1\36\5\0\12\36\1\153"+
    "\11\36\2\0\2\36\5\0\1\154\22\0\1\36\5\0"+
    "\16\36\1\155\2\36\1\156\2\36\2\0\1\36\1\156"+
    "\30\0\1\36\5\0\10\36\1\157\13\36\2\0\2\36"+
    "\3\0\1\160\50\0\1\161\2\0\1\162\5\0\1\162"+
    "\30\0\1\36\5\0\22\36\1\163\1\36\2\0\2\36"+
    "\42\0\1\164\53\0\1\36\5\0\7\36\1\165\14\36"+
    "\2\0\2\36\30\0\1\36\5\0\4\36\1\166\17\36"+
    "\2\0\2\36\42\0\1\167\53\0\1\36\5\0\13\36"+
    "\1\170\10\36\2\0\2\36\30\0\1\36\5\0\15\36"+
    "\1\171\6\36\2\0\1\171\1\36\53\0\1\172\10\0"+
    "\1\172\52\0\1\173\44\0\1\36\5\0\13\36\1\174"+
    "\10\36\2\0\2\36\30\0\1\36\5\0\4\36\1\175"+
    "\17\36\2\0\2\36\30\0\1\36\5\0\22\36\1\176"+
    "\1\36\2\0\2\36\60\0\1\177\47\0\1\200\53\0"+
    "\1\36\5\0\21\36\1\201\2\36\2\0\1\36\1\201"+
    "\30\0\1\36\5\0\4\36\1\202\17\36\2\0\2\36"+
    "\42\0\1\203\31\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[4374];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\2\11\2\1\3\11\2\1\1\11"+
    "\2\1\2\11\17\1\1\11\1\1\1\11\1\1\2\11"+
    "\1\0\1\11\1\0\1\11\2\0\2\11\1\0\1\1"+
    "\1\0\3\11\1\1\1\11\16\1\3\11\1\0\3\1"+
    "\1\0\3\1\1\0\7\1\1\0\1\11\2\1\1\11"+
    "\2\1\1\0\2\1\1\11\1\0\3\1\1\0\1\1"+
    "\1\11\3\1\2\0\1\11\1\1\1\11\2\1\1\11"+
    "\2\1\2\0\3\1\1\0\1\11\2\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[131];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
      yyline = 1;
    yychar = 1;
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { // System.err.println("Unrecognized character: " + yytext());
        return new Symbol(sym.ERROR, yyline, yycolumn, yytext());
            }
          // fall through
          case 52: break;
          case 2:
            { /* Ignore */
            }
          // fall through
          case 53: break;
          case 3:
            { // System.out.println("Recognized NOT " + yytext());
        return new Symbol(sym.NOT, yyline, yycolumn, yytext());
            }
          // fall through
          case 54: break;
          case 4:
            { // System.out.println("Recognized ROOT " + yytext());
        return new Symbol(sym.ROOT, yyline, yycolumn, yytext());
            }
          // fall through
          case 55: break;
          case 5:
            { // System.out.println("Recognized MODULO " + yytext());
        return new Symbol(sym.MODULO, yyline, yycolumn, yytext());
            }
          // fall through
          case 56: break;
          case 6:
            { // System.out.println("Recognized PAR_START " + yytext());
        return new Symbol(sym.PAR_START, yyline, yycolumn, yytext());
            }
          // fall through
          case 57: break;
          case 7:
            { // System.out.println("Recognized PAR_END " + yytext());
        return new Symbol(sym.PAR_END, yyline, yycolumn, yytext());
            }
          // fall through
          case 58: break;
          case 8:
            { // System.out.println("Recognized MULTIPLICATION " + yytext());
        return new Symbol(sym.MULTIPLICATION, yyline, yycolumn, yytext());
            }
          // fall through
          case 59: break;
          case 9:
            { // System.out.println("Recognized PLUS " + yytext());
        return new Symbol(sym.PLUS, yyline, yycolumn, yytext());
            }
          // fall through
          case 60: break;
          case 10:
            { // System.out.println("Recognized MINUS " + yytext());
        return new Symbol(sym.MINUS, yyline, yycolumn, yytext());
            }
          // fall through
          case 61: break;
          case 11:
            { // System.out.println("Recognized DOT " + yytext());
        return new Symbol(sym.DOT, yyline, yycolumn, yytext());
            }
          // fall through
          case 62: break;
          case 12:
            { // System.out.println("Recognized DIVISION " + yytext());
        return new Symbol(sym.DIVISION, yyline, yycolumn, yytext());
            }
          // fall through
          case 63: break;
          case 13:
            { // System.out.println("Recognized WHOLE " + yytext());
        return new Symbol(sym.WHOLE, yyline, yycolumn, yytext());
            }
          // fall through
          case 64: break;
          case 14:
            { // System.out.println("Recognized COLON " + yytext());
        return new Symbol(sym.COLON, yyline, yycolumn, yytext());
            }
          // fall through
          case 65: break;
          case 15:
            { // System.out.println("Recognized END " + yytext());
        return new Symbol(sym.END, yyline, yycolumn, yytext());
            }
          // fall through
          case 66: break;
          case 16:
            { // System.out.println("Recognized LESS_THAN " + yytext());
        return new Symbol(sym.LESS_THAN, yyline, yycolumn, yytext());
            }
          // fall through
          case 67: break;
          case 17:
            { // System.out.println("Recognized EQUALS " + yytext());
        return new Symbol(sym.EQUALS, yyline, yycolumn, yytext());
            }
          // fall through
          case 68: break;
          case 18:
            { // System.out.println("Recognized GREATER_THAN " + yytext());
        return new Symbol(sym.GREATER_THAN, yyline, yycolumn, yytext());
            }
          // fall through
          case 69: break;
          case 19:
            { // System.out.println("Recognized ID " + yytext());
        return new Symbol(sym.ID, yyline, yycolumn, yytext());
            }
          // fall through
          case 70: break;
          case 20:
            { // System.out.println("Recognized POWER " + yytext());
        return new Symbol(sym.POWER, yyline, yycolumn, yytext());
            }
          // fall through
          case 71: break;
          case 21:
            { // System.out.println("Recognized BRA_END " + yytext());
        return new Symbol(sym.BRA_END, yyline, yycolumn, yytext());
            }
          // fall through
          case 72: break;
          case 22:
            { // System.out.println("Recognized BRA_START " + yytext());
        return new Symbol(sym.BRA_START, yyline, yycolumn, yytext());
            }
          // fall through
          case 73: break;
          case 23:
            { // System.out.println("Recognized NOT_EQUAL " + yytext());
        return new Symbol(sym.NOT_EQUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 74: break;
          case 24:
            { // System.out.println("Recognized STRING " + yytext());
        return new Symbol(sym.STRING, yyline, yycolumn, yytext());
            }
          // fall through
          case 75: break;
          case 25:
            { // System.out.println("Recognized AND " + yytext());
        return new Symbol(sym.AND, yyline, yycolumn, yytext());
            }
          // fall through
          case 76: break;
          case 26:
            { // System.out.println("Recognized INCREMENT " + yytext());
        return new Symbol(sym.INCREMENT, yyline, yycolumn, yytext());
            }
          // fall through
          case 77: break;
          case 27:
            { // System.out.println("Recognized DECREASE " + yytext());
        return new Symbol(sym.DECREASE, yyline, yycolumn, yytext());
            }
          // fall through
          case 78: break;
          case 28:
            { // System.out.println("Recognized SINGLE_LINE_COMMENT " + yytext());
        return new Symbol(sym.SINGLE_LINE_COMMENT, yyline, yycolumn, yytext());
            }
          // fall through
          case 79: break;
          case 29:
            { // System.out.println("Recognized LESS_EQUAL_THAN " + yytext());
        return new Symbol(sym.LESS_EQUAL_THAN, yyline, yycolumn, yytext());
            }
          // fall through
          case 80: break;
          case 30:
            { // System.out.println("Recognized EQUALS_TO " + yytext());
        return new Symbol(sym.EQUALS_TO, yyline, yycolumn, yytext());
            }
          // fall through
          case 81: break;
          case 31:
            { // System.out.println("Recognized GREATER_EQUAL_THAN " + yytext());
        return new Symbol(sym.GREATER_EQUAL_THAN, yyline, yycolumn, yytext());
            }
          // fall through
          case 82: break;
          case 32:
            { // System.out.println("Recognized AS " + yytext());
        return new Symbol(sym.AS, yyline, yycolumn, yytext());
            }
          // fall through
          case 83: break;
          case 33:
            { // System.out.println("Recognized DO " + yytext());
        return new Symbol(sym.DO, yyline, yycolumn, yytext());
            }
          // fall through
          case 84: break;
          case 34:
            { // System.out.println("Recognized IF " + yytext());
        return new Symbol(sym.IF, yyline, yycolumn, yytext());
            }
          // fall through
          case 85: break;
          case 35:
            { // System.out.println("Recognized OR " + yytext());
        return new Symbol(sym.OR, yyline, yycolumn, yytext());
            }
          // fall through
          case 86: break;
          case 36:
            { // System.out.println("Recognized CHAR " + yytext());
        return new Symbol(sym.CHAR, yyline, yycolumn, yytext());
            }
          // fall through
          case 87: break;
          case 37:
            { // System.out.println("Recognized DOUBLE " + yytext());
        return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());
            }
          // fall through
          case 88: break;
          case 38:
            { // System.out.println("Recognized FOR " + yytext());
        return new Symbol(sym.FOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 89: break;
          case 39:
            { // System.out.println("Recognized LET " + yytext());
        return new Symbol(sym.LET, yyline, yycolumn, yytext());
            }
          // fall through
          case 90: break;
          case 40:
            { // System.out.println("Recognized LOG " + yytext());
        return new Symbol(sym.LOG, yyline, yycolumn, yytext());
            }
          // fall through
          case 91: break;
          case 41:
            { // System.out.println("Recognized BLOCK_COMMENT: " + yytext());
        return new Symbol(sym.BLOCK_COMMENT, yyline, yycolumn, yytext());
            }
          // fall through
          case 92: break;
          case 42:
            { // System.out.println("Recognized CAST " + yytext());
        return new Symbol(sym.CAST, yyline, yycolumn, yytext());
            }
          // fall through
          case 93: break;
          case 43:
            { // System.out.println("Recognized ELSE " + yytext());
        return new Symbol(sym.ELSE, yyline, yycolumn, yytext());
            }
          // fall through
          case 94: break;
          case 44:
            { // System.out.println("Recognized BOOLEAN " + yytext());
        return new Symbol(sym.BOOLEAN, yyline, yycolumn, yytext());
            }
          // fall through
          case 95: break;
          case 45:
            { // System.out.println("Recognized BREAK " + yytext());
        return new Symbol(sym.BREAK, yyline, yycolumn, yytext());
            }
          // fall through
          case 96: break;
          case 46:
            { // System.out.println("Recognized CONST " + yytext());
        return new Symbol(sym.CONST, yyline, yycolumn, yytext());
            }
          // fall through
          case 97: break;
          case 47:
            { // System.out.println("Recognized MATCH " + yytext());
        return new Symbol(sym.MATCH, yyline, yycolumn, yytext());
            }
          // fall through
          case 98: break;
          case 48:
            { // System.out.println("Recognized WHILE " + yytext());
        return new Symbol(sym.WHILE, yyline, yycolumn, yytext());
            }
          // fall through
          case 99: break;
          case 49:
            { // System.out.println("Recognized CONSOLE " + yytext());
        return new Symbol(sym.CONSOLE, yyline, yycolumn, yytext());
            }
          // fall through
          case 100: break;
          case 50:
            { // System.out.println("Recognized DEFAULT " + yytext());
        return new Symbol(sym.DEFAULT, yyline, yycolumn, yytext());
            }
          // fall through
          case 101: break;
          case 51:
            { // System.out.println("Recognized CONTINUE " + yytext());
        return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());
            }
          // fall through
          case 102: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
