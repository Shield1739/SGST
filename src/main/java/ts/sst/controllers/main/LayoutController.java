package ts.sst.controllers.main;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ts.sst.controllers.BaseController;
import ts.sst.models.User;

public class LayoutController extends BaseController
{
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
		this.userTipoLabel.setText(usuarioActivo.getTipo());

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

	/**
	 * Set Node Style
	 * @param node node to style
	 * @param style string name of style
	 */
	public void setStyle(Node node, String style) {
		node.getStyleClass().remove(2);
		node.getStyleClass().add(style);
	}

	@FXML
	void handleMenuToggle(ActionEvent event)
	{
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
	void handleTogglePrestamoEquipos()
	{

	}

	@FXML
	void handleTogglePrestamoLabs()
	{

	}
}
