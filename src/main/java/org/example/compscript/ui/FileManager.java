package org.example.compscript.ui;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class FileManager {

    Stage stage;
    Input codeArea;
    String content;

    public void open(Stage stage, Input codeArea) {

        this.stage = stage;
        this.codeArea = codeArea;
        this.content = "";

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.cs"));

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            content = readFile(selectedFile);
            showContentInCodeArea();
        } else {
            System.out.println("no file");
        }
    }

    private String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public void showContentInCodeArea() {
        codeArea.clear();
        codeArea.appendText(content);
    }

    public void save(Stage stage, Input codeArea) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.cs"));
        fileChooser.setTitle("Save Text File");

        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            Alert alert;
            try {
                if (!file.getName().endsWith(".cs")) {
                    file = new File(file.getAbsolutePath() + ".cs");
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(codeArea.getText());
                    writer.flush();
                }

                System.out.println("File saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Save Error");
                alert.setHeaderText("Could not save the file");
                alert.setContentText("An error occurred while saving the file: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }
}
