#! /bin/bash
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.9.1.jar lexer.jflex
echo "STARTING CUP COMPILING"
java -jar java-cup-11b.jar -parser Parser -symbols sym parser.cup
