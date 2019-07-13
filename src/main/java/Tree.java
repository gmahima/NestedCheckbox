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
                new CheckBoxTreeItem<String>("Tree");
        rootItem.setExpanded(false);
        final TreeView treeView = new TreeView(rootItem);
        treeView.setEditable(true);
        treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
        CheckBoxTreeItem<String> branch1 = makeTreeItem("branch1", rootItem);
        CheckBoxTreeItem<String> branch2 = makeTreeItem("branch2", rootItem);
        makeTreeItem("branch1.leaf1", branch1);
        makeTreeItem("branch1.leaf2", branch1);
        makeTreeItem("branch2.leaf1", branch2);
        makeTreeItem("branch2.leaf2", branch2);




        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }
    static CheckBoxTreeItem<String> makeTreeItem(String name, CheckBoxTreeItem<String> parent) {
        CheckBoxTreeItem<String> checkBoxTreeItem =
                new CheckBoxTreeItem<String>(name);
        checkBoxTreeItem.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    System.out.println("The selected item is " + checkBoxTreeItem.valueProperty().get());
                }
            }
        });
        parent.getChildren().add(checkBoxTreeItem);
        return checkBoxTreeItem;
    }
}