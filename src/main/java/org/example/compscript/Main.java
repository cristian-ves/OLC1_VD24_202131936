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

            var ast = new Tree((LinkedList<Instruction>) result.value);
            var table = new SymbolsTable();

            for(var a: ast.getInstructions()) {
                var res = a.interpret(ast, table);
                if(res instanceof Error) {
                    System.out.println(res.toString());
                }
            }

            System.out.println(ast.getConsole());
            console.showOutput(ast.getConsole());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}