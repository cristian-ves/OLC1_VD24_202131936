package org.example.compscript.ui;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;

public class Output extends CodeArea {

    public Output () {
        this.setStyle("-fx-background-color: #2b2b2b;");
        this.setParagraphGraphicFactory(LineNumberFactory.get(this));
        this.textProperty().addListener((obs, oldText, newText) -> {
            this.setStyleSpans(0, computeWhiteStyle(newText));
        });
        setEditable(false);
    }

    private StyleSpans<Collection<String>> computeWhiteStyle(String text) {
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
        spansBuilder.add(Collections.singleton("white-text"), text.length());
        return spansBuilder.create();
    }

    public void showOutput(String text) {
        clear();
        appendText(text);
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
