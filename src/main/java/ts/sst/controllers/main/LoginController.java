package ts.sst.controllers.main;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ts.sst.controllers.BaseController;
import ts.sst.database.DbUtilities;
import ts.sst.models.User;

public class LoginController extends BaseController
{
	@FXML
	private TextField correoField;

	@FXML
	private PasswordField passField;

	@FXML
	private Label errorLabel;

	@FXML
	private Button loginButton;

	//MAYBE move out?
	private DbUtilities dbUtilities = new DbUtilities();

	@FXML
	private void handleLoginButton()
	{
		String correo = this.correoField.getText();
		String pass = this.passField.getText();

		if (correo.equals("") || pass.equals(""))
		{
			this.errorLabel.setText("ERROR! Campo Vacio");
			return;
		}

		User user = this.dbUtilities.login(correo, pass);

		if (user == null)
		{
			this.errorLabel.setText("ERROR! Datos Incorrectos");
			return;
		}

		//IN
		this.errorLabel.setText("");
		//MAYBE 1 method?
		load(user);
	}

	private void load(User user)
	{
		try
		{
			//OPTIMIZE better path
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ts/sst/views/main/layoutView.fxml"));
			Scene scene = new Scene(loader.load());
			Stage stage = (Stage) loginButton.getScene().getWindow();
			stage.setScene(scene);

			//MAYBE move?
			LayoutController controller = loader.getController();
			controller.setUsuarioActivo(user);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
