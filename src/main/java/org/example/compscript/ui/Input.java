package org.example.compscript.ui;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

public class Input extends CodeArea {

    public Input() {}

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
