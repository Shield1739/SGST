package ts.sst.controllers.main;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ts.sst.controllers.BaseController;
import ts.sst.models.User;

public class LayoutController extends BaseController
{
	@FXML
	private ToggleGroup groupMenus;
	@FXML
	private VBox toggleVboxPrestamos;
	@FXML
	private ToggleButton toggleButtonPrestamos;
	@FXML
	private ToggleButton subTogglePrestamosEquipos;
	@FXML
	private ToggleGroup groupPrestamos;
	@FXML
	private ToggleButton subTogglePrestamosLabs;
	@FXML
	private ToggleButton toggleButtonInventario;
	@FXML
	private Label userCorreoLabel;
	@FXML
	private Label userTipoLabel;

	private User usuarioActivo;

	public void setUsuarioActivo(User usuarioActivo)
	{
		//MAYBE STORE ACTIVE USER SOMEWHERE?
		this.usuarioActivo = usuarioActivo;

		//this.usuarioCorreoLabel.setText(this.usuarioActivo.getCorreo());
		//this.usuarioTipoLabel.setText(this.usuarioActivo.getTipo());

		switchPane("main/panes/paneHomeView.fxml");
	}

	private void switchPane(String Url)
	{
		//MAYBE final constants urls?
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ts/sst/views/" + Url));
			loader.load();
			//this.subPane.getChildren().setAll((AnchorPane) loader.load());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void handleHome()
	{
		switchPane("main/panes/paneHomeView.fxml");
	}

	private void handleInventario()
	{
		switchPane("main/panes/inventario/paneInventarioView.fxml");
	}

	@FXML
	void handleSubTogglePrestamosEquipos()
	{

	}

	@FXML
	void handleSubTogglePrestamosLabs()
	{

	}

	@FXML
	void handleToggleButtonInventario()
	{

	}

	@FXML
	void handleToggleButtonPrestamos()
	{

	}

	//Menu Operations

	/**
	 * Show/Hide Menus
	 */
	public void toggleSubmenus(ToggleButton menu, VBox box, ToggleButton... toggleSubmenus)
	{
		if (box.getChildren().isEmpty())
		{
			box.getChildren().addAll(toggleSubmenus);
			//Animacao.fade(box);
			style(menu, "menu-group");
		}
		else
		{
			deactivateSubmenus(box);
			style(menu, "menu-group-inactivo");
		}
	}

	/**
	 * Deactivate Subemenus
	 */
	public void deactivateSubmenus(VBox... boxes)
	{
		for (VBox box : boxes)
		{
			box.getChildren().clear();
		}
	}

	/**
	 * Apply style to show/hide submenus
	 */
	public void style(Node no, String style)
	{
		no.getStyleClass().remove(3);
		no.getStyleClass().add(style);
	}
}
