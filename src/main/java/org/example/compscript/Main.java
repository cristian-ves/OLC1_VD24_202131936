package org.example.compscript;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.example.compscript.parser.Lexer;
import org.example.compscript.parser.Parser;
import org.example.compscript.ui.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Main extends Application {

    protected Input codeArea;
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

        ctrl.setCodeArea(codeArea);
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
            System.out.println(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}