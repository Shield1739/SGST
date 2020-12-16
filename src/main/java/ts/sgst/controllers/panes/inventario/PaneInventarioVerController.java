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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import ts.sgst.database.DbInventarioUtilities;
import ts.sgst.models.inventario.ItemAudiovisual;
import ts.sgst.models.inventario.ItemAudiovisualGeneral;
import ts.sgst.models.inventario.ItemAudiovisualLaptop;
import ts.sgst.models.inventario.ItemAudiovisualProyector;
import ts.sgst.models.inventario.ItemAudiovisualRaspberry;

public class PaneInventarioVerController
{
	@FXML
	private TableView inventarioTable;
	@FXML
	private ToggleGroup equiposGroup;
	@FXML
	private GridPane detailsGridPane;
	@FXML
	private TextField itemIDField;
	@FXML
	private TextField itemTipoField;
	@FXML
	private TextField itemEstadoField;
	@FXML
	private TextArea itemNotasArea;

	//MAYBE 1 controller
	private DbInventarioUtilities dbInventarioUtilities = new DbInventarioUtilities();

	public void initialize()
	{
		handleTodos();

		disableTextField(this.itemIDField);
		disableTextField(this.itemTipoField);
		disableTextField(this.itemEstadoField);
		//TODO fix text area scroll
		//disableTextField(itemNotasArea);
	}

	private void clearTable()
	{
		this.inventarioTable.getItems().clear();
		this.inventarioTable.getColumns().clear();
	}

	private void disableTextField(TextField field)
	{
		field.setEditable(false);
		field.setMouseTransparent(true);
		field.setFocusTraversable(false);
	}

	private void addTextAndField(String text, String fieldText)
	{
		int y = (this.detailsGridPane.getChildren().size() / 2) + 1;

		this.detailsGridPane.add(new Text(text), 1, y);
		TextField field = new TextField();
		field.setText(fieldText);
		disableTextField(field);
		this.detailsGridPane.add(field, 2, y);
	}

	/**
	 * TODO do dynamic table building
	 * MAYBE Check unchecked calls?
	 */

