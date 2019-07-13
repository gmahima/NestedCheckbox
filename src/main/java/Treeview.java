import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.awt.*;

public class Treeview {
    static TreeView<String> treeView;


    public static void display() {
        Stage window = new Stage();

        window.setMinWidth(250);
        CheckBoxTreeItem<String> root = new CheckBoxTreeItem<String>("Anime");
        CheckBoxTreeItem<String> shounen = makeCheckBranch("Shounen", root);
        makeCheckBranch("Naruto", shounen);
        makeCheckBranch("Inuyasha", shounen);
        CheckBoxTreeItem<String> shoujo = makeCheckBranch("Shoujo", root);
        makeCheckBranch("Ouran", shoujo);
        makeCheckBranch("Sailor moon", shoujo);



        // create the treeView
        treeView = new TreeView<String>();
        treeView.setRoot(root);

        // set the cell factory
        treeView.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

        ObservableSet<CheckBoxTreeItem<String>> checkedItems = FXCollections.observableSet();


        EventHandler eh = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CheckBoxTreeItem<String> chk = (CheckBoxTreeItem<String>) event.getSource();
                System.out.println("Action performed on checkbox " + chk);
                findCheckedItems((CheckBoxTreeItem<String>) treeView.getRoot(), checkedItems);

            }
        };


        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }
    public static CheckBoxTreeItem<String> makeCheckBranch(String  title, CheckBoxTreeItem<String> parent ) {
        CheckBoxTreeItem<String> item = new CheckBoxTreeItem<String>(title);
        parent.getChildren().add(item);
        return item;
    }
    private static void findCheckedItems(CheckBoxTreeItem<String> item, ObservableSet<CheckBoxTreeItem<String>> checkedItems) {
        if (item.isSelected()) {
            checkedItems.add(item);
            System.out.println(item);
        }
        for (TreeItem<String> child : item.getChildren()) {
            findCheckedItems((CheckBoxTreeItem<String>) child, checkedItems);
        }
        System.out.println(checkedItems);

    }


}