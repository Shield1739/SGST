package ts.sgst.controllers.panes.inventario;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.controlsfx.control.SearchableComboBox;
import ts.sgst.controllers.BaseController;

public class PaneInventarioAgregarController extends BaseController
{
	@FXML
	private TextArea notasArea;
	@FXML
	private SearchableComboBox<String> tipoComboBox;
	@FXML
	private SearchableComboBox<String> estadoComboBox;
	@FXML
	private GridPane detailsGridPane;

	private String activeDetails = "";

	public void initialize()
	{
		//TODO less strings maybe constants?
		this.tipoComboBox.getItems().clear();
		this.tipoComboBox.getItems().addAll(
			"Laptop",
			"Raspberry",
			"Proyector",
			"General"
		);

		this.estadoComboBox.getItems().clear();
		this.estadoComboBox.getItems().addAll(
			"Buen Estado",
			"Dañado",
			"En Mantenimiento",
			"Obsoleto",
			"En Descarte",
			"Descartado"
		);
	}

	//TODO Consolidate with view controller
	private void addTextAndField(String text)
	{
		int y = this.detailsGridPane.getChildren().size() / 2;

		Text t = new Text(text);
		t.setStyle("-fx-font: 14 system");
		this.detailsGridPane.add(t, 1, y);

		TextField field = new TextField();
		//field.setText(fieldText);
		//disableTextField(field);
		this.detailsGridPane.add(field, 2, y);
	}

	@FXML
	private void handleTipoComboBox()
	{
		String selected = this.tipoComboBox.getSelectionModel().getSelectedItem();
		if (activeDetails.equals(selected) || selected == null)
		{
			return;
		}
		else
		{
			activeDetails = selected;
		}

		this.detailsGridPane.getChildren().clear();

		switch (activeDetails)
		{
			case "Laptop":
				addTextAndField("Marca");
				addTextAndField("Modelo");
				addTextAndField("N Producto");
				addTextAndField("OS");
				break;
			case "Raspberry":
				addTextAndField("Modelo");
				addTextAndField("N Producto");
				break;
			case "Proyector":
				addTextAndField("Modelo");
				addTextAndField("N Producto");
				break;
			case "General":
				addTextAndField("Descripcion");
				addTextAndField("Cantidad");
				break;
			default:
					break;
		}
	}

	@FXML
	private void handleAgregarButton()
	{
		ObservableList<Node> nodes = this.detailsGridPane.getChildren();

		String tipo = this.tipoComboBox.getSelectionModel().getSelectedItem();
		String estado = this.estadoComboBox.getSelectionModel().toString();
		String notas = this.notasArea.getText();

		//TODO remove all this string matchin
		switch (tipo)
		{
			case "Laptop":
				System.out.println(getTextByName("Marca"));
				System.out.println(getTextByName("Modelo"));
				System.out.println(getTextByName("N Producto"));
				System.out.println(getTextByName("OS"));
				break;
			case "Raspberry":
				System.out.println(getTextByName("Modelo"));
				System.out.println(getTextByName("N Producto"));
				break;
			case "Proyector":
				System.out.println(getTextByName("Descripcion"));
				System.out.println(getTextByName("N Producto"));
				break;
			case "General":
				System.out.println(getTextByName("Modelo"));
				System.out.println(getTextByName("Cantidad"));
				break;
			default:
				break;
		}
	}

	private String getTextByName(String search)
	{
		String text = null;

		/*
		searches text with matching name,
		then searches for the textfield in same row.
		 */
		//TODO find better way

		for (Node node : this.detailsGridPane.getChildren())
		{
			if (node instanceof Text && ((Text) node).getText().equals(search))
			{
				int row = GridPane.getRowIndex(node);

				for (Node subnode : this.detailsGridPane.getChildren())
				{
					if (GridPane.getRowIndex(subnode) == row && GridPane.getColumnIndex(subnode) == 2)
					{
						//SAFETY CHECK
						if (subnode instanceof TextField)
						{
							text = ((TextField) subnode).getText();
						}
					}
				}
			}
		}

		return text;
	}
}