	@FXML
	private void handleTodos()
	{
		clearTable();

		ObservableList<ItemAudiovisual> items = FXCollections.observableList(dbInventarioUtilities.getAllItems());

		TableColumn<ItemAudiovisual, Integer> itemIdColumn = new TableColumn<>("Item ID");
		itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));

		TableColumn<ItemAudiovisual, String> tipoColumn = new TableColumn<>("Tipo");
		tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		TableColumn<ItemAudiovisual, String> estadoColumn = new TableColumn<>("Estado");
		estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));

		TableColumn<ItemAudiovisual, String> notasColumn = new TableColumn<>("Notas");
		notasColumn.setCellValueFactory(new PropertyValueFactory<>("notas"));

		this.inventarioTable.setItems(items);
		this.inventarioTable.getColumns().addAll(itemIdColumn, tipoColumn, estadoColumn, notasColumn);

	}

	@FXML
	private void handleLaptops()
	{
		clearTable();

		ObservableList<ItemAudiovisualLaptop> items = FXCollections.observableList(dbInventarioUtilities.getAllLaptopItems());

		TableColumn<ItemAudiovisualLaptop, Integer> itemIdColumn = new TableColumn<>("Item ID");
		itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));

		TableColumn<ItemAudiovisualLaptop, String> estadoColumn = new TableColumn<>("Estado");
		estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));

		TableColumn<ItemAudiovisualLaptop, String> marcaColumn = new TableColumn<>("Marca");
		marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));

		TableColumn<ItemAudiovisualLaptop, String> modeloColumn = new TableColumn<>("Modelo");
		modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));

		TableColumn<ItemAudiovisualLaptop, String> numeroProductoColumn = new TableColumn<>("Numero Producto");
		numeroProductoColumn.setCellValueFactory(new PropertyValueFactory<>("numeroProducto"));

		TableColumn<ItemAudiovisualLaptop, String> osColumn = new TableColumn<>("OS");
		osColumn.setCellValueFactory(new PropertyValueFactory<>("os"));

		this.inventarioTable.setItems(items);
		this.inventarioTable.getColumns().addAll(itemIdColumn, estadoColumn, marcaColumn, modeloColumn, numeroProductoColumn, osColumn);
	}

	@FXML
	private void handleRaspberrys()
	{
		clearTable();

		ObservableList<ItemAudiovisualRaspberry> raspberrys = FXCollections.observableList(dbInventarioUtilities.getAllRaspberryItems());

		TableColumn<ItemAudiovisualRaspberry, Integer> itemIdColumn = new TableColumn<>("Item ID");
		itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));

		TableColumn<ItemAudiovisualRaspberry, String> estadoColumn = new TableColumn<>("Estado");
		estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));

		TableColumn<ItemAudiovisualRaspberry, String> modeloColumn = new TableColumn<>("Modelo");
		modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));

		TableColumn<ItemAudiovisualRaspberry, String> numeroProductoColumn = new TableColumn<>("Numero Producto");
		numeroProductoColumn.setCellValueFactory(new PropertyValueFactory<>("numeroProducto"));

		this.inventarioTable.setItems(raspberrys);
		this.inventarioTable.getColumns().addAll(itemIdColumn, estadoColumn, modeloColumn, numeroProductoColumn);
	}

	@FXML
	private void handleProyectores()
	{
		clearTable();

		ObservableList<ItemAudiovisualProyector> proyectores = FXCollections.observableList(dbInventarioUtilities.getAllProyectorItems());

		TableColumn<ItemAudiovisualProyector, Integer> itemIdColumn = new TableColumn<>("Item ID");
		itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));

		TableColumn<ItemAudiovisualProyector, String> estadoColumn = new TableColumn<>("Estado");
		estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));

		TableColumn<ItemAudiovisualProyector, String> modeloColumn = new TableColumn<>("Modelo");
		modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));

		TableColumn<ItemAudiovisualProyector, String> numeroProductoColumn = new TableColumn<>("Numero Producto");
		numeroProductoColumn.setCellValueFactory(new PropertyValueFactory<>("numeroProducto"));

		this.inventarioTable.setItems(proyectores);
		this.inventarioTable.getColumns().addAll(itemIdColumn, estadoColumn, modeloColumn, numeroProductoColumn);
	}

	@FXML
	private void handleGeneral()
	{
		clearTable();

		ObservableList<ItemAudiovisualGeneral> audiovisuales = FXCollections.observableList(dbInventarioUtilities.getAllGeneralItems());

		TableColumn<ItemAudiovisualGeneral, Integer> itemIdColumn = new TableColumn<>("Item ID");
		itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));

		TableColumn<ItemAudiovisualGeneral, String> estadoColumn = new TableColumn<>("Estado");
		estadoColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));

		TableColumn<ItemAudiovisualGeneral, String> descripcionColumn = new TableColumn<>("Descripcion");
		descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

		TableColumn<ItemAudiovisualGeneral, Integer> cantidadColumn = new TableColumn<>("Cantidad");
		cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

		this.inventarioTable.setItems(audiovisuales);
		this.inventarioTable.getColumns().addAll(itemIdColumn, estadoColumn, descripcionColumn, cantidadColumn);
	}

	@FXML
	private void handleTableSelect()
	{
		Object obj = this.inventarioTable.getSelectionModel().getSelectedItem();

		//OPTIMIZE plz optimize

		if (obj instanceof ItemAudiovisual)
		{
			ItemAudiovisual item = (ItemAudiovisual) obj;

			//TODO tipo o catergorias elegir una de las 2
			itemIDField.setText("" + item.getItemID());
			itemTipoField.setText(item.getTipo());
			itemEstadoField.setText(item.getEstado());
			itemNotasArea.setText(item.getNotas());

			this.detailsGridPane.getChildren().clear();

			switch (item.getTipo())
			{
				case "Laptop":
					ItemAudiovisualLaptop laptop;

					if (obj instanceof ItemAudiovisualLaptop)
					{
						laptop = (ItemAudiovisualLaptop) obj;
					}
					else
					{
						laptop = dbInventarioUtilities.getLaptopItem(item.getItemID());
					}

					addTextAndField("Marca", laptop.getMarca());
					addTextAndField("Modelo", laptop.getModelo());
					addTextAndField("N Producto", laptop.getNumeroProducto());
					addTextAndField("OS", laptop.getOs());
					break;
				case "Raspberry":
					ItemAudiovisualRaspberry raspberry;

					if (obj instanceof ItemAudiovisualRaspberry)
					{
						raspberry = (ItemAudiovisualRaspberry) obj;
					}
					else
					{
						raspberry = dbInventarioUtilities.getRaspberryItem(item.getItemID());
					}

					addTextAndField("Modelo", raspberry.getModelo());
					addTextAndField("N Producto", raspberry.getNumeroProducto());
					break;
				case "Proyector":
					ItemAudiovisualProyector proyector;

					if (obj instanceof ItemAudiovisualProyector)
					{
						proyector = (ItemAudiovisualProyector) obj;
					}
					else
					{
						proyector = dbInventarioUtilities.getProyectorItem(item.getItemID());
					}

					addTextAndField("Modelo", proyector.getModelo());
					addTextAndField("N Producto", proyector.getNumeroProducto());
					break;
				case "Audiovisual":
					ItemAudiovisualGeneral general;

					if (obj instanceof ItemAudiovisualGeneral)
					{
						general = (ItemAudiovisualGeneral) obj;
					}
					else
					{
						general = dbInventarioUtilities.getGeneralItem(item.getItemID());
					}

					addTextAndField("Descripcion", general.getDescripcion());
					addTextAndField("Cantidad", "" + general.getCantidad());
					break;
				default:
					break;
			}
		}
	}
}
