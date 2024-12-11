package org.example.compscript;

import javafx.stage.Stage;
import org.example.compscript.ui.FileManager;
import org.example.compscript.ui.Input;
import org.example.compscript.ui.Output;

public class controller {

    private Input codeArea;
    private Output console;
    private Stage stage;

    public void newFile() {
        codeArea.clear();
    }

    public void openFile() {
        FileManager fileManager = new FileManager();
        fileManager.open(stage, codeArea);
    }

    public void saveFile() {
        FileManager fileManager = new FileManager();
        fileManager.save(stage, codeArea);
    }

    public void setCodeArea (Input codeArea) {
        this.codeArea = codeArea;
    }

    public void setStage (Stage stage) {
        this.stage = stage;
    }

    public void setConsole (Output console) { this.console = console; }

}
