package org.example.compscript;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.analisys.Lexer;
import org.example.compscript.parser.analisys.Parser;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.instructions.declarations.Array2DDeclaration;
import org.example.compscript.parser.instructions.declarations.ArrayDeclaration;
import org.example.compscript.parser.instructions.declarations.Declaration;
import org.example.compscript.parser.instructions.funcs.Method;
import org.example.compscript.parser.instructions.funcs.RunMain;
import org.example.compscript.parser.instructions.structs.StructDeclaration;
import org.example.compscript.parser.symbol.STableType;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.ui.Input;
import org.example.compscript.ui.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

public class Main extends Application {

    protected Input codeArea;
    protected Output console;
    private Button runButton;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Parent root = fxmlLoader.load();
        controller ctrl = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setTitle("Compiler proyect");
        stage.setScene(scene);
        stage.show();

        codeArea = new Input();
        codeArea.createCodeArea(root);
        codeArea.requestFocus();
        runButton = (Button) root.lookup("#runButton");

        console = new Output();
        console.createCodeArea(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        ctrl.setCodeArea(codeArea);
        ctrl.setConsole(console);
        ctrl.setStage(stage);

        addEventListeners();

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.ENTER) {
                runProgram();
            }
        });
    }

    public void addEventListeners() {
        runButton.setOnAction(event -> runProgram());
    }

    private void runProgram() {
        try {
            String text = codeArea.getText();
            Lexer lex = new Lexer(new BufferedReader(new StringReader(text)));
            Parser parser = new Parser(lex);
            var result = parser.parse();

            String sintacticErrorsConsole = "";
            for (var e : parser.sintacticErrors) {
                sintacticErrorsConsole += e.toString() + "\n";
            }

            String lexicalErrosConsole = "";
            for (var l : lex.lexicalErrors) {
                lexicalErrosConsole += l.toString() + "\n";
            }

            var ast = new Tree((LinkedList<Instruction>) result.value);
            var table = new SymbolsTable(STableType.MAIN);
            ast.setGlobalTable(table);

            String semanticErrosConsole = "";

            // first ast loop
            for (var a : ast.getInstructions()) {
                if (a == null) continue;

                if (a instanceof Method) {
                    ast.addFunction(a);
                    continue;
                }

                if (a instanceof StructDeclaration) {
                    var res = a.interpret(ast, table);
                }


            }

            // second ast loop, declarations and assignments
            for (var a : ast.getInstructions()) {
                if (a instanceof Declaration || a instanceof ArrayDeclaration || a instanceof Array2DDeclaration) {
                    var res = a.interpret(ast, table);
                    if (res instanceof CompError) {
                        semanticErrosConsole += res.toString() + "\n";
                    }
                }
            }

            // third ast loop, interpret main
            for (var a: ast.getInstructions()) {
                if(a instanceof RunMain) {
                    var res = a.interpret(ast, table);
                    if(res instanceof CompError) {
                        semanticErrosConsole += res.toString() + "\n";
                    }
                }
            }

            for (var e : ast.getErrors()) {
                semanticErrosConsole += e.toString() + "\n";
            }

            console.showOutput(ast.getConsole() + lexicalErrosConsole + sintacticErrorsConsole + semanticErrosConsole);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}