package it.polito.tdp.corsi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.GestoreCorsi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {

	private GestoreCorsi model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextArea txtResult;

	@FXML
	private TextField txtPeriodo;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnStatCorsi;

	@FXML
	void doCalcolaStatCorsi(ActionEvent event) {

	}

	@FXML
	void doCercaCorsi(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

	}

	public void setModel(GestoreCorsi model) {
		this.model = model;
	}
}
