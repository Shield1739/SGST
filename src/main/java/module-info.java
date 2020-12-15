module ts.sst {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires commons.dbutils;

	opens ts.sst to javafx.fxml;
	opens ts.sst.controllers to javafx.fxml;
	opens ts.sst.controllers.main to javafx.fxml;
	opens ts.sst.controllers.panes to javafx.fxml;
	opens ts.sst.controllers.panes.inventario to javafx.fxml;
    exports ts.sst;
    exports ts.sst.models;
    exports ts.sst.controllers;
	exports ts.sst.controllers.main;
	exports ts.sst.controllers.panes;
	exports ts.sst.controllers.panes.inventario;
}