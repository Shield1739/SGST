module ts.sst {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires commons.dbutils;

	opens ts.sgst to javafx.fxml;
	opens ts.sgst.controllers to javafx.fxml;
	opens ts.sgst.controllers.main to javafx.fxml;
	opens ts.sgst.controllers.panes to javafx.fxml;
	opens ts.sgst.controllers.panes.inventario to javafx.fxml;
    exports ts.sgst;
    exports ts.sgst.models;
	exports ts.sgst.models.inventario;
    exports ts.sgst.controllers;
	exports ts.sgst.controllers.main;
	exports ts.sgst.controllers.panes;
	exports ts.sgst.controllers.panes.inventario;
}