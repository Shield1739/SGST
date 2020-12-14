package ts.sst;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("views/main/loginView.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("SST");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}