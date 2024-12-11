package org.example.compscript.ui;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

import java.awt.*;
import java.util.Collections;

public class Output extends CodeArea {

    public Output () {
        setStyle("-fx-font-size: 16px; -fx-font-family: 'Courier New'; -fx-font-size: 14px;");
        setEditable(false);
    }

    public void showOutput(String text) {
        clear();
        appendText(text);
        applyColorToText(text, Color.WHITE);
    }

    private void applyColorToText(String text, Color color) {
        setStyle(getLength() - text.length(), getLength(), Collections.singleton("-fx-fill: " + toHexString(color) + ";"));
    }

    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X", (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public void createCodeArea(Parent root) {
        AnchorPane anchorPane = (AnchorPane) root.lookup("#anchorPaneWithConsole");

        VirtualizedScrollPane<CodeArea> scrollPane = new VirtualizedScrollPane<>(this);

        anchorPane.getChildren().add(scrollPane);

        AnchorPane.setTopAnchor(scrollPane, 15.0);
        AnchorPane.setBottomAnchor(scrollPane, 15.0);
        AnchorPane.setLeftAnchor(scrollPane, 15.0);
        AnchorPane.setRightAnchor(scrollPane, 15.0);

        scrollPane.prefWidthProperty().bind(anchorPane.widthProperty());
        scrollPane.prefHeightProperty().bind(anchorPane.heightProperty());
    }

}
