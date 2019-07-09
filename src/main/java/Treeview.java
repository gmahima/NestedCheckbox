import javafx.application.Application;
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
}