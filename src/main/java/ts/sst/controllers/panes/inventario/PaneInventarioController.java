package ts.sst.controllers.panes.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import ts.sst.database.DbUtilities;

public class PaneInventarioController
{
	@FXML
	private TableView<?> inventarioTable;

	@FXML
	private TableView<?> laptopsTable;

	@FXML
	private TableView<?> raspberrysTable;

	@FXML
	private TableView<?> proyectoresTable;

	@FXML
	private TableView<?> audiovisualTable;

	//MAYBE 1 controller
	private DbUtilities dbUtilities = new DbUtilities();

	public void initialize()
	{
		System.out.println("????????");
		dbUtilities.getTodosTable();
	}

	@FXML
	void handleInventarioAudiovisualTab() {}

	@FXML
	void handleInventarioLaptopsTab() {}

	@FXML
	void handleInventarioProyectoresTab() {}

	@FXML
	void handleInventarioRaspberrysTab() {}

	@FXML
	void handleInventarioTodosTab() {}
}
