package ts.sgst.controllers.panes.inventario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import ts.sgst.controllers.BaseController;
import ts.sgst.database.DbInventarioUtilities;
import ts.sgst.models.inventario.Item;

public class PaneInventarioVerController extends BaseController
{
	@FXML
	private TableView<Item> inventarioTable;
	@FXML
	private TableColumn<Item, Integer> idColumn;
	@FXML
	private TableColumn<Item, String> categoriaColumn;
	@FXML
	private TableColumn<Item, String> estadoColumn;
	@FXML
	private TableColumn<Item, String> marcaColumn;
	@FXML
	private TableColumn<Item, String> modeloColumn;
	@FXML
	private TableColumn<Item, String> numeroProductoColumn;
	@FXML
	private ToggleGroup equiposGroup;
	@FXML
	private TextField itemIDField;
	@FXML
	private TextField itemCategoriaField;
	@FXML
	private TextField itemEstadoField;
	@FXML
	private TextField itemMarcaField;
	@FXML
	private TextField itemModeloField;
	@FXML
	private TextField itemNumeroProductoField;
	@FXML
	private TextArea itemNotasArea;

	//MAYBE 1 controller
	private DbInventarioUtilities dbInventarioUtilities = new DbInventarioUtilities();

	public void initialize()
	{
		handleTodos();

		disableTextField(this.itemIDField);
		disableTextField(this.itemCategoriaField);
		disableTextField(this.itemEstadoField);
		disableTextField(this.itemMarcaField);
		disableTextField(this.itemModeloField);
		disableTextField(this.itemNumeroProductoField);
		//TODO fix text area scroll
		//disableTextField(itemNotasArea);

		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
		estadoColumn.setCellValueFactory(new PropertyValueFactory<>("Estado"));
		marcaColumn.setCellValueFactory(new PropertyValueFactory<>("Marca"));
		modeloColumn.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
		numeroProductoColumn.setCellValueFactory(new PropertyValueFactory<>("NumeroProducto"));
	}

	private void clearTable()
	{
		this.inventarioTable.getItems().clear();
		//this.inventarioTable.getColumns().clear();
	}

	private void disableTextField(TextField field)
	{
		field.setEditable(false);
		field.setMouseTransparent(true);
		field.setFocusTraversable(false);
	}

	/**
	 * TODO do dynamic table building
	 * MAYBE Check unchecked calls?
	 */

	@FXML
	private void handleTodos()
	{
		clearTable();

		ObservableList<Item> items = FXCollections.observableList(dbInventarioUtilities.getAllItems());
		this.inventarioTable.setItems(items);
	}

	@FXML
	private void handleTableSelect()
	{
		Item item = this.inventarioTable.getSelectionModel().getSelectedItem();

		//OPTIMIZE plz optimize

		if (item != null)
		{

			//TODO tipo o catergorias elegir una de las 2
			itemIDField.setText("" + item.getID());
			itemCategoriaField.setText(item.getCategoria());
			itemEstadoField.setText(item.getEstado());
			itemMarcaField.setText(item.getMarca());
			itemModeloField.setText(item.getModelo());
			itemNumeroProductoField.setText(item.getNumeroProducto());
			itemNotasArea.setText(item.getNotas());

		}
	}
}
