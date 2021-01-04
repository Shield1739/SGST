package ts.sgst.controllers.main;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ts.sgst.controllers.BaseController;
import ts.sgst.models.User;

public class LayoutController extends BaseController
{
	@FXML
	private AnchorPane subPane;
	@FXML
	private VBox mainVbox;
	@FXML
	private Label userCorreoLabel;
	@FXML
	private Label userTipoLabel;

	public void initLayout(User usuarioActivo)
	{
		//MAYBE Own method?
		this.userCorreoLabel.setText(usuarioActivo.getCorreo());
		this.userTipoLabel.setText(usuarioActivo.getRol());

		//MAYBE consolidat with menuToggle?
		for (Node node : this.mainVbox.getChildrenUnmodifiable())
		{
			VBox submenu = (VBox)node;
			for (Node subNode : submenu.getChildrenUnmodifiable())
			{
				if (subNode.getClass().equals(this.mainVbox.getClass()))
				{
					subNode.setVisible(false);
					subNode.setManaged(false);
				}
				else
				{
					setStyle(subNode, "menu-group-inactivo");
				}
			}
		}
	}

	private void switchPane(String Url)
	{
		//MAYBE final constants urls?
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ts/sgst/views/panes/" + Url));
			this.subPane.getChildren().setAll((AnchorPane) loader.load());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void handleHome()
	{
		switchPane("paneHomeView.fxml");
	}

	boolean toggleSubmenu(Node node)
	{
		if (node.isVisible())
		{
			node.setVisible(false);
			node.setManaged(false);
			return true;
		}
		else
		{
			node.setVisible(true);
			node.setManaged(true);
			return false;
		}
	}

	public void setStyle(Node node, String style) {
		node.getStyleClass().remove(2);
		node.getStyleClass().add(style);
	}

	/*
			FXML Menu Toggles
	 */

	@FXML
	void handleMenuToggle(ActionEvent event)
	{
		//MAYBE consolidate with initlayout
		Node eventNode = (Node) event.getSource();
		for (Node node : eventNode.getParent().getChildrenUnmodifiable())
		{
			if (node.getClass().equals(this.mainVbox.getClass()))
			{

				String style = toggleSubmenu(node) ? "menu-group-inactivo" : "menu-group";
				setStyle(eventNode, style);
				return;
			}
		}
	}

	@FXML
	void handlePaneSwitch(ActionEvent event)
	{
		this.subPane.getChildren().clear();

		ToggleButton button = (ToggleButton) event.getSource();

		String pane = "paneHomeView.fxml";

		//TODO better switch than strings
		switch (button.getText())
		{
			case "Prestamos de Equipos":
				System.out.println("COMIN SOON");
				break;
			case "Prestamos de Laboratorios":
				System.out.println("LABS");
				break;
			case "Ver Equipos":
				pane = "inventario/paneInventarioVerView.fxml";
				break;
			case "Agregar Equipo":
				pane = "inventario/paneInventarioAgregarView.fxml";
				break;
			default:
				System.out.println("???");
		}

		switchPane(pane);
	}
}
