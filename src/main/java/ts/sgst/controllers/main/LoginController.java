package ts.sgst.controllers.main;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ts.sgst.controllers.BaseController;
import ts.sgst.database.DbUserUtilities;
import ts.sgst.models.User;

public class LoginController extends BaseController
{
	@FXML
	private TextField correoField;

	@FXML
	private PasswordField contraseñaField;

	@FXML
	private Label errorLabel;

	//MAYBE move out?
	private DbUserUtilities dbUserUtilities = new DbUserUtilities();

	@FXML
	private void handleLoginButton()
	{
		//TODO remove after testing
		this.correoField.setText("sa");
		this.contraseñaField.setText("admin");

		String correo = this.correoField.getText();
		String contraseña = this.contraseñaField.getText();

		if (correo.equals("") || contraseña.equals(""))
		{
			this.errorLabel.setText("Campo Vacio");
			return;
		}

		User user = dbUserUtilities.login(correo, contraseña);

		if (user == null)
		{
			this.errorLabel.setText("Datos Incorrectos");
			return;
		}

		//IN
		this.errorLabel.setText("");
		load(user);
	}

	private void load(User user)
	{
		try
		{
			//OPTIMIZE better path
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ts/sgst/views/main/layoutView.fxml"));
			Scene scene = new Scene(loader.load());
			//scene.getStylesheets().clear();
			//scene.getStylesheets().add(getClass().getResource("/ts/sst/css/layoutView.css").toExternalForm());

			Stage stage = (Stage) correoField.getScene().getWindow();
			stage.setScene(scene);

			//MAYBE move?
			LayoutController controller = loader.getController();
			controller.initLayout(user);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
