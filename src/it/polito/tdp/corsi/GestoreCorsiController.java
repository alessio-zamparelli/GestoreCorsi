package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestoreCorsi;
import it.polito.tdp.corsi.model.Studente;
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
	private TextField txtCorso;

	@FXML
	private Button btnStudentiCorso;

	@FXML
	private Button btnCDS;

	//- dato un corso, stampare la divisione degli studenti iscritti tra i vari Corsi di Studio (CDS)
	@FXML
	void doCalcolaStatCDS(ActionEvent event) {

		String corso;
		
		txtResult.clear();
		corso = txtPeriodo.getText();
		
		// TODO: manca il controllo sulla correttezza della stringa in ingresso
		
		Map<Corso, Integer> res = model.getCDSPerCorso(corso);

		txtResult.clear();
		for (Entry entry : res.entrySet()) {
			txtResult.appendText(((Corso) entry.getKey()).getNome() + "->" + entry.getValue() + "\n");
		}

	}

	@FXML
	void doElencaStudenti(ActionEvent event) {
		// TODO: mancano i controlli sulla correttezza del testo in ingresso!!

		String codins = txtCorso.getText();
		List<Studente> studenti = this.model.elencaStudenti(codins);
		txtResult.clear();
		for (Studente studente : studenti) 
			txtResult.appendText(studente.toString() + "\n");
		

	}

	@FXML
	void doCalcolaStatCorsi(ActionEvent event) {

		int periodo;
		txtResult.clear();
		try {
			periodo = Integer.parseInt(txtPeriodo.getText());

		} catch (NumberFormatException e) {
			txtResult.appendText("Devi inserire un periodo didattico (1 o 2)\n");
			return;
		}
		if (periodo != 1 && periodo != 2) {
			txtResult.appendText("Devi inserire un periodo didattico (1 o 2)\n");
			return;
		}

		Map<Corso, Integer> res = model.getIscrittiCorsi(1);

		txtResult.clear();
		for (Entry entry : res.entrySet()) {
			txtResult.appendText(((Corso) entry.getKey()).getNome() + "->" + entry.getValue() + "\n");
		}

	}

	@FXML
	void doCercaCorsi(ActionEvent event) {

		int periodo;
		txtResult.clear();
		try {
			periodo = Integer.parseInt(txtPeriodo.getText());

		} catch (NumberFormatException e) {
			txtResult.appendText("Devi inserire un periodo didattico (1 o 2)\n");
			return;
		}
		if (periodo != 1 && periodo != 2) {
			txtResult.appendText("Devi inserire un periodo didattico (1 o 2)\n");
			return;
		}

		List<Corso> corsi = this.model.getCorsiByPeriodo(periodo);
		for (Corso c : corsi) {
			txtResult.appendText(c.toString() + "\n");
		}

	}

	@FXML
	void initialize() {
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert btnStudentiCorso != null : "fx:id=\"btnStudentiCorso\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
		assert btnCDS != null : "fx:id=\"btnCDS\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

	}

	public void setModel(GestoreCorsi model) {
		this.model = model;
	}
}
