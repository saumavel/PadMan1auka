package padman.vidmot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
public class FxUI {
    private static Stage fxStage;
    public static Stage getFxStage() {
        return fxStage;
    }
    @FXML
    private Button volume;
    public static void loadFxUI() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FxUI.class.getResource("fx-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        fxStage = new Stage();
        fxStage.setScene(scene);
        fxSetLocation();
        fxStage.setTitle("Sound Parameters");
        fxStage.show();
    }

    private static void fxSetLocation(){
        double mainWindowY = ApplicationUI.getMainStage().getY() + ApplicationUI.getMainStage().getHeight();
        double mainWindowX = ApplicationUI.getMainStage().getX();

        fxStage.setY(mainWindowY);
        fxStage.setX(mainWindowX);
    }
    @FXML
    private void onHP(){
        System.out.println("HighPass: On");
    }
}

