import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Tree {
    static TreeView<String> treeView;


    public static void display() {
        Stage window = new Stage();

        window.setMinWidth(250);
        CheckBoxTreeItem<String> rootItem =
                new CheckBoxTreeItem<String>("View Source Files");
        rootItem.setExpanded(true);
        final TreeView treeView = new TreeView(rootItem);
        treeView.setEditable(true);
        treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
        for (int i = 0; i < 8; i++) {
            final CheckBoxTreeItem<String> checkBoxTreeItem =
                    new CheckBoxTreeItem<String>("Sample" + (i + 1));
            checkBoxTreeItem.selectedProperty().addListener(new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        System.out.println("The selected item is " + checkBoxTreeItem.valueProperty().get());
                    }
                }
            });
            rootItem.getChildren().add(checkBoxTreeItem);
        }

        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }
}