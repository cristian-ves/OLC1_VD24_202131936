package org.example.compscript.ui;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.util.Collection;
import java.util.Collections;

public class Input extends CodeArea {

    public Input() {
        this.setStyle("-fx-background-color: #2b2b2b;");
        this.setParagraphGraphicFactory(LineNumberFactory.get(this));
        this.textProperty().addListener((obs, oldText, newText) -> {
            this.setStyleSpans(0, computeWhiteStyle(newText));
        });
    }

    private StyleSpans<Collection<String>> computeWhiteStyle(String text) {
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
        spansBuilder.add(Collections.singleton("white-text"), text.length());
        return spansBuilder.create();
    }

    public void createCodeArea(Parent root) {
        AnchorPane anchorPane = (AnchorPane) root.lookup("#anchorPaneWithCodeArea");

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
